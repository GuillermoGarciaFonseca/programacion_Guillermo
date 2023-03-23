package model;

public class Entrada {

    public static void main(String[] args) {
        Tienda tiendaBicis = new Tienda();
        tiendaBicis.construirAlmacen(2);
        tiendaBicis.agregarBicicleta(new Bicicleta(Tipo.mtb,Tamanio.M) {
            @Override
            public int reparar() {
                System.out.println("Esta bici se repara asi");
                return 100;
            }
        });
    }
}
