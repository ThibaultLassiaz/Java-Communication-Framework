/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites.interfaces;

import entites.ListeLien;
import entites.Plateforme;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public interface _Utilisateur extends Remote{
    
    /**
     * 
     * @return
     * @throws RemoteException 
     */
    public int getId() throws RemoteException;
    
    /**
     * 
     * @param id
     * @throws RemoteException 
     */
    public void setId(int id) throws RemoteException;
    
    /**
     * 
     * @return
     * @throws RemoteException 
     */
    public String getPseudo() throws RemoteException;
    
    /**
     * 
     * @param pseudo
     * @throws RemoteException 
     */
    public void setPseudo(String pseudo) throws RemoteException;
    
    /**
     * 
     * @return
     * @throws RemoteException 
     */
    public String getMotDePasse() throws RemoteException;
    
    /**
     * 
     * @param motDePasse
     * @throws RemoteException 
     */
    public void setMotDePasse(String motDePasse) throws RemoteException;
    
    /**
     * 
     * @return
     * @throws RemoteException 
     */
    public ArrayList<ListeLien> getListLien() throws RemoteException;
    
    /**
     * 
     * @param listLien
     * @throws RemoteException 
     */
    public void setListLien(ArrayList<ListeLien> listLien) throws RemoteException;
    
    /**
     * 
     * @return
     * @throws RemoteException 
     */
    public Plateforme getCurrentPlateforme() throws RemoteException;
    
    /**
     * 
     * @param p
     * @throws RemoteException 
     */
    public void setCurrentPlateforme(Plateforme p) throws RemoteException;
}
