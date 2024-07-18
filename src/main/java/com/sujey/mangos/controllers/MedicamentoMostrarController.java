package com.sujey.mangos.controllers;

import com.sujey.mangos.Login;
import com.sujey.mangos.models.Administracion;
import com.sujey.mangos.models.DatabaseConnection;
import com.sujey.mangos.models.Medicamento;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MedicamentoMostrarController {

    @FXML
    private Button agregar;

    @FXML
    private Button eliminar;

    @FXML
    private Button modificar;

    @FXML
    private Button mostrar;

    @FXML
    private Button ver;

    @FXML
    private Button offWindow;

    @FXML
    private TableView<Medicamento> tableMostrarMedicamentos;

    @FXML
    private TableColumn<Medicamento, String> nombreColumn;

    @FXML
    private TableColumn<Medicamento, String> fechaColumn;

    @FXML
    private TableColumn<Medicamento, String> descripcionColumn;

    @FXML
    private TableColumn<Medicamento, String> cantidadColumn;

    @FXML
    private TableColumn<Medicamento, Double> costoColumn;

    @FXML
    void MouseClickAgregar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("medicamentosAgregar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Agregar medicamentos");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void MouseClickEliminar(MouseEvent event) {
        int indiceSeleccionado = tableMostrarMedicamentos.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Medicamento medicamentoSeleccionado = tableMostrarMedicamentos.getItems().get(indiceSeleccionado);
            String nombre = medicamentoSeleccionado.getNombre();

            eliminarMedicamentoDeBD(nombre);
            tableMostrarMedicamentos.getItems().remove(indiceSeleccionado);
            mostrarMensajeEliminar();
        }
    }

    private void eliminarMedicamentoDeBD(String nombre) {
        String sql = "DELETE FROM medicamento WHERE nombre = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Confirmación de eliminación");
                alerta.setHeaderText(null);
                alerta.setContentText("Medicamento eliminado correctamente de la base de datos");
                alerta.showAndWait();
            } else {
                Alert alertaError = new Alert(Alert.AlertType.ERROR);
                alertaError.setTitle("Error de eliminación");
                alertaError.setHeaderText(null);
                alertaError.setContentText("No se pudo eliminar el medicamento de la base de datos.");
                alertaError.showAndWait();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alertaError = new Alert(Alert.AlertType.ERROR);
            alertaError.setTitle("Error de eliminación");
            alertaError.setHeaderText(null);
            alertaError.setContentText("Hubo un error al eliminar el medicamento de la base de datos.");
            alertaError.showAndWait();
        }
    }
    private void mostrarMensajeEliminar() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ELIMINADO");
        alert.setHeaderText(null);
        alert.setContentText("EL MEDICAMENTO SE HA ELIMINADO CORRECTAMENTE.");
        alert.showAndWait();
    }

    @FXML
    void MouseClickMostrar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("medicamentoMostrar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Mostrar Medicamento");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void MouseClickModificar(MouseEvent event) {
        int indiceSeleccionado = tableMostrarMedicamentos.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Medicamento medicamentoSeleccionado = tableMostrarMedicamentos.getItems().get(indiceSeleccionado);
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("medicamentosAgregar-view-fxml.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage modificarStage = new Stage();
                modificarStage.setTitle("Modificar Medicamento");
                modificarStage.setScene(scene);

                MedicamentosAgregarController controller = fxmlLoader.getController();

                controller.tes6.setText(medicamentoSeleccionado.getNombre());
                controller.tes7.setText(medicamentoSeleccionado.getCantidad());
                controller.tes8.setText(String.valueOf(medicamentoSeleccionado.getCosto()));
                controller.tes9.setText(medicamentoSeleccionado.getDescripcion());
                controller.tes10.setText(medicamentoSeleccionado.getFecha());

                modificarStage.showAndWait();
                String nuevoNombre = controller.tes6.getText();
                String nuevaCantidad = controller.tes7.getText();
                double nuevoCosto = Double.parseDouble(controller.tes8.getText());
                String nuevaDescripcion = controller.tes9.getText();
                String nuevaFecha = controller.tes10.getText();

                actualizarMedicamentoEnBD(medicamentoSeleccionado, nuevoNombre, nuevaCantidad, nuevoCosto, nuevaDescripcion, nuevaFecha);

                Medicamento medicamentoModificado = new Medicamento(nuevoNombre, nuevaFecha, nuevaDescripcion, nuevaCantidad, nuevoCosto);
                tableMostrarMedicamentos.getItems().set(indiceSeleccionado, medicamentoModificado);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void actualizarMedicamentoEnBD(Medicamento medicamento, String nuevoNombre, String nuevaCantidad,
                                           double nuevoCosto, String nuevaDescripcion, String nuevaFecha) {
        String sql = "UPDATE medicamento SET nombre=?, cantidad=?, costo=?, descripcion=?, fecha=? WHERE nombre=?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nuevoNombre);
            pstmt.setString(2, nuevaCantidad);
            pstmt.setDouble(3, nuevoCosto);
            pstmt.setString(4, nuevaDescripcion);
            pstmt.setString(5, nuevaFecha);
            pstmt.setString(6, medicamento.getNombre());

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Confirmación de actualización");
                alerta.setHeaderText(null);
                alerta.setContentText("Medicamento actualizado correctamente en la base de datos");
                alerta.showAndWait();
            } else {
                Alert alertaError = new Alert(Alert.AlertType.ERROR);
                alertaError.setTitle("Error de actualización");
                alertaError.setHeaderText(null);
                alertaError.setContentText("No se pudo actualizar el medicamento en la base de datos.");
                alertaError.showAndWait();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alertaError = new Alert(Alert.AlertType.ERROR);
            alertaError.setTitle("Error de actualización");
            alertaError.setHeaderText(null);
            alertaError.setContentText("Hubo un error al actualizar el medicamento en la base de datos.");
            alertaError.showAndWait();
        }
    }

    @FXML
    void MouseClickVer(MouseEvent event) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            if (conn == null) {
                throw new SQLException("No se pudo establecer la conexión a la base de datos.");
            }

            String sql = "SELECT * FROM medicamento";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            ArrayList<Medicamento> medicamentos = new ArrayList<>();
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String cantidad = rs.getString("cantidad");
                String descripcion = rs.getString("descripcion");
                String fecha = rs.getString("fecha");
                double costo = rs.getDouble("costo");

                Medicamento medicamento = new Medicamento(nombre, cantidad, descripcion, fecha, costo);
                medicamentos.add(medicamento);
            }

            tableMostrarMedicamentos.getItems().clear();
            tableMostrarMedicamentos.getItems().addAll(medicamentos);

            rs.close();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error de conexión");
            alert.setHeaderText(null);
            alert.setContentText("Hubo un error al conectar con la base de datos o al recuperar los datos.");
            alert.showAndWait();
        }
    }

    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void initialize() {
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        fechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
        descripcionColumn.setCellValueFactory(cellData -> cellData.getValue().descripcionProperty());
        cantidadColumn.setCellValueFactory(cellData -> cellData.getValue().cantidadProperty());
        costoColumn.setCellValueFactory(cellData -> cellData.getValue().costoProperty().asObject());

        MouseClickVer(null);
    }
}
