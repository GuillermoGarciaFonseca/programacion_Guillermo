package model;

public class Categorias {
    private String nomnbre;
    private int numero;

    public Categorias(String nomnbre, int numero) {
        this.nomnbre = nomnbre;
        this.numero = numero;
    }

    public Categorias() {
    }

    public String getNomnbre() {
        return nomnbre;
    }

    public void setNomnbre(String nomnbre) {
        this.nomnbre = nomnbre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
