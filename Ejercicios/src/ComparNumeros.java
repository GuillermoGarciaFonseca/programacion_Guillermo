import java.util.Scanner;

public class ComparNumeros {
    public static void main(String[] args) {
        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println("Introduce primer numero");
        int numeroUno = lecturaTeclado.nextInt();
        System.out.println("Introduce el segundo numero");
        int numeroDos = lecturaTeclado.nextInt();
        System.out.println("Introduce un tercer numero");
        int numeroTres = lecturaTeclado.nextInt();
        boolean coprobacionsuma = ((numeroUno +numeroDos) == numeroTres);


        //
        //System
    }
}
