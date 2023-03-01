public class Entrada {
    public static void main(String[] args) {
        String palabra=null;
        int [] numeros =new int[]{1,2,3,4,5,6,7,8,9,10};

        try {
            System.out.println(palabra.length());

            System.out.println(numeros[11]);
        }catch (NullPointerException e){
            System.out.println("Encontrado unn fallo de nulo");
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Sout se encuentraun fallo en el array");

        }finally {
            System.out.println("Ejecutado de forma obligatoria en try/catch");
        }
        Errores errores =new Errores();

    }
}
