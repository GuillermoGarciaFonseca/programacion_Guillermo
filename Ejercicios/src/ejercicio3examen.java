import java.util.Scanner;

public class ejercicio3examen {
    public static void main(String[] args) {
        Scanner lecturaTeclado = new Scanner(System.in);
        System.out.println("Que nota has sacado en el primer examen");
        double primeranota = lecturaTeclado.nextDouble();
        System.out.println("Que nota quieres sacar en el trimestre");
        double notatrimestral = lecturaTeclado.nextDouble();
        double resultado1nota = (primeranota *40)/100;
        double nota2 = notatrimestral -resultado1nota;
        double notanecesaria = (nota2*100)/60;
        System.out.println("Nota primer examen: "+primeranota);
        System.out.println("¿Que nota quieres sacar en el trimestre?" +notatrimestral);
        System.out.println("Necesitas sacar en el examen trimestral" + notanecesaria);
    }
}
