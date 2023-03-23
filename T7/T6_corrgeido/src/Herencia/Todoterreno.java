package Herencia;

import java.util.Scanner;

public class Todoterreno extends Coche{
    private String traccion;
    private boolean modoCampo;

    public Todoterreno() {
    }

    public Todoterreno(String marca, String modelo, String traccion) {
        super(marca, modelo);
        this.traccion = traccion;
    }

    @Override
    public void encender() {
        super.encender();
        if (traccion.equalsIgnoreCase("4*4")){
            System.out.println("Quieres encender el modo campo (s/n)");
            String respuesta =new Scanner(System.in).next();
            if (respuesta.equalsIgnoreCase("s")){
                modoCampo=true;
            }
        }
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Traccion: "+this.traccion);
        System.out.println("Modo campo: "+this.modoCampo);
    }
public void subirSuspension(){
    System.out.println("Subiendo suspensión");
}
    public String getTraccion() {
        return traccion;
    }

    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }

    public boolean isModoCampo() {
        return modoCampo;
    }

    public void setModoCampo(boolean modoCampo) {
        this.modoCampo = modoCampo;
    }

}
