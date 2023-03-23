package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Entrada {
    private ArrayList<Usuario>usuarios;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String opcion =" ";
        ArrayList<Usuario> agenda =new ArrayList<>();
        String nombre,apellido,dni;
        int edad,telefono;

        do {
            System.out.println("Introduce nombre");
            nombre = in.next();
            System.out.println("Introduce apellidos");
            apellido = in.next();
            System.out.println("Introduce dni");
            dni = in.next();
            System.out.println("Introduce edad");
            edad = in.nextInt();
            System.out.println("Introduce telefono");
            telefono = in.nextInt();
            Usuario usuario =new Usuario(nombre,apellido,dni,edad,telefono);
            System.out.println("Quieres continuar añadiendo");
            opcion= in.next();
        }while (opcion.equalsIgnoreCase("s"));
        File fichero=new File("src/fichero/agenda.txt");
        FileWriter fileWriter = null;
        PrintWriter printWriter = null;
        try {
            fileWriter=new FileWriter(fichero,true);
            printWriter =new PrintWriter(fileWriter);int contador=1;

            for (Usuario item: agenda) {
                printWriter.println("usuario"+contador);
                printWriter.println(item);
            contador++;
            }
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
}
