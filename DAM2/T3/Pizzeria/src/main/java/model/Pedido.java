package model;

public class Pedido {
    private int id;
    private String nombre;
    private String telefono;
    private Pizza pizza;

    public Pedido(int id, String nombre, String telefono, Pizza pizza) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.pizza = pizza;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public Pizza getPizza() {
        return pizza;
    }
}
