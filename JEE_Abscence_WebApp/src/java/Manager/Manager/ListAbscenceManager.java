/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import abscence.entite.ListeAbscence.Listeabscence;
import abscence.org.hibernate.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author DABANTI
 */
public class ListAbscenceManager {
    private SessionFactory factory;
    private Listeabscence listAbscence=new Listeabscence();

    public Listeabscence getListAbscence() {
        return listAbscence;
    }

    public void setListAbscence(Listeabscence listAbscence) {
        this.listAbscence = listAbscence;
    }
        public void  insererFormation(Listeabscence listAbscence)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.save(listAbscence);
            transaction.commit();
            
            
        }
        catch(HibernateException e)
        {
            if(transaction!=null)
            {
                transaction.rollback();
            }
            
        }
      }
    
    
    
    
    
          public List ListeApprenant() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(e);
        }
        Session session = factory.openSession();
        Transaction transaction = null;
        List list=null;
        try {
            transaction = session.beginTransaction();
         list=session.createQuery("FROM Apprenant").list();
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return list;

    }
}
