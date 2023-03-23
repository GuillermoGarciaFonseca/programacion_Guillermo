package Herencia;
import javax.sound.midi.Soundbank;
public abstract class Coche {
    private String marca;
    private String modelo;
    private boolean encendido;

    public Coche(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public Coche() {
    }
    public void mostrarDatos(){
        System.out.println("Marca: "+marca);
        System.out.println("Modelo: "+modelo);
        System.out.println("Encendido: "+encendido);
    }
    public void encender(){
        if (encendido){
            System.out.println("El coche ya esta encendido");
        }else {
            System.out.println("Encendiendo coche");
        this.encendido=true;
        }
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }
}
