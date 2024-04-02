package com.sujey.mangos.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Administracion {
    private ArrayList<Actividad> listActividad = new ArrayList<>();
    private ArrayList<Combustible> listCombustible = new ArrayList<>();
    private ArrayList<Cultivo> listCultivo = new ArrayList<>();
    private ArrayList<Medicamento> listMedicamento = new ArrayList<>();
    private ArrayList<Venta> listVenta = new ArrayList<>();
    private Set<Integer> indicesEliminados = new HashSet<>();


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
    public boolean addActividad(Actividad actividad) {
        return listActividad.add(actividad);
    }
    public boolean eliminarVenta(int indice) {
        if (indice >= 0 && indice < listVenta.size()) {
            indicesEliminados.add(indice);
            return true;
        }
        return false;
    }
    public Set<Integer> getIndicesEliminados() {
        return indicesEliminados;
    }
    public boolean esEliminado(int indice) {
        return indicesEliminados.contains(indice);
    }
    public boolean addCombustible(Combustible combustible) {
        return listCombustible.add(combustible);
    }
    public boolean addCultivo(Cultivo cultivo) {
        return listCultivo.add(cultivo);
    }
    public boolean addMedicamento(Medicamento medicamento) {
        return listMedicamento.add(medicamento);
    }
    public boolean addVenta(Venta venta) {
        return listVenta.add(venta);
    }



}
