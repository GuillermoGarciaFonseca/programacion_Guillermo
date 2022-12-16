import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;

public class ejercicios {
    static Scanner in= new Scanner(System.in);
    public static void main(String[]args) {
        ejercicicio17();
    }
    public static void ejercicicio17(){
        Hashtable<String, Object[]>menupersonas = new Hashtable<>();
        int opcion= 0;
        do {
            System.out.println("1---Agregar persona");
            System.out.println("2---Buscar persona");
            System.out.println("3---Borrar persona");
            System.out.println("4---Listas persona");
            System.out.println("5---Salir");
            System.out.println("************");
            System.out.println("Dime una opcion");
            opcion=in.nextInt();
            switch (opcion){
                case 1:
                    agregarUsuario(menupersonas);
                    break;
                case 2:
                    buscarusuario(menupersonas);
                case 3:
                    /*if (borrarusuario()){
                        System.out.println("el usuario se ha borrado correctamente");
                    }else {
                        System.out.println("fallo al borrar,usuario no encontrado");
                    }*/
                    borrarusuario(menupersonas);
                    break;
                case 4:
                    listarusuarios(menupersonas);
                    break;
                case 5:
                    System.out.println("saliendo");
                    break;
            }
        }while (opcion!=5);


    }
    public static void agregarUsuario(Hashtable<String,Object[]>menuparametro){
        System.out.println("Dime tu DNI: ");
        String DNI = in.next();
        if (menuparametro.containsKey(DNI)){
            System.out.println("fallo al agregar, el dni ya existe");
        }else {
            System.out.println("Dime tu nombre: ");
            String nombre = in.next();
            System.out.println("Dime tus apellidos: ");
            String apellidos = in.next();
            System.out.println("Dime tu telefono: ");
            int numerotelefono = in.nextInt();

        Object [] usuario = new Object[]{nombre,apellidos,numerotelefono,DNI};
        menuparametro.put(usuario[3].toString(),usuario);
            System.out.println("Añadido correctamente");
        }
    }
    public static void listarusuarios(Hashtable<String,Object[]>menuparametro){
        // Lista que quiero mostrar
        // 1. Sacar las claves de la lista
        if (!menuparametro.isEmpty()){
        Enumeration<String> claves = menuparametro.keys();
        while (claves.hasMoreElements()) {
            String key = claves.nextElement();
            Object[] usuario = menuparametro.get(key);
            System.out.println("Nombre: " + usuario[0]);
            System.out.println("\tApellido: " + usuario[1]);
            System.out.println("\tTelefono: " + usuario[2]);
        }
        }else {
            System.out.println("la agenda no tiene datos");
        }
    }
    public static void borrarusuario(Hashtable<String,Object[]> menuparametro){
        System.out.println("Introduce el dni de la persona que quieres borrar");
        String DNI= in.next();
        Object[] usuarioborrado;
        if ((usuarioborrado=menuparametro.remove(DNI))!=null){
            System.out.println("persona borrada correctamente"+usuarioborrado[0]);
        }else {
            System.out.println("Fallo al borrar, usuario no encontrado");
        }
       // if (menuparametro.containsKey(DNI)){
         //   menuparametro.remove(DNI);
        //}
        //return menuparametro.remove(DNI)!=null;
    }

    public static void buscarusuario(Hashtable<String,Object[]>menuparametro){
        System.out.println("Introduce el dni de la persona que quieres borrar");
        String DNI= in.next();
        Object[] usuarioencontrado;
        if ((usuarioencontrado=menuparametro.get(DNI))!=null){
            System.out.println("Nombre: " + usuarioencontrado[0]);
            System.out.println("\tApellido: " + usuarioencontrado[1]);
            System.out.println("\tTelefono: " + usuarioencontrado[2]);
        }else {
            System.out.println("La agenda no tiene datos");
        }
    }
public static void mostrarinformacion(Object[]usuarioParametro){



}

}
