import java.util.Arrays;
import java.util.Scanner;

public class ejercicio3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcion = 0;
        int[] numeros = new int[5];
        do {
            System.out.println("1. Llenar array");
            System.out.println("2. Mostrar posición");
            System.out.println("3. Mostrar array");
            System.out.println("4. Ordenar array");
            System.out.println("5. Invertir array");
            System.out.println("6. Salir");
            System.out.println("-----------------------");
            System.out.println("Introduce opción:");
            opcion = in.nextInt();

            switch (opcion){
                case 1:
                    for (int i = 0; i < numeros.length; i++) {
                        System.out.println("Introduce un número:");
                        numeros[i] = in.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("Introduce posición para mostrar:");
                    int posicion = in.nextInt();
                    System.out.println(numeros[posicion]);
                    break;
                case 3:
                    for (int i = 0; i < numeros.length; i++) {
                        System.out.println(numeros[i]);
                    }
                    break;
                case 4:
                    Arrays.sort(numeros);
                    for (int i = 0; i < numeros.length-1; i++) {
                        System.out.println(numeros[i]);
                    }
                    break;
                case 5:
                    for(int i = numeros.length -1; i >= 0; i--) {
                        System.out.println(numeros[i]);
                    }
                    int primero = numeros[0];
                    for (int i = 0; i < numeros.length-1 ; i++) {
                        numeros[i]= numeros[i+1];
                    }
                    break;
                case 6:
                    for (int i = 0; i < numeros.length-1; i++) {
                        for (int j = 1; j < numeros.length-1-i ; j++) {
                            if (numeros[i]>numeros[j+1]){
                                int aux= numeros[j+1];
                                numeros[j+1]=numeros[j];
                                numeros[j] =aux;
                            }
                        }
                        }
                    System.out.println("saliendo");
                    break;
                default:
                    System.out.println("opcion incorrecta");
            }
        }while (opcion != 6);

    }
}
