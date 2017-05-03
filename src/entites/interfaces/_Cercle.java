/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public interface _Cercle<T> extends Remote{
    
    public ArrayList<T> getListeT() throws RemoteException;
    
    public void setListeT(ArrayList<T> listeT) throws RemoteException;
    
    public String getNomCercle() throws RemoteException;
    
    public void setNomCercle(String nomCercle) throws RemoteException;
}
