package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@ToString
@Getter
@Setter
@Data
@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String correo;
    @Column
    private int telefono;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "expediente")
    private Matricula matricula;
    @OneToMany(mappedBy = "matricula",cascade = CascadeType.ALL)
    private List<Ciclos> listaCiclos =new ArrayList<>();

    public Alumno() {
    }

    public Alumno(String nombre, String apellido, String correo, int telefono, Matricula matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.telefono = telefono;
        this.matricula = matricula;
        this.listaCiclos = listaCiclos;
    }
}
