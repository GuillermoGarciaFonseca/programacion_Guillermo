package org.example.model;

import jakarta.persistence.Column;

public class Perfil {
    @Column
    private int idPerfil;
    @Column
    private String nombreP;

    public Perfil() {
    }

    public Perfil(int idP, String nombre) {
        this.idPerfil = idP;
        this.nombreP = nombre;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "idP=" + idPerfil +
                ", nombre='" + nombreP + '\'' +
                '}';
    }

    public String getNombre() {
        return nombreP;
    }

    public void setNombre(String nombre) {
        this.nombreP = nombre;
    }

    public int getIdP() {
        return idPerfil;
    }

    public void setIdP(int idP) {
        this.idPerfil = idP;
    }
}
