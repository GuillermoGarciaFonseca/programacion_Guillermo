package Trabajadores;

public final class Jefe extends Persona implements Firectivo{

    public boolean Contratado;
    private int acciones;
    private double beneficios;
    // nombre, dni, apellidos

    private boolean contratado;

    public Jefe() {
    }

    public Jefe(String nombre, String apellido, String dni, int acciones, double beneficios) {
        super(nombre, apellido, dni);
        this.acciones = acciones;
        this.beneficios = beneficios;
    }

    @Override
    public void mostrarDatos() {
        super.MostrarDatos();
        System.out.println("Beneficio: "+beneficios);
        System.out.println("Acciones: "+acciones);
    }

    @Override
    public double emitirVoto(int voto) {
        return 0;
    }

    public void despedirTrabajador(Trabajador trabajador){
        if (trabajador.isContratado()){
            trabajador.setContratado(false);
        }
    }

    public int getAcciones() {
        return acciones;
    }

    public void setAcciones(int acciones) {
        this.acciones = acciones;
    }

    public double getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(double beneficios) {
        this.beneficios = beneficios;
    }

}