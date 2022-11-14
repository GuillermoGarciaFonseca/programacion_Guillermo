import java.util.Scanner;

public class ejercicio1 {
    public static void main(String[] args) {
        Scanner lecturateclado = new Scanner(System.in);
        System.out.println("Dime una palabra maestra");
        String palabramaestra = lecturateclado.nextLine();
        System.out.println("Dime una  palabra secundaria");
        String palabrasecundaria = lecturateclado.nextLine();
            if (palabramaestra !=palabrasecundaria) {
                do palabrasecundaria = lecturateclado.nextLine();
                while (palabramaestra == palabrasecundaria);

            }
        System.out.print("\n\n letras"+palabramaestra.length());
    }
}

