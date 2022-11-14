import java.util.Scanner;

public class frasearray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Intorduce la frase que quieres evaluar");
        String frase = scanner.nextLine();
        System.out.println(frase);
        String[] palabras = frase.split(" ");
        String palabraLarga= palabras[0];String palabraCorta= palabras[0];
        for (String item: palabras) {
            if (item.length() > palabraLarga.length()){
                palabraLarga=item;
            }
            if(item.length()<palabraCorta.length()){
                palabraCorta = item;
            }
        }
        System.out.println("La palabra mas corta es "+palabraCorta);
        System.out.println("La palabra mas larga es "+palabraLarga);
    }
    private static void resumen(){
        Object[] cosas = new Object[]{1,"hola",true,0.0,5,false};
        for (Object item : cosas){
            if (item instanceof String){
                System.out.println(((String) item).length());

            }else if ( item instanceof Integer){
                System.out.println("El cuadrado del numero es : " +Math.pow((int)item,2));
            }

        }
    }
}
