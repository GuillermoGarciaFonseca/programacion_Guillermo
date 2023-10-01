package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.database.GestionDB;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

@Getter
@Setter
public class Alumno extends GestionDB {
    private String dni;
    private String nombre;
    private String apellido;

    public Alumno() {
    }

    public Alumno(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }


    }
