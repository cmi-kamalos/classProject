package abscence.entite.Apprenant;



/**
 * Apprenant generated by hbm2java
 */
public class Apprenant  implements java.io.Serializable {

     private int idApprenant;
     private String nom;
     private String prenom;

    public Apprenant() {
    }

    public Apprenant(int idApprenant, String nom, String prenom) {
       this.idApprenant = idApprenant;
       this.nom = nom;
       this.prenom = prenom;
    }
   
    public int getIdApprenant() {
        return this.idApprenant;
    }
    
    public void setIdApprenant(int idApprenant) {
        this.idApprenant = idApprenant;
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




}


