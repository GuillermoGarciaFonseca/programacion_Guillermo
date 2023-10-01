package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Profesor {
    private String dni;
    private String nombre;
    private String apellido;
    private String asignatura;


    public Profesor() {
    }

    public Profesor(String dni, String nombre, String apellido, String asignatura) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.asignatura = asignatura;
    }
}
