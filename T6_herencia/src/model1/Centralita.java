package model1;



import java.util.ArrayList;

public final class Centralita {
private void listar;
    private ArrayList<Llamada> listaLLamadas;
private double costreacumulado;
    public Centralita() {
        this.listaLLamadas = new ArrayList<>();
    }

    public void agregarLlamada(Llamada llamada){
        listaLLamadas.add(llamada);
    }


    public void mostrarLlamadas(String nombreClase){
        for (Llamada itemLlamada: listaLLamadas) {
            if (itemLlamada.getClass().getSimpleName().toLowerCase().equals(nombreClase.toLowerCase())){
                itemLlamada.MostrarDatos();
            }
        }
    }

    public void mostrarLlamadas(Class<Llamada> clase){
        for (Llamada itemLlamada: listaLLamadas) {
            if (itemLlamada.getClass() == clase){
                itemLlamada.MostrarDatos();
            }

            /*if (itemLlamada instanceof LlamadaLocal){
            }*/
        }
    }

    public void calcularCostes(){

        double costeTotal =0;

        for ( Llamada llamada: listaLLamadas ) {
            costeTotal += llamada.getCoste();
        }

        System.out.println("El coste total es: "+costeTotal);
    }
    public void calcularCostes(String nombreClase){

        double costeTotal = 0;
        for (Llamada itemLlamada: listaLLamadas) {
            if (itemLlamada.getClass().getSimpleName().toLowerCase().equals( nombreClase.toLowerCase())){
                costeTotal +=itemLlamada.getCoste();
            }
        }

        System.out.printf("El coste total de las llamadas %s es de %.2f%n", nombreClase,costeTotal);
    }

    public void buscarLlamada(int nOrigen){

        boolean existe = false;

        for ( Llamada itemLlamada : listaLLamadas ) {
            if (itemLlamada.getNumeroOrigen() == nOrigen){
                itemLlamada.MostrarDatos();
                existe = true;
                break;
            }
        }

        if (!existe){
            System.out.println("El numero no ha sido encontrado");
        }

    }

    public ArrayList<Llamada> getListaLLamadas() {
        return listaLLamadas;
    }

    public void setListaLLamadas(ArrayList<Llamada> listaLLamadas) {
        this.listaLLamadas = listaLLamadas;
    }
}
