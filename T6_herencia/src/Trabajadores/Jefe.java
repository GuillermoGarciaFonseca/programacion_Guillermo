package Trabajadores;

import java.util.ArrayList;

public final class Jefe extends Persona{
    private double acciones,beneficios;
private ArrayList<Persona>ListaJefes;
    public Jefe(String nombre, String apellido, String dni, double acciones, double beneficios) {
        super(nombre, apellido, dni);
        this.acciones = acciones;
        this.beneficios = beneficios;
    }
public Jefe(){}
public boolean depedirTrabajador(Trabajador trabajador){
        if (trabajador.isContratado()){

        }
    System.out.println();;

    return false;
}
public void aplicardespido(String dni,Jefe jefe){
        Trabajador trabajador=estatrabajador(dni);
        if (trabajador!=null){

        }
}
    @Override
    public void MostrarDatos() {
        super.MostrarDatos();
        System.out.println("Acciones: "+acciones);
        System.out.println("Beneficios: "+beneficios);
    }

    public double getAcciones() {
        return acciones;
    }

    public void setAcciones(double acciones) {
        this.acciones = acciones;
    }

    public double getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(double beneficios) {
        this.beneficios = beneficios;
    }
}
