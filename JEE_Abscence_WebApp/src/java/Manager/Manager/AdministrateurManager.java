/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import abscence.entite.administrateur.Administrateur;
import abscence.entite.formateur.Formateur;
import abscence.org.hibernate.HibernateUtil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author DABANTI
 */
@ManagedBean(name = "admin")
@SessionScoped
public class AdministrateurManager {

    private SessionFactory factory = null;

    private Administrateur manager = new Administrateur();
    private FormateurManager fm=new FormateurManager();

    public FormateurManager getFm() {
        return fm;
    }
    public void setFm(FormateurManager fm) {
        this.fm = fm;
    }

    public Administrateur getManager() {
        return manager;
    }

    public void setManager(Administrateur manager) {
        this.manager = manager;
    }

    public void insererAdministrateur(Administrateur manager) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(manager);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }



    public void supprimerAdministrateur(int idAdministrateur) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(e);
        }
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete((Administrateur) session.get(Administrateur.class, idAdministrateur));
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void insererAdministrateur(int idAdministrateur, String nom, String prenom, String login, String password) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(e);
        }
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(new Administrateur(idAdministrateur, nom, prenom, login, password));
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }
        public List ListeAdministrateur(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;
        List list = null;
        try {
            transaction = session.beginTransaction();
            list = session.createQuery("FROM Administrateur").list();
            transaction.commit();
        }
        catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } 
        finally {
            session.close();
        }
        return list;

    }

    public String Login(String login, String mdp) {
        Administrateur a = new Administrateur();
        Formateur formateur =new Formateur();
        for (Object object : ListeAdministrateur()) {
            a = (Administrateur) object;
            if (a.getLogin().equals(login) && a.getPassword().equals(mdp)) {
                return "admin.xhtml";
            }
        }

        for (Object object : fm.ListeFormateur()) {
            formateur = (Formateur) object;
            if (formateur.getLogin().equals(login) && formateur.getPassword().equals(mdp)) {
                return "Accueil.xhtml";
            }
        }

        return "index.xhtml";
    }
    public String redirect(){
    return "admin?faces-redirect=true";
}

}
