/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.Serializable;

/**
 *
 * @author Asus G75
 */
public class Lien implements Serializable{
    
   private Utilisateur u1;
   private Utilisateur u2;
   
   public Lien(Utilisateur u1, Utilisateur u2) {
       this.u1 = u1;
       this.u2 = u2;
   }
   
    /**
     * @return the u1
     */
    public Utilisateur getU1() {
        return u1;
    }

    /**
     * @param u1 the u1 to set
     */
    public void setU1(Utilisateur u1) {
        this.u1 = u1;
    }

    /**
     * @return the u2
     */
    public Utilisateur getU2() {
        return u2;
    }

    /**
     * @param u2 the u2 to set
     */
    public void setU2(Utilisateur u2) {
        this.u2 = u2;
    }
}
