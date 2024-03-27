package com.sujey.mangos.models;

import java.util.ArrayList;

public class Administracion {
    private ArrayList<Actividad> listActividad = new ArrayList<>();
    private ArrayList<Combustible> listCombustible = new ArrayList<>();
    private ArrayList<Cultivo> listCultivo = new ArrayList<>();
    private ArrayList<Medicamento> listMedicamento = new ArrayList<>();
    private ArrayList<Venta> listVenta = new ArrayList<>();

    public ArrayList<Actividad> getListActividad() {
        return listActividad;
    }

    public ArrayList<Combustible> getListCombustible() {
        return listCombustible;
    }

    public ArrayList<Cultivo> getListCultivo() {
        return listCultivo;
    }

    public ArrayList<Medicamento> getListMedicamento() {
        return listMedicamento;
    }

    public ArrayList<Venta> getListVenta() {
        return listVenta;
    }
}
