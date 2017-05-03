/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites.interfaces;

import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public interface _Cercle<T> {
    
    public ArrayList<T> getListeT();
    
    public void setListeT(ArrayList<T> listeT);
    
    public String getNomCercle();
    
    public void setNomCercle(String nomCercle);
}
