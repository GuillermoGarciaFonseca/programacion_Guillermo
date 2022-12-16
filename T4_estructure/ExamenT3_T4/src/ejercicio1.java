import java.util.Scanner;

public class ejercicio1 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            String palabraMaestra, palabra ="";

            System.out.println("Introduce palabra maestra:");
            palabraMaestra = in.nextLine();

            do {
                System.out.println("Introduce una palabra:");
                palabra = in.nextLine();
                int contadoraciertos =0;
                for (int i = 0; i <palabraMaestra.length() ; i++) {
                    if (palabraMaestra.charAt(i) == palabra.charAt(contadoraciertos)) {
                        contadoraciertos++;
                        if (contadoraciertos == palabra.length()) {
                            break;
                        }
                    }else {
                        contadoraciertos=0;
                    }
                }
                if (palabraMaestra.equals(palabra)) {
                    String[] palabraSeparada = palabra.split("");
                    for(int i = palabraSeparada.length -1; i >= 0; i--) {
                        System.out.print(palabraSeparada[i]);
                    }
                }


            }while (!palabraMaestra.contains(palabra) );
            System.out.println("Longitud: "+palabraMaestra.length());
        }
    }