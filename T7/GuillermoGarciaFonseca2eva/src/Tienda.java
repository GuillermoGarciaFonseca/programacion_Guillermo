import Anidadas.Almacen;

import java.util.ArrayList;

public class Tienda extends Bicicleta  {
    private Almacen almacen;
    private ArrayList<Bicicleta> bicicletasStock;
    private ArrayList<Bicicleta>bicicletasReparar;
    private int caja;
    private Bicicleta Bicicleta;

    public void construirAlmacer(){
if(almacen==null){
almacen=new Almacen(1);
    System.out.println("Almacen construido");
}else {
    System.out.println("No se puede construir un alamacen");
}
    }
    public void venderBicicleta(ArrayList<Bicicleta>bicicletasStock){
this.bicicletasStock.remove(Bicicleta);
    }
    public void agregarBicicleta(Bicicleta bicicletasStock){
        this.bicicletasStock.add(Bicicleta);
    }
public void repararBicicletas(Bicicleta bicicletasReparar){
}
public void precioReparar(){

    double precio2= (int)(Math.random()*100*200);
    double precio3= (int)(Math.random()*50*100);
    double precio4= (int)(Math.random()*150*250);
}


    public Tienda() {
    }

    public Tienda(EnumbiciM enumbici, int velocidad, int pulgadas, EnumbiciT enumbiciT, boolean estado, Almacen almacen, ArrayList<Bicicleta> bicicletasStock, ArrayList<Bicicleta> bicicletasReparar, int caja, Bicicleta bicicleta) {
        super(enumbici, velocidad, pulgadas, enumbiciT, estado);
        this.almacen = almacen;
        this.bicicletasStock = bicicletasStock;
        this.bicicletasReparar = bicicletasReparar;
        this.caja = caja;
        Bicicleta = bicicleta;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public ArrayList<Bicicleta> getBicicletasStock() {
        return bicicletasStock;
    }

    public void setBicicletasStock(ArrayList<Bicicleta> bicicletasStock) {
        this.bicicletasStock = bicicletasStock;
    }

    public ArrayList<Bicicleta> getBicicletasReparar() {
        return bicicletasReparar;
    }

    public void setBicicletasReparar(ArrayList<Bicicleta> bicicletasReparar) {
        this.bicicletasReparar = bicicletasReparar;
    }

    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }

    public Bicicleta getBicicleta() {
        return Bicicleta;
    }

    public void setBicicleta(Bicicleta bicicleta) {
        Bicicleta = bicicleta;
    }


}
