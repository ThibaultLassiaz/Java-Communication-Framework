/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.ArrayList;

/**
 *
 * @author hanene
 */
    public class Utilisateur {
        private int id;
        private String pseudo;
        private String motDePasse;
        private ArrayList<ListeLien> tousMesLiens;

    public Utilisateur (int id, String pseudo, String mdp){
        this.setId(id);
        this.setPseudo(pseudo);
        this.setMotDePasse(mdp);
    }

    public Utilisateur (int id, String pseudo, String mdp, ArrayList<ListeLien> listeLaison) {
        this.setPseudo(pseudo);
        this.setMotDePasse(mdp);
        this.setListLien(listeLaison);
    }
    
    public void AddListeLien(ListeLien listLien) {
        this.getListLien().add(listLien);
    }
    
    public void InitTousLesLiens(ListeLien listLien) {
        this.setListLien(new ArrayList<ListeLien>());
        this.getListLien().add(listLien);
    }

    public String getCurrentUserType() {
        return this.getClass().getSimpleName();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * @param pseudo the pseudo to set
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * @return the motDePasse
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * @param motDePasse the motDePasse to set
     */
    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    /**
     * @return the listLien
     */
    public ArrayList<ListeLien> getListLien() {
        return tousMesLiens;
    }

    /**
     * @param listLien the listLien to set
     */
    public void setListLien(ArrayList<ListeLien> listLien) {
        this.tousMesLiens = listLien;
    }

}
