import java.io.*;
import java.nio.Buffer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class OperacionesFicheros {
    int numeroLineas=0;
    int numeroPalabras=0;
    int numeroLetras=0;
    public void creacionFichero() {
        File file = new File("C:\\Users\\Guillermo\\OneDrive\\Escritorio\\Fichero\\fichero.txt");
        File fileFinal = new File("C:\\Users\\Guillermo\\OneDrive\\Escritorio\\Fichero\\fichero2.txt");
        File fileCarpeta = new File("C:\\Users\\Guillermo\\OneDrive\\Escritorio\\Fichero\\carpeta.txt");
        boolean esfichero = fileFinal.isFile();
        boolean escarpeta = fileFinal.isDirectory();
        String rutaFichero = fileFinal.getAbsolutePath();
        String nombreFichero = fileFinal.getName();
        //Crear un fichero
        try {
            fileFinal.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // crear una carpeta
        fileCarpeta.mkdir();
        //pedir por consola un fichero(ruta completa)
        // y sacar informacion sobre un fichero
        System.out.println(esfichero);
        System.out.println(escarpeta);
        System.out.println(rutaFichero);
        System.out.println(nombreFichero);

    }

    public void sacarFichero() {
        Scanner in = new Scanner(System.in);
        System.out.println("Dime el fichero");
        String rutaEntrada = in.next();
        Path path = Paths.get(rutaEntrada);
        /* Para una ruta relativa recomendable para quitar los espacios system out println ("src/ficheros/" +rutaenrutamiento) */
        File file = new File(String.valueOf(path));
        System.out.println(file.getName());
        System.out.println(file.canExecute());
        System.out.println(file.canWrite());
        System.out.println(file.canRead());
        System.out.println(file.lastModified());
        System.out.println(file.getUsableSpace());
        System.out.println(file.length());
        System.out.println(file.setReadOnly());
    }

    public void lecturaRuta() {
        File file = new File("src/ficheros");
        System.out.println(file.getName());
        File[] listaNombres = file.listFiles();
        for (File nombre : listaNombres
        ) {
            System.out.println(nombre.getName());
            if (nombre.isDirectory()) {
                for (File fichero1 : nombre.listFiles()
                ) {
                    System.out.println("\t " + fichero1.getName());

                }
            }
        }
    }

    public void leerDirectorio(File file) {
        File[] ficheros = file.listFiles();
        for (File i : ficheros) {
            System.out.println(i.getName());
            if (i.isDirectory()) {
                System.out.println("\t");
                leerDirectorio(i);
            }
        }
    }

    public void leerFichero() {
        File fichero = new File("T8/T8_ficheros/src/lectura");
        FileReader reader = null;
        try {
            reader = new FileReader(fichero);

            int codigo = -1;
            while ((codigo = reader.read()) != -1) {
                System.out.println((char) codigo);
            }
        } catch (IOException e) {
            System.out.println("Fichero no encontrado");
        } finally {
            try {
                reader.close();

            } catch (IOException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }


    }
    public void leerBufferFicheros(){
        File file =new File("T8/T8_ficheros/src/lectura");
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            bufferedReader.readLine();
            String lineacodigo = null;
            StringBuilder contenido = new StringBuilder();
            while ((lineacodigo=bufferedReader.readLine())!=null){
                contenido.append(lineacodigo+"\n");

            }
            System.out.println("EL CONTENIDO ES: ");
            System.out.println(contenido);

        } catch (IOException|NullPointerException e) {
            throw new RuntimeException(e);
        }
    }
    public void ejercicioConteo(){
        File file =new File("T8/T8_ficheros/src/lectura");
        FileReader reader =null;
        BufferedReader bufferedReader = null;
        try {
            reader =new FileReader(file);
            bufferedReader =new BufferedReader(reader);
            String linea =null;
            while ((linea=bufferedReader.readLine())!=null){
                System.out.println(linea);
                numeroLineas++;
                System.out.println(linea);
            numeroPalabras+=linea.split(" ").length;
            numeroLetras+=linea.replaceAll(" ","").toCharArray().length;
            }
            System.out.println("El numero de lineas "+numeroLineas);
            System.out.println("El numero de palabras "+numeroPalabras);
            System.out.println("El numero de letras "+numeroLetras);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException | NullPointerException e) {
                throw new RuntimeException(e);
            }
        }

    }
    public  void lecturaCodigos(){
        File file =new File("src/ficheros/codigo.txt");
        FileReader fileReader =null;
        BufferedReader bufferedReader =null;
        try {
            fileReader =new FileReader(file);
            bufferedReader= new BufferedReader(fileReader);
            bufferedReader.readLine();
            String linea=null;
            while ((linea=bufferedReader.readLine())!=null){

                String[] palabras = linea.split(" ");
                for (String palabra: palabras) {
                    try {
                        System.out.println((char) Integer.parseInt(palabra));
                    }catch (Exception e){

                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }    }
public void lecturaByte(){
        //char letra = 'A';
    //System.out.println((byte)letra);
    File file =new File("src/ficheros/lore.txt");
    FileReader fileReader =null;

    try {
       fileReader=new FileReader(file);

       int numero=-1;while ((numero=fileReader.read())!=-1){
            System.out.println(numero+" ");
        }
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
public void escrituraBase(){
        String ejemplo ="Esto es un ejercicio de escritura base para comprobar que todo esta OK";
        File file =new File("src/escritura_codigos.txt");
        FileWriter fileWriter =null;
        try {
            fileWriter= new FileWriter(file,true);
            char [] letras= ejemplo.toCharArray();
            for (char letra: letras) {
                fileWriter.write(String.valueOf((byte)letra));
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}
public void escrituraBuffer(){
    String ejemplo ="Esto es un ejercicio de escritura base para comprobar que todo esta OK";
    File file =new File("src/escritura_codigos.txt");
    FileWriter fileWriter =null;
    //BufferedWriter bufferedWriter = null;
    PrintWriter printWriter =null;

    try {
        fileWriter =new FileWriter(file);
        printWriter = new PrintWriter(fileWriter);
        printWriter.println("Esto es un ejemplo de escritura");
        printWriter.println("donde vamos a escribir lineas multiples");
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}
}
