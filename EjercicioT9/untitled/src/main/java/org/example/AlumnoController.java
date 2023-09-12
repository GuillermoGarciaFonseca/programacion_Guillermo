package org.example;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import org.bson.Document;
import org.example.model.Alumno;

import java.util.ArrayList;
import java.util.List;

public class AlumnoController {

    // URL -- Clients -- BaseDatos

    private MongoCollection database;

    public AlumnoController() {
        String urlConnection = "mongodb+srv://root:root@cluster0.viqdbzm.mongodb.net/?retryWrites=true&w=majority";
        try {
            database = MongoClients.create(urlConnection).getDatabase("academia").getCollection("alumnos");
        } catch (MongoException e) {
            System.out.println("Error al conectar con la base de datos");
        }

    }


    // obtener un objeto de tipo alumno como parametro e insertsaarlo en la bd
    public void insertarAlumno(Alumno alumno) {
        Document documentAlumno = new Document();
        documentAlumno.put("nombre", alumno.getNombre());
        documentAlumno.put("edad", alumno.getEdad());
        documentAlumno.put("experiencia", alumno.isExperiencia());
        documentAlumno.put("telefono", alumno.getTelefono());
        System.out.println(database.toString());
        database.insertOne(documentAlumno);
    }

    public void insertarAlumnos(ArrayList<Alumno> alumnos) {
        List<Document> alumnosDocuments = new ArrayList<>();
        for (Alumno alumno : alumnos) {
            Document document = new Document();
            document.put("nombre", alumno.getNombre());
            document.put("edad", alumno.getEdad());
            document.put("experiencia", alumno.isExperiencia());
            document.put("telefono", alumno.getTelefono());

        }
        database.insertMany(alumnos);
    }

    public void borrarAlumno(String nombre){

        Document document = new Document();
        document.put("nombre", nombre);
        database.deleteOne(document);

        // deleteOne( Document - <Criterio> {nombre:"Borja"} ) --> return objectId
        // findOneAndDelete( Document - <Criterio> {nombre:"Borja"}) --> return objectId y el document
        // deleteMany( Document - <Criterio> {nombre:"Borja"} ) --> return objectId
        // deleteAll() -- clear()

    }

    // rango de [18-25]

    public void borrarEdad(int edad){
        Document documentCriterio = new Document();
        /*Document documentoQuery = new Document();
        documentoQuery.put("$lt",18);*/
        documentCriterio.put("edad",new Document().append("$lt",18));
        database.deleteMany(documentCriterio);
    }

    public void actualizarAlumno(String nombre, int edad){
        // modificar aquellos alumnos que tienen una edad de 20
        // y ponerles la experienia a false
        // updateOne( {nombre: "Borja"},  {$set: {edad: 23}})
        // updateMany( criterio,  modificacion)

        Document documentoUpdate= new Document();
        documentoUpdate.put("edad", 20);
        Document documentoSet = new Document();
        documentoSet.put("$set",new Document().append("experiencia",true));


        database.updateMany(documentoUpdate,documentoSet);

        // modificar la experiencia de todos los alumnos que tengan
        // mas de 20 y ponerla a true

        // modificar la experiencia de todos los alumnos que tengan
        // menos o = a 20 y ponerla a false

    }
public void actualizacionRango(){
        Document documentoUpdate =new Document();
        documentoUpdate.put("edad",new Document().append("lte",20));
        Document documentoSet =new Document();
        documentoSet.put("$set",new Document().append("experiencia",false));
        database.updateMany(documentoUpdate,documentoSet);
    MongoCursor<Document>cursor=database.find().iterator();
    while(cursor.hasNext()){
        Document document =cursor.next();
        System.out.println(document.getString("nombre"));

    }
        // obtener todos los usuarios que no tienen experiencia
    MongoCursor<Document>cursor1 = database.find(new Document().append("experiencia",false)).iterator();
    while(cursor1.hasNext()){
        Document document =cursor.next();
        System.out.println(document.getString("nombre"));

    }
    }
    public void agregarConocimientos(Alumno alumno) {
        //agregar una lista de conocimientos "Programacion","Base datos" con la key conocimientos
        // a todos aquellos usuarios que tengan como experiencia true
        /*
         * id: ObjectId
         */
        ArrayList<String> conocimientos = new ArrayList<>();
        conocimientos.add("Programacion");
        conocimientos.add("Base de datos");

        Document documentUpdate = new Document();
        documentUpdate.put("experience", true);
        Document documentSet = new Document();
        documentSet.put("$set", new Document("conocimientos", conocimientos));


        database.updateMany(documentUpdate, documentSet);
    }
    public void setConocimientos(){
        Document documentUpdate = new Document();
        documentUpdate.put("edad", new Document().append("$lt",30));

        database.updateMany(documentUpdate);
    }

}