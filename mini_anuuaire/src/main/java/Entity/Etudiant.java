/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author KAOUTAR
 */
public class Etudiant {
    private Integer CNE;
    private String nom, prenom, telephone;
    private Filiere filiere;
    private Departement departement;

    public Etudiant() {
    }
    

    public Etudiant(Integer CNE, String nom, String prenom, Filiere filiere, Departement departement, String telephone) {
        this.CNE = CNE;
        this.nom = nom;
        this.prenom = prenom;
        this.filiere = filiere;
        this.departement = departement;
        this.telephone = telephone;
    }

    public Integer getCNE() {
        return CNE;
    }

    public void setCNE(Integer CNE) {
        this.CNE = CNE;
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

    public Filiere getFiliere() {
        return filiere;
    }

    public void setFiliere(Filiere filiere) {
        this.filiere = filiere;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
    
}
