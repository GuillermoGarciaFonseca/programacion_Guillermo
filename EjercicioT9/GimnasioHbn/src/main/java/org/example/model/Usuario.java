package org.example.model;

import jakarta.persistence.*;

import java.util.Map;

@Entity
@Table(name = "users")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private String exerciseLevel;
    private String appName;
    private String userType;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "user_routines", joinColumns = @JoinColumn(name = "user_id"))
    @MapKeyColumn(name = "routine_name")
    @Column(name = "exercise_id")
    private Map<String, Ejercicio> routines;


    public Usuario(String firstName, String lastName, String username, String password, String exerciseLevel, String appName, String userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        this.exerciseLevel = exerciseLevel;
        this.appName = appName;
        this.userType = userType;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getExerciseLevel() {
        return exerciseLevel;
    }

    public String getAppName() {
        return appName;
    }

    public String getUserType() {
        return userType;
    }

    public void addExerciseToRoutine(String routineName, Ejercicio ejercicio) {
        routines.put(routineName, ejercicio);
    }
}