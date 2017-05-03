/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author Lucas
 */
public interface _Commentaire extends Remote{
    
    public int getId() throws RemoteException;
    
    public String getCommentaire() throws RemoteException;
    
    public void setCommentaire(String commentaire) throws RemoteException;
    
    public Date getDateComm() throws RemoteException;
    
    public void setDateComm(Date dateComm) throws RemoteException;
    
    public int getIdcible() throws RemoteException;
    
    
}
