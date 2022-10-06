import java.util.Scanner;

public class FormatoPersonas {
    public static void main(String[] args){

       String linea1 =  new FormatoPersonas().PedirDatos();
        String linea2 =new FormatoPersonas().PedirDatos();
        System.out.printf("Nombre/t/t/t/tEdad/t/t/tAltura/t/t/tCarnet/t/t/tletra%n");
        System.out.printf("%s",linea1);
        System.out.printf("%s",linea2);
                //         carnetdeconducir,letraDNI);
       //  Scanner lecturaTeclado= new Scanner(System.in);
      //// String nombre = lecturaTeclado.next();
        //   System.out.println("Introduzca apellidos");
        //  String apellido =lecturaTeclado.next();
        //  System.out.println("Edad");
        //  int edad = lecturaTeclado.nextInt();
        //  System.out.println("Altura");
        //  double altura = lecturaTeclado.nextDouble();
        // System.out.printf("Carnet de conducir");
        //  boolean carnetdeconducir = lecturaTeclado.nextBoolean();
        //  System.out.println("letra DNI");
        //  char letraDNI = lecturaTeclado.next().charAt(0);
        //  System.out.printf("NOMBRE/t/t/tEdad/t/t/tAltura/t/tCarnet/t/t/tletra%n");
        //   System.out.printf("%s/t/t/t/t%d/t/t%.2f/t/t%b/t/t%b/t/t/t%c%n", nombre+" "+apellido,edad,altura,
        //         carnetdeconducir,letraDNI);
    }
    public static String PedirDatos(){
        Scanner lecturaTeclado= new Scanner(System.in);
        System.out.println("Introduzca nombre");
        String nombre = lecturaTeclado.next();
        System.out.println("Introduzca apellidos");
        String apellido =lecturaTeclado.next();
        System.out.println("Edad");
        int edad = lecturaTeclado.nextInt();
        System.out.println("Altura");
        double altura = lecturaTeclado.nextDouble();
        System.out.printf("Carnet de conducir");
        boolean carnetdeconducir = lecturaTeclado.nextBoolean();
        System.out.println("letra DNI");
        char letraDNI = lecturaTeclado.next().charAt(0);
        System.out.printf("%s/t/t/t/t%d/t/t%.2f/t/t%b/t/t%b/t/t/t%c%n", nombre+" "+apellido,edad,altura,
                carnetdeconducir,letraDNI);
        return String.format("%s/t/t/t/t%d/t/t%.2f/t/t%b/t/t%b/t/t/t%c%n", nombre+" "+apellido,edad,altura,
                carnetdeconducir,letraDNI);
    }
}
