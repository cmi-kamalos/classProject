package Manager;

import abscence.entite.administrateur.Administrateur;
import abscence.entite.formateur.Formateur;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

@ManagedBean(name = "formateur")
@SessionScoped
public class FormateurManager {

    private SessionFactory factory = null;
    private Formateur formateur = new Formateur();

    public Formateur getFormateur() {
        return formateur;
    }

    public void setFormateur(Formateur formateur) {
        this.formateur = formateur;
    }

    public void insererFormateur(Formateur formateur) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(e);
        }
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(formateur);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public void supprimerApprenant(int idApprenant) {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(e);
        }
        Session session = factory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.delete((Formateur) session.get(Formateur.class, idApprenant));
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
    }

    public List ListeFormateur() {
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            throw new ExceptionInInitializerError(e);
        }
        Session session = factory.openSession();
        Transaction transaction = null;
        List list = null;
        try {
            transaction = session.beginTransaction();
            list = session.createQuery("FROM Formateur").list();
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

    public int chercherId(String login) {
        for (Object formateur : ListeFormateur()) {
            if (login.equals(((Formateur) formateur).getLogin())) {
                return ((Formateur) formateur).getIdFormateur();
            }
        }
        return 0;
    }

  
}
