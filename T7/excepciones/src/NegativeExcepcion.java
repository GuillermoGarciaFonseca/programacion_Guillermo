public class NegativeExcepcion  extends Exception{
    public NegativeExcepcion(String mensaje){
        super(mensaje);
        System.out.println("El numero pasado es: ")         ;
    }
}
