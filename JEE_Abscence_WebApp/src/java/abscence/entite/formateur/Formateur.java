package abscence.entite.formateur;
// Generated 26 avr. 2019 22:09:06 by Hibernate Tools 4.3.1



/**
 * Formateur generated by hbm2java
 */

public class Formateur  implements java.io.Serializable {


     private int idFormateur;
     private String nom;
     private String prenom;
     private String login;
     private String password;

    public Formateur() {
    }

    public Formateur(int idFormateur, String nom, String prenom, String login, String password) {
       this.idFormateur = idFormateur;
       this.nom = nom;
       this.prenom = prenom;
       this.login = login;
       this.password = password;
    }
   
    public int getIdFormateur() {
        return this.idFormateur;
    }
    
    public void setIdFormateur(int idFormateur) {
        this.idFormateur = idFormateur;
    }
    public String getNom() {
        return this.nom;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return this.prenom;
    }
    
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getLogin() {
        return this.login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }
    public String getPassword() {
        return this.password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }




}


