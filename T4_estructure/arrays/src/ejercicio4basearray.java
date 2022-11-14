import java.util.Scanner;

public class ejercicio4basearray {
    public static void main(String[] args) {
        int[] listanumeros=new int[20];
        int[] cuadrados = new int[20];
        int [] cubos = new int[20];
        for (int i =0;i<20;i++){
            int aleatorio = (int)(Math.random()*101);
            listanumeros[i] =aleatorio;
            cuadrados[i]=((int)Math.pow(listanumeros[i],2));
            cubos[i]=((int) Math.pow(listanumeros[i],3));
        }
        System.out.println("Numero\t\tCuadrado\t\tCubo");
        for (int i = 0; i<listanumeros.length;i++){
            System.out.println();
        }
    }

}
