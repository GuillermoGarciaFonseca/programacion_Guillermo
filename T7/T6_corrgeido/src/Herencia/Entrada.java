package Herencia;

import java.util.ArrayList;

public class Entrada {

    public static void main(String[] args) {
        Todoterreno todoterreno = new Todoterreno("T1","MT1", "4x4");
        Deportivo deportivo = new Deportivo("D1","MD1",400,500);

        ArrayList<Coche> listaCoches = new ArrayList<>();
        listaCoches.add(deportivo);
        listaCoches.add(todoterreno);

        for (Coche item: listaCoches) {
            //((Deportivo)item).acelerar();
            item.mostrarDatos();
            if (item instanceof  Deportivo){
                ((Deportivo) item).acelerar();
            } else if (item instanceof Todoterreno){
                ((Todoterreno) item).subirSuspension();
            }
        }

    }
}