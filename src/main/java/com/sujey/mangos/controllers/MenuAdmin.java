package com.sujey.mangos.controllers;

import com.sujey.mangos.Login;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuAdmin {


    @FXML
    private Button activ;

    @FXML
    private Button combus;

    @FXML
    private Button cultiv;

    @FXML
    private Button medica;

    @FXML
    private Button vent;

    @FXML
    private Button offWindow;
    private Stage primaryStage;

    @FXML
    void MouseClickActiv(MouseEvent event) {
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
    void MouseClickCombus(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("combustibleAgregar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Agregar Combustibles");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void MouseClickCultiv(MouseEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("cultivoAgregar-view-fxml.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage callAgregar = new Stage();
            callAgregar.setTitle("Agregar cultivos");
            callAgregar.setScene(scene);
            callAgregar.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void MouseClickMedica(MouseEvent event) {
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
    void MouseClickVent(MouseEvent event) {
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
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }
    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }
}
