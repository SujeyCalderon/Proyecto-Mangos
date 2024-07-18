package com.sujey.mangos.controllers;

import com.sujey.mangos.models.Gasto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static com.sujey.mangos.Login.admin;

public class GastoController {

@FXML
private TableView<Gasto> tableGastos;

    @FXML
    private TableColumn<Gasto, Double> actividadesColumn;

    @FXML
    private TableColumn<Gasto, Double> medicamentosColumn;

    @FXML
    private TableColumn<Gasto, Double> combustiblesColumn;

    @FXML
    private TableColumn<Gasto, Double> sueldoColumn;

    @FXML
    private TableColumn<Gasto, Double> gastosColumn;

@FXML
private Button Ver;

@FXML
private Button offWindow;

    @FXML
    void MouseClickVer(MouseEvent event) {
        if (admin != null) {
            Gasto gasto = new Gasto();
            gasto.generarReporte(admin);

            ObservableList<Gasto> gastosList = FXCollections.observableArrayList();
            gastosList.add(gasto);

            tableGastos.setItems(gastosList);
        }
    }

    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize() {
        actividadesColumn.setCellValueFactory(cellData -> cellData.getValue().totalActividadesProperty().asObject());
        medicamentosColumn.setCellValueFactory(cellData -> cellData.getValue().totalMedicamentosProperty().asObject());
        combustiblesColumn.setCellValueFactory(cellData -> cellData.getValue().totalCombustiblesProperty().asObject());
        sueldoColumn.setCellValueFactory(cellData -> cellData.getValue().totalSueldoProperty().asObject());
        gastosColumn.setCellValueFactory(cellData -> cellData.getValue().totalGastosProperty().asObject());
    }

}
