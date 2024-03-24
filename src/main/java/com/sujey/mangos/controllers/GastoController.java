package com.sujey.mangos.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GastoController {

@FXML
private ListView<?> List3;

@FXML
private Button Ver;

@FXML
private Button offWindow;

@FXML
void MouseClickVer(MouseEvent event) {

}

@FXML
void MouseClickoffWindow(MouseEvent event) {
    Stage stage = (Stage) offWindow.getScene().getWindow();
    stage.close();
}

}
