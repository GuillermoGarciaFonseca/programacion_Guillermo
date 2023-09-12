package model;

import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
@Getter
@Setter
public class Trabajadores {
    private ObjectId id;
    private String nombre;
    private String cargo;
    private  int salario;
    private String correo;
    private String password;

    public Trabajadores() {
    }

    public Trabajadores(String nombre, String cargo, int salario, String correo, String password) {
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.correo = correo;
        this.password = password;
    }

    public Trabajadores(ObjectId id, String nombre, String cargo, int salario, String correo, String password) {
        this.id = id;
        this.nombre = nombre;
        this.cargo = cargo;
        this.salario = salario;
        this.correo = correo;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Trabajadores{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", cargo='" + cargo + '\'' +
                ", salario=" + salario +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
