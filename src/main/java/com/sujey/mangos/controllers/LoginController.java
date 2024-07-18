package com.sujey.mangos.controllers;

import com.sujey.mangos.Login;
import com.sujey.mangos.models.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    Usuario usuario = new Usuario();

    @FXML
    private TextField contraseñaUsuario;


    @FXML
    private Button ingresarUsuario;

    @FXML
    private TextField nombreUsuario;
    private String Contrasena;
    Stage callMenu = new Stage();
    Stage callMenu2 = new Stage();
    @FXML
    private Button SalirButton;


    @FXML
    void OnMouseClickedIngresarUsuario(MouseEvent event) {
        String nombreUsu = nombreUsuario.getText();
        String contrasena = contraseñaUsuario.getText();
        if (nombreUsu.equals(usuario.getUsuario()) && contrasena.equals(usuario.getContrasenia())) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("menuSuperAdmin-view-fxml.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                MenuSuperAdminController menuSuperAdminController = fxmlLoader.getController();
                menuSuperAdminController.setPrimaryStage(callMenu);
                callMenu.setTitle("Menú de super Administrador");
                callMenu.setScene(scene);
                callMenu.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (nombreUsu.equals(usuario.getUsuario2()) && contrasena.equals(usuario.getContrasenia2())) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("menuAdmin-view-fxml.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                MenuAdmin menuAdmin = fxmlLoader.getController();
                menuAdmin.setPrimaryStage(callMenu2);
                callMenu2.setTitle("Menú de Administrador");
                callMenu2.setScene(scene);
                callMenu2.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    void OnMouseClickedSalirButton(MouseEvent event) {
        Stage stage = (Stage) SalirButton.getScene().getWindow();
        stage.close();
    }
}

