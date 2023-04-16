package databases;

import java.sql.*;

public class GestionBD {
    Conexion conexion;
    Connection connection;

    public GestionBD() {
        conexion = new Conexion();
        connection = conexion.getConnection();
    }

    public void insercionPerfiles() {
        String nombre1 = "Trabajador";
        String nombre2 = "Director";
        String nombre3 = "Gerente";
        String query = "INSERT INTO %s (%s) VALUES ('%s')";
        String queryDirector = String.format(query, SchemaDb.TABLE_PERFIL, SchemaDb.COL_NAME,nombre3);
        String queryTrabajador = String.format(query, SchemaDb.TABLE_PERFIL, SchemaDb.COL_NAME,nombre1);
        String queryGerente = String.format(query, SchemaDb.TABLE_PERFIL, SchemaDb.COL_NAME,nombre2);

        try {
            Statement statementInsert = connection.createStatement();
            int rows = statementInsert.executeUpdate(queryTrabajador) + statementInsert.executeUpdate(queryDirector)
                    + statementInsert.executeUpdate(queryGerente);
            if(rows>0){
                System.out.printf("El número de filas afectadas es de %d%n", rows);
            }else{
                System.out.printf("Inserción incorrecta %n");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void insertarUsuarios(){


        String queryUsuario = "INSERT INTO %s (%s, %s, %s, %s) VALUES (?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(String.format(queryUsuario,SchemaDb.TABLE_USUARIO,
                    SchemaDb.COL_NAME,SchemaDb.COL_SURNAME, SchemaDb.COL_PHONE, SchemaDb.COL_PAIS));
            ps.setString(1,"Heide-Marie");
            ps.setString(2,"Rausch");
            ps.setInt(3,2145024);
            ps.setString(4,"Holanda");
            ps.execute();

            ps.setString(1,"Liam");
            ps.setString(2,"Montgomery");
            ps.setInt(3,16977);
            ps.setString(4,"España");
            ps.execute();

            ps.setString(1,"Ioanna");
            ps.setString(2,"Van der Gaag");
            ps.setInt(3,978229);
            ps.setString(4,"Belgica");
            ps.execute();

            ps.setString(1,"Eloane");
            ps.setString(2,"Bourgeois");
            ps.setInt(3,595439);
            ps.setString(4,"Francia");
            ps.execute();

            ps.setString(1,"Mina");
            ps.setString(2,"Rieger");
            ps.setInt(3,8154354);
            ps.setString(4,"Alemania");
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void realizarOperaciones(){
        try {
            Statement st = connection.createStatement();
            // actualizar usuarios de España y ponerlos a 10000
            String queryUPDATE = "UPDATE %s SET %s=%d WHERE %s='%s'";
            int rows = st.executeUpdate(String.format(queryUPDATE,SchemaDb.TABLE_USUARIO,
                    SchemaDb.COL_SUELDO,10000,
                    SchemaDb.COL_PAIS,"España"));
            if (rows>0){
                System.out.println("El número de usuarios de España actualizados es de "+rows);
            }
            queryUPDATE = "UPDATE %s SET %s=? WHERE %s=?";
            PreparedStatement ps = connection.prepareStatement(String.format(queryUPDATE,SchemaDb.TABLE_USUARIO,
                    SchemaDb.COL_SUELDO,
                    SchemaDb.COL_PAIS));
            ps.setInt(1,5000);
            ps.setString(2,"Alemania");
            rows = ps.executeUpdate();
            if (rows>0){
                System.out.println("El número de usuarios de Alemania actualizados es de "+rows);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void consularDatos(){
        String query = "SELECT * FROM %s WHERE %s = '%s'";
        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(String.format(query,SchemaDb.TABLE_USUARIO,SchemaDb.COL_PAIS,"España"));
            while (rs.next()){
                String nombre = rs.getString(SchemaDb.COL_NAME);
                int sueldo = rs.getInt(SchemaDb.COL_SUELDO);
                System.out.printf("El nombre es: %s el salario es: %d%n",nombre,sueldo);
            }
            System.out.println("ORDENADOS");
            query = "SELECT * FROM %s ORDER BY %s";
            st = connection.createStatement();
            rs = st.executeQuery(String.format(query,SchemaDb.TABLE_USUARIO,SchemaDb.COL_SUELDO));
            while (rs.next()){
                String nombre = rs.getString(SchemaDb.COL_NAME);
                int sueldo = rs.getInt(SchemaDb.COL_SUELDO);
                System.out.printf("El nombre es: %s el salario es: %d%n",nombre,sueldo);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
