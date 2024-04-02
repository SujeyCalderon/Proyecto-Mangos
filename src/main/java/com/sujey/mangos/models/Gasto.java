package com.sujey.mangos.models;

import java.util.ArrayList;

public class Gasto {
    private double totalActividades;
    private double totalMedicamentos;
    private double totalCombustibles;
    private double totalGastos; // Eliminar "static" aquí

    public Gasto() {
        this.totalActividades = 0;
        this.totalMedicamentos = 0;
        this.totalCombustibles = 0;
        this.totalGastos = 0; // Inicializar en el constructor
    }

    // Otros métodos de la clase aquí...

    public double getTotalGastos() {
        return totalGastos;
    }

    public void generarReporte(Administracion admin) {
        ArrayList<Actividad> actividades = admin.getListActividad();
        ArrayList<Medicamento> medicamentos = admin.getListMedicamento();
        ArrayList<Combustible> combustibles = admin.getListCombustible();

        for (Actividad actividad : actividades) {
            totalActividades += actividad.getCosto();
        }

        for (Medicamento medicamento : medicamentos) {
            totalMedicamentos += medicamento.getCosto();
        }

        for (Combustible combustible : combustibles) {
            totalCombustibles += combustible.getCosto();
        }

        totalGastos = totalActividades + totalMedicamentos + totalCombustibles;
    }

    @Override
    public String toString() {
        return "Gastos: " + '\n' +
                "Actividades= " + totalActividades +  '\n' +
                "Medicamentos= " + totalMedicamentos +  '\n' +
                "Combustibles= " + totalCombustibles;
    }
}
