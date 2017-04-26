/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.java;

import entites.Cercle;
import java.util.ArrayList;

/**
 *
 * @author Asus G75
 */
public class Groupe<T> extends Cercle{
    
    public Groupe(ArrayList<T> listeT, String nomCercle) {
        super(listeT, nomCercle);
    }
}
