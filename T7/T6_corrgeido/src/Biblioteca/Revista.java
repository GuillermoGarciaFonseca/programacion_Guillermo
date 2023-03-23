package Biblioteca;

public class Revista  extends Elemento{
    private String ISBN;

    public Revista() {
    }

    public Revista(int id, int seccion, String titulo, boolean prestado, String ISBN) {
        super(id, seccion, titulo, prestado);
        this.ISBN = ISBN;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("ISBN "+ISBN);
    }
}
