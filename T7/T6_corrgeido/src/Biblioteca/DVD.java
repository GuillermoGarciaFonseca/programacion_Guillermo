package Biblioteca;

import java.util.ArrayList;


public class DVD  extends Elemento implements Prestable{
    private int anioEdicion;
    private String direccion;
    private ArrayList<String> actores;
    private EnumDVD tipo;

    public DVD() {
    }

    public DVD(int id, int seccion, String titulo, boolean prestado, int anioEdicion, String direccion, ArrayList<String> actores, EnumDVD tipo) {
        super(id, seccion, titulo, prestado);
        this.anioEdicion = anioEdicion;
        this.direccion = direccion;
        this.actores = actores;
        this.tipo = tipo;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Año de edicion: "+anioEdicion);
        System.out.println("Director: "+direccion);
        System.out.println("Actores: ");
        tipo.mostrarDatos();
        for (String item :actores) {
            System.out.println(item);
        }
    }


    @Override
    public boolean prestar() {
        System.out.println("El Dvd ha sido prestado durante dos semanas");
        setPrestado(true);
        return true;
    }
    @Override
    public boolean devolver() {
        System.out.println("El DVD ha sido devuelto");
        setPrestado(false);
        return false;
    }

    public int getAnioEdicion() {
        return anioEdicion;
    }

    public void setAnioEdicion(int anioEdicion) {
        this.anioEdicion = anioEdicion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<String> getActores() {
        return actores;
    }

    public void setActores(ArrayList<String> actores) {
        this.actores = actores;
    }

    public EnumDVD getTipo() {
        return tipo;
    }

    public void setTipo(EnumDVD tipo) {
        this.tipo = tipo;
    }
}
