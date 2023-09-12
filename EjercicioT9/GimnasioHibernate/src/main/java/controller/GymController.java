import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GymController {
    private SessionFactory sessionFactory;
    private Scanner scanner;

    public GymController() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            System.out.println("----- Menú Principal -----");
            System.out.println("1. Login como administrador");
            System.out.println("2. Login como usuario");
            System.out.println("3. Registrar usuario");
            System.out.println("4. Salir");
            System.out.print("Ingrese su elección: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (choice) {
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
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo nuevamente.");
                    break;
            }
            System.out.println();
        } while (choice != 4);
        sessionFactory.close();
        scanner.close();
    }

    private void adminLogin() {
        System.out.print("Ingrese nombre de usuario (administrador): ");
        String username = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();

        // Realizar la autenticación del administrador
        if (authenticateAdmin(username, password)) {
            int choice;
            do {
                System.out.println("----- Menú Administrador -----");
                System.out.println("1. Eliminar usuario");
                System.out.println("2. Ver datos de usuario");
                System.out.println("3. Añadir ejercicio");
                System.out.println("4. Volver al menú principal");
                System.out.print("Ingrese su elección: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

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

    private void userLogin() {
        System.out.print("Ingrese nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Ingrese contraseña: ");
        String password = scanner.nextLine();

        // Realizar la autenticación del usuario
        if (authenticateUser(username, password)) {
            int choice;
            do {
                System.out.println("----- Menú Usuario -----");
                System.out.println("1. Ver mis datos");
                System.out.println("2. Crear rutina");
                System.out.println("3. Volver al menú principal");
                System.out.print("Ingrese su elección: ");
                choice = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

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

    private boolean authenticateAdmin(String username, String password) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Verificar si existe un administrador con el nombre de usuario y contraseña proporcionados
        List<?> result = session.createQuery("FROM Administrator WHERE username = :username AND password = :password")
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return !result.isEmpty();
    }

    private boolean authenticateUser(String username, String password) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Verificar si existe un usuario con el nombre de usuario y contraseña proporcionados
        List<?> result = session.createQuery("FROM User WHERE username = :username AND password = :password")
                .setParameter("username", username)
                .setParameter("password", password)
                .getResultList();

        session.getTransaction().commit();
        session.close();

        return !result.isEmpty();
    }

    private void registerUser() {
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

        // Crear un nuevo usuario y guardarlo en la base de datos
        User user = new User(firstName, lastName, username, password, exerciseLevel, appName, userType);
        session.save(user);

        session.getTransaction().commit();
        session.close();

        System.out.println("¡Usuario registrado exitosamente!");
    }

    private void deleteUser() {
        System.out.print("Ingrese el nombre de usuario del usuario que desea eliminar: ");
        String username = scanner.nextLine();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Obtener el usuario a eliminar
        User user = session.createQuery("FROM User WHERE username = :username", User.class)
                .setParameter("username", username)
                .uniqueResult();

        if (user != null) {
            session.delete(user);
            session.getTransaction().commit();
            System.out.println("¡Usuario eliminado exitosamente!");
        } else {
            System.out.println("El usuario especificado no existe.");
        }

        session.close();
    }

    private void viewUserData() {
        System.out.print("Ingrese el nombre de usuario del usuario: ");
        String username = scanner.nextLine();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Obtener los datos del usuario
        User user = session.createQuery("FROM User WHERE username = :username", User.class)
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

    private void addExercise() {
        System.out.print("Ingrese el nombre del ejercicio: ");
        String exerciseName = scanner.nextLine();
        System.out.print("Ingrese el grupo muscular que trabaja el ejercicio: ");
        String muscleGroup = scanner.nextLine();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Crear un nuevo ejercicio y guardarlo en la base de datos
        Exercise exercise = new Exercise(exerciseName, muscleGroup);
        session.save(exercise);

        session.getTransaction().commit();
        session.close();

        System.out.println("¡Ejercicio añadido exitosamente!");
    }

    private void viewUserData(String username) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Obtener los datos del usuario
        User user = session.createQuery("FROM User WHERE username = :username", User.class)
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

    private void createRoutine(String username) {
        System.out.print("Ingrese el nombre de la rutina: ");
        String routineName = scanner.nextLine();
        System.out.print("Ingrese los ejercicios separados por comas: ");
        String exerciseNames = scanner.nextLine();

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        // Obtener el usuario
        User user = session.createQuery("FROM User WHERE username = :username", User.class)
                .setParameter("username", username)
                .uniqueResult();

        if (user != null) {
            String[] exercises = exerciseNames.split(",");
            for (String exerciseName : exercises) {
                // Obtener el ejercicio por nombre
                Exercise exercise = session.createQuery("FROM Exercise WHERE exerciseName = :exerciseName", Exercise.class)
                        .setParameter("exerciseName", exerciseName.trim())
                        .uniqueResult();

                if (exercise != null) {
                    // Agregar el ejercicio a la rutina del usuario
                    user.addExerciseToRoutine(routineName, exercise);
                } else {
                    System.out.println("El ejercicio '" + exerciseName.trim() + "' no existe.");
                }
            }

            session.update(user);
            session.getTransaction().commit();
            System.out.println("¡Rutina creada exitosamente!");
        } else {
            System.out.println("El usuario especificado no existe.");
        }

        session.close();
    }
}