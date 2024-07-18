package com.sujey.mangos.controllers;

import com.sujey.mangos.Login;
import com.sujey.mangos.models.Actividad;
import com.sujey.mangos.models.Administracion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class Actividadesmostrarcontroller {

    @FXML
    private Button agregar;

    @FXML
    private Button eliminar;

    @FXML
    private Button mostrar;
    @FXML
    private Button modificar;

    @FXML
    private Button ver;

    @FXML
    private TableView<Actividad> actividadesTable;

    @FXML
    private TableColumn<Actividad, String> actividadColumn;

    @FXML
    private TableColumn<Actividad, String> fechaColumn;

    @FXML
    private TableColumn<Actividad, Double> costoColumn;

    @FXML
    private TableColumn<Actividad, String> cantidadColumn;

    @FXML
    private Button offWindow;

    @FXML
    void MouseClickAgregar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("actividades-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Agregar actividades");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    void MouseClickMostrar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("actividadesMostrar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Mostrar actividades");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void MouseClickEliminar(MouseEvent event) {
        int indiceSeleccionado = actividadesTable.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            admi.getListActividad().remove(indiceSeleccionado);
            actividadesTable.getItems().remove(indiceSeleccionado);
            mostrarMensajeEliminar();
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
        int indiceSeleccionado = actividadesTable.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            ArrayList<Actividad> listActividad = admi.getListActividad();
            Actividad actividadSeleccionada = listActividad.get(indiceSeleccionado);

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("actividades-view-fxml.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage modificarStage = new Stage();
                modificarStage.setTitle("Modificar Actividad");
                modificarStage.setScene(scene);
                ActividadesController controller = fxmlLoader.getController();
                controller.tex1.setText(actividadSeleccionada.getFecha());
                controller.tex2.setText(actividadSeleccionada.getNombre());
                controller.tex3.setText(String.valueOf(actividadSeleccionada.getCosto()));
                controller.tex4.setText(actividadSeleccionada.getCantidadHec());
                admi.getListActividad().remove(indiceSeleccionado);
                actividadesTable.getItems().remove(indiceSeleccionado);
                modificarStage.showAndWait();
                actividadSeleccionada.setFecha(controller.tex1.getText());
                actividadSeleccionada.setNombre(controller.tex2.getText());
                actividadSeleccionada.setCosto(Double.parseDouble(controller.tex3.getText()));
                actividadSeleccionada.setCantidadHec(controller.tex4.getText());
                admi.getListActividad().add(indiceSeleccionado, actividadSeleccionada);
                actividadesTable.getItems().add(indiceSeleccionado, actividadSeleccionada);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void MouseClickVer(MouseEvent event) {
        Administracion admi = Login.getAdmin();
        ArrayList<Actividad> listActividad = admi.getListActividad();

        ObservableList<Actividad> data = FXCollections.observableArrayList(listActividad);
        actividadesTable.setItems(data);
    }

    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize() {
        actividadColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        fechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
        costoColumn.setCellValueFactory(cellData -> cellData.getValue().costoProperty().asObject());
        cantidadColumn.setCellValueFactory(cellData -> cellData.getValue().cantidadHecProperty());
    }

}
