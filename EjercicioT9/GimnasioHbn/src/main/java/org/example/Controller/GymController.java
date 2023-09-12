package org.example.Controller;

import java.util.Scanner;

import org.example.model.Ejercicio;
import org.example.model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GymController {
     SessionFactory sessionFactory;
     Scanner scanner;

    public GymController() {
        sessionFactory = new Configuration()
                .configure()
                .buildSessionFactory();
        scanner = new Scanner(System.in);
    }

    public void Iniciacion() {
        int opcion;
        do {
            System.out.println("----- Gimnasio - Menú Principal -----");
            System.out.println("1. Login como administrador");
            System.out.println("2. Login como usuario");
            System.out.println("3. Registrar usuario");
            System.out.println("4. Salir");
            System.out.print("Ingrese una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (opcion) {
                case 1:
                    adminLogin();
                    break;
                case 2:
                    userLogin();
                    break;
                case 3:
                    registerUser();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo nuevamente.");
                    break;
            }
            System.out.println();
        } while (opcion != 4);

        sessionFactory.close();
        scanner.close();
    }

    public void adminLogin() {
        System.out.print("Ingrese nombre de usuario (administrador): ");
        String username = scanner.nextLine();
        System.out.print("Ingrese contraseña (administrador): ");
        String password = scanner.nextLine();

        if (authenticateAdmin(username, password)) {
            int choice;
            do {
                System.out.println("----- Administrador - Menú -----");
                System.out.println("1. Eliminar usuario");
                System.out.println("2. Ver datos de usuario");
                System.out.println("3. Añadir ejercicio");
                System.out.println("4. Volver al menú principal");
                System.out.print("Ingrese una opción: ");
                choice = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch (choice) {
                    case 1:
                        deleteUser();
                        break;
                    case 2:
                        viewUserData();
                        break;
                    case 3:
                        addExercise();
                        break;
                    case 4:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción inválida. Inténtelo nuevamente.");
                        break;
                }
                System.out.println();
            } while (choice != 4);
        } else {
            System.out.println("Credenciales incorrectas. Vuelva a intentarlo.");
        }
    }

    public void userLogin() {
        System.out.print("Ingrese nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();

        if (authenticateUser(username, password)) {
            int choice;
            do {
                System.out.println("----- Usuario - Menú -----");
                System.out.println("1. Ver mis datos");
                System.out.println("2. Crear rutina");
                System.out.println("3. Volver al menú principal");
                System.out.print("Ingrese una opción: ");
                choice = Integer.parseInt(scanner.nextLine());
                System.out.println();

                switch (choice) {
                    case 1:
                        viewUserData(username);
                        break;
                    case 2:
                        createRoutine(username);
                        break;
                    case 3:
                        System.out.println("Volviendo al menú principal...");
                        break;
                    default:
                        System.out.println("Opción inválida. Inténtelo nuevamente.");
                        break;
                }
                System.out.println();
            } while (choice != 3);
        } else {
            System.out.println("Credenciales incorrectas. Vuelva a intentarlo.");
        }
    }

    public void registerUser() {
        System.out.print("Ingrese nombre: ");
        String firstName = scanner.nextLine();
        System.out.print("Ingrese apellido: ");
        String lastName = scanner.nextLine();
        System.out.print("Ingrese nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();
        System.out.print("Ingrese nivel de ejercicio: ");
        String exerciseLevel = scanner.nextLine();
        System.out.print("Ingrese nombre de la aplicación: ");
        String appName = scanner.nextLine();
        System.out.print("Ingrese tipo de usuario: ");
        String userType = scanner.nextLine();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Usuario user = new Usuario(firstName, lastName, username, password, exerciseLevel, appName, userType);
        session.save(user);

        session.getTransaction().commit();
        session.close();

        System.out.println("Usuario registrado exitosamente.");
    }

    public void deleteUser() {
        System.out.print("Ingrese el nombre de usuario que desea eliminar: ");
        String username = scanner.nextLine();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Usuario user = session.createQuery("FROM User WHERE username = :username", Usuario.class)
                .setParameter("username", username)
                .uniqueResult();

        if (user != null) {
            session.delete(user);
            session.getTransaction().commit();
            System.out.println("Usuario eliminado exitosamente.");
        } else {
            System.out.println("El usuario especificado no existe.");
        }

        session.close();
    }

    public void viewUserData() {
        System.out.print("Ingrese el nombre de usuario: ");
        String username = scanner.nextLine();

        viewUserData(username);
    }

    public void addExercise() {
        System.out.print("Ingrese el nombre del ejercicio: ");
        String exerciseName = scanner.nextLine();
        System.out.print("Ingrese el grupo muscular que trabaja el ejercicio: ");
        String muscleGroup = scanner.nextLine();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Ejercicio ejercicio = new Ejercicio(exerciseName, muscleGroup);
        session.save(ejercicio);

        session.getTransaction().commit();
        session.close();

        System.out.println("Ejercicio añadido exitosamente.");
    }

    public void viewUserData(String username) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Usuario user = session.createQuery("FROM User WHERE username = :username", Usuario.class)
                .setParameter("username", username)
                .uniqueResult();

        if (user != null) {
            System.out.println("----- Datos de Usuario -----");
            System.out.println("Nombre: " + user.getFirstName());
            System.out.println("Apellido: " + user.getLastName());
            System.out.println("Contraseña: " + user.getPassword());
            System.out.println("Nivel de Ejercicio: " + user.getExerciseLevel());
            System.out.println("Nombre de Aplicación: " + user.getAppName());
            System.out.println("Tipo de Usuario: " + user.getUserType());
        } else {
            System.out.println("El usuario especificado no existe.");
        }

        session.getTransaction().commit();
        session.close();
    }

    public void createRoutine(String username) {
        System.out.print("Ingrese el nombre de la rutina: ");
        String routineName = scanner.nextLine();
        System.out.print("Ingrese los ejercicios separados por comas: ");
        String exerciseNames = scanner.nextLine();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        Usuario user = session.createQuery("FROM User WHERE username = :username", Usuario.class)
                .setParameter("username", username)
                .uniqueResult();

        if (user != null) {
            String[] exerciseList = exerciseNames.split(",");
            for (String exerciseName : exerciseList) {
                Ejercicio ejercicio = session.createQuery("FROM Exercise WHERE exerciseName = :exerciseName", Ejercicio.class)
                        .setParameter("exerciseName", exerciseName.trim())
                        .uniqueResult();

                if (ejercicio != null) {
                    user.addExerciseToRoutine(routineName, ejercicio);
                } else {
                    System.out.println("El ejercicio " + exerciseName + " no existe.");
                }
            }

            session.getTransaction().commit();
            System.out.println("Rutina creada exitosamente.");
        } else {
            System.out.println("El usuario especificado no existe.");
        }

        session.close();
    }

    private boolean authenticateAdmin(String username, String password) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        long count = session.createQuery("SELECT COUNT(*) FROM Administrator WHERE username = :username AND password = :password", Long.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .uniqueResult();

        session.getTransaction().commit();
        session.close();

        return count > 0;
    }

    private boolean authenticateUser(String username, String password) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        long count = session.createQuery("SELECT COUNT(*) FROM User WHERE username = :username AND password = :password", Long.class)
                .setParameter("username", username)
                .setParameter("password", password)
                .uniqueResult();

        session.getTransaction().commit();
        session.close();

        return count > 0;
    }
}