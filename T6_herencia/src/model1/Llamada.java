package model1;

public abstract class Llamada {
protected long numeroOrigen,numeroDestino;
protected double coste,duracion;
public Llamada(long nOrigen, long nDestino, double duracion){}
    public abstract void cobrar();

    public Llamada(long numeroOrigen, long numeroDestino, double coste, double duracion) {
        this.numeroOrigen = numeroOrigen;
        this.numeroDestino = numeroDestino;
        this.cobrar();
        this.duracion = duracion;
    }
    public void MostrarDatos(){
        System.out.println(coste);
        System.out.println(duracion);
        System.out.println(numeroOrigen);
        System.out.println(numeroDestino);
    }

    public long getNumeroOrigen() {
        return numeroOrigen;
    }

    public void setNumeroOrigen(long numeroOrigen) {
        this.numeroOrigen = numeroOrigen;
    }

    public long getNumeroDestino() {
        return numeroDestino;
    }

    public void setNumeroDestino(long numeroDestino) {
        this.numeroDestino = numeroDestino;
    }

    public double getCoste() {
        return coste;
    }

    public void setCoste(double coste) {
        this.coste = coste;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }
}
