package ejercicioEquipo;

import java.util.ArrayList;

public class jugador {
    private String nombre, posicion;
    private boolean estrella;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public boolean isEstrella() {
        return estrella;
    }

    public void setEstrella(boolean estrella) {
        this.estrella = estrella;
    }
    public void mostrarDatos(){
        System.out.println(nombre);
        System.out.println(posicion);
        System.out.println(estrella);
    }
}
