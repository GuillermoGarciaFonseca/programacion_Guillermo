package model1;

public abstract class Productos {
    private String nombre;
    private int Precio;
public void mostrarDatos(){
    System.out.println(+getPrecio());
    System.out.println(getNombre());
}
    public Productos() {
    }

    public Productos(String nombre, int precio) {
        this.nombre = nombre;
        this.Precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int precio) {
        Precio = precio;
    }
}
