package com.sujey.mangos.controllers;

import com.sujey.mangos.Login;
import com.sujey.mangos.models.Actividad;
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

public class ActividadesController {

    @FXML
    private Button Agregar;



    @FXML
    private Button Guardar;

    @FXML
    private Button Mostrar;

    @FXML
    private Button offWindow;

    @FXML
    TextField tex1;

    @FXML
    TextField tex2;

    @FXML
    TextField tex3;

    @FXML
    TextField tex4;

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
    void MouseClickGuardar(MouseEvent event) {
        String fecha = tex1.getText();
        String nombre = tex2.getText();
        String cantidadHec = tex4.getText();
        double costo;

        try {
            costo = Double.parseDouble(tex3.getText());
        } catch (NumberFormatException e) {
            mostrarError();
            return;
        }

        Actividad actividad = new Actividad(fecha,nombre, costo, cantidadHec);
        Administracion administracion = Login.getAdmin();
        administracion.addActividad(actividad);

        tex1.clear();
        tex2.clear();
        tex3.clear();
        tex4.clear();

        mostrarMensajeGuardado();
    }
    private void mostrarMensajeGuardado() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Guardado exitoso");
        alert.setHeaderText(null);
        alert.setContentText("Se ha añadido la actividad con éxito.");
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
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

}
