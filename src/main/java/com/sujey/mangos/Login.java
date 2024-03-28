package com.sujey.mangos;

import com.sujey.mangos.models.Administracion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


import java.io.IOException;

public class Login extends Application {
    public static Administracion admin  = new Administracion();
    public static Administracion getAdmin(){
        return admin;
    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Login.class.getResource("Login-view.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setTitle("Login / Inicio de sesion");
        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(event -> {
            event.consume();
        });
    }
}