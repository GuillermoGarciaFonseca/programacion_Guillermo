import java.util.Scanner;

public class ejercicio1212 {
    public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String palabraMaestra, palabra = "";

            System.out.println("Introduce palabra maestra:");
            palabraMaestra = in.nextLine();

            do {
                System.out.println("Introduce una palabra:");
                palabra = in.nextLine();

                if (palabraMaestra.equals(palabra)){
                    String[] palabraSeparada = palabra.split("");
                    for(int i = palabraSeparada.length -1; i >= 0; i--) {
                        System.out.print(palabraSeparada[i]);
                    }
                }else if (palabraMaestra.contains(palabra)){
                    System.out.println("Longitud: "+palabraMaestra.length());
                }
            }while (!palabra.equals(palabraMaestra) && !palabraMaestra.contains(palabra));
        }
    }

