package com.sujey.mangos.models;

public class Medicamento {
    private String nombre;
    private String fecha;
    private String descripcion;
    private String cantidad;
    private double costo;

    public Medicamento(String nombre, String fecha, String descripcion, String cantidad, double costo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cantidad='" + cantidad + '\'' +
                ", costo=" + costo +
                '}';
    }
}
