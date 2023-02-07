package model1;

public class LlamadaNacional  extends Llamada{
    private char destino;

public  LlamadaNacional(long nOrigen,long nDestino, double duracion,char destino){
        super(nOrigen,nDestino,duracion);
        this.destino=destino;
        this.cobrar();
}

    @Override
    public void MostrarDatos() {
        super.MostrarDatos();
        System.out.println("Franja"+this.destino);
    }

    @Override
    public void cobrar() {
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
}
