package com.sujey.mangos.controllers;
import com.sujey.mangos.models.DatabaseConnection;
import com.sujey.mangos.models.Medicamento;

import com.sujey.mangos.Login;
import com.sujey.mangos.models.Administracion;
import com.sujey.mangos.models.Venta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicamentosAgregarController {

    @FXML
    private Button agregar;

    @FXML
    private Button eliminar;

    @FXML
    private Button guardar;

    @FXML
    private Button mostrar;

    @FXML
    public TextField tes10;

    @FXML
    public TextField tes6;

    @FXML
    public TextField tes7;

    @FXML
    public TextField tes8;

    @FXML
    public TextField tes9;

    @FXML
    private Button offWindow;

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
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("medicamentosEliminar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Eliminar medicamentos");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void MouseClickGuardar(MouseEvent event) {
        String nombre = tes6.getText();
        String fecha = tes10.getText();
        String descripcion = tes9.getText();
        String cantidad = tes8.getText();
        double precio;
        try {
            precio = Double.parseDouble(tes8.getText());
        } catch (NumberFormatException e) {
            mostrarError();
            return;
        }

        Medicamento medicamento = new Medicamento(nombre, fecha, descripcion, cantidad, precio);
        Administracion administracion = Login.getAdmin();
        administracion.addMedicamento(medicamento);
        agregarMedicamento(nombre, fecha, descripcion, cantidad, precio);

        tes6.clear();
        tes7.clear();
        tes8.clear();
        tes9.clear();
        tes10.clear();

        mostrarMensajeGuardado();
    }

    public void agregarMedicamento(String nombre, String fecha, String descripcion, String cantidad, double costo) {
        String sql = "INSERT INTO medicamento (nombre, fecha, descripcion, cantidad, costo) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nombre);
            pstmt.setString(2, fecha);
            pstmt.setString(3, descripcion);
            pstmt.setString(4, cantidad);
            pstmt.setDouble(5, costo);

            int filasAfectadas = pstmt.executeUpdate();
            if (filasAfectadas > 0) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Confirmación de agregado");
                alerta.setHeaderText(null);
                alerta.setContentText("Medicamento agregado correctamente");
                alerta.showAndWait();
            } else {
                Alert alertaError = new Alert(Alert.AlertType.ERROR);
                alertaError.setTitle("Error de Agregado");
                alertaError.setHeaderText(null);
                alertaError.setContentText("No se pudo agregar el medicamento.");
                alertaError.showAndWait();
            }

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alertaError = new Alert(Alert.AlertType.ERROR);
            alertaError.setTitle("Error de Agregado");
            alertaError.setHeaderText(null);
            alertaError.setContentText("Hubo un error al agregar el medicamento a la base de datos.");
            alertaError.showAndWait();
        }
    }

    private void mostrarMensajeGuardado() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Guardado exitoso");
        alert.setHeaderText(null);
        alert.setContentText("Se ha añadido el Medicamento con éxito.");
        alert.showAndWait();
    }
    private void mostrarError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText("El precio debe ser un número valido.");
        alert.showAndWait();
    }



    @FXML
    void MouseClickMostrar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("medicamentoMostrar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Mostrar medicamentos");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

}
