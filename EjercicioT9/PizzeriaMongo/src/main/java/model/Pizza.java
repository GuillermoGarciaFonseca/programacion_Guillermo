package model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Pizza  {
    private Object _id;
    private int numeroPedido;
    private  String nombre;
    private String base;
    private int precio;

    public Pizza(int numeroPedido, String nombre, String base, int precio, ArrayList<String> ingredientes) {
        this.numeroPedido = numeroPedido;
        this.nombre = nombre;
        this.base = base;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }
    private ArrayList<String>ingredientes;

    @Override
    public String toString() {
        return "Pizza{" +
                "_id=" + _id +
                ", numeroPedido=" + numeroPedido +
                ", nombre='" + nombre + '\'' +
                ", base='" + base + '\'' +
                ", precio=" + precio +
                ", ingredientes=" + ingredientes +
                '}';
    }

    public Pizza(Object _id, int numeroPedido, String nombre, String base, int precio, ArrayList<String> ingredientes) {
        this._id = _id;
        this.numeroPedido = numeroPedido;
        this.nombre = nombre;
        this.base = base;
        this.precio = precio;
        this.ingredientes = ingredientes;
    }

    public Pizza() {
    }
}
