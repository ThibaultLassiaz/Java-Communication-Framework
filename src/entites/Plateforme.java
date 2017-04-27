/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.ArrayList;

/**
 *
 * @author Asus G75
 */
public class Plateforme {
       
    private String NomPlateforme;
    private ArrayList<Utilisateur> listeUtilisateurs;
    
    public Plateforme(String nom) {
        this.setNomPlateforme(nom);
        this.setListeUtilisateurs();
    }
    
    public void getAllUserOnPlateform() {
        for( Utilisateur u : getListeUtilisateurs())
        {
            System.out.println(u.getPseudo());
        }
    }   
    
    public void addUser(Utilisateur u){
        this.listeUtilisateurs.add(u);
    }
    
    /**
     * @return the NomPlateforme
     */
    public String getNomPlateforme() {
        return NomPlateforme;
    }

    /**
     * @param NomPlateforme the NomPlateforme to set
     */
    public void setNomPlateforme(String NomPlateforme) {
        this.NomPlateforme = NomPlateforme;
    }

    /**
     * @return the listeUtilisateurs
     */
    public ArrayList<Utilisateur> getListeUtilisateurs() {
        return listeUtilisateurs;
    }

    public void setListeUtilisateurs() {
        this.listeUtilisateurs =  new ArrayList();
    }
}
