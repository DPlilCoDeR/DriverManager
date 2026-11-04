package com.m486.model;

public class Persona {
    private String nif;
    private String nombre;
    private int edat;

    public Persona(String nif, String nombre, int edat) {
        this.nif = nif;
        this.nombre = nombre;
        this.edat = edat;
    }

    public String getNif() {
        return nif;
    }
    public void setNif(String nif) {
        this.nif = nif;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getEdat() {
        return edat;
    }
    public void setEdat(int edat) {
        this.edat = edat;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edat=" + edat +
                '}';
    }
}
