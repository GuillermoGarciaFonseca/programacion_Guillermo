package org.example.controller;

import org.example.database.HibernateUtil;
import org.example.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class AplicacionController {
    private SessionFactory sessionFactory;
    public AplicacionController(){
        sessionFactory= HibernateUtil.getSessionFactory();

    }
    /*public void agregaralumno(){
        Session session =HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(new Alumno("Manuel","Garcia","asdasdasd@gmail.com",12222222,new Matricula(true)));
    }*/
    public void agregarAsignatura(){
        Session session =HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.persist(new Asignatura(2,"Formacion y orientacion laboral","FOL"));
        session.persist(new Asignatura(1,"Programacion","Programar"));
    }
public void agregarProfesor(){
    Session session =HibernateUtil.getSessionFactory().getCurrentSession();
    session.beginTransaction();
    session.persist(new Profesor(2,"Raul","Gonzalez","aqwqqwwq@gmail.com",22222222,"Magisterio",true,11111,new Ciclos(1,"Educacion Fisica","EF")));
    session.persist(new Profesor(1,"Pablo","Gonzalez","aqwqqww2@gmail.com",22222122,"Magisterio",true,11111,new Ciclos(1,"Lengua","Lengua")));
    }

}
