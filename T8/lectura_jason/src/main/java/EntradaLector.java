import java.util.ArrayList;
import java.util.Scanner;

public class EntradaLector {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Lector lector = new Lector();
        ArrayList<String> categorias = lector.lecturaCategorias();
        for (int i = 0; i < categorias.size(); i++) {
            System.out.printf("%d - %s%n",i,categorias.get(i));
        }
        System.out.printf("Que categoria quieres mostrar");
    }
}
