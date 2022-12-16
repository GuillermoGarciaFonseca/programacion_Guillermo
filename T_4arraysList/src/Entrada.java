import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        listatipadas();
        //Encontrarelemento();
    }

    public static void listatipadas() {
        //<Pones la condicion y solo se podran poner valores de ese tipo>
        ArrayList<String> listapalabras = new ArrayList();
        listapalabras.add("Palabra1");
        listapalabras.add("Ejemplo");
        listapalabras.add("Casa");
        listapalabras.add("Secundaria");
        Encontrarelemento("programacion", listapalabras);


        // busca elementos
        //--> se pide una palabra por teclado
        //--> se comprueba si la palabra esta en la lista
        //for (int i = 0; i < listapalabras.size(); i++) {

        //}

    }

    public static void Encontrarelemento(String elemento, ArrayList<String> lista) {
        boolean encontrado = false;
        String palabraencontrada = null;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equalsIgnoreCase(elemento)) {
                encontrado = true;
                palabraencontrada = lista.get(i);
                break;
            } else {

            }
        }
        //despues del break terminar
        if (palabraencontrada != null) {
            System.out.println("palabra encontrada");
        } else {
            System.out.println("palabra no encontrada");
        }
    }

    public static void inicioarrayList() {
        ArrayList lista = new ArrayList();
        //tamaño de la lista
        System.out.println(lista.size());
        //añadir un elemento
        lista.add("Elemento 1");
        lista.add(1234);
        lista.add(true);
        lista.add('A');
        System.out.println(lista.size());
        //eliminar un objeto
        lista.remove(2);
        lista.remove(1);
        System.out.println(lista.size());
        //antes del cambio
        System.out.println("El elemento de la posicion 1 es " + lista.get(0));
        //cambio elemento
        lista.set(0, 98234);
        System.out.println(lista.size());
        System.out.println("El elemento de la posicion 1 es " + lista.get(0));
        //sacar todos los elementos de la lista
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
        for (Object item : lista) {
            System.out.println(item);
        }
    }

    private static void ejerciciosNumeros() {
        //crear una lista de numeros solo numeros
        // Meter 50 aletorios entre el 0-20
        // Pedir al usuario un numero
        // Indicar las veces que se repite dicho numero
        // Obtener la primera poscion del numero indicado
        // En el caso de no repetirse nunca, avisar al usuario
        // En el caso de no estar, avisar al usuario
        ArrayList<Integer> listanumero = new ArrayList<>();

        for (int i = 0; i < 50; i++) {
            listanumero.add((int) (Math.random() * 21));

        }

        Scanner in = new Scanner(System.in);
        System.out.println("Dime un numero");
        listanumero.add(in.nextInt());
        int numeroevaluar = in.nextInt();
        int posicioninicial = -1;
        int numerorepeticiones = 0;
        for (int i = 0; i < listanumero.size(); i++) {
            if (listanumero.get(i) == numeroevaluar) {
                numerorepeticiones++;
                if (numerorepeticiones == 1) {
                    posicioninicial = i;
                }
            }
        }
        if (!listanumero.contains(numeroevaluar)) {
            if (numerorepeticiones > 1) {
                System.out.println("el numero esta");
            } else {
                System.out.println("el numero no esta");
            }
            //otra opcion seria if (numero
        } else {
            System.out.println("el numero no esta");
        }
    }
}
