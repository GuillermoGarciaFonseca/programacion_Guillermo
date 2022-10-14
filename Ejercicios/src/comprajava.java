import java.util.Scanner;

public class comprajava {
    public static void main(String[] args) {
        System.out.println("Cuanto le ha costado el java ");
        Scanner lecturaTeclado = new Scanner(System.in);
        double cobrojava = lecturaTeclado.nextDouble();
        System.out.println("Cuanto es su iva");
        int iva = lecturaTeclado.nextInt();
        System.out.println("Su iva " +iva);

        System.out.printf("Su valor de la compra es: " +cobrojava);
        System.out.printf("Su iva es de: "+iva);

        double aumentoiva= (cobrojava *iva)/100;
        double ivadinero = cobrojava -aumentoiva;

        System.out.printf("Compra: "+aumentoiva);
        System.out.printf("El dinero del iva es:"+ivadinero);
        System.out.printf("El cobro en total es: "+cobrojava);
        ////System.out.printf("El cobro total: "+ (cobrojava - aumentoiva))
    }
}
