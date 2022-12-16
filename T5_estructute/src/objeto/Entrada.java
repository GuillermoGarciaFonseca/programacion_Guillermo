package objeto;


import java.util.Scanner;

public class Entrada {
    public static void main(String[]args){
        Scanner in = new Scanner(System.in);
        String nombre,apellidos,dni;
        int altura,edad;
        double peso;
        System.out.println("Introduce nombre");
        nombre= in.next();
        System.out.println("Introduce apellidos");
        apellidos = in.next();
        System.out.println("Introduce dni");
        dni = in.next();
        System.out.println("Introduce edad");
        edad = in.nextInt();
        System.out.println("Introduce altura");
        altura= in.nextInt();
        System.out.println("Introduce peso");
        peso= in.nextDouble();
        Persona persona1= new Persona(nombre,apellidos,edad,peso,altura);
       Persona persona2 = new Persona( "Guillermo ","Garcia ", edad, peso, altura);
        Persona persona3 = new Persona();
        persona1.calcularIMC();
        persona2.calcularIMC();
        persona3.calcularIMC();

    }
}
