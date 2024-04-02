package com.sujey.mangos.models;

public class Actividad {
    private String fecha;
    private String nombre;
    private double costo;
    private String cantidadHec;

    public Actividad(String fecha, String nombre, double costo, String cantidadHec) {
        this.fecha = fecha;
        this.nombre = nombre;
        this.costo = costo;
        this.cantidadHec = cantidadHec;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public String getCantidadHec() {
        return cantidadHec;
    }

    public void setCantidadHec(String cantidadHec) {
        this.cantidadHec = cantidadHec;
    }

    public void total3 (){
        double total=0;
        total=total+ getCosto();
    }

    @Override
    public String toString() {
        return "Actividad = " +
                "Fecha= " + fecha + '\n' +
                "Actividad= " + nombre + '\n' +
                "Costo= " + costo +'\n'+
                "CantidadHec= " + cantidadHec ;
    }
}
