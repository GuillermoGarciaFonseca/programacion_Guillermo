import java.util.Scanner;

public class EjercicioUno {
    public static void main (String[] args){
        String nombre,apellido,sexo;
        int edad;
        double altura,peso;
        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println("¿Cual es tu nombre?");
        nombre = lecturaTeclado.nextLine();
        System.out.println("¿Cual es tu apellido?");
        apellido =lecturaTeclado.nextLine();
        System.out.println("¿Cual es tu sexo?");
        sexo = lecturaTeclado.nextLine();
        System.out.printf("¿Cual es tu altura?");
        altura = lecturaTeclado.nextDouble();
        System.out.println("¿Cuantos años tienes");
        edad = lecturaTeclado.nextInt();
        System.out.printf("¿Cuanto es tu peso?" );
        peso = lecturaTeclado.nextDouble();
        System.out.println("Tu nombre es: "+nombre);
        System.out.println("Tu apellido es: "+apellido);
        System.out.println("Tu sexo es: "+sexo);
        System.out.println("Tu altura es: "+altura);
        System.out.println("Tu peso es: "+peso);
        System.out.println("Tu edad es: "+edad);
        double IMC = peso / (altura*altura);
        double alturacm = altura * 100;
        System.out.printf("Hola "+nombre);
        System.out.printf("tu IMC teniendo en cuenta tu altura de"+alturacm);
        System.out.printf("cm");
        System.out.printf("y tu peso de " +peso);
        System.out.printf("kg");
        System.out.printf("tiene un valor de " +IMC);
    }

}
