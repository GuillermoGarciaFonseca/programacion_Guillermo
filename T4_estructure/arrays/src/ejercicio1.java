import java.lang.reflect.Array;
import java.util.Arrays;

public class ejercicio1 {
    public static void main(String[] args) {
        /*int[] listanumeros= {1,2,3,4,5,6,7,8,9,10};
        int primero = listanumeros[0];
        for (int i = 0; i < listanumeros.length-1; i++) {
            listanumeros[i]= listanumeros[i+1];
        }
        int ultimo = listanumeros[listanumeros.length-1];
        listanumeros[listanumeros.length-1]=primero;
        for (int i = listanumeros.length-1; i >=1; i--) {
            listanumeros[i]= listanumeros[i-1];

        }
        listanumeros[0]=ultimo;
        for (int element: listanumeros) {
            System.out.println(element+" ");
        }*/
        int[] numeros = {3,6,7,8,9,12,1,4,2,6};
        Arrays.sort(numeros);
       int[] nuevo= Arrays.copyOf(numeros,15);
       nuevo[10]=100;
        System.out.println(Arrays.compare(numeros,nuevo));
        for (int item:
             numeros) {
            System.out.println(item+" ");

        }
        for (int i = 0; i < numeros.length-1; i++) {
            for (int j = 0; j < numeros.length-1-i; j++) {
                if (numeros[j]>numeros[j+1]){
                    int temporal = numeros[j+1];
                    numeros[j+1]=numeros[j];
                    numeros[j] = temporal;
                }
            }
        }
    }
}
