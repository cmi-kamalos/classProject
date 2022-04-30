/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import abscence.entite.Seance.Seance;
import org.hibernate.SessionFactory;
import abscence.org.hibernate.HibernateUtil;
import java.sql.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author DABANTI
 */
@ManagedBean(name="seance")
@SessionScoped

public class SeanceManager {
    

    private Seance seance;
    private SessionFactory factory;
  
      
 

    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }
   public void insererSeance(Seance seance)
   {
       
           Session session=HibernateUtil.getSessionFactory().openSession();
           Transaction transaction=null;
           try{
               transaction=session.beginTransaction();
               session.save(seance);
               transaction.commit();
               }
           catch(HibernateException e)
           {
               if(transaction != null)
               {
                   transaction.rollback();
               }
           }
           finally
                   {
                       session.close();
                   }
   }
      public void insererSeance(int idSeance,String titre, Date dateDebut,Date dateFin, int idFormateur)
   {
       
           Session session=HibernateUtil.getSessionFactory().openSession();
           Transaction transaction=null;
           try{
               transaction=session.beginTransaction();
               session.save(new Seance(idSeance,titre,dateDebut,dateFin,idFormateur));
               transaction.commit();
               }
           catch(HibernateException e)
           {
               if(transaction != null)
               {
                   transaction.rollback();
               }
           }
           finally
                   {
                       session.close();
                   }
   }
    public void supprimerSeance(int idSeance) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(e);
        }
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete((Seance) session.get(Seance.class, idSeance));
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }}
    
    
    
}
