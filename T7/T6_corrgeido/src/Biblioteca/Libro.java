package Biblioteca;

public final class Libro extends Elemento implements Prestable {
    private String ISBN,autor,editorial;
    private int numeroPaginas;

    public Libro() {
    }

    public Libro(int id, int seccion, String titulo, boolean prestado, String ISBN, String autor, String editorial, int numeroPaginas) {
        super(id, seccion, titulo, prestado);
        this.ISBN = ISBN;
        this.autor = autor;
        this.editorial = editorial;
        this.numeroPaginas = numeroPaginas;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("ISBN: "+ISBN);
        System.out.println("Autor: "+autor);
        System.out.println("Editorial: "+editorial);
        System.out.println("Paginas: "+numeroPaginas);
    }

    @Override
    public boolean prestar() {
        System.out.println("El libro ha sido prestado durante una semana");
        setPrestado(true);
        return true;
    }

    @Override
    public boolean devolver() {
        System.out.println("El libro ha sido devuelto");
        setPrestado(false);
        return false;
    }
}
