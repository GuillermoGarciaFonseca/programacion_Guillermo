import java.util.Scanner;
public class Adivinar {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numerorandom= (int) (Math.random()*21);
        int numerointentos=0;
        int numeroUsuario=0;
        do {
            System.out.println("Introduce un numero");
            try {
                numeroUsuario = in.nextInt();
                if (numeroUsuario < 0) {
                    System.out.println("El numero introducido es menor que 0");
                }
                if (numeroUsuario >20) {
                    System.out.println("El numero introducido es mayor a 20");
                }
                numerointentos++;
            } catch (Exception e) {
                System.out.println("El valor introducido no es un numero");
            }
            in.nextLine();
        } while (numerorandom != numeroUsuario);
        System.out.println("Has acertado el numero en " + numerointentos+ " intentos");
        in.close();
    }
}

