/*import java.util.Random;
import java.util.Scanner;

public class ahorcado2 {
    public static void main(String[] args) {
        Scanner lecturapalabra = new Scanner(System.in);

        String palabrarandom= getguines();
        char[]
        System.out.println(palabrarandom);



        System.out.println(palabrasguines);
    }
private static String obtpalabramisteriosa() {
        Scanner lecturapalabra = new Scanner(System.in);
        String[] palabras = new String[]{"avestruz","boa","camaleon","bufalo","cebra","cercopiteco","chimpance","cocodrilo",
                "cucaracha","elefante","escorpion","estornio","flamenco","gacela","ganso","gecko","gorila","hipopotamo","jirafa","lemur",
                "leopardo","leon","nutria","paloma","pato","rana","raton","rata","rinoceronte","tortuga",};
        Random palabraaleatoria = new Random();
        int aleatoria= palabraaleatoria.nextInt(palabras.length);
        return palabras[aleatoria];
    }
    private static char[] getguines(String palabra){
        int npalabrasrandom= palabrarandom.length();
        char [] palabrasguines = new char[npalabrasrandom];
        for (int i = 0; i < palabrasguines.length; i++) {
            palabrasguines[i]='-';
        }
    }
}
*/