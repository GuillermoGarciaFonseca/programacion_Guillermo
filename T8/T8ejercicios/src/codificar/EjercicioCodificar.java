package codificar;

import java.io.*;
import java.util.Scanner;

public class EjercicioCodificar {
    public static void main(String[] args) {
        FileWriter fileWriter =null;
        PrintWriter printWriter =null;

        Scanner in = new Scanner(System.in);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Introduce el mensaje a codificar");
        String mensaje = null;
        int clave=0;
        try {
            mensaje=bufferedReader.readLine();
            System.out.println(mensaje);
            System.out.println("Introduce la clave a codificar");
            clave =Integer.parseInt(bufferedReader.readLine());
            File file= new File("src/fichero/fichero_codificado.txt");
            fileWriter = new FileWriter(file);
            printWriter = new PrintWriter(fileWriter);
            for (char item :mensaje.toCharArray()) {
                int codigo = (byte)item * clave;
                printWriter.println(codigo+" ");
            }
            for (char item:mensaje.toCharArray()) {
                System.out.println((byte)item *clave);
            }
            System.out.println(clave);

        }catch (IOException e){
            throw new RuntimeException(e);
        }finally {
            try{
               bufferedReader.close();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }


    }
}
