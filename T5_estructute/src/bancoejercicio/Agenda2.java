package bancoejercicio;

import java.util.ArrayList;

public class Agenda2 {
    private ArrayList<Persona> listaPersona;


    public Agenda2(){
        this.listaPersona=new ArrayList<>();
    }
    public Persona existePersona(String dni){
        Persona personaEncontrada= null;

        for (Persona item :listaPersona
             ) {if(dni.equalsIgnoreCase((item.getNif()))){
                 personaEncontrada=item;
                 break;
        }

        }

        return personaEncontrada;
    }
    public boolean agregarPersona(){
        boolean existe = false;

        for (Persona item:listaPersona) {
            if (item.getNif().equalsIgnoreCase(item.getNif())){
                existe = true;
                break;
            }

        }

        if (existe){
            System.out.println("Existe un dni ya guardado, no se puede add");

        }else {
            listaPersona.add(item);

        }
        // si el dni existe en la lista
        // no agrego
        // si el dni no existe
        //add

        return !existe;
    }
    public void listarAgenda(){
        if (!listaPersona.isEmpty()){
            for (Persona item:listaPersona
                 ) {item.mostrarDatos();

            }
        }else{System.out.println("No se puede listar porque esta vacia");}
    }
    public boolean borrarPersona(String dni){

        Persona persona=existePersona(dni);

        if (persona!=null){
            listaPersona.remove(persona);
            return true;
        }else {
            System.out.println("No se ha borrado, porque no existe");
        }

        return false;
    }
    public void actualizarPersona(String dni,Persona personaNueva ){
        Persona personaEncontrada = existePersona(dni);
        if (personaEncontrada!=null){
            // actualizo

            listaPersona.set(0,personaEncontrada);
        }else {
            System.out.println("No se ha encontrado la persona");
        }

    }
    public void buscarPersona(String dni){
        Persona personaEncontrada = existePersona(dni);
        if (personaEncontrada!=null){
            personaEncontrada.mostrarDatos();
        }else {
            System.out.println("La persona que buscas no se encuentra en la lista");
        }
    }
    public void vaciarAgenda(){
        for (Persona item:listaPersona
             ) {listaPersona.remove("");

        }
    }

}
