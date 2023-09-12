package controller;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import com.mysql.cj.xdevapi.DeleteStatement;
import databases.SchemaDb;
import databases.Usuario;
import databases.conexion;

import java.sql.*;
import java.util.Scanner;

public class gimansioDb {
    Connection connection;

    public gimansioDb() {
        connection = new conexion().getConnection();
    }

    public void Login() {
        Scanner in = new Scanner(System.in);
        int opcion;
        System.out.println("1ª LOGIN COMO ADMINISTRADOR");
        System.out.println("2ª LOGIN COMO USUARIO");
        System.out.println("3ª REGISTRAR USUARIO");
        System.out.println("4ª SALIR");
        opcion = in.nextInt();
        switch (opcion) {
            case 1:
                String query = "SELECT * FROM usuarios WHERE nombre=? AND aministrador=? AND contrasenia=?";
                PreparedStatement st = null;
                try {
                    st = connection.prepareStatement(query);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                try {
                    ResultSet resultado = st.executeQuery();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                int opcion2;
                System.out.println("Dime una de estas tres opciones");
                System.out.println("1º Eliminar Usuario");
                System.out.println("2º Ver datos usuario");
                System.out.println("3º Añadir ejercicio");
                System.out.println("4º Salir");
                System.out.println("Dime una opcion");
                opcion2 = in.nextInt();
                final var format = String.format(query, SchemaDb.TABLE_USER, SchemaDb.COL_NAME, SchemaDb.COL_CONTRASENIA, SchemaDb.COL_NIVELEJERCICIO, SchemaDb.COL_GRUPO,
                        SchemaDb.COL_EJERCICIO);
                switch (opcion2) {
                    System.out.println("Dime que opcion quieres ejecutatar");
                    System.out.println("1º Opcion a eliminar");
                    System.out.println("2º Ver datos");
                    System.out.println("3º ejerciio que quieres añadir");
                    System.out.println("4º Salir");
                    int opcion4;
                    opcion4 = in.nextInt();
                    switch (opcion4) {
                        case 1:
                            System.out.println("Dime que usuario quieres eliminar");
                            String usuario;
                            DeleteStatement statement = (DeleteStatement) st.executeQuery(format);
                            break;
                        case 2:
                            ResultSet rs = st.executeQuery(format);
                            String nombre = rs.getString(SchemaDb.COL_NAME);
                            int nivelEjercicio = rs.getInt(SchemaDb.COL_NIVELEJERCICIO);
                            String apellidos = rs.getString(SchemaDb.COL_APELLIDOS);
                            System.out.printf("El nombre es: %s el nivel es:%d%n, apellidos es:%s", nombre, nivelEjercicio, apellidos);
                            System.out.println(rs);
                            break;
                        case 3:
                            System.out.println("dime un ejercicio que quieras añadir");
                            String ejercicio = in.next();
                            ResultSet resultSet = st.executeQuery(ejercicio);
                            break;
                        default:
                            throw new IllegalStateException("Unexpected value: " + opcion2);
                        case 4:
                            System.out.println("Salir");
                            break;
                    }
                    break;
                    case 2:
                        String query2 = "SELECT * FROM usuarios WHERE nombre=? AND usuario=? AND contrasenia=?";
                        try {
                            PreparedStatement st2 = connection.prepareStatement(query);
                            ResultSet resultado2 = st2.executeQuery(format);
                            int opcion3;
                            System.out.println("Dime una de estas tres opciones");
                            opcion3 = in.nextInt();
                            System.out.println("1º Ver datos usuario");
                            System.out.println("2º Crear rutina");
                            System.out.println("3º Salir");
                            switch (opcion3) {
                                case 1:
                                    ResultSet resultSet = st.executeQuery(format);
                                    String nombre = resultSet.getString(SchemaDb.COL_NAME);
                                    int nivelEjercicio = resultSet.getInt(SchemaDb.COL_NIVELEJERCICIO);
                                    String apellidos = resultSet.getString(SchemaDb.COL_APELLIDOS);
                                    System.out.printf("El nombre es: %s el nivel es:%d%n, apellidos es:%s", nombre, nivelEjercicio, apellidos);
                                    break;

                                case 2:
                                    try {
                                        Statement statement = connection.createStatement();
                                        String queryPerfil = "INSERT INTO %s (%s) VALUES ('%s')";
                                        Scanner scanner = new Scanner(System.in);
                                        System.out.println("Ingrese el nombre de la rutina: ");
                                        String nombreRutina = scanner.nextLine();
                                        System.out.println("Ingrese los ejercicios de java");
                                        String ejercicios = scanner.next();
                                        st.executeUpdate(String.format(queryPerfil, SchemaDb.TABLE_EJERCICIO, SchemaDb.COL_NAME, SchemaDb.COL_USUARIO));

                                    } catch (SQLException e) {
                                        throw new RuntimeException(e);
                                    }
                                    break;
                                case 3:
                                    System.out.println("Salir");
                                    break;

                                break;
                                case 3:
                                    System.out.println("Registro de usuario:");
                                    System.out.println("Nombre:");
                                    String nombreUsuario = in.next();
                                    System.out.println("Apellido:");
                                    String apellidoUsuario = in.next();
                                    System.out.println("Contraseña:");
                                    String contraUsuario = in.next();
                                    System.out.println("Nivel del ejercicio:");
                                    String nivelEjerUsuario = in.next();
                                    System.out.println("Tipo de perfil:");
                                    int tipoPerfilUsuario = in.nextInt();

                                    String queryPrepared = "INSERT INTO %s (%s,%s,%s,%s,%s)" +
                                            "VALUES (?,?,?,?,?)";
                                    String queryFormateadaPrepared = String.format(queryPrepared, SchemaDb.TABLE_USER,
                                            SchemaDb.COL_NAME, SchemaDb.COL_APELLIDOS, SchemaDb.COL_CONTRASENIA, SchemaDb.COL_NIVELEJERCICIO);
                                    try {
                                        PreparedStatement preparedStatement = connection.prepareStatement(queryFormateadaPrepared);
                                        preparedStatement.setString(1, nombreUsuario);
                                        preparedStatement.setString(2, apellidoUsuario);
                                        preparedStatement.setString(3, contraUsuario);
                                        preparedStatement.setString(4, nivelEjerUsuario);
                                        preparedStatement.setInt(5, tipoPerfilUsuario);
                                        preparedStatement.execute();
                                        Usuario usuario = new Usuario(nombreUsuario, apellidoUsuario, contraUsuario, nivelEjerUsuario, tipoPerfilUsuario);
                                        ResultSet set = st.executeQuery(String.valueOf(usuario));
                                    } catch (SQLException throwables) {
                                        throwables.printStackTrace();
                                    }
                                    break;
                                case 4:
                                    System.out.println("Salir");
                                    break;


                                default:
                                    throw new IllegalStateException("Unexpected value: " + opcion);

                            }
                        } catch (SQLException e) {
                            throw new RuntimeException(e);
                        }
                    default:
                        throw new IllegalStateException("Unexpected value: " + opcion);
                }

        }
    }
}


