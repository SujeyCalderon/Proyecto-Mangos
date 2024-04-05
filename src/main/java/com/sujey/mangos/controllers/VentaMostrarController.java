package com.sujey.mangos.controllers;

import com.sujey.mangos.Login;
import com.sujey.mangos.models.Administracion;
import com.sujey.mangos.models.Venta;
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

public class VentaMostrarController {

    @FXML
    private Button Agregar;
    @FXML
    private Button Modificar;

    @FXML
    private Button Eliminar;
    @FXML
    private Button Actualizar;

    @FXML
    private Button Mostrar;

    @FXML
    private Button Ver;

    @FXML
    private Button offWindow;

    @FXML
    private TableView<Venta> TableVenta;

    @FXML
    private TableColumn<Venta, String> TipoColumn;

    @FXML
    private TableColumn<Venta, String> FechaColumn;

    @FXML
    private TableColumn<Venta, Double> CantidadColumn;

    @FXML
    private TableColumn<Venta, Double> PrecioColumn;

    @FXML
    private TableColumn<Venta, Double> SueldoColumn;

    @FXML
    void MouseClickAgregar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("VentaAgregar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Agregar ventas");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    void MouseClickMostrar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("ventaMostrar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Mostar ventas");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void MouseClickVer(MouseEvent event) {
        Administracion admi = Login.getAdmin();
        ArrayList<Venta> listVenta = admi.getListVenta();

        TableVenta.getItems().clear();

        Set<Integer> indicesModificados = new HashSet<>();

        for (Venta venta : listVenta) {
            int indice = listVenta.indexOf(venta);
            if (!admi.esEliminado(indice) && !indicesModificados.contains(indice)) {
                TableVenta.getItems().add(venta);
            }
        }
    }
    @FXML
    void MouseClickModificar(MouseEvent event) {
        int indiceSeleccionado = TableVenta.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            ArrayList<Venta> listVenta = admi.getListVenta();
            Venta ventaSeleccionada = listVenta.get(indiceSeleccionado);

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("VentaAgregar-view-fxml.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage modificarStage = new Stage();
                modificarStage.setTitle("Modificar venta");
                modificarStage.setScene(scene);
                VentaAgregarController controller = fxmlLoader.getController();
                controller.Texto.setText(ventaSeleccionada.getTipo());
                controller.Texto2.setText(ventaSeleccionada.getFecha());
                controller.Texto3.setText(String.valueOf(ventaSeleccionada.getPrecio()));
                controller.Texto4.setText(String.valueOf(ventaSeleccionada.getCantidad()));
                controller.suel.setText(String.valueOf(ventaSeleccionada.getSueldo()));
                admi.getListVenta().remove(indiceSeleccionado);
                TableVenta.getItems().remove(indiceSeleccionado);
                modificarStage.showAndWait();
                ventaSeleccionada.setTipo(controller.Texto.getText());
                ventaSeleccionada.setFecha(controller.Texto2.getText());
                ventaSeleccionada.setPrecio(Double.parseDouble(controller.Texto3.getText()));
                ventaSeleccionada.setCantidad(Double.parseDouble(controller.Texto4.getText()));
                ventaSeleccionada.setSueldo(Double.parseDouble(controller.suel.getText()));
                listVenta.set(indiceSeleccionado, ventaSeleccionada);
                TableVenta.getItems().add(indiceSeleccionado, ventaSeleccionada);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
    @FXML
    void MouseClickEliminar(MouseEvent event) {
        int indiceSeleccionado = TableVenta.getSelectionModel().getSelectedIndex();

        if (indiceSeleccionado != -1) {
            Administracion admi = Login.getAdmin();
            admi.getListVenta().remove(indiceSeleccionado);
            TableVenta.getItems().remove(indiceSeleccionado);
            mostrarMensajeEliminar();
        }
    }

    private void mostrarMensajeEliminar() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ELIMINADO");
        alert.setHeaderText(null);
        alert.setContentText("LA VENTA SE HA ELIMINADO CORRECTAMENTE.");
        alert.showAndWait();
    }
    

    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        TipoColumn.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());
        FechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
        CantidadColumn.setCellValueFactory(cellData -> cellData.getValue().cantidadProperty().asObject());
        PrecioColumn.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());
        SueldoColumn.setCellValueFactory(cellData -> cellData.getValue().sueldoProperty().asObject());
    }

}
