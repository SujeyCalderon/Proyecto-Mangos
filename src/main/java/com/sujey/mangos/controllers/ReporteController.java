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
            double totalVentas = calcularTotalVentas(admin);
            double totalGastos = calcularTotalGastos(admin);

            Reporte reporte = new Reporte(totalVentas, totalGastos);
            LIst2.getItems().clear();
            LIst2.getItems().add(reporte.toString());
        }
    }

    private double calcularTotalVentas(Administracion admin) {
        double totalVentas = 0;
        for (Venta venta : admin.getListVenta()) {
            venta.totalVenta();
            totalVentas += venta.getCantidad() * venta.getPrecio();
        }
        return totalVentas;
    }

    private double calcularTotalGastos(Administracion admin) {
        Gasto gasto = new Gasto();
        gasto.generarReporte(admin);
        return gasto.getTotalGastos();
    }

    @FXML
    void MouseClickoffWindow(MouseEvent event) {
        Stage stage = (Stage) offWindow.getScene().getWindow();
        stage.close();
    }
}
