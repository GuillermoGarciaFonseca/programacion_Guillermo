package org.example.database;

import lombok.Getter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Getter
public class GestionDB {


    private Connection connection;

    public GestionDB(){
        realizarConexion();
    }
    private void realizarConexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user="root";
            String pass="";
            String host="127.0.0.1:3306";
            String dbName= "examen";
            String url= "jdbc:mysql://"+host+"/"+dbName;
            connection = DriverManager.getConnection(url,user,pass);
            System.out.println("conexion correcta");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}