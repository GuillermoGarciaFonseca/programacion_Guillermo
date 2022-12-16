package objeto3;

public class Alumno {
    private Asignatura programacion;
    private Asignatura basesdedatos;
    private Asignatura fol;

    public void alumno(int programacion, int fol, int basesdedatos) {
        this.programacion = new Asignatura(programacion);
        this.fol = new Asignatura(fol);
        this.basesdedatos = new Asignatura(basesdedatos);


    }

    public Alumno(Asignatura programacion, Asignatura basesdedatos, Asignatura fol) {
        this.programacion = programacion;
        this.basesdedatos = basesdedatos;
        this.fol = fol;
    }

    public Alumno(int id1, int id2, int id3) {
        this.programacion =  new Asignatura(id1);
        this.basesdedatos = new Asignatura(id2);
        this.fol = new Asignatura(id3);

    }

    public Asignatura getProgramacion() {
        return programacion;
    }

    public void setProgramacion(Asignatura programacion) {
        this.programacion = programacion;
    }

    public Asignatura getBasesdedatos() {
        return basesdedatos;
    }

    public void setBasesdedatos(Asignatura basesdedatos) {
        this.basesdedatos = basesdedatos;
    }

    public Asignatura getFol() {
        return fol;
    }

    public void setFol(Asignatura fol) {
        this.fol = fol;
    }
}
