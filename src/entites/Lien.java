/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Map;

/**
 *
 * @author hanene
 */
public class Lien<T>{
<<<<<<< HEAD
    Map<Integer,T> m;
=======
    
    private Map<Integer,T> m;
>>>>>>> a73024f9a3754ec995fc9f2809fea83405194b1e
    String nomLien; 
    
    public Lien(Map<Integer, T> m) {
        this.m = m;
    }
<<<<<<< HEAD
    
    
    
}
=======

    /**
     * @return the m
     */
    public Map<Integer,T> getM() {
        return m;
    }

    /**
     * @param m the m to set
     */
    public void setM(Map<Integer,T> m) {
        this.m = m;
    }
    
    
    
}
>>>>>>> a73024f9a3754ec995fc9f2809fea83405194b1e
