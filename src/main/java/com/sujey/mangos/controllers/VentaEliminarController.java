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
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class VentaEliminarController {

    @FXML
    private Button Agregar;
    @FXML
    private TextField Texto4;
    @FXML
    private Button Sueldo;

    @FXML
    private Button Cantidad;

    @FXML
    private Button Eliminar;
    @FXML
    private Button Fecha;

    @FXML
    private Button Mostrar;

    @FXML
    private Button Precio;

    @FXML
    private Button Tipo;
    @FXML
    private ListView<String> List4;

    @FXML
    private Button offWindow;

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
    void MouseClickCantidad(MouseEvent event) {
            String datoAEliminar = Texto4.getText();
            Administracion administracion = Login.getAdmin();
            administracion.eliminarVentaPorCantidad(datoAEliminar);
            actualizarListView();
            mostrarMensaje5();

    }

    private void actualizarListView() {
        List4.getItems().clear();
        Administracion admi = Login.getAdmin();
        ArrayList<Venta> listVenta = admi.getListVenta();
        for (Venta venta : listVenta) {
            List4.getItems().add(venta.toString());
        }
    }


    private void mostrarMensaje5() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ELIMINADO");
        alert.setHeaderText(null);
        alert.setContentText("LA CANTIDAD SE HA ELIMINADO.");
        alert.showAndWait();
    }

    @FXML
    void MouseClickEliminar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("ventaEliminar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Eliminar ventas");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void MouseClickFecha(MouseEvent event) {
        mostrarMensaje();

    }

    private void mostrarMensaje() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ELIMINADO");
        alert.setHeaderText(null);
        alert.setContentText("LA FECHA SE HA ELIMINADO.");
        alert.showAndWait();
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
    void MouseClickPrecio(MouseEvent event) {
        mostrarMensaje2();

    }
    private void mostrarMensaje2() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ELIMINADO");
        alert.setHeaderText(null);
        alert.setContentText("EL PRECIO HA SIDO ELIMINADO DEL SISTEMA.");
        alert.showAndWait();
    }

    @FXML
    void MouseClickTipo(MouseEvent event) {
        mostrarMensaje3();
    }
    private void mostrarMensaje3() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ELIMINADO");
        alert.setHeaderText(null);
        alert.setContentText("EL TIPO DE MANGO HA SIDO ELIMINADO DEL SISTEMA.");
        alert.showAndWait();
    }
    @FXML
    void MouseClickSueldo(MouseEvent event) {
        mostrarMensaje4();
    }
    private void mostrarMensaje4() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("ELIMINADO");
        alert.setHeaderText(null);
        alert.setContentText("EL SUELDO HA SIDO ELIMINADO DEL SISTEMA.");
        alert.showAndWait();
    }


    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

}
