package controller;

import com.google.gson.Gson;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import model.Productos;
import model.Trabajadores;
import org.bson.Document;
import org.bson.types.ObjectId;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TiendaController {
    private MongoCollection collection;
    public TiendaController(){
        String  urlConnection="mongodb+srv://root:root@cluster0.viqdbzm.mongodb.net/?retryWrites=true&w=majority";
        try {
            collection= MongoClients.create(urlConnection).getDatabase("Tienda").getCollection("Productos");
            collection=MongoClients.create(urlConnection).getDatabase("Tienda").getCollection("Trabajadores");
            System.out.println("Conexion correcta");
        }catch (MongoException e){
            System.out.println("Error al conectarse a la base de datos");
        }
    }
    public void insercionUsuarios(Trabajadores trabajadores){


            Document document=new Document();

            document.put("nombre", trabajadores.getNombre());
            document.put("cargo", trabajadores.getCargo());
            document.put("salario", trabajadores.getSalario());
            document.put("correo", trabajadores.getCorreo());
            document.put("password", trabajadores.getPassword());
           collection.insertOne(document);




    }
    public void login(){
        MongoCursor<Document>cursor=collection.find(new Document().append("nombre","contrasenia")).iterator();
        while (cursor.hasNext()){

        }
    }
    public void insercionProductos(Productos productos){
        Document document=new Document();
        document.put("nombre",productos.getNombre());
        document.put("precio",productos.getPrecio());
        document.put("cantidad",productos.getCantidad());
        collection.insertOne(document);
    }
    public void obtencionproductos(Productos productos){
MongoCursor<Document> cursor=collection.find().iterator();
        Gson gson=new Gson();
        while (cursor.hasNext()){
            Document document=cursor.next();
            Productos productos1=gson.fromJson(document.toJson(),Productos.class);
            System.out.println(productos1.getNombre());
            if (productos1.getCantidad()>10){
                for (String item:productos.getNombre()
                     ) {
                    System.out.println("\t"+item);
                }
            }
        }
    }
    public void borrarProducto(ObjectId id){
        Document document=new Document();
        document.put("id",id);
    collection.deleteOne(document);
    }
}
