package adivinar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {
    private ArrayList<Juego>juegos;
    public static void main(String[] args) {
        ArrayList<Juego> juegos1= new ArrayList<>();
        Scanner in= new Scanner(System.in);
        int numeroRandom;
        public void numeroAleatorio(){
            numeroRandom = (int) Math.random()*21;
        }
        String nombre;
        int numero;
        int numerointentos;
        do {
            System.out.println("Dime tu nombre");
            nombre= in.next();
            System.out.println("Dime un numero entre el 1 y el 20");
            numero = in.nextInt();
            if (numeroRandom == numero){
                System.out.println("Has acertado el numero ");
            }else {
                System.out.println("introduce otro numero");
                numerointentos++;
            }

        }while(numero !=22){
            System.out.println("No puede ser un numero mayor a 20");
            numerointentos++;
            File fichero=new File("src/fichero/agenda.txt");
            FileWriter fileWriter = null;
            PrintWriter printWriter = null;
            try {
                fileWriter=new FileWriter(fichero,true);
                printWriter =new PrintWriter(fileWriter);
            }catch  (IOException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    printWriter.close();
                }catch (NullPointerException e){
                    System.out.println("Error");
                }


    }
}
