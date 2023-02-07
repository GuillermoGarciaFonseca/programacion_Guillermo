package prueba1;

public class Garaje {
    private Coche coche;
    private String averiaAsociada;
    private int cochesatendidos;

    public void devolverCoche() {
        if (coche != null) {
            this.coche = null;
            this.averiaAsociada = null;
            cochesatendidos++;
        } else {
            System.out.println("El coche sigue en reparacion");
        }
    }

}
