package model;

import lombok.Getter;
import lombok.Setter;
import org.bson.BsonObjectId;
import org.bson.types.ObjectId;

@Getter
@Setter
public class Productos {
private ObjectId id;
private String nombre;
private int precio;
private int cantidad;

    public Productos() {
    }

    public Productos(String nombre, int precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public Productos(ObjectId id, String nombre, int precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", cantidad=" + cantidad +
                '}';
    }
}
