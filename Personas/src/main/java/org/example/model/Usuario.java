package org.example.model;
import jakarta.persistence.*;
@Entity
@Table
public class Usuario {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int idUsuario;
    @Column
    private String nombre;
    @Column
    private String apellido;
    @Column
    private String pais;
    @Column
    private int sueldo;
    @Column
    private int telefono;
    @Embedded
    private Perfil perfil;

    public Usuario(Perfil perfil) {
    }

    public Usuario(String nombre, String apellido, String pais, int sueldo, int telefono, Perfil perfil) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.sueldo = sueldo;
        this.telefono = telefono;
        this.perfil = perfil;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + idUsuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", pais='" + pais + '\'' +
                ", sueldo=" + sueldo +
                ", telefono=" + telefono +
                ", perfil=" + perfil +
                '}';
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    public int getId() {
        return idUsuario;
    }

    public void setId(int id) {
        this.idUsuario = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getSueldo() {
        return sueldo;
    }

    public void setSueldo(int sueldo) {
        this.sueldo = sueldo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

}
