import java.util.Scanner;

public class ejercicios {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int[] listaNumeros = new int[10];
            int min = 21;
            int max = 0;
            int pares = 0;
            int impares = 0;
            int repeticiones = 0;

            for (int i = 0; i < listaNumeros.length; i++) {
                listaNumeros[i] = (int) (Math.random() * 21);
                System.out.println(listaNumeros[i]);
            }

            System.out.println("Introduce un número para buscar repeticiones:");
            int buscar = in.nextInt();

            for (int i = 0; i < listaNumeros.length; i++) {
                if (listaNumeros[i] > max) {
                    max = listaNumeros[i];
                } else if (listaNumeros[i] < min) {
                    min = listaNumeros[i];
                }

                if (listaNumeros[i] % 2 == 0){
                    pares++;
                }else {
                    impares++;
                }

                if (buscar == listaNumeros[i]){
                    repeticiones++;
                }
            }

            System.out.println("Max: " + max + "\n Min: " + min);
            System.out.println("Pares: " + pares + "\n Impares: " + impares);
            System.out.println("Repeticiones: " + repeticiones);
        }
    }




