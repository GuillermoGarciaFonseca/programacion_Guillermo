package model1;

public class Entrada {
    public static void main(String[] args) {
LLamadaLocal lLamadaLocal=new LLamadaLocal(1213213,312313,21);
LlamadaNacional llamadaNacional=new LlamadaNacional(1213213,31231,23,'A');
        Centralita centralita = new Centralita();
        // listaLlamadas = []

        Centralita centralita1=new Centralita();
        centralita1.agregarLlamada(lLamadaLocal);
        centralita1.agregarLlamada(llamadaNacional);



    }
}
