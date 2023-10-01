package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Array;

@Getter
@Setter
public class Proyectos {
    private String titulo;
    private String descripcion;
    private Array[] lista;
    private String profesorAsig;

    private String asignatura;

    public Proyectos(String titulo, String descripcion, String profesorAsig, String asignatura) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.profesorAsig = profesorAsig;
        this.asignatura = asignatura;
        this.lista=new Array[3];
    }
}
