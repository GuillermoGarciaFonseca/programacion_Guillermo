package trigonometria;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int opcionPrimera=0,opcionSecundaria=0,base=0,altura=0,radio=0;
        do {
            System.out.println("1. Cuadrados");
            System.out.println("2. Triangulos");
            System.out.println("3. Circulos");
            opcionPrimera=in.nextInt();
            switch (opcionPrimera){
                case 1:
                    System.out.println("trabajo con cuadrados");
                    System.out.println("Dime la base");
                    base= in.nextInt();
                    System.out.println("Dime la altura");
                    altura=in.nextInt();
                    Cuadrado cuadrado=new Cuadrado(base,altura);
                    System.out.println("Que quieres hacer");
                    System.out.println("1. Calcular area");
                    System.out.println("2. Mostrar Datos");
                    opcionSecundaria=in.nextInt();
                do {
                    case 1:
                        System.out.println(cuadrado.calcularArea());
                        break;
                    case 2:
                        cuadrado.m
                        break;
                }
                    System.out.println("pulsa cualquier tecla+");
                    break;
            }
        }while ()
    }
}
