import java.util.Scanner;

public class compararpar {
    public static void main(String[] args){
        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println("Dime un numero");
        int numero= lecturaTeclado.nextInt();
        int numeropar= lecturaTeclado.nextInt();
        boolean ispar = numero%2 == 0;
        boolean ismayor = numero > 50;
        System.out.println("El número es par: " +ispar);
        System.out.println("El número es mayor de 50: " +ismayor);
    }
}
