import java.util.Scanner;

public class CompararLogica {
    public static void main(String[] args) {
        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println(("Introduce un numero"));
        int numeroUno = lecturaTeclado.nextInt();
        System.out.println("Introduce numeroDos");
        int numeroDos = lecturaTeclado.nextInt();
        boolean isParN1 = numeroUno%2 ==0;
        boolean isImparN2 = numeroDos%2 !=0;
        boolean comprobación1 = isParN1 && isImparN2;
        boolean superiorPrimero = numeroUno > (numeroDos*2);
        boolean inferiorPrimero = numeroUno < 8;
        boolean comprobación2 = superiorPrimero && inferiorPrimero;

        boolean numerosIguales = numeroUno == numeroDos;
        boolean diferenciaNumeros = (numeroUno - numeroDos)<2;
        boolean comprobación3 = numerosIguales || diferenciaNumeros;

        System.out.println("El primero es par y el segundo impar " +comprobación1);
        System.out.println("El primero es el doble del segundo y el primero es <8" +comprobación2);

    }
}
