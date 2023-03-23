package Biblioteca;

public abstract class Elemento {
    private int id,seccion;
    private String titulo;
    private boolean prestado;

    public Elemento() {
    }

    public Elemento(int id, int seccion, String titulo, boolean prestado) {
        this.id = id;
        this.seccion = seccion;
        this.titulo = titulo;
        this.prestado = prestado;
    }
    public void mostrarDatos(){
        System.out.println("ID "+id);
        System.out.println("Seccion "+seccion);
        System.out.println("Titulo"+titulo);
        System.out.println("prestado"+prestado);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeccion() {
        return seccion;
    }

    public void setSeccion(int seccion) {
        this.seccion = seccion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }
}
