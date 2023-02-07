package Trabajadores;

public final class Asalariados extends Trabajador {
    private int Npagas;

    public Asalariados(String nombre, String apellido, String dni, double sueldo, boolean contratado, int Npagas) {
        super(nombre, apellido, dni, sueldo, contratado);
        this.Npagas = Npagas;
    }

    @Override
    public void MostrarDatos() {
        super.MostrarDatos();
        System.out.println("Sueldo: "+getSueldo());
        System.out.println("Contratado: "+isContratado());
        System.out.println("Numero de pagas: "+Npagas);
    }

    public Asalariados() {
    }

    public int getNpagas() {
        return Npagas;
    }

    public void setNpagas(int npagas) {
        Npagas = npagas;
    }
}
