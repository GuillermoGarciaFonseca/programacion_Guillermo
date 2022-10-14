import java.util.Scanner;

public class circunferencia {
    public static void main(String[] args) {
        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println("introduce el radio de la circunferencia: ");
        int radioCircunferencia = lecturaTeclado.nextInt();
        // (2pi radio)
        double longitudCircunferencia = 2*Math.PI*radioCircunferencia;
        //pi rcuadrado
        double areaCircunferencia = Math.PI * (Math.pow(radioCircunferencia,2));

        System.out.printf("la longitud de la circunferencia es de %.2f%n", longitudCircunferencia);
        System.out.printf("El radio de la circunferencia es de %.2f%n", areaCircunferencia);


    }
}
