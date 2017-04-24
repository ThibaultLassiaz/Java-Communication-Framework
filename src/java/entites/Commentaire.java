/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.util.Date;

/**
 *
 * @author hanene
 */
public class Commentaire {
    private int id;
    private String commentaire;
    private Date dateComm;
    private int idcible;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the commentaire
     */
    public String getCommentaire() {
        return commentaire;
    }

    /**
     * @param commentaire the commentaire to set
     */
    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    /**
     * @return the dateComm
     */
    public Date getDateComm() {
        return dateComm;
    }

    /**
     * @param dateComm the dateComm to set
     */
    public void setDateComm(Date dateComm) {
        this.dateComm = dateComm;
    }

    /**
     * @return the idcible
     */
    public int getIdcible() {
        return idcible;
    }
    
}
