package bancoejercicio;

import java.util.Scanner;

public class Entrada {
    public static void main(String[] args) {
        Agenda2 agendaTrabajo= new Agenda2();
        //listaPersona[]
        Agenda2 agendaAmigos = new Agenda2();

       /* agendaTrabajo.agregarPersona(new Persona("Carlos","ASDADA2",47854784,"Hoyo"));
        agendaTrabajo.buscarPersona("");
    agendaTrabajo.borrarPersona("");
    agendaTrabajo.actualizarPersona("",new Persona("","",212,""));*/
        Scanner in = new Scanner(System.in);
        int opcion = 0;
        System.out.println("1. Añadir persona");
        System.out.println("2. Buscar persona");
        System.out.println("3. Borrar persona");
        System.out.println("4. Listar persona");
        System.out.println("5. Vaciar lista");
        System.out.println("6. Editar persona");
        System.out.println("7. Salir");
        System.out.println("****************");
        System.out.println("Buenas dime un opcion");
        opcion= in.nextInt();
        switch (opcion){
            case 1:
                String nombre,apellidos,dni;
                int telefono;
                agendaTrabajo.agregarPersona(){

                System.out.println("Dime tu nombre");
                nombre= in.next();
                System.out.println("Dime tus apellidos");
                apellidos=in.next();
                System.out.println("Dime tu DNI");
                dni=in.next();
                System.out.println("Dime tu numero");
                telefono=in.nextInt();
            }break;
            case 2:

                break;
        }while (opcion!=7);
    }
}
