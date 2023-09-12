package org.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
@Getter
@Setter
@ToString
@Data
@Entity
@Table(name = "alumno")
public class Matricula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private boolean expediente;

    public Matricula() {
    }

    public Matricula(boolean expediente) {
        this.expediente = expediente;
    }
}
