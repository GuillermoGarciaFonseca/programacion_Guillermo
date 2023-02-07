package ejercicioEquipo;

import javax.print.DocFlavor;
import java.util.Scanner;

public class Equipo {

    private String nombre;
    private int NA, NC, ND;
    private int goles;
    public boolean atacar(){
        return goles;
    }
    public void Nivel(int NA,int NC,int ND){
        this.NA=NA;
        this.NC=NC;
        this.ND=ND;
    }

    public void nombre(){
        Scanner in = new Scanner(System.in);
        System.out.println("Como se llama el jugador");
        String jugadornombre= in.next();
        NA=(int) (Math.random()*101);
        ND=(int) (Math.random()*101);
        NC=(int) (Math.random()*101);

    }
    public int getNA() {
        return NA;
    }

    public void setNA(int NA) {
        this.NA = NA;
    }

    public int getNC() {
        return NC;
    }

    public void setNC(int NC) {
        this.NC = NC;
    }

    public int getND() {
        return ND;
    }

    public void setND(int ND) {
        this.ND = ND;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
