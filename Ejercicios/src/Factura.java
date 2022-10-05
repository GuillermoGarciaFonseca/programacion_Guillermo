import java.util.Scanner;

public class Factura {
    public static void main(String[] args) {
        double facturasiniva =2500;
        double iva = 21;
        double cobroiva = facturasiniva * iva/100;
        double facturaiva = cobroiva + facturasiniva;
        System.out.println("Su factura sin iva es :" +facturasiniva);
        System.out.println("Se le sumaria con iva :"+cobroiva);
        System.out.println("Su factura  con iva es de:"+facturaiva);
    }

}
