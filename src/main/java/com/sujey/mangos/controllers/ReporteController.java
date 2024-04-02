package com.sujey.mangos.controllers;

import com.sujey.mangos.models.Administracion;
import com.sujey.mangos.models.Gasto;
import com.sujey.mangos.models.Reporte;
import com.sujey.mangos.models.Venta;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import static com.sujey.mangos.Login.admin;

public class ReporteController {

    @FXML
    private ListView<String> LIst2;

    @FXML
    private Button Ver;

    @FXML
    private Button offWindow;

    @FXML
    void MouseClickVer(MouseEvent event) {
        if (admin != null) {
            calcularTotalVentas(admin);

            Reporte reporte = new Reporte(Venta.getTotalVentas(), Gasto.getTotalGastos());
            LIst2.getItems().clear();
            LIst2.getItems().add(reporte.toString());
        }
    }

    private void calcularTotalVentas(Administracion admin) {
        for (Venta venta : admin.getListVenta()) {
            venta.totalVenta();
        }
    }

    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }

}
