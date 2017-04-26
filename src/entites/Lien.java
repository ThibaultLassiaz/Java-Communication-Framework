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
   
    private Map<Integer,T> m;
    String nomLien; 
    
    public Lien(Map<Integer, T> m) {
        this.m = m;
    }

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
