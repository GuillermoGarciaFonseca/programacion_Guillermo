package ejercicio6;

public class Aplicacion6 {
    public static void main(String[] args) {
        Equipo equipoA=new Equipo("Barcelona");
        Equipo equipoB=new Equipo("Real Madrid",93,90,88);

        equipoA.atacar();
        equipoB.atacar();
        equipoA.atacar();
        equipoB.atacar();
        equipoA.atacar();
        equipoB.atacar();

    }
}
