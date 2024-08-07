package com.sujey.mangos.controllers;

import com.sujey.mangos.Login;
import com.sujey.mangos.models.Administracion;
import com.sujey.mangos.models.Combustible;
import com.sujey.mangos.models.Cultivo;
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

public class CultivoMostrarController{

    @FXML
    private Button agregar;

    @FXML
    private Button modificar;

    @FXML
    private Button eliminar;

    @FXML
    private Button mostrar;

    @FXML
    private Button ver;

    @FXML
    private Button offWindow;

    @FXML
    private TableView<Cultivo> tableMostrarCultivo;

    @FXML
    private TableColumn<Cultivo, String> nombreColumn;

    @FXML
    private TableColumn<Cultivo, String> fechaColumn;

    @FXML
    private TableColumn<Cultivo, String> cantidadColumn;

    @FXML
    private TableColumn<Cultivo, String> distanciaColumn;

    @FXML
    private TableColumn<Cultivo, String> tipoLunaColumn;

    @FXML
    void MouseClickAgregar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("cultivoAgregar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Agregar cultivo");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void MouseClickMostrar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("cultivoMostrar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Mostrar cultivo");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void MouseClickEliminar(MouseEvent event) {
        int indiceSeleccionado = tableMostrarCultivo.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            admi.getListCultivo().remove(indiceSeleccionado);
            tableMostrarCultivo.getItems().remove(indiceSeleccionado);
            mostrarMensajeEliminar();
        }
    }
    private void mostrarMensajeEliminar() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ELIMINADO");
        alert.setHeaderText(null);
        alert.setContentText("EL CULTIVO SE HA ELIMINADO CORRECTAMENTE.");
        alert.showAndWait();
    }

    @FXML
    void MouseClickModificar(MouseEvent event) {
        int indiceSeleccionado = tableMostrarCultivo.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            ArrayList<Cultivo> listCultivo = admi.getListCultivo();
            Cultivo cultivoSeleccionada = listCultivo.get(indiceSeleccionado);

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("cultivoAgregar-view-fxml.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage modificarStage = new Stage();
                modificarStage.setTitle("Modificar Cultivo");
                modificarStage.setScene(scene);
                CultivoAgregarController controller = fxmlLoader.getController();
                controller.tes.setText(cultivoSeleccionada.getTipo());
                controller.tes2.setText(cultivoSeleccionada.getFecha());
                controller.tes3.setText(cultivoSeleccionada.getCantidadHec());
                controller.tes4.setText(cultivoSeleccionada.getDistancia());
                controller.tes5.setText(cultivoSeleccionada.getTipoLuna());
                admi.getListCultivo().remove(indiceSeleccionado);
                tableMostrarCultivo.getItems().remove(indiceSeleccionado);
                modificarStage.showAndWait();
                cultivoSeleccionada.setTipo(controller.tes.getText());
                cultivoSeleccionada.setFecha(controller.tes2.getText());
                cultivoSeleccionada.setCantidadHec(controller.tes3.getText());
                cultivoSeleccionada.setDistancia(controller.tes4.getText());
                cultivoSeleccionada.setTipoLuna(controller.tes5.getText());
                listCultivo.set(indiceSeleccionado, cultivoSeleccionada);
                tableMostrarCultivo.getItems().add(indiceSeleccionado, cultivoSeleccionada);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void MouseClickVer(MouseEvent event) {
        Administracion admi = Login.getAdmin();
        ArrayList<Cultivo> listCultivo = admi.getListCultivo();

        tableMostrarCultivo.getItems().clear();

        Set<Integer> indicesModificados = new HashSet<>();

        for (Cultivo cultivo : listCultivo) {
            int indice = listCultivo.indexOf(cultivo);
            if (!admi.esEliminado(indice) && !indicesModificados.contains(indice)) {
                tableMostrarCultivo.getItems().add(cultivo);
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
        nombreColumn.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());
        fechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
        cantidadColumn.setCellValueFactory(cellData -> cellData.getValue().cantidadHecProperty());
        distanciaColumn.setCellValueFactory(cellData -> cellData.getValue().distanciaProperty());
        tipoLunaColumn.setCellValueFactory(cellData -> cellData.getValue().tipoLunaProperty());
    }
}
