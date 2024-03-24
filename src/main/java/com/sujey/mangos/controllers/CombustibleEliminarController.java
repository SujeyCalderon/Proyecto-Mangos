package com.sujey.mangos.controllers;

import com.sujey.mangos.Login;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class CombustibleEliminarController {

    @FXML
    private Button Agregar;

    @FXML
    private Button Cost;

    @FXML
    private Button Descrip;

    @FXML
    private Button Eliminar;

    @FXML
    private Button Fecha;

    @FXML
    private Button Maqui;

    @FXML
    private Button Mostrar;

    @FXML
    private Button Nombre;

    @FXML
    private Button offWindow;

    @FXML
    void MouseClickCost(MouseEvent event) {

    }

    @FXML
    void MouseClickDescrip(MouseEvent event) {

    }

    @FXML
    void MouseClickFecha(MouseEvent event) {

    }

    @FXML
    void MouseClickMaqui(MouseEvent event) {

    }

    @FXML
    void MouseClickNombre(MouseEvent event) {

    }

    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

    @FXML
    void OnMouseClickedAgregar(MouseEvent event) {
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
    void OnMouseClickedEliminar(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("combustibleEliminar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Eliminar combustibles");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void OnMouseClickedMostrar(MouseEvent event) {
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

}
