package com.sujey.mangos.models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Venta {
    private StringProperty tipo;
    private StringProperty fecha;
    private DoubleProperty cantidad;
    private DoubleProperty precio;
    private DoubleProperty sueldo;
    private static double totalVentas = 0;

    public Venta(String tipo, String fecha, double cantidad, double precio, double sueldo) {
        this.tipo = new SimpleStringProperty(tipo);
        this.fecha = new SimpleStringProperty(fecha);
        this.cantidad = new SimpleDoubleProperty(cantidad);
        this.precio = new SimpleDoubleProperty(precio);
        this.sueldo = new SimpleDoubleProperty(sueldo);
    }

    public String getTipo() {
        return tipo.get();
    }

    public StringProperty tipoProperty() {
        return tipo;
    }

    public String getFecha() {
        return fecha.get();
    }

    public StringProperty fechaProperty() {
        return fecha;
    }

    public double getCantidad() {
        return cantidad.get();
    }

    public DoubleProperty cantidadProperty() {
        return cantidad;
    }

    public double getPrecio() {
        return precio.get();
    }

    public DoubleProperty precioProperty() {
        return precio;
    }

    public double getSueldo() {
        return sueldo.get();
    }

    public DoubleProperty sueldoProperty() {
        return sueldo;
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public void setCantidad(double cantidad) {
        this.cantidad.set(cantidad);
    }

    public void setPrecio(double precio) {
        this.precio.set(precio);
    }

    public void setSueldo(double sueldo) {
        this.sueldo.set(sueldo);
    }

    public void totalVenta() {
        double multiplicacion = getCantidad() * getPrecio();
        totalVentas += multiplicacion;
    }

    @Override
    public String toString() {
        return "Venta: " + '\n' +
                "Tipo: " + tipo.get() + '\n' +
                "Fecha: " + fecha.get() + '\n' +
                "Cantidad= " + cantidad.get() + '\n' +
                "Precio= " + precio.get() + '\n' +
                "Sueldo= " + sueldo.get();
    }
}
