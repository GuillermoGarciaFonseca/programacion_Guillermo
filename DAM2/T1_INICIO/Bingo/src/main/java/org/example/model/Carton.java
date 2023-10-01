package org.example.model;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
@Getter
@Setter
public class Carton {
    private int id;
    private final int dinero=1;
    private int[] loteria=new int[10];
}
