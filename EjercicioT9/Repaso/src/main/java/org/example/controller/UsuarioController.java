package org.example.controller;

import org.example.database.SchemaDB;
import org.example.model.Usuario;
import org.example.database.DatabaseUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioController {
private DatabaseUtil databaseUtil;
private Connection connection;
public UsuarioController(){
    connection=new DatabaseUtil().getConnection();
}
    public void insertarUsuario(Usuario usuario){
        //statement o prepareStatement
        try {
            Statement statement = connection.createStatement();
            // INSERT INTO usuarios(nombre, apellidos, correo, pass) VALUES (usuario.getter)
            statement.execute(String.format("INSERT INTO %s(%s,%s) VALUES ('%s','%s')",
                    SchemaDB.TAB_USER_NAME,
                    SchemaDB.COL_NAME, SchemaDB.COL_MAIL,
                    usuario.getNombre(),usuario.getCorreo()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void seleccionUsuarios(String nombre, String pass){
    Statement statement=connection.createStatement();
    ResultSet resultSet=statement.executeQuery(
            String.format("SELECT * FROM %s WHERE %s ='%s' AND %s = '%s'"),
            SchemaDB.TAB_USER_NAME,
            SchemaDB.COL_NAME,nombre));
    }
}
