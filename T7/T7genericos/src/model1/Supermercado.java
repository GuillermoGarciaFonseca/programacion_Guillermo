package model1;

import java.util.ArrayList;
import java.util.Scanner;

public class Supermercado<R>{
private int caja;
private ArrayList<R>listarProducto =new ArrayList<>();


    public void listarProductos(R productos){
        for (R item:listarProducto) {
            i;
        }
    }
    public void agregarProductos(R producto){
      this.listarProducto.add(producto);
    }
    public void vaciarAlmacen(){
        for (R item: listarProducto) {
            listarProducto.remove(item);
        }
    }
}
