package com.example.practicajson;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONPokemon {
    private String nombre;
    private JSONArray habilidades;
    private JSONArray tipos;
    private int generacion;

    // Constructor
    public JSONPokemon(String nombre, JSONArray habilidades, JSONArray tipos, int generacion) {
        this.nombre = nombre;
        this.habilidades = this.habilidades;
        this.tipos = this.tipos;
        this.generacion = this.generacion;
    }

    // Método para convertir el objeto JSONPokemon a un objeto JSONObject
    public JSONObject toJSON() {
        JSONObject jsonPokemon = new JSONObject();
        jsonPokemon.put("nombre", nombre);
        jsonPokemon.put("habilidades", habilidades);
        jsonPokemon.put("tipos", tipos);
        jsonPokemon.put("generacion", generacion);
        return jsonPokemon;
    }

    // Métodos getter y setter (puedes generarlos automáticamente en tu IDE)

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public JSONArray getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(JSONArray habilidades) {
        this.habilidades = habilidades;
    }

    public JSONArray getTipos() {
        return tipos;
    }

    public void setTipos(JSONArray tipos) {
        this.tipos = tipos;
    }

    public int getGeneracion() {
        return generacion;
    }

    public void setGeneracion(int generacion) {
        this.generacion = generacion;
    }

    // Otros métodos según sea necesario
}
