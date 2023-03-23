package model;

public abstract class Bicicleta {
    private Tipo tipo;
    private Tamanio tamanio;
    private int velocidad,pulgadas;
    private boolean estado;

    public Bicicleta() {
    }

    public Bicicleta(Tipo tipo, Tamanio tamanio, int velocidad, int pulgadas, boolean estado) {
        this.tipo = tipo;
        this.tamanio = tamanio;
        this.velocidad = velocidad;
        this.pulgadas = pulgadas;
        this.estado = estado;
    }
    public abstract int reparar();

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tamanio getTamanio() {
        return tamanio;
    }

    public void setTamanio(Tamanio tamanio) {
        this.tamanio = tamanio;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getPulgadas() {
        return pulgadas;
    }

    public void setPulgadas(int pulgadas) {
        this.pulgadas = pulgadas;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
