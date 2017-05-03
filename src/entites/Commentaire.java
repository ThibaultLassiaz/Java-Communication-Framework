/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import entites.interfaces._Commentaire;
import java.rmi.RemoteException;
import java.util.Date;

/**
 *
 * @author hanene
 */
public class Commentaire implements _Commentaire{
    private int id;
    private String commentaire;
    private Date dateComm;
    private int idcible;

    /**
     * @return the id
     */
    @Override
    public int getId() throws RemoteException{
        return id;
    }

    /**
     * @return the commentaire
     */
    @Override
    public String getCommentaire() throws RemoteException{
        return commentaire;
    }

    /**
     * @param commentaire the commentaire to set
     */
    @Override
    public void setCommentaire(String commentaire) throws RemoteException{
        this.commentaire = commentaire;
    }

    /**
     * @return the dateComm
     */
    @Override
    public Date getDateComm() throws RemoteException{
        return dateComm;
    }

    /**
     * @param dateComm the dateComm to set
     */
    @Override
    public void setDateComm(Date dateComm) throws RemoteException{
        this.dateComm = dateComm;
    }

    /**
     * @return the idcible
     */
    @Override
    public int getIdcible() throws RemoteException{
        return idcible;
    }
    
}
