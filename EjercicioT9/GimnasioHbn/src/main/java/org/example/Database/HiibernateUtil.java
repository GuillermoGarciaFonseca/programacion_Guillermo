package org.example.Database;


import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiibernateUtil {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            System.out.println("Conexion correcta");
        }catch (Throwable ex){
            System.err.println("Error al crear la configuración de hibernate: "+ex);
            throw new ExceptionInInitializerError();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}