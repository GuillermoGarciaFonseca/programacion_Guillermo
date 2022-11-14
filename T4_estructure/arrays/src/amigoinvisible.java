import java.util.Scanner;

import static java.lang.String.valueOf;

public class amigoinvisible {
    public static void main(String[] args) {
        Scanner lecturaparticipantes = new Scanner(System.in);
        System.out.println("Cuantos participantes hay");

        int numerop = lecturaparticipantes.nextInt();
        String [] grupo1 =new String[numerop/2],grupo2 = new String[numerop/2];
        int[] listaparticipantes = new int[numerop];
        if (numerop% 2==0){
            for (int i = 0; i < grupo1.length; i++) {
                grupo1[i] = añadirParticipantes();
                grupo2[i] = añadirParticipantes();
                System.out.printf("%s : %s\n",grupo1[i],grupo2[i]);
            }
        }else {
            System.out.println("El numero de participantes es impar");
        }


    }
    private static String añadirParticipantes (){
        Scanner lecturaparticipantes = new Scanner(System.in);
        System.out.println("Dime los nombres de los participantes");
       return lecturaparticipantes.next();
    }
}
