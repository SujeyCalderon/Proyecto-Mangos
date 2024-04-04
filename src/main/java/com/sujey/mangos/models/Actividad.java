package com.sujey.mangos.models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;

public class Actividad {
    private final SimpleStringProperty fecha;
    private final SimpleStringProperty nombre;
    private final SimpleDoubleProperty costo;
    private final SimpleStringProperty cantidadHec;

    public Actividad(String fecha, String nombre, double costo, String cantidadHec) {
        this.fecha = new SimpleStringProperty(fecha);
        this.nombre = new SimpleStringProperty(nombre);
        this.costo = new SimpleDoubleProperty(costo);
        this.cantidadHec = new SimpleStringProperty(cantidadHec);
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

    public String getNombre() {
        return nombre.get();
    }

    public SimpleStringProperty nombreProperty() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
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

    public String getCantidadHec() {
        return cantidadHec.get();
    }

    public SimpleStringProperty cantidadHecProperty() {
        return cantidadHec;
    }

    public void setCantidadHec(String cantidadHec) {
        this.cantidadHec.set(cantidadHec);
    }

    @Override
    public String toString() {
        return "Actividad: " + '\n' +
                "Fecha: " + fecha.get() + '\n' +
                "Actividad: " + nombre.get() + '\n' +
                "Costo= " + costo.get() +'\n'+
                "Cantidad por Héctareas= " + cantidadHec.get();
    }
}
