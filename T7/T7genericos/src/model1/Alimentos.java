package model1;

public class Alimentos extends Productos{
    private double caloria;

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println(caloria);
    }

    public Alimentos(String nombre, int precio, double caloria) {
        super(nombre, precio);
        this.caloria = caloria;
    }

    public Alimentos() {
    }

    public double getCaloria() {
        return caloria;
    }

    public void setCaloria(double caloria) {
        this.caloria = caloria;
    }
}
