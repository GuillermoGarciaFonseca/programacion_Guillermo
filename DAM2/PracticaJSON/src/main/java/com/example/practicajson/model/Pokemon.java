package com.example.practicajson.model;

import org.json.JSONArray;

public class Pokemon {
    private String nombre,tipo,habilidades;
    private int generacion;

    public Pokemon(String nombre, String tipo, int generacion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.habilidades = habilidades;
        this.generacion = generacion;
    }

    public Pokemon(String nombrePokemon, JSONArray habilidades, JSONArray tipos, int generacion) {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(String habilidades) {
        this.habilidades = habilidades;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", habilidades='" + habilidades + '\'' +
                ", generacion=" + generacion +
                '}';
    }
}

