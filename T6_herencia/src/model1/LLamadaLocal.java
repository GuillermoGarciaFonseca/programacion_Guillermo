package model1;

public  class LLamadaLocal extends Llamada {



    public LLamadaLocal(long nOrigen,long nDestino,double duracion){super(nOrigen,nDestino,duracion);}
    @Override
    public void cobrar() {
        this.setCoste(0.50+(getDuracion()*0.15));

    }
}
