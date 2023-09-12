package org.example.model;

import java.util.ArrayList;

public class Alumno {

    private String id;
    private String nombre;
    private int edad, telefono;

    private boolean experiencia;

    private ArrayList<String>conocimientos;

    public Alumno() {
    }

    public Alumno( String nombre, int edad, int telefono, boolean experiencia) {
        this.nombre = nombre;
        this.edad = edad;
        this.telefono = telefono;
        this.experiencia = experiencia;

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public boolean isExperiencia() {
        return experiencia;
    }

    public void setExperiencia(boolean experiencia) {
        this.experiencia = experiencia;
    }

    public ArrayList<String> getConocimientos() {
        return conocimientos;
    }

    public void setConocimientos(ArrayList<String> conocimientos) {
        this.conocimientos = conocimientos;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", telefono=" + telefono +
                ", experiencia=" + experiencia +
                ", conocimientos=" + conocimientos +
                '}';
    }
}