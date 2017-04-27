/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.java;

import entites.ListeLien;
import entites.Utilisateur;
import java.util.Date;

/**
 *
 * @author hanene
 */
public class Employe extends Utilisateur {
    //private int id;
   // private String pseudo;
    private String nom;
    private String prenom;
    private Date dateNais;
    public enum Sexe{homme, femme};
    private Sexe sexe;
    private String email;
   // private String motDePasse;
    
    public Employe(int id, String pseudo, String mdp, String prenom, String nom, Date dateNais, Sexe sexe, String email) {
        super(id, pseudo, mdp);
        this.prenom=prenom;
        this.nom=nom;
        this.dateNais=dateNais;
        this.sexe=sexe;
        this.email=email;
        
    }
    
    
    /**
     * @return the id
     */
   /* public int getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }
    
    public void setPseudo() {
        this.pseudo = pseudo;
    }
    */
    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the prenom
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * @param prenom the prenom to set
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * @return the dateNais
     */
    public Date getDateNais() {
        return dateNais;
    }

    /**
     * @param dateNais the dateNais to set
     */
    public void setDateNais(Date dateNais) {
        this.dateNais = dateNais;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the motDePasse
     */
   /* public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * @param motDePasse the motDePasse to set
     */
   /* public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
    */
}
