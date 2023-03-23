package model;

public class Producto {
    private  int precio;
    private String nombre,descripcion;

    public Producto(String nombre, int precio, String descripcion) {
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Producto(int precio, String nombre, String descripcion) {
        this.precio = precio;
        this.nombre = nombre;
        this.descripcion =  descripcion;
    }
}
