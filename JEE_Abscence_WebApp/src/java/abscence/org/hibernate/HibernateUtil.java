/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abscence.org.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author DABANTI
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory=buildSessionFactory();
    private static final SessionFactory buildSessionFactory()
    {
        try{
            return new Configuration().configure().buildSessionFactory();
        }
         catch (Throwable ex) {
       
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
        
    }
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
