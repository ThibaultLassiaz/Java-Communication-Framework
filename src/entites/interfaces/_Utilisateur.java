/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites.interfaces;

import entites.ListeLien;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public interface _Utilisateur extends Remote{
    
    public int getId() throws RemoteException;
    
    public void setId(int id) throws RemoteException;
    
    public String getPseudo() throws RemoteException;
    
    public void setPseudo(String pseudo) throws RemoteException;
    
    public String getMotDePasse() throws RemoteException;
    
    public void setMotDePasse(String motDePasse) throws RemoteException;
    
    public ArrayList<ListeLien> getListLien() throws RemoteException;
    
    public void setListLien(ArrayList<ListeLien> listLien) throws RemoteException;
}
