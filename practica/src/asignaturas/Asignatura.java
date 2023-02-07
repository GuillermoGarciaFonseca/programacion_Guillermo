package asignaturas;

public class Asignatura {
    private int Id;
    private double Calificicacion;

    public Asignatura(int id) {
        Id = id;
    }

    public int getId() {
        return Id;
    }

    public double getCalificicacion() {
        return Calificicacion;
    }

    public void setCalificicacion(double calificicacion) {
        Calificicacion = calificicacion;
    }
}
