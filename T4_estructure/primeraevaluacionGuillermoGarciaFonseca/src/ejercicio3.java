/*import  java.util.Scanner;

public class ejercicio3 {

    public static void main(String[] args) {
        int[] tipo = new int[7];
        int[] CV = new int[7];
        int[] costetotal = new int[7];
        int opcion = 0;
        Scanner in = new Scanner(System.in);

        do {


            System.out.println("Introduce que opcion");
            System.out.println("Opción 1: Registrar coche");
            System.out.println("Opción 2: Lista de coches");
            System.out.println("Opción 3: Buscar coche");
            System.out.println("Opción 4: Calcular coche");
            System.out.println("Opción 5: Salir");
            opcion = in.nextInt();
            switch (opcion) {
                case 1:
                    for (int i = 0; i < tipo.length; i++) {

                        System.out.println("que modelo es");
                        tipo.length= in.next();
                    }

                    for (int i = 0; i < CV.length; i++) {
                        System.out.println("Cuantos caballos tiene");
                        CV[i] = in.nextInt();
                    }

                    for (int i = 0; i < costetotal.length; i++) {
                        System.out.println("Cuanto es el coste del arreglo");
                        costetotal[i] = Integer.parseInt(in.next());
                    }
                    break;


                case 2:
                    for (int i = 0; i < tipo.length; i++) {
                        System.out.println("que modelo es");
                        String modelo = in.next();
                        System.out.println(modelo);
                    }
                    for (int i = 0; i < CV.length; i++) {
                        System.out.print(CV);
                    }
                    for (int i = 0; i < costetotal.length; i++) {
                        System.out.print(costetotal);

                    }
                    break;
                case 3:
                    System.out.println("Que coche quieres saber:");
                    int posicion = in.nextInt();
                    System.out.print(tipo[posicion]);
                    System.out.print(CV[posicion]);
                    System.out.print(costetotal[posicion]);
                    break;

                case 4:
                    for (int i = 0; i < costetotal.length; i++) {
                        int sumacoste;
                        sumacoste = costetotal[i] + costetotal[i];
                        System.out.println(sumacoste);
                    }
                    break;
                case 5:
                    System.out.println("saliendo");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        } while (opcion != 6);
    }
}
*/