package org.example.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TareaOcio extends Tarea{
private String Ubicacion;
private int presupuesto;

    public TareaOcio(String ubicacion, int presupuesto) {
        Ubicacion = ubicacion;
        this.presupuesto = presupuesto;
    }

    public TareaOcio(int id, String titulo, Prioridades prioridad, String descripcion, String ubicacion, int presupuesto) {
        super(id, titulo, prioridad, descripcion);
        Ubicacion = ubicacion;
        this.presupuesto = presupuesto;
    }
}
