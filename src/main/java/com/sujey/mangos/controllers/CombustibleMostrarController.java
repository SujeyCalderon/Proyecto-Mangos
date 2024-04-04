package com.sujey.mangos.controllers;

import com.sujey.mangos.Login;
import com.sujey.mangos.models.Administracion;
import com.sujey.mangos.models.Combustible;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class CombustibleMostrarController {

    @FXML
    private Button Agregar;

    @FXML
    private Button Eliminar;

    @FXML
    private Button Modificar;

    @FXML
    private Button Mostrar;

    @FXML
    private Button Ver;

    @FXML
    private Button offWindow;

    @FXML
    private TableView<Combustible> TableCombustible;

    @FXML
    private TableColumn<Combustible, String> NombreColumn;

    @FXML
    private TableColumn<Combustible, String> FechaColumn;

    @FXML
    private TableColumn<Combustible, String> DescripcionColumn;

    @FXML
    private TableColumn<Combustible, String> MaquinariaColumn;

    @FXML
    private TableColumn<Combustible, Double> CostoColumn;

    @FXML
    void MouseClickAgregar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("combustibleAgregar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Agregar combustibles");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }



    @FXML
    void MouseClickEliminar(MouseEvent event) {
        int indiceSeleccionado = TableCombustible.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            ArrayList<Combustible> listCombustible = admi.getListCombustible();

            if (!listCombustible.isEmpty()) {
                admi.getListCombustible().remove(indiceSeleccionado);
                TableCombustible.getItems().remove(indiceSeleccionado);
                mostrarMensajeEliminar();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("La lista de combustibles está vacía.");
                alert.showAndWait();
            }
        }
    }


    private void mostrarMensajeEliminar() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ELIMINADO");
        alert.setHeaderText(null);
        alert.setContentText("LA ACTIVIDAD SE HA ELIMINADO CORRECTAMENTE.");
        alert.showAndWait();
    }

    @FXML
    void MouseClickModificar(MouseEvent event) {
        int indiceSeleccionado = TableCombustible.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            ArrayList<Combustible> listCombustible = admi.getListCombustible();
            Combustible combustibleSeleccionado = listCombustible.get(indiceSeleccionado);

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("combustibleAgregar-view-fxml.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage modificarStage = new Stage();
                modificarStage.setTitle("Modificar Combustible");
                modificarStage.setScene(scene);

                CombustibleAgregarController controller = fxmlLoader.getController();

                controller.Texto.setText(combustibleSeleccionado.getNombre());
                controller.Texto2.setText(combustibleSeleccionado.getFecha());
                controller.Texto3.setText(combustibleSeleccionado.getDescripcion());
                controller.Texto4.setText(String.valueOf(combustibleSeleccionado.getCosto()));
                controller.Texto41.setText(combustibleSeleccionado.getMaquinaria());

                admi.getListCombustible().remove(indiceSeleccionado);
                TableCombustible.getItems().remove(indiceSeleccionado);

                modificarStage.showAndWait();

                String costoText = controller.Texto4.getText();
                if (!costoText.isEmpty()) {
                    combustibleSeleccionado.setCosto(Double.parseDouble(costoText));
                } else {
                }

                combustibleSeleccionado.setNombre(controller.Texto.getText());
                combustibleSeleccionado.setFecha(controller.Texto2.getText());
                combustibleSeleccionado.setDescripcion(controller.Texto3.getText());
                combustibleSeleccionado.setMaquinaria(controller.Texto41.getText());
                listCombustible.set(indiceSeleccionado, combustibleSeleccionado);
                TableCombustible.getItems().add(indiceSeleccionado, combustibleSeleccionado);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (NumberFormatException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText("El campo de costo debe ser un número válido.");
                alert.showAndWait();
            }
        }
    }

    @FXML
    void MouseClickMostrar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("combustibleMostrar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Mostrar combustibles");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void MouseClickVer(MouseEvent event) {
        Administracion admi = Login.getAdmin();
        ArrayList<Combustible> listCombustible = admi.getListCombustible();

        TableCombustible.getItems().clear();

        Set<Integer> indicesModificados = new HashSet<>();

        for (Combustible combustible : listCombustible) {
            int indice = listCombustible.indexOf(combustible);
            if (!admi.esEliminado(indice) && !indicesModificados.contains(indice)) {
                TableCombustible.getItems().add(combustible);
            }
        }
    }


    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize() {
        NombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        FechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
        DescripcionColumn.setCellValueFactory(cellData -> cellData.getValue().descripcionProperty());
        CostoColumn.setCellValueFactory(cellData -> cellData.getValue().costoProperty().asObject());
        MaquinariaColumn.setCellValueFactory(cellData -> cellData.getValue().maquinariaProperty());
    }
}
