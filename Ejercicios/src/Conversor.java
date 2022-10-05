import java.util.Scanner;

public class Conversor {
    public static void main(String[] args){
        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println("¿Que cantidad de dinero quieres cambiar? ");
        long cantidadDinero = lecturaTeclado.nextLong();
        System.out.println("Esta cantidad de dinero en euros es " +cantidadDinero);
         long libras = cantidadDinero * 87/100;
        System.out.println("Esta cantidad de dinero en libras es " +libras);
         long yenes = cantidadDinero * 143160/100;
        System.out.println("Esta cantidad de dinero en yenes es " +yenes);
         long dollar = cantidadDinero * 99/100;
        System.out.println("La cantidad de dinero en dollars es " +dollar);

    }
}