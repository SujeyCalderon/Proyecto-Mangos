package com.sujey.mangos.controllers;

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

public class VentaAgregarController {

    @FXML
    private Button Agregar;

    @FXML
    private Button Eliminar;

    @FXML
    private Button Guardar;

    @FXML
    private Button Mostrar;

    @FXML
    TextField Texto;

    @FXML
    TextField Texto2;
    @FXML
    TextField suel;

    @FXML
    TextField Texto3;

    @FXML
    TextField Texto4;

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
    void MouseClickGuardar(MouseEvent event) {
        String tipo = Texto.getText();
        String fecha = Texto2.getText();
        double cantidad;
        double sueldo;
        double precio;
        try {
            precio = Double.parseDouble(Texto3.getText());
        } catch (NumberFormatException e) {
            mostrarError();
            return;
        }
        try {
            cantidad = Double.parseDouble(Texto4.getText());
        } catch (NumberFormatException e) {
            mostrarError2();
            return;
        }
        try {
            sueldo = Double.parseDouble(suel.getText());
        } catch (NumberFormatException e) {
            mostrarError3();
            return;
        }

        Venta venta = new Venta(tipo,fecha,cantidad, precio, sueldo);
        Administracion administracion = Login.getAdmin();
        administracion.addVenta(venta);

        Texto.clear();
        Texto2.clear();
        Texto3.clear();
        Texto4.clear();
        suel.clear();

        mostrarMensajeGuardado();

    }
    private void mostrarMensajeGuardado() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Guardado exitoso");
        alert.setHeaderText(null);
        alert.setContentText("Se ha añadido la venta con éxito.");
        alert.showAndWait();
    }
    private void mostrarError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText("El precio debe ser un número valido.");
        alert.showAndWait();
    }
    private void mostrarError2() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText("La cantidad debe ser un número valido.");
        alert.showAndWait();
    }
    private void mostrarError3() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText("El sueldo debe ser un número valido.");
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
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

}