public class ejercicio2 {
    public static void main(String[] args) {
        char[] letras = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g','h'};
        String palabraGenerada = "";
        String palabraUno = "";
        String palabraDos = "";
        String palabraTres = "";
        String palabraCuatro = "";
        String palabraCinco = "";
        for(int i = 0; i<5;i++){
            int aleatorio = (int) (Math.random()*letras.length);
            char letra = letras[aleatorio];
            palabraGenerada +=letra;
//for (element0 nombre : variable  es el foreach
        }

    }
}
