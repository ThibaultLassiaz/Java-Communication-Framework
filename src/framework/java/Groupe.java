/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.java;

import entites.Cercle;
import entites.Utilisateur;
import java.util.ArrayList;

/**
 *
 * @author Asus G75
 */
public class Groupe extends Cercle<Utilisateur>{
    
    public Groupe(ArrayList<Utilisateur> listeT, String nomCercle) {
        super(listeT, nomCercle);
    }
    
}
