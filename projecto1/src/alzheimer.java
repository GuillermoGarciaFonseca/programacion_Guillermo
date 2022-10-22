import java.util.Scanner;

public class alzheimer {
    public static void main(String[] args) {
        System.out.println("Hola buenas");
        System.out.println("Bienvenido a appalzheimer");
        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println("Dime tu nombre");
        String nombre = lecturaTeclado.nextLine();
        System.out.println("¿Que grado de alzheimer tiene su familiar o amigo?");
        int numero = lecturaTeclado.nextInt();

    }

}