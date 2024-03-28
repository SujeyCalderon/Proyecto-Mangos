package com.sujey.mangos.models;

public class Venta {
    private String tipo;
    private String fecha;
    private double cantidad;
    private double precio;
    private double sueldo;

    public Venta(String tipo, String fecha, double cantidad, double precio, double sueldo) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precio = precio;
        this.sueldo = sueldo;
    }

    @Override
    public String toString() {
        return "Venta: " +
                "Tipo: " + tipo + '\n' +
                "Fecha: " + fecha + '\n' +
                "Cantidad= " + cantidad + '\n' +
                "Precio= " + precio + '\n' +
                "Sueldo= " + sueldo ;
    }
}
