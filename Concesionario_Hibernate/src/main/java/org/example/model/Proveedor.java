package org.example.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

public class Proveedor {
    @Id
    @GeneratedValue()
    private int id;
    @Column
    private String nombre;
    @Column
    private String pais;
    @OneToOne(mappedBy = "ficha")
    private Vehiculo vehiculo;

    public Proveedor() {
    }

    public Proveedor(String nombre, String pais, Vehiculo vehiculo) {
        this.nombre = nombre;
        this.pais = pais;
        this.vehiculo = vehiculo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                ", vehiculo=" + vehiculo +
                '}';
    }
}
