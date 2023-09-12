
package org.example.controller;

import org.example.database.HibernateUtil;
import org.example.model.Usuario;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GestionBd {
private  SessionFactory sessionFactory;
    public GestionBd() {
            sessionFactory = HibernateUtil.getSessionFactory();
        }

    public void agregarPersona(Usuario usuario){

        Session session=sessionFactory.openSession();
        session.beginTransaction();
        session.persist(usuario);
        session.getTransaction().commit();
        session.close();
    }
}
