/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import abscence.entite.formation.Formation;
import abscence.org.hibernate.HibernateUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author DABANTI
 */
@ManagedBean(name="formation")
@SessionScoped
public class FormationManager {
    
    private Formation formation=new Formation();

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }
    public void  insererFormation(Formation formation)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.save(formation);
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
      public void  insererFormation(int idFormation, String nom,int idFormateur)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try{
            transaction=session.beginTransaction();
            session.save(new Formation(idFormation,nom,idFormateur));
            transaction.commit();
            
            
        }
        catch(HibernateException e)
        {
            if(transaction!=null)
            {
                transaction.rollback();
            }
            
        }
         finally{
            session.close();
        }
        
    }
    public void supprimerFormation(int idFormation)
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        try{
            
            transaction=session.beginTransaction();
            session.delete((Formation)(session.get(Formation.class,idFormation)));
            transaction.commit();
            
          }
        catch(HibernateException e)
        {
            if(transaction!=null)
            {
                transaction.rollback();
            }
        }
        finally{
            session.close();
        }
        
    }
    public List ListFormation()
    {
        Session session=HibernateUtil.getSessionFactory().openSession();
        Transaction transaction=null;
        List list=null;
        try
        {
         transaction=session.beginTransaction();
         list=session.createQuery("From Formation").list();
         transaction.commit();
         
         
        }
        catch(HibernateException e)
        {
            if(transaction!=null)
            {
                transaction.rollback();
            }
            
        }
        finally
        {
            session.close();
        }
        return list;
        
        
    }
    
    
}
