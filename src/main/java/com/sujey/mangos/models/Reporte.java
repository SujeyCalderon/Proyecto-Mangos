package com.sujey.mangos.models;

import javafx.beans.property.SimpleDoubleProperty;

public class Reporte {
    private SimpleDoubleProperty totalVentas;
    private SimpleDoubleProperty totalGastos;

    public Reporte(double totalVentas, double totalGastos) {
        this.totalVentas = new SimpleDoubleProperty(totalVentas);
        this.totalGastos = new SimpleDoubleProperty(totalGastos);
    }

    public SimpleDoubleProperty TotalVentas() {
        return totalVentas;
    }

    public SimpleDoubleProperty TotalGastos() {
        return totalGastos;
    }


    @Override
    public String toString() {
        return "Reporte: " + '\n' +
                "Ganancias= " + totalVentas +'\n' +
                "Gastos= " + totalGastos;
    }
}
