import java.util.Scanner;

public class alzheimer {
    public static void main(String[] args) {
        Object[][] usuarios = new Object[0][0];
        for (Object[] item : usuarios
        ) {
            System.out.println("Hola buenas");
            System.out.println("Bienvenido a appalzheimer");
            Scanner lecturaTeclado = new Scanner(System.in);
            System.out.println("Dime tu nombre: ");
            String nombre = lecturaTeclado.nextLine();
            System.out.println("Dime tu apellido: ");
            String apellido = lecturaTeclado.nextLine();
            System.out.println("Dime tu número de telefono: ");
            int numero = lecturaTeclado.nextInt();
            System.out.println("Dime los números del  DNI: ");
            int dninumeros = lecturaTeclado.nextInt();
            System.out.println("Dime tu letra del dni");
            char letra = lecturaTeclado.next().charAt(0);
            System.out.println("¿Que grado de alzheimer tiene su familiar o amigo?");
            int gradoalzheimer = lecturaTeclado.nextInt();
            System.out.println("¿Cual es tu problema");
            String problema = lecturaTeclado.nextLine();

        }



    }

}