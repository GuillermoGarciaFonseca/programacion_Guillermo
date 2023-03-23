package model1;

public class Ropa extends Productos{
    private int talla;

    public Ropa() {
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println(talla);
    }

    public Ropa(String nombre, int precio, int talla) {
        super(nombre, precio);
        this.talla = talla;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }
}
