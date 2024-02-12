package model;

import java.util.ArrayList;

public class Pizza {
    private String nombre;
    private ArrayList<Ingrediente> ingredientes;
    private String tamaño;
    private double precio;

    public Pizza(String nombre, ArrayList<Ingrediente> ingredientes, String tamaño, double precio) {
        this.nombre = nombre;
        this.ingredientes = ingredientes;
        this.tamaño = tamaño;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public String getTamaño() {
        return tamaño;
    }

    public double getPrecio() {
        return precio;
    }
}