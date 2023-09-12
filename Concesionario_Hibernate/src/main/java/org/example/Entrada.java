package org.example;

import org.example.controller.ConcesionarioController;
import org.example.database.HibernateUtil;
import org.example.model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
public class Entrada {
    public static void main(String[] args) {

ConcesionarioController concesionarioController=new ConcesionarioController();
/*SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session= sessionFactory.getCurrentSession();
        session.beginTransaction();
        session.persist(new vehiculo("Ford","Focus",2000,100,30000));
        session.getTransaction().commit();
        session.close();
        */
        //controller.obtenerDatos();
        //controller.borrarDatos();
    //controller.modificarVehiculo();
        concesionarioController.realizarBusquedaProveedor("Alemania");
    }
}
