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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCantidadHec() {
        return cantidadHec;
    }

    public void setCantidadHec(String cantidadHec) {
        this.cantidadHec = cantidadHec;
    }

    public String getDistancia() {
        return distancia;
    }

    public void setDistancia(String distancia) {
        this.distancia = distancia;
    }

    public String getTipoLuna() {
        return tipoLuna;
    }

    public void setTipoLuna(String tipoLuna) {
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
