package com.sujey.mangos.models;

import java.util.ArrayList;

public class Gasto {
    private double totalActividades;
    private double totalMedicamentos;
    private double totalCombustibles;
    private double totalSueldo;
    private double totalGastos;

    public Gasto() {
        this.totalActividades = 0;
        this.totalMedicamentos = 0;
        this.totalCombustibles = 0;
        this.totalGastos = 0;
        this.totalSueldo =0;
    }


    public double getTotalGastos() {
        return totalGastos;
    }

    public void generarReporte(Administracion admin) {
        ArrayList<Actividad> actividades = admin.getListActividad();
        ArrayList<Medicamento> medicamentos = admin.getListMedicamento();
        ArrayList<Combustible> combustibles = admin.getListCombustible();
        ArrayList<Venta> ventas = admin.getListVenta();

        for (Actividad actividad : actividades) {
            totalActividades += actividad.getCosto();
        }

        for (Medicamento medicamento : medicamentos) {
            totalMedicamentos += medicamento.getCosto();
        }

        for (Combustible combustible : combustibles) {
            totalCombustibles += combustible.getCosto();
        }
        for (Venta venta : ventas) {
            totalSueldo += venta.getSueldo();
        }

        totalGastos = totalActividades + totalMedicamentos + totalCombustibles+totalSueldo;
    }

    @Override
    public String toString() {
        return "Gastos: " + '\n' +
                "Actividades= " + totalActividades +  '\n' +
                "Medicamentos= " + totalMedicamentos +  '\n' +
                "Combustibles= " + totalCombustibles +  '\n' +
                "Sueldo= " +totalSueldo;
    }
}
