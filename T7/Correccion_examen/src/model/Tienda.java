package model;

import java.util.ArrayList;
import java.util.function.BinaryOperator;

public class Tienda {
    private Almacen almacen;
    private ArrayList<Bicicleta> biciStock;
    private ArrayList<Bicicleta> bicisReparar;
    private int caja;
    private double Precio;
    class Almacen{
    int numeroPlazas;

        public Almacen(int numeroPlazas) {
            this.numeroPlazas = numeroPlazas;
        }

        public int getNumeroPlazas() {
            return numeroPlazas;
        }

        public void setNumeroPlazas(int numeroPlazas) {
            this.numeroPlazas = numeroPlazas;
        }
    }

    public Tienda() {
        biciStock = new ArrayList<>();
        bicisReparar = new ArrayList<>();

    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }

    public ArrayList<Bicicleta> getBiciStock() {
        return biciStock;
    }

    public void setBiciStock(ArrayList<Bicicleta> biciStock) {
        this.biciStock = biciStock;
    }

    public ArrayList<Bicicleta> getBicisReparar() {
        return bicisReparar;
    }

    public void setBicisReparar(ArrayList<Bicicleta> bicisReparar) {
        this.bicisReparar = bicisReparar;
    }

    public int getCaja() {
        return caja;
    }

    public void setCaja(int caja) {
        this.caja = caja;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }

    public void construirAlmacen(int numeroPlazas){
almacen = new Almacen(numeroPlazas);
    }
    public  void venderBicicleta(int posicion){
        try {
            caja += this.biciStock.remove(posicion).getPrecio;
        }catch (Exception e){
            System.out.println("No se puede vender la bicicleta");
        }
    }
public void agregarBicicleta(Bicicleta bicicleta){
        biciStock.add(bicicleta);
}
public void repararBicicleta(Bicicleta bicicleta){
        if (almacen.getNumeroPlazas()>this.bicisReparar.size()){
            bicisReparar.add(bicicleta);
        }else {try {
            throw new Exception("No se puede agregar bicicletas");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        }
}




}
