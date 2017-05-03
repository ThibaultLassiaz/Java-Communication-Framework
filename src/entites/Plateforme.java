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
       
    private int idPlateforme;
    private String NomPlateforme;
    private ArrayList<Utilisateur> listeUtilisateurs;
    
    public Plateforme(int id, String nom) {
        this.setIdPlateforme(id);
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

    /**
     * @return the idPlateforme
     */
    public int getIdPlateforme() {
        return idPlateforme;
    }

    /**
     * @param idPlateforme the idPlateforme to set
     */
    public void setIdPlateforme(int idPlateforme) {
        this.idPlateforme = idPlateforme;
    }
    
    /**
     * 
     * @param id l'identifiant d'un utilisateur
     * @return true si l'utilisateur d'identifiant id appartient à la plateforme
     */
    public boolean contientUtilisateur(int id){
        for(Utilisateur utilisateur : listeUtilisateurs) {
            if(utilisateur.getId()==id){
                return true;
            }
        }
        return false;
    }
}
