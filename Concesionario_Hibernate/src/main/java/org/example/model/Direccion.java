package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

public class Direccion {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private int nplazas;
    @Column
    private String direccion;
@Column
private String  calle;
    public Direccion() {
    }

    public Direccion(int nplazas, String direccion) {
        this.nplazas = nplazas;
        this.direccion = direccion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNplazas() {
        return nplazas;
    }

    public void setNplazas(int nplazas) {
        this.nplazas = nplazas;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Direccion{" +
                "id=" + id +
                ", nplazas=" + nplazas +
                ", direccion='" + direccion + '\'' +
                '}';
    }
}
