package com.sujey.mangos.models;

import java.util.ArrayList;

public class Gasto {
    private double totalActividades;
    private double totalMedicamentos;
    private double totalCombustibles;

    public Gasto() {
        this.totalActividades = 0;
        this.totalMedicamentos = 0;
        this.totalCombustibles = 0;
    }

    public double getTotalActividades() {
        return totalActividades;
    }

    public double getTotalMedicamentos() {
        return totalMedicamentos;
    }

    public double getTotalCombustibles() {
        return totalCombustibles;
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

    }
    @Override
    public String toString() {
        return "Gastos: " + '\n' +
                "Actividades= " + totalActividades +  '\n' +
                "Medicamentos= " + totalMedicamentos +  '\n' +
                "Combustibles= " + totalCombustibles;
    }
}
