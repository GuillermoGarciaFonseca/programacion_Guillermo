import java.util.Scanner;

public class nomina {
    public static  void main(String[]args){

        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println("Introudce su salario  bruto mensual ");
        int numeroLeido = lecturaTeclado.nextInt();
         System.out.println("Su salario bruto mensual es " +numeroLeido);
         int neto = numeroLeido * 15/100;
         int salarionetomensual = numeroLeido - neto;
         System.out.println("Su salario neto mensual es " + salarionetomensual);
         int salariobrutoanual = numeroLeido * 12;
         System.out.println("Su salario bruto anual es " + salariobrutoanual);
         int salarionetoanual = salarionetomensual *12;
         System.out.println("Su salario neto anual es " +salarionetoanual);
    }
}
