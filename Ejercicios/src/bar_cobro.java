import java.util.Scanner;

public class bar_cobro {
    public static void main(String[] args) {
        final double Precio_botellas = 1.25;
        final double Precio_bocadillos = 2.05;
        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println("¿Cuantas bebidas has pedido?");
        int numerobebida = lecturaTeclado.nextInt();
        System.out.println("¿Cuantos bocadillos habeis perdido?");
        int numerobocadillos = lecturaTeclado.nextInt();

        System.out.println("Numero de bebidas: " +numerobebida);
        System.out.println("Numero de bocadillos: " +numerobocadillos);

         double costedebebidas = numerobebida * 375/100;
         double costedebocadillos = numerobocadillos * 1025/100;
         double costetotal = costedebebidas + costedebocadillos;

        System.out.printf("El coste de las bebidas fue: "+ costedebebidas);
        System.out.printf("El coste de los bocadillos fue: "+ costedebocadillos);
        System.out.printf("El coste de la consumición fue: "+ costetotal);
        //System.out.printf("El coste de la consumición fue: "+ (costedebebidas+costedebocadillos))
    }
}
