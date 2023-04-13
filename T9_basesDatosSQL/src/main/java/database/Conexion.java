package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
    public class Conexion {
        private Connection connection;
        private void createConnection(){
            String url =String.format("jdbc:mysql://localhost/%s", schemaDB.DB_NAME);
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection= DriverManager.getConnection(url,"root","");
                System.out.println("Conexion correcta");
            } catch (SQLException e) {
                System.out.println();
                System.out.println("Conexion incorrecta");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            System.out.println("");
        }
        public java.sql.Connection getConnection(){
            if (connection==null){
                createConnection();
            }
            return connection;
        }
        public  void closeConnection(){
            try {
                if (connection!=null){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    }


