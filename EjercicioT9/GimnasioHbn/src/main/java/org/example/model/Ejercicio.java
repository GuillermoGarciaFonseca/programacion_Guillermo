package org.example.model;

import jakarta.persistence.*;



@Entity
@Table(name = "exercises")
public class Ejercicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String exerciseName;
    private String muscleGroup;

    public Ejercicio() {
    }

    public Ejercicio(String exerciseName, String muscleGroup) {
        this.exerciseName = exerciseName;
        this.muscleGroup = muscleGroup;
    }

    public Long getId() {
        return id;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public String getMuscleGroup() {
        return muscleGroup;
    }
}