package prueba1;

public class Coche {
    private Motor motor;
    private String marca,modelo;
    private double averiasCoche;
    public Coche(String marca,String modelo){
        this.marca=marca;
        this.modelo=modelo;
    }

    public Motor getMotor() {
        return motor;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public double getAveriascoche() {
        return averiasCoche;
    }
    public void AveriasCoche(){
        this.averiasCoche+=(int)(Math.random()*401+100);
    }
}
