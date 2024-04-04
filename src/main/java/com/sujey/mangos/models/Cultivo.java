package com.sujey.mangos.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cultivo {
    private final StringProperty tipo;
    private final StringProperty fecha;
    private final StringProperty cantidadHec;
    private final StringProperty distancia;
    private final StringProperty tipoLuna;

    public Cultivo(String tipo, String fecha, String cantidadHec, String distancia, String tipoLuna) {
        this.tipo = new SimpleStringProperty(tipo);
        this.fecha = new SimpleStringProperty(fecha);
        this.cantidadHec = new SimpleStringProperty(cantidadHec);
        this.distancia = new SimpleStringProperty(distancia);
        this.tipoLuna = new SimpleStringProperty(tipoLuna);
    }

    public StringProperty tipoProperty() {
        return tipo;
    }

    public StringProperty fechaProperty() {
        return fecha;
    }

    public StringProperty cantidadHecProperty() {
        return cantidadHec;
    }

    public StringProperty distanciaProperty() {
        return distancia;
    }

    public StringProperty tipoLunaProperty() {
        return tipoLuna;
    }

    public String getTipo() {
        return tipo.get();
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    public String getFecha() {
        return fecha.get();
    }

    public void setFecha(String fecha) {
        this.fecha.set(fecha);
    }

    public String getCantidadHec() {
        return cantidadHec.get();
    }

    public void setCantidadHec(String cantidadHec) {
        this.cantidadHec.set(cantidadHec);
    }

    public String getDistancia() {
        return distancia.get();
    }

    public void setDistancia(String distancia) {
        this.distancia.set(distancia);
    }

    public String getTipoLuna() {
        return tipoLuna.get();
    }

    public void setTipoLuna(String tipoLuna) {
        this.tipoLuna.set(tipoLuna);
    }

    @Override
    public String toString() {
        return "Cultivo{" +
                "tipo=" + tipo.get() +
                ", fecha=" + fecha.get() +
                ", cantidadHec=" + cantidadHec.get() +
                ", distancia=" + distancia.get() +
                ", tipoLuna=" + tipoLuna.get() +
                '}';
    }
}
