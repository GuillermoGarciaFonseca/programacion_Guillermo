package objeto2;

public class Aplicacion {
    public static void main(String[] args) {
        Motor m=new Motor(100);
        Coche c1 = new Coche("","",m);
         Coche c2 = new Coche ("Marca","Modelo",new Motor(150));
        Coche c3 = new Coche ("Marca","Modelo",new Motor(200));
        Coche c = new Coche("Marca","Modelo", m);
        c.setMotor(m);
        //¿Sacar ppor consola los cv del motor del coche?
        System.out.println(c.getMotor().getCv());
        Garaje garaje = new Garaje();
        garaje.aceptarCoche(c1,"aceite");



        //garaje devolverCoche()
    }
}
