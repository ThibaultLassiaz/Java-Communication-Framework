/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hanene
 */
public class Cercle<T> {
    
    private ArrayList<T> listeT;
    private String nomCercle;


    public Cercle(ArrayList<T> listeT, String nomCercle) {
        this.listeT = listeT;
        this.nomCercle = nomCercle;
    }

    /**
     * @return the listeT
     */
    public ArrayList<T> getListeT() {
        return listeT;
    }

    /**
     * @param listeT the listeT to set
     */
    public void setListeT(ArrayList<T> listeT) {
        this.listeT = listeT;
    }

    /**
     * @return the nomCercle
     */
    public String getNomCercle() {
        return nomCercle;
    }

    /**
     * @param nomCercle the nomCercle to set
     */
    public void setNomCercle(String nomCercle) {
        this.nomCercle = nomCercle;
    }
    
    
}
