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
        return "Actividad{" +
                "fecha='" + fecha + '\'' +
                ", actividad='" + actividad + '\'' +
                ", costo=" + costo +
                ", cantidadHec='" + cantidadHec + '\'' +
                '}';
    }
}
