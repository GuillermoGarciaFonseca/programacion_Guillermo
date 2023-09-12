package databases;

import com.mysql.cj.exceptions.ConnectionIsClosedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    private Connection connection;
    public void createConnection(){
    String url = String.format("jdbc:mysql://localhost/%s",SchemaDb.DB_NAME);
    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url,"root","");

        System.out.println("Conexion correcta");
    } catch (SQLException | ClassNotFoundException e) {
        System.out.println(e.getMessage());
        System.out.println("Conexion incorrecta");
    }
}

    public Connection getConnection() {
        if (connection==null){
            createConnection();
        }
        return connection;
    }

    public void closeConnecion(){
        try {
            if (connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}