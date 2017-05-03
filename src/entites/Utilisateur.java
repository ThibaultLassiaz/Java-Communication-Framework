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

/**
 *
 * @author hanene
 */
    public class Utilisateur implements _Utilisateur, Serializable{
        private int id;
        private String pseudo;
        private String motDePasse;
        private ArrayList<ListeLien> tousMesLiens;

    public Utilisateur (int id, String pseudo, String mdp) throws RemoteException{
        this.setId(id);
        this.setPseudo(pseudo);
        this.setMotDePasse(mdp);
    }

    public Utilisateur (int id, String pseudo, String mdp, ArrayList<ListeLien> listeLaison) throws RemoteException {
        this.setPseudo(pseudo);
        this.setMotDePasse(mdp);
        this.setListLien(listeLaison);
    }
    
    public void AddListeLien(ListeLien listLien) throws RemoteException {
        this.getListLien().add(listLien);
    }
    
    public void InitTousLesLiens(ListeLien listLien) throws RemoteException {
        this.setListLien(new ArrayList<ListeLien>());
        this.getListLien().add(listLien);
    }

    public String getCurrentUserType() {
        return this.getClass().getSimpleName();
    }

    /**
     * @return the id
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
     */
    @Override
    public String getPseudo() throws RemoteException{
        return pseudo;
    }

    /**
     * @param pseudo the pseudo to set
     */
    @Override
    public void setPseudo(String pseudo) throws RemoteException{
        this.pseudo = pseudo;
    }

    /**
     * @return the motDePasse
     */
    @Override
    public String getMotDePasse() throws RemoteException{
        return motDePasse;
    }

    /**
     * @param motDePasse the motDePasse to set
     */
    @Override
    public void setMotDePasse(String motDePasse) throws RemoteException{
        this.motDePasse = motDePasse;
    }

    /**
     * @return the listLien
     */
    @Override
    public ArrayList<ListeLien> getListLien() throws RemoteException{
        return tousMesLiens;
    }

    /**
     * @param listLien the listLien to set
     */
    @Override
    public void setListLien(ArrayList<ListeLien> listLien) throws RemoteException{
        this.tousMesLiens = listLien;
    }

}
