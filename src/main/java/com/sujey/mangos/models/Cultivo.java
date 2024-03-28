package com.sujey.mangos.models;

public class Cultivo {
    private String tipo;
    private String fecha;
    private String cantidadHec;
    private String distancia;
    private String tipoLuna;

    public Cultivo(String tipo, String fecha, String cantidadHec, String distancia, String tipoLuna) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.cantidadHec = cantidadHec;
        this.distancia = distancia;
        this.tipoLuna = tipoLuna;
    }

    @Override
    public String toString() {
        return "Cultivo{" +
                "tipo='" + tipo + '\'' +
                ", fecha='" + fecha + '\'' +
                ", cantidadHec='" + cantidadHec + '\'' +
                ", distancia='" + distancia + '\'' +
                ", tipoLuna='" + tipoLuna + '\'' +
                '}';
    }
}
