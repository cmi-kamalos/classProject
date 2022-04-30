/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abscence.entite.administrateur;

/**
 *
 * @author DABANTI
 */
public class Administrateur {
    private int idAdministrateur;
    private String nom;
    private String prenom;
    private String login;
    private String password;

    public Administrateur() {
    }

    public Administrateur(int idAdministrateur, String nom, String prenom, String login, String password) {
        this.idAdministrateur = idAdministrateur;
        this.nom = nom;
        this.prenom = prenom;
        this.login = login;
        this.password = password;
    }

    public int getIdAdministrateur() {
        return idAdministrateur;
    }

    public void setIdAdministrateur(int idAdministrateur) {
        this.idAdministrateur = idAdministrateur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
