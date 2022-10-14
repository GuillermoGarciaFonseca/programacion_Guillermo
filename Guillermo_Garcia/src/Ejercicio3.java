import java.util.Scanner;

public class Ejercicio3 {
    public  static void main(String[] args){
        double preciocoche,pagoplazos;
        int plazospagar;
        Scanner lecturateclado = new Scanner(System.in);
        System.out.println("Cuanto valio el coche");
        preciocoche = lecturateclado.nextDouble();
        System.out.println("Cuantos plazos");
        plazospagar = lecturateclado.nextInt();
        pagoplazos= preciocoche / plazospagar ;
        System.out.printf("Vas a pagar un coche de "+preciocoche);
        System.out.printf("€");
        System.out.printf(" en "+plazospagar);
        System.out.printf(" meses, con un total de " +pagoplazos);
        System.out.printf("€ ");
        System.out.printf("cada plazo");
    }
}
