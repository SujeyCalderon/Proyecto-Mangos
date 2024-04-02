package com.sujey.mangos.models;

import java.util.ArrayList;

public class Reporte {
    private double totalVentas;
    private double totalGastos;

    public Reporte(double totalVentas, double totalGastos) {
        this.totalVentas = totalVentas;
        this.totalGastos = totalGastos;
    }

    @Override
    public String toString() {
        return "Reporte: " + '\n' +
                "Ganancias= " + totalVentas +'\n' +
                "Gastos= " + totalGastos;
    }
}
