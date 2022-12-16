import java.util.Arrays;
import java.util.Scanner;

public class menuarray {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opcion = 0;
        System.out.println("Dime con cuantas posiciones quieres el array");
        int[] numeros = new int[in.nextInt()];
        do {
            System.out.println("1. Llenar array");
            System.out.println("2. Mostrar posición");
            System.out.println("3. Mostrar array");
            System.out.println("4. Ordenar array");
            System.out.println("5. Invertir array");
            System.out.println("-----------------------");
            System.out.println("Introduce opción:");
            opcion = in.nextInt();

            switch (opcion){
                case 1:
                    for (int i = 0; i < numeros.length; i++) {
                        numeros[i] = (int) (Math.random());
                    }
                    break;
                case 2:
                    for (int i = 0; i <numeros.length; i++) {
                        System.out.println("Introduce un numero");
                        numeros[i] = in.nextInt();
                    }
                    break;
                case 3:
                    Arrays.sort(numeros);
                    for (int i = 0; i < numeros.length; i++) {
                        System.out.println(numeros[i]);
                    }
                    break;
                case 4:
                    int [] numerosnuevos = numeros.clone();
                    System.out.println(numerosnuevos.length);
                    break;
                case 5:
                    for (int i = 0; i < numeros.length; i++) {
                        int rotar = numeros[1+i];
                        numeros[i+1]=numeros[0];
                        numeros[0]=rotar;
                    }
                    break;
                    case 6:
                    for (int i = 0; i < numeros.length; i++) {
                        System.out.println(numeros[i]);
                    }
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }
        }while (opcion != 0);
    }
}

