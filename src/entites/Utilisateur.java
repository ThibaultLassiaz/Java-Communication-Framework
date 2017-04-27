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
    private ArrayList<ListeLiaison>  listeLaison;
    
public Utilisateur (int id, String pseudo, String mdp){
    this.id=id;
    this.pseudo=pseudo;
    this.motDePasse=mdp;
}

    public void SetListeLiens(ListeLiaison listLien) {
        this.setListLien(new ArrayList<ListeLiaison>());
        this.getListLien().add(listLien);
    }


    /**
     * @return the id
     */
    public int getId() {
        return id;
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
    public ArrayList<ListeLiaison> getListLien() {
        return listeLaison;
    }

    /**
     * @param listLien the listLien to set
     */
    public void setListLien(ArrayList<ListeLiaison> listLien) {
        this.listeLaison = listLien;
    }

}
