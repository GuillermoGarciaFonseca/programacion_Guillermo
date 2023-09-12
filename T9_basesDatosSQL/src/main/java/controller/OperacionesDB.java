package controller;
import database.Conexion;
import database.schemaDB;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

public class OperacionesDB {
Conexion conexion;
Connection connection;
    public OperacionesDB(){
        conexion = new Conexion();
        connection = conexion.getConnection();
    }

    public void insercionAlumno(){

        String nombre = "Borja";
        String apellido = "Martin";
        String correo = "ces@juanpablosegundo.com";
        int telefono = 12345;
        String query= "INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s','%s','%s','%d')";

        String queryFormateada = String.format(query, schemaDB.TABLE_NAME,
                schemaDB.COL_NAME, schemaDB.COL_SURNAME, schemaDB.COL_EMAIL, schemaDB.COL_PHONE,
                nombre, apellido, correo, telefono);

        try {
            Statement statementInsert = connection.createStatement();
            PreparedStatement preparedStatement= connection.prepareStatement(queryFormateada);
            preparedStatement.setString(1,nombre);
            preparedStatement.setString(2,apellido);
            preparedStatement.setString(3,correo);
            preparedStatement.setInt(4,telefono);
            int rows2=preparedStatement.executeUpdate();
            int rows = statementInsert.executeUpdate(queryFormateada);
            if (rows>0){
            System.out.printf("El número de filas afectadas es de %d%n", rows);
            } else {

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
public void insercionMasiva(){
    String query=String.format ("INSERT INTO %s (%s,%s,%s,%s) VALUES (?,?,?,?)"+schemaDB.TABLE_NAME,
            schemaDB.COL_NAME, schemaDB.COL_SURNAME, schemaDB.COL_EMAIL, schemaDB.COL_PHONE);
    Scanner in= new Scanner(System.in);
    String nombre ,apellido,correo;
    int telefono;
    try {
        PreparedStatement preparedStatement=connection.prepareStatement(query);
        for (int i = 0; i < 5; i++) {
            System.out.println("Dime tu nombre");
            nombre=in.next();
            System.out.println("Dime tu apellido");
            apellido=in.next();
            System.out.println("Dime tu correo");
            correo=in.next();
            System.out.println("Dime tu numero de telefono");
            telefono=in.nextInt();
            Statement statementInsert = connection.createStatement();
            preparedStatement.setString(1,nombre);
            preparedStatement.setString(2,apellido);
            preparedStatement.setString(3,correo);
            preparedStatement.setInt(4,telefono);
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
    }
public void actualizacionDatos(){
    Scanner scanner = new Scanner(System.in);
    String nombre, correo;
    System.out.println("Introduce el nombre del valor a actualizar");
    nombre = scanner.next();
    System.out.println("Introduce el nuevo correo para el usuario con nombre "+nombre);
    correo = scanner.next();
    String query = String.format("UPDATE %s SET %s = '%s' WHERE %s = '%s'",
            schemaDB.TABLE_NAME,
            schemaDB.COL_EMAIL,correo,
            schemaDB.COL_NAME, nombre) ;
    try {
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate(query);

        if (rows>0){
            System.out.printf("El numero de filas afectas es de %d%n",rows);
        } else {
            System.out.printf("No hay datos a actualizar%n");
        }

    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
public void borrarDatos() {
    String query = String.format("DELETE FROM %s WHERE %s = ? AND %s = ?",
            schemaDB.TABLE_NAME,
            schemaDB.COL_NAME, schemaDB.COL_PHONE);
    Scanner scanner = new Scanner(System.in);
    String nombre;
    int telefono;
    System.out.println("Introduce el nombre del valor a borrar");
    nombre = scanner.next();
    System.out.println("Introduce el nuevo telefono para el usuario");
    telefono = scanner.nextInt();
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nombre);
        preparedStatement.setInt(2, telefono);
        if (!preparedStatement.execute()) {
            System.out.println("Uusario borrado correctamente");
        } else {
            System.out.println("No hay coincidencias");
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public void seleccion(){
        String query = String.format("SELECT * FROM %s ",schemaDB.TABLE_NAME);
        try {
            Statement statement= connection.createStatement();
            ResultSet resultSet= statement.executeQuery(query);
            while(resultSet.next()){
                System.out.println("hay elemento");
                String nombre= resultSet.getString(schemaDB.COL_NAME);
                String apellido= resultSet.getString(schemaDB.COL_SURNAME);
                String correo= resultSet.getString(schemaDB.COL_EMAIL);
                int telefono = resultSet.getInt(schemaDB.COL_PHONE);

                Usuario usuario=new Usuario(nombre,apellido,correo,telefono);
                usuario.mostrarDatos();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public void arraylistUsuario(){
        Scanner in= new Scanner(System.in);
        ArrayList<Usuario> usuarios=new ArrayList<>();
        String nombre ,apellido,correo;
        int telefono;
        for (Usuario usuario : usuarios) {
            System.out.println("Dime tu nombre");
            nombre=in.next();
            System.out.println("Dime tu apellido");
            apellido=in.next();
            System.out.println("Dime tu correo");
            correo=in.next();
            System.out.println("Dime tu numero de telefono");
            telefono=in.nextInt();
            System.out.println(usuario);
        }
        
        {

        }
    }
    public void gelAllproducts(){
        String urlString = "https://dummyjson.com/products";


        try {
            PreparedStatement preparedStatement = connection.prepareStatement(String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?,?,?,?)",
                    schemaDB.TABLE_PRODUCTS,schemaDB.TABLE_NAME,schemaDB.COL_DESCROPTION,schemaDB.COL_CATEGORY,schemaDB.COL_PRICE));
            URL url = new URL(urlString);
            HttpURLConnection connectionHttp = (HttpURLConnection) url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connectionHttp.getInputStream()));
            String linea = null;
            StringBuilder builder = new StringBuilder();
            while ((linea = bufferedReader.readLine())!= null){
                builder.append(linea);
            }
            JSONObject objectResponse = new JSONObject(builder.toString());
            JSONArray arrayProducts = objectResponse.getJSONArray("products");
            for (int i = 0; i < arrayProducts.length(); i++) {
                JSONObject producto = arrayProducts.getJSONObject(i);
                String name = producto.getString("title");
                String descrition = producto.getString("description");
                String category = producto.getString("category");
                int price = producto.getInt("price");
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,descrition);
                preparedStatement.setInt(3,price);
                preparedStatement.setString(4,category);
                preparedStatement.execute();
            }



        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    }


