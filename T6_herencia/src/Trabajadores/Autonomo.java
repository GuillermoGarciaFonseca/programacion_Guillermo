package Trabajadores;

import java.util.ArrayList;

public final class Autonomo extends Trabajador{
    private double cuotas;
    public Autonomo(String nombre, String apellido, String dni, double sueldo, boolean contratado, double cuotas) {
        super(nombre, apellido, dni, sueldo, contratado);
        this.cuotas = cuotas;
    }

    @Override
    public void MostrarDatos() {
        super.MostrarDatos();
        System.out.println("Sueldo: "+getSueldo());
        System.out.println("Contratado: "+isContratado());
        System.out.println("Numero de pagas: "+cuotas);
    }

    public Autonomo() {
    }

    public double getCuotas() {
        return cuotas;
    }

    public void setCuotas(double cuotas) {
        this.cuotas = cuotas;
    }
}
