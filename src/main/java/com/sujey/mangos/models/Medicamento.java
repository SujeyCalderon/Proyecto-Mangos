package com.sujey.mangos.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Medicamento{
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty fecha;
    private final SimpleStringProperty descripcion;
    private final SimpleStringProperty cantidad;
    private final SimpleDoubleProperty costo;

    public Medicamento(String nombre, String fecha, String descripcion, String cantidad, double costo) {
        this.nombre = new SimpleStringProperty(nombre);
        this.fecha = new SimpleStringProperty(fecha);
        this.descripcion = new SimpleStringProperty(descripcion);
        this.cantidad = new SimpleStringProperty(cantidad);
        this.costo = new SimpleDoubleProperty(costo);
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getFecha() {
        return fecha.get();
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public String getDescripcion() {
        return descripcion.get();
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    public String getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(String cantidad) {
        this.cantidad.set(cantidad);
    }

    public double getCosto() {
        return costo.get();
    }

    public void setCosto(double costo) {
        this.costo.set(costo);
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public SimpleStringProperty fechaProperty() {
        return fecha;
    }

    public SimpleStringProperty descripcionProperty() {
        return descripcion;
    }

    public SimpleStringProperty cantidadProperty() {
        return cantidad;
    }

    public SimpleDoubleProperty costoProperty() {
        return costo;
    }
    private Gasto gasto;
}
