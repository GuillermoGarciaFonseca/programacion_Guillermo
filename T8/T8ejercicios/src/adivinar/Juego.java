package adivinar;

public class Juego {
    private String nombre;
    private int numero,numerointentos;

    public Juego() {
    }

    public Juego(String nombre, int numero,int numerointentos) {
        this.nombre = nombre;
        this.numero = numero;
        this.numerointentos = numerointentos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getNumerointentos() {
        return numerointentos;
    }

    public void setNumerointentos(int numerointentos) {
        this.numerointentos = numerointentos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }
    public void numeroAleatorio(){
        numero =((int) Math.random()*21);
    }
}
