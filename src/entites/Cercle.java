/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import entites.interfaces._Cercle;
import java.util.ArrayList;

/**
 *
 * @author hanene
 */
public class Cercle<T> implements _Cercle<T>{
    
    private ArrayList<T> listeT;
    private String nomCercle;


    public Cercle(ArrayList<T> listeT, String nomCercle) {
        this.listeT = listeT;
        this.nomCercle = nomCercle;
    }

    /**
     * @return the listeT
     */
    @Override
    public ArrayList<T> getListeT() {
        return listeT;
    }

    /**
     * @param listeT the listeT to set
     */
    @Override
    public void setListeT(ArrayList<T> listeT) {
        this.listeT = listeT;
    }

    /**
     * @return the nomCercle
     */
    @Override
    public String getNomCercle() {
        return nomCercle;
    }

    /**
     * @param nomCercle the nomCercle to set
     */
    @Override
    public void setNomCercle(String nomCercle) {
        this.nomCercle = nomCercle;
    }
    
    
}
