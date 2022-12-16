import java.util.Arrays;
import java.util.Scanner;

public class ejercicio41 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Object[][] usuarios = new Object[10][4];
        int opcion=0;
        int contadorpersonas = 0;
        do {
            System.out.println("1. Agregar persona");
            System.out.println("2. Buscar persona");
            System.out.println("3. Lista persona");
            System.out.println("4. Salir");
            System.out.println("-----------------------");
            System.out.println("Introduce opción:");
            opcion = in.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Introduce nombre");
                    String nombre = in.next();
                    System.out.println("Introduce dni");
                    String dni = in.next();
                    System.out.println("Introduce telefomo");
                    int telefono = in.nextInt();
                    System.out.println("Introduce apellido");
                    String apellido = in.next();
                    usuarios[contadorpersonas][0]=nombre;
                    usuarios[contadorpersonas][1]=apellido;
                    usuarios[contadorpersonas][2]=dni;
                    usuarios[contadorpersonas][3]=telefono;
                    contadorpersonas++;
                    break;
                case 2:
                    System.out.println("Introduce posición para mostrar:");
                    dni = in.next();
                    for (int i = 0; i < contadorpersonas; i++) {
                        if (usuarios[i][2].equals(dni)) {
                            for (int j = 0; j < usuarios[i].length; j++) {
                                System.out.println(usuarios[i][j]);
                            }
                            break;
                        }
                    }
                    break;
                case 3:

                    for (Object[]item:usuarios
                         ) {
                        for (Object buscar:item
                             ) {
                            System.out.print(buscar+" ");
                        }
                        System.out.println();
                    }
                    break;
                case 4:
                    System.out.println("saliendo");
                    break;

                default:
                    System.out.println("opcion incorrecta");

            }

        }while (opcion != 4) ;
    }
}
