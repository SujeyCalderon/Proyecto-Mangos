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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    public void total(){
       double total=0;
       total=total+getCosto();
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
