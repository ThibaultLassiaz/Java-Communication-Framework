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
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    public int getId() throws RemoteException;
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    public String getCommentaire() throws RemoteException;
    
    /**
     *
     * @param commentaire
     * @throws RemoteException
     */
    public void setCommentaire(String commentaire) throws RemoteException;
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    public Date getDateComm() throws RemoteException;
    
    /**
     *
     * @param dateComm
     * @throws RemoteException
     */
    public void setDateComm(Date dateComm) throws RemoteException;
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    public int getIdcible() throws RemoteException;
    
    
}
