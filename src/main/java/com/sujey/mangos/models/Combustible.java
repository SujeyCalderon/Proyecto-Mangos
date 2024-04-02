package com.sujey.mangos.models;

public class Combustible extends Producto{
    private String nombre;
    private String fecha;
    private String descripcion;

    private String maquinaria;
    private double costo;

    public Combustible(String nombre, String fecha, String descripcion, String maquinaria, double costo) {
        super(nombre, fecha, descripcion);
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.maquinaria = maquinaria;
        this.costo = costo;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String getFecha() {
        return fecha;
    }

    @Override
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMaquinaria() {
        return maquinaria;
    }

    public void setMaquinaria(String maquinaria) {
        this.maquinaria = maquinaria;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void total2(){
        double total=0;
        total= total+getCosto();
    }
    @Override
    public String toString() {
        return "Combustible " +
                "Nombre: " + nombre + '\n' +
                "Fecha: " + fecha + '\n' +
                "Descripcion: " + descripcion + '\n' +
                "Maquinaria: " + maquinaria + '\n' +
                "Costo = " + costo ;
    }
}
