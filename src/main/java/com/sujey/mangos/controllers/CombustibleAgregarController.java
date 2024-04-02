package com.sujey.mangos.controllers;

import com.sujey.mangos.Login;
import com.sujey.mangos.models.Actividad;
import com.sujey.mangos.models.Administracion;
import com.sujey.mangos.models.Combustible;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CombustibleAgregarController {

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
    TextField Texto3;

    @FXML
    TextField Texto4;

    @FXML
    TextField Texto41;

    @FXML
    private Button offWindow;

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
    void MouseClickGuardar(MouseEvent event) {
        String nombre = Texto.getText();
        String fecha = Texto2.getText();
        String descripcion = Texto3.getText();
        String maquinaria = Texto41.getText();
        double costo;

        try {
            costo = Double.parseDouble(Texto4.getText());
        } catch (NumberFormatException e) {
            mostrarError();
            return;
        }

        Combustible combustible = new Combustible(nombre, fecha, descripcion, maquinaria, costo);
        Administracion administracion = Login.getAdmin();
        administracion.addCombustible(combustible);

        Texto.clear();
        Texto2.clear();
        Texto3.clear();
        Texto4.clear();
        Texto41.clear();

        mostrarMensajeGuardado();
    }
    private void mostrarMensajeGuardado() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Guardado exitoso");
        alert.setHeaderText(null);
        alert.setContentText("El combustible se ha añadido con éxito.");
        alert.showAndWait();
    }
    private void mostrarError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("ERROR");
        alert.setHeaderText(null);
        alert.setContentText("El costo debe ser un número valido.");
        alert.showAndWait();
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
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

}
