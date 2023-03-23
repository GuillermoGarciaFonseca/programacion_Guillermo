import Anidadas.Almacen;

public class Entrada {
    public static void main(String[] args) {
            double precio1,precio2,precio3;
Tienda tienda = new Tienda();
        Almacen almacen =new Almacen(2);
        Bicicleta bicicleta1=new Bicicleta(EnumbiciM.mtb,100,500,EnumbiciT.L,true);
        Bicicleta bicicleta2=new Bicicleta(EnumbiciM.paseo,50,100,EnumbiciT.S,true);
        Bicicleta bicicleta3=new Bicicleta(EnumbiciM.carretera,150,300,EnumbiciT.M,true);
        Bicicleta bicicleta4=new Bicicleta(EnumbiciM.paseo,22,42,EnumbiciT.L,true);
        Bicicleta bicicleta5=new Bicicleta(EnumbiciM.mtb,27,29,EnumbiciT.L,false);
        Bicicleta bicicleta6=new Bicicleta(EnumbiciM.paseo,2,27,EnumbiciT.M,false);
        Bicicleta bicicleta7=new Bicicleta(EnumbiciM.carretera,8,24,EnumbiciT.S,false);
        tienda.agregarBicicleta(bicicleta1);
        tienda.agregarBicicleta(bicicleta2);
        tienda.agregarBicicleta(bicicleta3);
        tienda.agregarBicicleta(bicicleta4);
        tienda.agregarBicicleta(bicicleta5);
        tienda.agregarBicicleta(bicicleta6);
            tienda.agregarBicicleta(bicicleta7);;
        tienda.repararBicicletas(bicicleta5);
        tienda.repararBicicletas(bicicleta6);
        tienda.repararBicicletas(bicicleta7);
       bicicleta5.setVelocidad(29);
       bicicleta6.setVelocidad(1);
       bicicleta6.setPulgadas(29);
       bicicleta7.setVelocidad(12);
       bicicleta7.setPulgadas(29);
       precio1=(double)(Math.random()*50*100);
       precio2=(Math.random()*100*200);
       precio3=(Math.random()*150*250);
            System.out.println("Reparar la bicicleta 6 vale: "+precio1);
            System.out.println("Reparar la bicileta 5 vale"+precio2);
            System.out.println("Reparar bici 7 "+precio3);
            System.out.println(bicicleta1);
            System.out.println(bicicleta2);
            System.out.println(bicicleta3);
            System.out.println(bicicleta4);
            System.out.println(bicicleta5);
            System.out.println(bicicleta6);
            System.out.println(bicicleta7);
    }
}
