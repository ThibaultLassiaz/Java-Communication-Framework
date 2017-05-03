/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites.interfaces;

import entites.Utilisateur;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public interface _Plateforme extends Remote{
    
    public int getIdPlateforme() throws RemoteException;
    
    public void setIdPlateforme(int id) throws RemoteException;
    
    public String getNomPlateforme() throws RemoteException;
    
    public void setNomPlateforme(String nomPlateforme) throws RemoteException;
    
    public ArrayList<Utilisateur> getListeUtilisateurs() throws RemoteException;
    
    public void setListeUtilisateurs() throws RemoteException;
    
    public void addUser(Utilisateur u) throws RemoteException;
}
