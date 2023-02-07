package model;

import java.util.Scanner;

public class Todoterreno extends Coche{
    //tenga todo lo que tiene coche-->eXtends
    //si no quiero que la clase Todoterreno se extienda en vez de poner abstract se pone public final class nombre
    // extends
    private String traccion;
    private boolean modoCampo;


    public Todoterreno(String marca,String modelo,String traccion){
        super(marca,modelo);
        //modoCampo=false
        this.traccion=traccion;
    }
    //Mostrar datos-->si
    //genero getter y setter de los nuevos de los antiguos no
    // De marca y modelo no se escribirian porque estarian duplicados
    //pregunta si quiero encender en el modoCampo
    // y __> se enciende "Encendido mod campo"
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
    System.out.println("la traccion"+traccion);
    System.out.println("Modo campo"+modoCampo);
    }
    @Override
    public void encender(){
        super.encender();
        if (traccion.equalsIgnoreCase("4x2")){
            System.out.println("Quieres enceder el modocampo");
            String answer=new Scanner(System.in).next();
         if (answer.equalsIgnoreCase("s")){
             modoCampo=true;
         }
        }
    }
    public void subirSuspension(){
        System.out.println("Subiendo supension");
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


