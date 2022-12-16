import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int numeros;
        do{
            System.out.print("Pon un numero > 1: ");
            numeros = in.nextInt();
        }while(numeros<=1);
            System.out.println("Los " + numeros + " primeros numeros de Fibonacci a partir del 0 son:");
            int variable1=1;
            int variable2=1;
            System.out.print(variable1 + " ");
            for(int i=2;i<=numeros;i++){
                System.out.print(variable2 + " ");
                variable2 = variable1 + variable2;
                variable1 = variable2 - variable1;
            }
            System.out.println();
        }
    }


