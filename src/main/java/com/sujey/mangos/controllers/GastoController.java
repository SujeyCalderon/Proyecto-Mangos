package com.sujey.mangos.controllers;

import com.sujey.mangos.models.Gasto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static com.sujey.mangos.Login.admin;

public class GastoController {

@FXML
private TableView<?> TableGastos;

    @FXML
    private TableColumn<?, ?> ActividadesColumn;

    @FXML
    private TableColumn<?, ?> MedicamentosColumn;

    @FXML
    private TableColumn<?, ?> CombustiblesColumn;

    @FXML
    private TableColumn<?, ?> SueldoColumn;

    @FXML
    private TableColumn<?, ?> GastosColumn;

@FXML
private Button Ver;

@FXML
private Button offWindow;

    @FXML
    void MouseClickVer(MouseEvent event) {
        if (admin != null) {
            Gasto gasto = new Gasto();
            gasto.generarReporte(admin);

            TableGastos.getItems().clear();
            TableGastos.getItems().add(gasto.toString());
        }
    }

@FXML
void MouseClickoffWindow(MouseEvent event) {
    Stage stage = (Stage) offWindow.getScene().getWindow();
    stage.close();
}

}
