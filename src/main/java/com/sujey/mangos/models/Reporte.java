package com.sujey.mangos.models;

import java.util.ArrayList;

public class Reporte {
    private double totalVentas;
    private double totalGastos;

    public Reporte(double totalVentas, double totalGastos) {
        this.totalVentas = totalVentas;
        this.totalGastos = totalGastos;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public double getTotalGastos() {
        return totalGastos;
    }
    public void generarReporte(Administracion admin) {



    }
}
