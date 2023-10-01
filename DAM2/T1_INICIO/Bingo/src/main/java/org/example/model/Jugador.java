package org.example.model;

import lombok.Getter;
import lombok.Setter;
import org.example.model.Carton;

import java.util.ArrayList;
@Getter
@Setter
public class Jugador {
    private String nombre;
    private String dni;
    private int dinero;
    private ArrayList<Carton>carton;
}
