/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abscence.entite.formation;

/**
 *
 * @author DABANTI
 */
public class Formation implements java.io.Serializable{
    
    private int idFormation;
    private String nom;
    private int identifiantFormateur;

    public int getIdFormation() {
        return idFormation;
    }

    public void setIdFormation(int idFormation) {
        this.idFormation = idFormation;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdentifiantFormateur() {
        return identifiantFormateur;
    }

    public void setIdFormateur(int idFormateur) {
        this.identifiantFormateur= idFormateur;
    }

    public Formation(int idFormation, String nom, int idFormateur) {
        this.idFormation = idFormation;
        this.nom = nom;
        this.identifiantFormateur = idFormateur;
    }

    public Formation() {
    }
    
    
    
}
