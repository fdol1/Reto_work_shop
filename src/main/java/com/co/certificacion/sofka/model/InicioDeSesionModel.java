package com.co.certificacion.sofka.model;

public class InicioDeSesionModel {

    private String usuario;
    private String clave;

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }
}
