package ejercicio6;

public class Partido {
    private Equipo equipo1, equipo2;
    private boolean partidoJugando;
    private int parte;
    public Partido(Equipo equipo1, Equipo equipo2){
        this.equipo1=equipo1;
        this.equipo2=equipo2;
    }
    public void iniciarPartido(){

    }

    public void mostrarResultado(){
        System.out.println("El resultado es:");
        System.out.println("Real Madrid CF "+equipo2.getGoles()+" : "+equipo1.getGoles()+ " FC Barcelona");}
}