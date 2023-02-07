package Trabajadores;

import java.util.ArrayList;
import java.util.Scanner;

public final class Empresa {
    private ArrayList<Trabajador>listatrabajador;
    private ArrayList<Jefe>listaJefe;

    private Trabajador trabajador;
public Empresa(){
    listatrabajador=new ArrayList<>();
    listaJefe=new ArrayList<>();
}
    Scanner in=new Scanner(System.in);
public void AgregarJefe(Jefe jefe){
    for (Jefe itemJefe:listaJefe) {
       listaJefe.add(jefe);
    }

}
public void listar(){}
public void AgregarTrabajador(Trabajador trabajador){
    for (Trabajador itemtrabajador:listatrabajador) {
        if (estaTrabajador(trabajador.getDni())==null) {
            listatrabajador.add(trabajador);
        }else {
            System.out.println("El trabajador se encuentra en la lista");
            //estaTrabajador((trabajador.getDni());
        }
    }
}
public void emitirFactura(String cif,String nombre, int cantidad){
    // FACTURA DE LA EMPRESA SL CON EL CIF 12212112B
    //PARA EL CLUENTE nombre CON EL CIF
    // POR UNA CANTIDAD DE cantidad
    System.out.printf("FACTURA DE LA EMPRESA SL CON EL CIF 12212112B%n");
    System.out.printf("PARA EL CLUENTE %s nombre CON EL CIF%s%n",nombre,cif);
    System.out.printf("POR UNA CANTIDAD DE %d%n",cantidad);


}
public void listarTrabajadores(){
    for (Trabajador item: listatrabajador) {
        System.out.println(item.getDni());
    }
}
private Trabajador estaTrabajador(String dni){
    Trabajador trabajadorEncontrado=null;

    for (Trabajador item:listatrabajador
         ) {if (item.getDni().equalsIgnoreCase(dni)){
             return item;
    }

    }
    return null;
}
}
