package com.example.guillermo_garciadam2.model;

public class Equipo {
    private String nombre,liga,imagen;

    public Equipo(String nombre, String liga, String imagen) {
        this.nombre = nombre;
        this.liga = liga;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLiga() {
        return liga;
    }

    public String getImagen() {
        return imagen;
    }
}
