import java.util.Scanner;

public class ejercicio22 {
    public static void main(String[] args) {
        int [] listanumeros = new int[10];int max=0;int min=21;int par=0;int impar =0;int repeticiones =0;
        for (int i =0 ; i < listanumeros.length; i++) {
             listanumeros[i] = (int)(Math.random()*21);
            System.out.println(listanumeros[i]);
        }
        Scanner lecturateclado=new Scanner(System.in);
        System.out.println("Que numero quieres saber");
        int busqueda= lecturateclado.nextInt();
        for (int i = 0; i <listanumeros.length ; i++) {
            if (listanumeros[i]>max) {
                max = listanumeros[i];
            }else if (listanumeros[i]<min){
                min = listanumeros[i];
            }
            if (listanumeros[i]%2 ==0) {
                par++;
            } else {
                impar++;
            }
            if (busqueda == listanumeros[i]) {
                busqueda++;
            }
        }

        System.out.println("Maximo "+max);
        System.out.println("Minimo "+min);
        System.out.println("Pares "+par);
        System.out.println("Impares "+impar);
        System.out.println("Repeticiones "+repeticiones);

    }
}
