import objeto.Coche;

public class Entrada {
    public static void main(String[]args){
        Coche coche= new Coche();
        // marca = null modelo = null cv = 0  numeropuertas = 0 precio = 0
        Coche cocheDefecto1 = new Coche();
        // marca = por defecto modleo = por defecto cv = 0 numeropuerta= 0
        Coche cocheDefecto2 = new Coche();
        // marca = por defecto modleo = por defecto cv = 0 numeropuerta= 0
        Coche cocheprecio= new Coche("Mercedes","C220",5,500,6000);
        // marca = Mercedes modleo = C220 cv = 500 numeropuertas= 5 precio =6000
        Coche cocheSinPrecio1 = new Coche("Ford","Focus",3,200);
        // marca = Mercedes modleo = C220 cv = 500 numeropuertas= 5 precio =6000
        Coche cochesinPrecio2 = new Coche("Ford","Mustang",3,400);
        // marca = Mercedes modleo = C220 cv = 500 numeropuertas= 5 precio =6000
        cochesinPrecio2.setMarca("FordGT");
        System.out.println(cochesinPrecio2.getMarca());
        System.out.println(cocheprecio.getMarca());
        System.out.println(cocheDefecto1);
        System.out.println(cocheprecio.getVelocidad());
        cocheprecio.acelerar(30);
        cocheprecio.acelerar(10);
        cocheprecio.acelerar(50);
        System.out.println(cocheprecio.getVelocidad());
        cocheSinPrecio1.mostrarDatos();
        cocheSinPrecio1.cargarGasolina(50);
        cocheSinPrecio1.mostrarDatos();
        cocheSinPrecio1.cargarGasolina(-50);
        cocheSinPrecio1.mostrarDatos();
        cocheSinPrecio1.cargarGasolina(100);
        cocheSinPrecio1.mostrarDatos();
        cocheSinPrecio1.cargarGasolina(100);
        cocheSinPrecio1.mostrarDatos();
        // modificar el metodo acelerar para que
        // no pueda acelerar si no tengo al menos la misma cantidad de gasolinan
        // que lo que se intenta acelerar
        // al acelerar se le sume a la  velocidad lo que tenemos mas 1/20 de la velocidad * los cv
        // frenar y cambiar de marcha
    }
}
