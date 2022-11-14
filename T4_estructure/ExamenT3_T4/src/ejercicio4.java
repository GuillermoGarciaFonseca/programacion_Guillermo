import java.util.Scanner;

public class ejercicio4 {
    public static void main(String[] args) {
        Object[][] usuarios = new Object[9][9];
        for (Object[] item : usuarios
        ) {
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
            System.out.println("tu nombre es" + nombre);
            System.out.println("tu apellido  es" + apellido);
            System.out.println("tu numero es" + numero);
        }
    }
}
