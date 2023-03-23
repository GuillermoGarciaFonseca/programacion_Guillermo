package model1;

public class Muebles extends Productos{
    private String descripcion;

    public Muebles() {
    }

    public Muebles(String nombre, int precio, String descripcion) {
        super(nombre, precio);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println(descripcion);
    }
}
