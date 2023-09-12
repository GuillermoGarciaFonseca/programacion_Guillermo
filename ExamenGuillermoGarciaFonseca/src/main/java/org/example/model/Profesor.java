package org.example.model;

import java.io.Serializable;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
@Table(name = "profesor")
public class Profesor implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String correo;
    @Column
    private int telefono;
    @Column
    private String titulacion;
    @Column
    private boolean doctorado;
    @Column
    private int sueldo;
    @OneToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "nombre")
    private Ciclos ciclos;

}
