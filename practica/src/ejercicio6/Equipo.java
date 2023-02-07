package ejercicio6;

import java.util.ArrayList;

public class Equipo {
    private String nombre;
    private int nivelAtaque, nivelCentro, nivelDefensa, goles;
    private ArrayList<Jugador> listaJugadores;

    public Equipo(){}

    public Equipo (String nombre){
        this.nombre=nombre;
        nivelAtaque=(int) (Math.random()*101);
        nivelCentro=(int) (Math.random()*101);
        nivelDefensa =(int) (Math.random()*101);
        goles=0;
    }

    public Equipo (String nombre, int nivelAtaque, int nivelDefensa, int nivelCentro){
        this.nombre=nombre;
        this.nivelAtaque=nivelAtaque;
        this.nivelDefensa=nivelDefensa;
        this.nivelCentro=nivelCentro;
    }

    public boolean atacar(){
        if ((nivelAtaque*((int) (Math.random()*2)))+(nivelDefensa*((int) (Math.random()*2)))+(nivelCentro*((int) (Math.random()*2)))>90){

            goles++;
            return true;
        }else {
            return false;
        }
    }

    public void jugadoresEquipo(Jugador jugador){
        listaJugadores.add(jugador);
    }

    public void listarDelanteros(Jugador jugador){
        if (jugador.getPosicion().equalsIgnoreCase("delantero")){
            System.out.println("Nombre: "+jugador.getNombre());
            System.out.println("Posicion: "+jugador.getPosicion());
            System.out.println("Calidad: "+jugador.getCalidad());
            System.out.println("Estrella: "+jugador.isEstrella());
        }
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelAtaque() {
        return nivelAtaque;
    }
    public void setNivelAtaque(int nivelAtaque) {
        this.nivelAtaque = nivelAtaque;
    }

    public int getNivelCentro() {
        return nivelCentro;
    }
    public void setNivelCentro(int nivelCentro) {
        this.nivelCentro = nivelCentro;
    }

    public int getNivelDefensa() {
        return nivelDefensa;
    }
    public void setNivelDefensa(int nivelDefensa) {
        this.nivelDefensa = nivelDefensa;
    }

    public int getGoles() {
        return goles;
    }
    public void setGoles(int goles) {
        this.goles = goles;
    }
}