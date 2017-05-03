/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites.interfaces;

import entites.Utilisateur;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public interface _Plateforme {
    
    public int getIdPlateforme();
    
    public void setIdPlateforme(int id);
    
    public ArrayList<Utilisateur> getListeUtilisateurs();
    
    public void setListeUtilisateurs();
    
    public void addUser(Utilisateur u);
}
