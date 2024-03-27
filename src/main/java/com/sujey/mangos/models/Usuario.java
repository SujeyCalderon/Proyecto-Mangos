package com.sujey.mangos.models;

public class Usuario {
    private String tipo = "Super admin";
    private String tipo2 = "admin";
    private  String usuario = "Sujey";
    private String contrasenia = "calder123";
    private  String usuario2 = "Hannia";
    private String contrasenia2 = "pao123";

    public String getUsuario() {
        return usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getUsuario2() {
        return usuario2;
    }

    public String getContrasenia2() {
        return contrasenia2;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTipo2() {
        return tipo2;
    }
}

