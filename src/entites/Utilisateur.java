/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author hanene
 */
public class Utilisateur {
    private int id;
    private String pseudo;
    private String motDePasse;
    
public Utilisateur (int id, String psoeudo, String mdp){
    this.id=id;
    this.pseudo=psoeudo;
    this.motDePasse=mdp;
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
}
