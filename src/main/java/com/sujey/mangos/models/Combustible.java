package com.sujey.mangos.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Combustible extends Producto {
    private SimpleStringProperty nombre;
    private SimpleStringProperty fecha;
    private SimpleStringProperty descripcion;
    private SimpleStringProperty maquinaria;
    private SimpleDoubleProperty costo;

    public Combustible(String nombre, String fecha, String descripcion, String maquinaria, double costo) {
        super(nombre, fecha, descripcion);
        this.nombre = new SimpleStringProperty(nombre);
        this.fecha = new SimpleStringProperty(fecha);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.maquinaria = new SimpleStringProperty(maquinaria);
        this.costo = new SimpleDoubleProperty(costo);
    }

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getFecha() {
        return fecha.get();
    }

    public SimpleStringProperty fechaProperty() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public SimpleStringProperty descripcionProperty() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public String getMaquinaria() {
        return maquinaria.get();
    }

    public SimpleStringProperty maquinariaProperty() {
        return maquinaria;
    }

    public void setMaquinaria(String maquinaria) {
        this.maquinaria.set(maquinaria);
    }

    public double getCosto() {
        return costo.get();
    }

    public SimpleDoubleProperty costoProperty() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo.set(costo);
    }

    @Override
    public String toString() {
        return "Combustible: " + '\n' +
                "Nombre: " + nombre.get() + '\n' +
                "Fecha: " + fecha.get() + '\n' +
                "Descripcion: " + descripcion.get() + '\n' +
                "Maquinaria: " + maquinaria.get() + '\n' +
                "Costo = " + costo.get();
    }
}
