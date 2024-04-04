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
private TableView<Gasto> TableGastos;

    @FXML
    private TableColumn<Gasto, Double> ActividadesColumn;

    @FXML
    private TableColumn<Gasto, Double> MedicamentosColumn;

    @FXML
    private TableColumn<Gasto, Double> CombustiblesColumn;

    @FXML
    private TableColumn<Gasto, Double> SueldoColumn;

    @FXML
    private TableColumn<Gasto, Double> GastosColumn;

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

            TableGastos.setItems(gastosList);
        }
    }

    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void initialize() {
        ActividadesColumn.setCellValueFactory(cellData -> cellData.getValue().totalActividadesProperty().asObject());
        MedicamentosColumn.setCellValueFactory(cellData -> cellData.getValue().totalMedicamentosProperty().asObject());
        CombustiblesColumn.setCellValueFactory(cellData -> cellData.getValue().totalCombustiblesProperty().asObject());
        SueldoColumn.setCellValueFactory(cellData -> cellData.getValue().totalSueldoProperty().asObject());
        GastosColumn.setCellValueFactory(cellData -> cellData.getValue().totalGastosProperty().asObject());
    }

}
