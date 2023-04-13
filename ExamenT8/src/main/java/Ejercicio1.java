import java.io.*;

public class Ejercicio1 {
    public void Ejerc1() {
        File file = new File("src/main/java/fichero/ejer1.txt");
        FileReader fileReader =null;
        BufferedReader bufferedReader=null;
        try {

                 fileReader = new FileReader(file);
                 bufferedReader = new BufferedReader(fileReader);
                String lctura= bufferedReader.readLine();
                String [] numero= lctura.split(" ");
            for (String item :numero) {
                int numeroConv=Integer.valueOf(item);
                System.out.println((char) numeroConv);
            }
            } catch (FileNotFoundException e) {
                System.out.println("Error: Fichero no encontrado");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}