/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import entites.interfaces._Utilisateur;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hanene
 */
    public class Utilisateur implements _Utilisateur, Serializable{
        private int id;
        private String pseudo;
        private String motDePasse;
        private ArrayList<ListeLien> tousMesLiens;
        private Plateforme currentPlateforme;

    /**
     *
     * @param id
     * @param pseudo
     * @param mdp
     * @throws RemoteException
     */
    public Utilisateur (int id, String pseudo, String mdp) throws RemoteException{
        this.setId(id);
        this.setPseudo(pseudo);
        this.setMotDePasse(mdp);
    }

    /**
     *
     * @param id
     * @param pseudo
     * @param mdp
     * @param listeLaison
     * @throws RemoteException
     */
    public Utilisateur (int id, String pseudo, String mdp, ArrayList<ListeLien> listeLaison) throws RemoteException {
        this.setPseudo(pseudo);
        this.setMotDePasse(mdp);
        this.setListLien(listeLaison);
    }
    
    /**
     *
     * @param listLien
     * @throws RemoteException
     */
    public void AddListeLien(ListeLien listLien) throws RemoteException {
        this.getListLien().add(listLien);
    }
    
    /**
     *
     * @param listLien
     * @throws RemoteException
     */
    public void InitTousLesLiens(ListeLien listLien) throws RemoteException {
        this.setListLien(new ArrayList<ListeLien>());
        this.getListLien().add(listLien);
    }

    /**
     *
     * @return
     */
    public String getCurrentUserType() {
        return this.getClass().getSimpleName();
    }
    
    public String toString () {
            try {
                return this.getPseudo();
            } catch (RemoteException ex) {
                Logger.getLogger(Utilisateur.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;
    }

    /**
     * @return the id
     * @throws java.rmi.RemoteException
     */
    @Override
    public int getId() throws RemoteException{
        return id;
    }

    @Override
    public void setId(int id) throws RemoteException{
        this.id = id;
    }
    
    /**
     * @return the pseudo
     * @throws java.rmi.RemoteException
     */
    @Override
    public String getPseudo() throws RemoteException{
        return pseudo;
    }

    /**
     * @param pseudo the pseudo to set
     * @throws java.rmi.RemoteException
     */
    @Override
    public void setPseudo(String pseudo) throws RemoteException{
        this.pseudo = pseudo;
    }

    /**
     * @return the motDePasse
     * @throws java.rmi.RemoteException
     */
    @Override
    public String getMotDePasse() throws RemoteException{
        return motDePasse;
    }

    /**
     * @param motDePasse the motDePasse to set
     * @throws java.rmi.RemoteException
     */
    @Override
    public void setMotDePasse(String motDePasse) throws RemoteException{
        this.motDePasse = motDePasse;
    }

    /**
     * @return the listLien
     * @throws java.rmi.RemoteException
     */
    @Override
    public ArrayList<ListeLien> getListLien() throws RemoteException{
        return tousMesLiens;
    }

    /**
     * @param listLien the listLien to set
     * @throws java.rmi.RemoteException
     */
    @Override
    public void setListLien(ArrayList<ListeLien> listLien) throws RemoteException{
        this.tousMesLiens = listLien;
    }

    @Override
    public Plateforme getCurrentPlateforme() throws RemoteException {
        return this.currentPlateforme;
    }

    @Override
    public void setCurrentPlateforme(Plateforme p) throws RemoteException {
        this.currentPlateforme=p;
    }

}
