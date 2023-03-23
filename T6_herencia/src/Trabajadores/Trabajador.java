package Trabajadores;

public  abstract  class Trabajador extends Persona implements Firectivo{
    private double sueldo;
    private boolean contratado;

    public Trabajador() {
    }

    public Trabajador(String nombre, String apellido, String dni, double sueldo, boolean contratado) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
        this.contratado = contratado;
    }

    public abstract double calcularNetoAnual();

    @Override
    public void mostrarDatos() {
        super.MostrarDatos();
        System.out.println("Sueldo " + sueldo);
        System.out.println("Contratado " + isContratado());
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public boolean isContratado() {
        return contratado;
    }

    public void setContratado(boolean contratado) {
        this.contratado = contratado;
    }

    @Override
    public double emitirVoto(int voto) {
        return 0;
    }
}