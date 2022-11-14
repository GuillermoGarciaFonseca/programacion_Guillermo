import java.util.Random;
import java.util.Scanner;

/*public class ahorcado {
    public static void main(String[] args) {
        final int  intentos_totales =8;
        int intentos = 0;
        int aciertos = 0;
        Scanner lecturaTeclado = new Scanner(System.in);
        lecturaTeclado.useDelimiter("\n");
        char resp;
        Random rnd =new Random();
        String arraypalabras[] = new String[2];
        arraypalabras[0]= "casa";
        arraypalabras[1]="camaleon";
        do {
            int aleatorio = rnd.nextInt(3);
            char[] desguazada = desguaza(arrayPalabras[alea]);
            char[] copia = desguaza(arrayPalabras[alea]); // Algo auxiliar para mas tarde
            // Array para pintar mierdecillas en pantalla(Guiones o letras vamos)
            char[] tusRespuestas = new char[desguazada.length];

            // Rellenamos palabras ocn guiones
            for(int i = 0; i < tusRespuestas.length; i++){
                tusRespuestas[i] = '_';
            }

            // Empezamos a pintar mierdas en pantalla
            System.out.println("Adivina la palabra!");

            // Mientras que no nos pasemos con los intentos y no la acertemos...
            while(intentos < INTENTOS_TOTALES && aciertos != tusRespuestas.length){
                imprimeOculta(tusRespuestas);

                System.out.println("\nIntroduce una letra: ");
                resp = teclado.next().toLowerCase().charAt(0);
                // Recorremos el array y comprobamos si se ha producido un acierto
                for(int i = 0; i < desguazada.length; i++){
                    if(desguazada[i]==resp){
                        tusRespuestas[i] = desguazada[i];
                        desguazada[i] = ' ';
                        aciertos++;
                    }
                }
                intentos++;
            }
            // Si hemos acertado todas imprimimos un mensahe
            if(aciertos == tusRespuestas.length){
                System.out.print("\nFalocidades!! has acertado la palabra: ");
                imprimeOculta(tusRespuestas);
            }
            // Si no otro
            else{
                System.out.print("\nMenudo ceporro eres! la palabra era: ");
                for(int i = 0; i < copia.length; i++){
                    System.out.print(copia[i] + " ");
                }
            }
            // Reseteamos contadores
            intentos = 0;
            aciertos = 0;

            resp = pregunta("\n\nQuieres volver a jugar?",teclado);
        }while(resp != 'n');

    }


    private static char[] desguaza(String palAzar){
        char[] letras;
        letras = new char[palAzar.length()];
        for(int i = 0; i < palAzar.length(); i++){
            letras[i] = palAzar.charAt(i);
        }
        return letras;
    }


    private static void imprimeOculta(char[] tusRespuestas){

        for(int i = 0; i < tusRespuestas.length; i++){
            System.out.print(tusRespuestas[i] + " ");
        }
    }


    public static char pregunta(String men, Scanner teclado) {
        char resp;
        System.out.println(men+" (s/n");
        resp = teclado.next().toLowerCase().charAt(0);
        while (resp != 's'&& resp != 'n'){
            System.out.println("Errpr! solo se admite S o N");
            resp = teclado.next().toLowerCase().charAt(0);
        }
        return resp;
    }
}*/
