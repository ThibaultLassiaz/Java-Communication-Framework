/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites.interfaces;

import entites.ListeLien;
import java.rmi.Remote;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public interface _Utilisateur extends Remote{
    
    public int getId();
    
    public void setId(int id);
    
    public String getPseudo();
    
    public void setPseudo(String pseudo);
    
    public String getMotDePasse();
    
    public void setMotDePasse(String motDePasse);
    
    public ArrayList<ListeLien> getListLien();
    
    public void setListLien(ArrayList<ListeLien> listLien);
}
