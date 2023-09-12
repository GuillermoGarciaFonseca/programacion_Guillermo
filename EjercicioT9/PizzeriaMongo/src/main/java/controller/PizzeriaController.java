package controller;

import com.mongodb.MongoException;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import model.Pizza;
import org.bson.Document;

public class PizzeriaController {
    private MongoCollection collection;
    public PizzeriaController(){
        String urlconnection="mongodb+srv://root:root@cluster0.viqdbzm.mongodb.net/?retryWrites=true&w=majority";
        try{
            collection= MongoClients.create(urlconnection).getDatabase("Pizzeria").getCollection("tienda");
            System.out.println("conexion correcta");
        }catch (MongoException e){
            System.out.println("Error al conectar a la base de datos");
        }
    }
    public void insertarPizza(Pizza pizza){

            Document documentPizza=new Document();
            documentPizza.put("numeroPedido",pizza.getNumeroPedido());
            documentPizza.put("nombre",pizza.getNombre());
            documentPizza.put("Base",pizza.getBase());
            documentPizza.put("Ingredientes",pizza.getIngredientes());
            documentPizza.put("precio",pizza.getPrecio());
            collection.insertOne(documentPizza);
        }
        public void actualizarPizza(){
        Document documentActualizado=new Document();
        documentActualizado.put("ingredientes",new Document().append("$"))
        }

}
