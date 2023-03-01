import java.util.InputMismatchException;
import java.util.Scanner;

public class Errores {
    public void operar(int op1,int op2){
        double  division= (double) op1/op2;
        System.out.println(division);
    }

    private void accesoArray() throws ArrayIndexOutOfBoundsException{
        int [] numeros = new int[]{1,2,3,4,5,6,7,8,9,10};

        System.out.println(numeros[11]);
    }
    private void recepcionDatos() throws InputMismatchException {
        System.out.println("Introduce datos");
        int edad = new Scanner(System.in).nextInt();
        System.out.println("El nombre introducido es: "+edad);
    }
    public void ejecutarCosas(){
        //operar(0,8)
        try {
            recepcionDatos();
            accesoArray();
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Fallo encontrado");
        }catch (InputMismatchException e){
            System.out.println("Fallo encontrado en el array");
        }
    accesoArray();
    }
}
