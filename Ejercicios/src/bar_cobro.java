import java.util.Scanner;

public class bar_cobro {
    public static void main(String[] args) {
        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println("¿Cuantas bebidas has pedido?");
        int numerobebida = lecturaTeclado.nextInt();
        System.out.println("¿Cuantos bocadillos habeis perdido?");
        int numerobocadillos = lecturaTeclado.nextInt();
        System.out.println("ENTRADA");
        System.out.println("las bebidas que has pedido son: " +numerobebida);
        System.out.println("los bocadillos que has pedido son: " +numerobocadillos);

        double costedebebidas = numerobebida * 375/100;
        double costedebocadillos = numerobocadillos * 1025/100;
        double costetotal = costedebebidas + costedebocadillos;
        System.out.println("Salida");
        System.out.printf("El coste de las bebidas fue: "+ costedebebidas);
        System.out.printf("El coste de los bocadillos fue: "+ costedebocadillos);
        System.out.printf("El coste de la consumición fue: "+ costetotal);
    }
}
