import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        int numero,factorial = 1;
        Scanner input = new Scanner(System.in) ;
        System.out.print("Dime un número\n::: ");
        numero = input.nextInt();
        for (int i = 0; i < numero; i++) {
            factorial*=numero;
        }
        System.out.print("factorial = %d\n"+factorial);
    }
}
