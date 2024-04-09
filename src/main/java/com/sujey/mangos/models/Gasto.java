package com.sujey.mangos.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

import java.util.ArrayList;

public class Gasto {
    private final DoubleProperty totalActividades;
    private final DoubleProperty totalMedicamentos;
    private final DoubleProperty totalCombustibles;
    private final DoubleProperty totalSueldo;
    private final DoubleProperty totalGastos;

    public Gasto() {
        this.totalActividades = new SimpleDoubleProperty(0);
        this.totalMedicamentos = new SimpleDoubleProperty(0);
        this.totalCombustibles = new SimpleDoubleProperty(0);
        this.totalGastos = new SimpleDoubleProperty(0);
        this.totalSueldo = new SimpleDoubleProperty(0);
    }

    public double getTotalActividades() {
        return totalActividades.get();
    }

    public DoubleProperty totalActividadesProperty() {
        return totalActividades;
    }

    public void setTotalActividades(double totalActividades) {
        this.totalActividades.set(totalActividades);
    }

    public double getTotalMedicamentos() {
        return totalMedicamentos.get();
    }

    public DoubleProperty totalMedicamentosProperty() {
        return totalMedicamentos;
    }

    public void setTotalMedicamentos(double totalMedicamentos) {
        this.totalMedicamentos.set(totalMedicamentos);
    }

    public double getTotalCombustibles() {
        return totalCombustibles.get();
    }

    public DoubleProperty totalCombustiblesProperty() {
        return totalCombustibles;
    }

    public void setTotalCombustibles(double totalCombustibles) {
        this.totalCombustibles.set(totalCombustibles);
    }

    public double getTotalSueldo() {
        return totalSueldo.get();
    }

    public DoubleProperty totalSueldoProperty() {
        return totalSueldo;
    }

    public void setTotalSueldo(double totalSueldo) {
        this.totalSueldo.set(totalSueldo);
    }

    public double getTotalGastos() {
        return totalGastos.get();
    }

    public DoubleProperty totalGastosProperty() {
        return totalGastos;
    }

    public void setTotalGastos(double totalGastos) {
        this.totalGastos.set(totalGastos);
    }

    public void generarReporte(Administracion admin) {
        ArrayList<Actividad> actividades = admin.getListActividad();
        ArrayList<Medicamento> medicamentos = admin.getListMedicamento();
        ArrayList<Combustible> combustibles = admin.getListCombustible();
        ArrayList<Venta> ventas = admin.getListVenta();

        for (Actividad actividad : actividades) {
            totalActividades.set(totalActividades.get() + actividad.getCosto());
        }

        for (Medicamento medicamento : medicamentos) {
            totalMedicamentos.set(totalMedicamentos.get() + medicamento.getCosto());
        }

        for (Combustible combustible : combustibles) {
            totalCombustibles.set(totalCombustibles.get() + combustible.getCosto());
        }

        for (Venta venta : ventas) {
            totalSueldo.set(totalSueldo.get() + venta.getSueldo());
        }

        totalGastos.set(totalActividades.get() + totalMedicamentos.get() + totalCombustibles.get() + totalSueldo.get());
    }

    @Override
    public String toString() {
        return "Gastos: " + '\n' +
                "Actividades= " + totalActividades.get() + '\n' +
                "Medicamentos= " + totalMedicamentos.get() + '\n' +
                "Combustibles= " + totalCombustibles.get() + '\n' +
                "Sueldo= " + totalSueldo.get();
    }
}
