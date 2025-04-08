package com.co.certificacion.sofka.model;

public class InfoPersonalModel {

    private String nombre1;
    private String nombre2;
    private String codigoPostal;

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getNombre2() {
        return nombre2;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }
}
