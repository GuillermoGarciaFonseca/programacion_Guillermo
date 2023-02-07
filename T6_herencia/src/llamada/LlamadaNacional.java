package llamada;

public class LlamadaNacional {
    private long numeroOrigen,numeroDestino;
    private char destino;
    private double duracion,coste;

    public LlamadaNacional(long numeroOrigen, long numeroDestino, char destino, double duracion) {
        this.numeroOrigen = numeroOrigen;
        this.numeroDestino = numeroDestino;
        this.destino = destino;
        this.duracion = duracion;
        switch (destino){
            case 'A':
                this.coste=(this.duracion*0.4)+0.7;
                break;
            case 'B':
                this.coste=(this.duracion*0.5)+0.7;
                break;
            case 'C':
                this.coste=(this.duracion*0.6)+0.7;
                break;
        }

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

    public char getDestino() {
        return destino;
    }

    public void setDestino(char destino) {
        this.destino = destino;
    }

    public double getDuracion() {
        return duracion;
    }

    public void setDuracion(double duracion) {
        this.duracion = duracion;
    }

    public LlamadaNacional(long numeroOrigen, long numeroDestino, char destino, double duracion, double coste) {
        this.numeroOrigen = numeroOrigen;
        this.numeroDestino = numeroDestino;
        this.destino = destino;
        this.duracion = duracion;
        this.coste = coste;
    }

    public double getCoste() {
        return coste;
    }

}

