package objeto3;

public class Entrada {
    public static void main(String[] args) {
        Asignatura programacion = new Asignatura(1);
        Asignatura basesdatos = new Asignatura(2);
        Asignatura fol = new Asignatura(3);

        Alumno alumno1= new Alumno(programacion,basesdatos,fol);
        Alumno alumno2 = new Alumno(4,5,6);

        Profesor profesor1 = new Profesor();
        profesor1.ponerNotas(alumno1);
        profesor1.ponerNotas(alumno2);

    }
}
