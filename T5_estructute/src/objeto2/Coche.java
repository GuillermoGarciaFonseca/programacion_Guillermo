package objeto2;

import objeto.Persona;

public class Coche {
    private Motor motor;
    private String marca,modelo;
    private double averias;

    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
   public  Coche (String marca, String modelo, Motor m) {
       this.marca = marca;
       this.modelo = modelo;
       this.motor = new Motor();
   }


    private void acumularAveria(){
        averias= (int) Math.random()*401+100;
    }
    public String getMarca() {
        return marca;
    }
    public void mostrarDatos(){
        System.out.println("La marca del coche es "+marca);
        System.out.println("El modelo del coche es "+modelo);
        System.out.println("Las averias acumuladas son"+averias);
        System.out.println("Motor:");

        System.out.println("\tCV:  " +this.motor.getCv());
        System.out.println("\t litros de aceite:   "+this.motor.getLitrosaceite());

    }

    public String getModelo() {
        return modelo;
    }

    public Motor getMotor() {
        return motor;
    }

    public double getAverias() {
        return averias;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setAverias(double averias) {
        this.averias = averias;
    }

}
