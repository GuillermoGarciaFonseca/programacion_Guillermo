import java.util.Scanner;

public class nomina2 {
    public static  void main(String[]args) {

        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println("Introudce su salario  salario ");
        int sueldoBrutoAnual = lecturaTeclado.nextInt();
        System.out.println("Cuantas pagas tienes");
        final int Retenciones = 15;
        int pagas = lecturaTeclado.nextInt();
        double SueldoNetoAnual = sueldoBrutoAnual - ((double) (sueldoBrutoAnual * Retenciones)) / 100;
        double sueldoBrutoMensual = sueldoBrutoAnual / ((double) (sueldoBrutoAnual * Retenciones)) / 100;
        double sueldoNetoMensual = sueldoBrutoMensual / ((double) (sueldoBrutoAnual * Retenciones) / 100);
    }
}
