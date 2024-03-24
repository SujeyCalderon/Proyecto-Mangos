package com.sujey.mangos.models;

public class Producto {
    protected String nombre;
    protected String Fecha;
    protected String Descripcion;

    public Producto(String nombre, String fecha, String descripcion) {
        this.nombre = nombre;
        Fecha = fecha;
        Descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
