import java.util.Scanner;
// double precioinicialbocadillos
//double precioinicialbebidas
public class baravnazado {
    public static void main(String[] args) {
        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println("¿Cuantas bebidas has pedido (0-20)?");
        int numerobebida = lecturaTeclado.nextInt();
        System.out.println("¿Cuantos bocadillos habeis perdido(0-20)?");
        int numerobocadillos = lecturaTeclado.nextInt();
        System.out.println("Cuanto ha csotado cada bocata(0.0-3.0): ");
        double precioinicialbocadillos = lecturaTeclado.nextDouble();
        System.out.println("Cuanto ha costado cada bebida (0.0-3.0)");
        double precioinicialbebidas = lecturaTeclado.nextDouble();
        System.out.println("Cuantos comensales sois: ");
        int numeropersonas = lecturaTeclado.nextInt();
        double costedebocadillos = numerobocadillos * 1025 / 100;
        double costedebebidas = numerobebida * 375 / 100;

        double costetotal = costedebebidas + costedebocadillos;
        System.out.println("Articulo/t/t/t\tCantidad\t\t precio\t\t\tCoste");
        System.out.printf("Bebidass\t/T/t %d/t/t/t%.2f/t/T/t %.2f%n",numerobebida,precioinicialbebidas,costedebebidas);
        System.out.printf("Bocadillos/t/T/t %d/t/t/t%.2f/t/T/t %.2f%n",numerobocadillos,precioinicialbocadillos,costedebocadillos);
        System.out.printf("Total/t/T/t /t/t/t/t/T/t %.2f%n",costetotal);
        System.out.printf("ppp/t/T/t %d/t/t/t/t/T/t %.2f%n",costetotal/numeropersonas);
    }
}
