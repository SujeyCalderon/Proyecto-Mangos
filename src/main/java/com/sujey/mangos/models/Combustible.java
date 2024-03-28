package com.sujey.mangos.models;

public class Combustible extends Producto{
    private String nombre;
    private String fecha;
    private String descripcion;

    private String maquinaria;
    private double costo;

    public Combustible(String nombre, String fecha, String descripcion, String nombre1, String fecha1, String descripcion1, String maquinaria, double costo) {
        super(nombre, fecha, descripcion);
        this.nombre = nombre1;
        this.fecha = fecha1;
        this.descripcion = descripcion1;
        this.maquinaria = maquinaria;
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "Combustible{" +
                "nombre='" + nombre + '\'' +
                ", fecha='" + fecha + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", maquinaria='" + maquinaria + '\'' +
                ", costo=" + costo +
                '}';
    }
}
