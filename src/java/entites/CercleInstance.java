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
public class CercleInstance<T> implements Cercle<T> {
    
    private ArrayList<T> t;
    
    public CercleInstance(ArrayList<T> t){
        this.t=t;
    }

    /**
     * @return the t
     */
    public ArrayList<T> getT() {
        return t;
    }

    /**
     * @param t the t to set
     */
    public void setT(ArrayList<T> t) {
        this.t = t;
    }
    
    
}
