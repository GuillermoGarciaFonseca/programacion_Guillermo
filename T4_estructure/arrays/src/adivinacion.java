import java.util.Scanner;

public class adivinacion {
    public static void main(String [] args) {
        int numero = (int) (Math.random() * 30 + 1);
        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println("Tienes 10 intentos");
        System.out.println("Dime un numero del uno al treinta");
        int numerodicho = lecturaTeclado.nextInt();
        int intentos =0;
        if (numerodicho == numero) {
            System.out.println("Has acertado el numero");
            System.out.println(intentos);
        } while (numero != numerodicho) {
            System.out.println("No has acertado el numero");
            Scanner numeros = new Scanner(System.in);
            System.out.println("Di otro numero");
            int pruebanumeros = numeros.nextInt();
            intentos = intentos+1;
            if (intentos==10){
                System.out.println("Prueba otra vez");
                System.out.println(numero);
                break;
            }
            if (numero== pruebanumeros){
                break;
            }
        }
        System.out.println("Has fallado suerte a la próxima"+intentos);
    }
}

