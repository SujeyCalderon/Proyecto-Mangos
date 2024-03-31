package com.sujey.mangos.models;

public class Actividad {
    private String fecha;
    private String actividad;
    private double costo;
    private String cantidadHec;

    public Actividad(String fecha, String actividad, double costo, String cantidadHec) {
        this.fecha = fecha;
        this.actividad = actividad;
        this.costo = costo;
        this.cantidadHec = cantidadHec;
    }

    @Override
    public String toString() {
        return "Actividad = " +
                "Fecha='" + fecha + '\n' +
                "Actividad='" + actividad + '\n' +
                "Costo=" + costo +'\n'+
                "CantidadHec='" + cantidadHec ;
    }
}
