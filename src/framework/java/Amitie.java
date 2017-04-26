/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.java;

import entites.Utilisateur;

/**
 *
 * @author Asus G75
 */
public class Amitie {
    
    private Utilisateur s1;
    private Utilisateur s2;
    
    public Amitie(Utilisateur s1, Utilisateur s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    /**
     * @return the s1
     */
    public Utilisateur getS1() {
        return s1;
    }

    /**
     * @param s1 the s1 to set
     */
    public void setS1(Utilisateur s1) {
        this.s1 = s1;
    }

    /**
     * @return the s2
     */
    public Utilisateur getS2() {
        return s2;
    }

    /**
     * @param s2 the s2 to set
     */
    public void setS2(Utilisateur s2) {
        this.s2 = s2;
    }
    
    
    
    
}
