import java.util.Scanner;

public class ejercicioforfactorial {
    public static void main(String[] args) {
        long factorial2=1;
        Scanner in = new Scanner(System.in);
        System.out.println("Dime un numero");
        int numeroaleatorio = in.nextInt();
        int factorial = 1;
        for (int i =numeroaleatorio ; i >0; i--) {
            factorial = factorial * i;
        }
        System.out.println("El factorial de " +numeroaleatorio+ "es " +factorial);
    }
}
