package llamada;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Centralita centralita = new Centralita();
        Scanner in=new Scanner(System.in);
        int opcion = 0;
        System.out.println("Bienvenido a tu servicio de llamadas");
        System.out.println("1.****Agregar una llamada local****");
        System.out.println("2.****Agregar una llamada nacional****");
        System.out.println("3.****Mostrar datos de llamada locales****");
        System.out.println("4.****Mostrar datos de llamadas nacionales****");
        System.out.println("5.****Mostrar coste acumulados****");
        System.out.println("6.****Salir****");
        System.out.println("///////////////////");
        System.out.println("Dime una opcion");
        opcion=in.nextInt();
        switch (opcion){
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;

        }while (opcion!=7);
    }
}
