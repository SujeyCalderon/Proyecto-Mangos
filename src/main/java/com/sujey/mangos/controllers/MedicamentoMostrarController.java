package com.sujey.mangos.controllers;

import com.sujey.mangos.Login;
import com.sujey.mangos.models.Administracion;
import com.sujey.mangos.models.Venta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import com.sujey.mangos.models.Medicamento;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MedicamentoMostrarController {

    @FXML
    private Button Agregar;

    @FXML
    private Button Eliminar;
    @FXML
    private Button Modificar;

    @FXML
    private ListView<String> List6;

    @FXML
    private Button Mostrar;

    @FXML
    private Button Ver;

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
        int indiceSeleccionado = List6.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            admi.getListMedicamento().remove(indiceSeleccionado);
            List6.getItems().remove(indiceSeleccionado);
            mostrarMensajeEliminar();
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
            callAgregar.setTitle("Mostar Medicamento");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void MouseClickModificar(MouseEvent event) {
        int indiceSeleccionado = List6.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            ArrayList<Medicamento> listMedicamento = admi.getListMedicamento();
            Medicamento medicamentoSeleccionada = listMedicamento.get(indiceSeleccionado);

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("medicamentosAgregar-view-fxml.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage modificarStage = new Stage();
                modificarStage.setTitle("Modificar Medicamento");
                modificarStage.setScene(scene);

                MedicamentosAgregarController controller = fxmlLoader.getController();

                controller.Tes6.setText(medicamentoSeleccionada.getNombre());
                controller.Tes7.setText(medicamentoSeleccionada.getCantidad());
                controller.Tes8.setText(String.valueOf(medicamentoSeleccionada.getCosto()));
                controller.Tes9.setText(medicamentoSeleccionada.getDescripcion());
                controller.Tes10.setText(medicamentoSeleccionada.getFecha());

                admi.getListMedicamento().remove(indiceSeleccionado);
                List6.getItems().remove(indiceSeleccionado);

                modificarStage.showAndWait();

                medicamentoSeleccionada.setNombre(controller.Tes6.getText());
                medicamentoSeleccionada.setCantidad(controller.Tes7.getText());
                medicamentoSeleccionada.setCosto(Double.parseDouble(controller.Tes8.getText()));
                medicamentoSeleccionada.setDescripcion(controller.Tes9.getText());
                medicamentoSeleccionada.setFecha(controller.Tes10.getText());


                listMedicamento.set(indiceSeleccionado, medicamentoSeleccionada);

                List6.getItems().add(indiceSeleccionado, medicamentoSeleccionada.toString());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @FXML
    void MouseClickVer(MouseEvent event) {
        Administracion admi = Login.getAdmin();
        ArrayList<Medicamento> listMedicamento = admi.getListMedicamento();

        List6.getItems().clear();

        Set<Integer> indicesModificados = new HashSet<>();

        for (Medicamento medicamento : listMedicamento) {
            int indice = listMedicamento.indexOf(medicamento);
            if (!admi.esEliminado(indice) && !indicesModificados.contains(indice)) {
                List6.getItems().add(medicamento.toString());
            }
        }
    }
    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }
}



