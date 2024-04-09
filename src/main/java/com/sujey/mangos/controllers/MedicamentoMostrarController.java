package com.sujey.mangos.controllers;

import com.sujey.mangos.Login;
import com.sujey.mangos.models.Administracion;
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
    private Button Mostrar;

    @FXML
    private Button Ver;

    @FXML
    private Button offWindow;

    @FXML
    private TableView<Medicamento> TableMostrarMedicamentos;

    @FXML
    private TableColumn<Medicamento, String> NombreColumn;

    @FXML
    private TableColumn<Medicamento, String> FechaColumn;

    @FXML
    private TableColumn<Medicamento, String> DescripcionColumn;

    @FXML
    private TableColumn<Medicamento, String> CantidadColumn;

    @FXML
    private TableColumn<Medicamento, Double> CostoColumn;

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
        int indiceSeleccionado = TableMostrarMedicamentos.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            admi.getListMedicamento().remove(indiceSeleccionado);
            TableMostrarMedicamentos.getItems().remove(indiceSeleccionado);
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
            callAgregar.setTitle("Mostrar Medicamento");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void MouseClickModificar(MouseEvent event) {
        int indiceSeleccionado = TableMostrarMedicamentos.getSelectionModel().getSelectedIndex();

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
                TableMostrarMedicamentos.getItems().remove(indiceSeleccionado);

                modificarStage.showAndWait();

                medicamentoSeleccionada.setNombre(controller.Tes6.getText());
                medicamentoSeleccionada.setCantidad(controller.Tes7.getText());
                medicamentoSeleccionada.setCosto(Double.parseDouble(controller.Tes8.getText()));
                medicamentoSeleccionada.setDescripcion(controller.Tes9.getText());
                medicamentoSeleccionada.setFecha(controller.Tes10.getText());

                listMedicamento.set(indiceSeleccionado, medicamentoSeleccionada);

                TableMostrarMedicamentos.getItems().add(indiceSeleccionado, medicamentoSeleccionada);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void MouseClickVer(MouseEvent event) {
        Administracion admi = Login.getAdmin();
        ArrayList<Medicamento> listMedicamento = admi.getListMedicamento();

        TableMostrarMedicamentos.getItems().clear();

        Set<Integer> indicesModificados = new HashSet<>();

        for (Medicamento medicamento : listMedicamento) {
            int indice = listMedicamento.indexOf(medicamento);
            if (!admi.esEliminado(indice) && !indicesModificados.contains(indice)) {
                TableMostrarMedicamentos.getItems().add(medicamento);
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
        CantidadColumn.setCellValueFactory(cellData -> cellData.getValue().cantidadProperty());
        CostoColumn.setCellValueFactory(cellData -> cellData.getValue().costoProperty().asObject());
    }
}
