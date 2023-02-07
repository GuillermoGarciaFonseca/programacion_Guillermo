package llamadas;

import java.util.ArrayList;

public class LlamadaLocal {
    private long numeroOrigen,numeroDestino;
    private double coste,duracion;

    public LlamadaLocal(long numeroOrigen, long numeroDestino,double duracion) {
        this.numeroDestino = numeroDestino;
        this.numeroOrigen = numeroOrigen;
        this.duracion=duracion;
        this.coste=(duracion*0.15)+0.5;
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

    public LlamadaLocal(double coste) {
        this.coste = coste;
    }

    public double getCoste() {
        return coste;
    }
}
