package objeto2;

public class Garaje {
    
    private  Coche cocheActual;
    private int numeroCoches; 
    private String averiaActual;
    
    //por defecto ()
    
    public void devolverCoche(){
        if (cocheActual != null) {
            this.cocheActual=null;
            this.averiaActual=null;
            numeroCoches++;
        }else {
            System.out.println("El coche sigue en reparacion");
        }
    }
    public boolean aceptarCoche(Coche coche, String averia){

        if (cocheActual != null) {
            //hay coche en el garaje
            System.out.println("No se puede atender porque ya hay un coche");
        }else {
            // no hay coche en el garaje
            this.cocheActual=coche;
            this.averiaActual=averia;
        }
            if (coche == null) {
            
        }
        return cocheActual==null;
    }

    public Coche getCocheActual() {
        return cocheActual;
    }

    public void setCocheActual(Coche cocheActual) {
        this.cocheActual = cocheActual;
    }
}
