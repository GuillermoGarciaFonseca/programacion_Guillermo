import controller.OperacionesDB;

import java.sql.Connection;

public class Entrada {

    public static void main(String[] args) {
        OperacionesDB operacionesDB=new OperacionesDB();
        //operacionesDB.insercionAlumno();
//operacionesDB.insercionMasiva();
    operacionesDB.seleccion();
    }
}
