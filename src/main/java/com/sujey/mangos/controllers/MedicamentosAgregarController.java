package com.sujey.mangos.controllers;
import com.sujey.mangos.models.Actividad;
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

public class MedicamentosAgregarController {

    @FXML
    private Button Agregar;


    @FXML
    private Button Guardar;

    @FXML
    private Button Mostrar;

    @FXML
    TextField Tes10;

    @FXML
    TextField Tes6;

    @FXML
    TextField Tes7;

    @FXML
    TextField Tes8;

    @FXML
    TextField Tes9;

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
    void MouseClickGuardar(MouseEvent event) {
        String nombre = Tes6.getText();
        String fecha = Tes10.getText();
        String descripcion = Tes9.getText();
        String cantidad = Tes7.getText();
        double costo;

        try {
            costo = Double.parseDouble(Tes8.getText());
        } catch (NumberFormatException e) {
            mostrarError();
            return;
        }

        Medicamento medicamento = new Medicamento(nombre,fecha, descripcion, cantidad, costo);
        Administracion administracion = Login.getAdmin();
        administracion.addMedicamento(medicamento);

        Tes6.clear();
        Tes7.clear();
        Tes8.clear();
        Tes9.clear();
        Tes10.clear();

        mostrarMensajeGuardado();
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
    private void mostrarError2() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText("La cantidad debe ser un número valido.");
        alert.showAndWait();
    }


    @FXML
    void MouseClickMostrar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("medicamentosMostrar-view-fxml.fxml"));
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
