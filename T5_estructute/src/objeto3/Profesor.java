package objeto3;

public class Profesor {
    public void ponerNotas(Alumno a1){
        a1.getProgramacion().setCalificacion((Math.random()*10)+1);
        a1.getFol().setCalificacion((Math.random()*10)+1);
        a1.getBasesdedatos().setCalificacion((Math.random()*10)+1);

    }
    public double calcularMedia(Alumno alumno1){
        double media=(alumno1.getProgramacion().getCalificacion()+alumno1.getFol().getCalificacion()+alumno1.getBasesdedatos().getCalificacion())/3;
        return media;
    }
}
