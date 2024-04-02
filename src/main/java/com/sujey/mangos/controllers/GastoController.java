package com.sujey.mangos.controllers;

import com.sujey.mangos.models.Gasto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static com.sujey.mangos.Login.admin;

public class GastoController {

@FXML
private ListView<String> List3;

@FXML
private Button Ver;

@FXML
private Button offWindow;

    @FXML
    void MouseClickVer(MouseEvent event) {
        if (admin != null) {
            Gasto gasto = new Gasto();
            gasto.generarReporte(admin);

            List3.getItems().clear();
            List3.getItems().add(gasto.toString());
        }
    }

@FXML
void MouseClickoffWindow(MouseEvent event) {
    Stage stage = (Stage) offWindow.getScene().getWindow();
    stage.close();
}

}
