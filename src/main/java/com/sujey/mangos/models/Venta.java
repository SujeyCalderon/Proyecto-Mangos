package com.sujey.mangos.models;

public class Venta {
    private String tipo;
    private String fecha;
    private double cantidad;
    private double precio;
    private double sueldo;
    private static double totalVentas = 0;

    public Venta(String tipo, String fecha, double cantidad, double precio, double sueldo) {
        this.tipo = tipo;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precio = precio;
        this.sueldo = sueldo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void totalVenta(){
        double multiplicacion = getCantidad() * getPrecio();
        totalVentas += multiplicacion;
    }




    @Override
    public String toString() {
        return "Venta: " + '\n' +
                "Tipo: " + tipo + '\n' +
                "Fecha: " + fecha + '\n' +
                "Cantidad= " + cantidad + '\n' +
                "Precio= " + precio + '\n' +
                "Sueldo= " + sueldo ;
    }


}
