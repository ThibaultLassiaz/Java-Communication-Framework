/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import entites.interfaces._Plateforme;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Asus G75
 */
public class Plateforme implements _Plateforme{
       
    private int idPlateforme;
    private String NomPlateforme;
    private ArrayList<Utilisateur> listeUtilisateurs;
    
    public Plateforme(int id, String nom) throws RemoteException {
        this.setIdPlateforme(id);
        this.setNomPlateforme(nom);
        this.setListeUtilisateurs();
    }
    
    public void getAllUserOnPlateform() throws RemoteException {
        for( Utilisateur u : getListeUtilisateurs())
        {
            System.out.println(u.getPseudo());
        }
    }   
    
    @Override
    public void addUser(Utilisateur u) throws RemoteException{
        this.listeUtilisateurs.add(u);
    }
    
    /**
     * @return the NomPlateforme
     */
    @Override
    public String getNomPlateforme() throws RemoteException{
        return NomPlateforme;
    }

    /**
     * @param NomPlateforme the NomPlateforme to set
     */
    @Override
    public void setNomPlateforme(String NomPlateforme) throws RemoteException{
        this.NomPlateforme = NomPlateforme;
    }

    /**
     * @return the listeUtilisateurs
     */
    @Override
    public ArrayList<Utilisateur> getListeUtilisateurs() throws RemoteException{
        return listeUtilisateurs;
    }
    
    @Override
    public void setListeUtilisateurs() throws RemoteException{
        this.listeUtilisateurs =  new ArrayList();
    }

    /**
     * @return the idPlateforme
     */
    @Override
    public int getIdPlateforme() throws RemoteException{
        return idPlateforme;
    }

    /**
     * @param idPlateforme the idPlateforme to set
     */
    @Override
    public void setIdPlateforme(int idPlateforme) throws RemoteException{
        this.idPlateforme = idPlateforme;
    }
    
    /**
     * 
     * @param id l'identifiant d'un utilisateur
     * @return true si l'utilisateur d'identifiant id appartient à la plateforme
     */
    public boolean contientUtilisateur(int id) throws RemoteException{
        for(Utilisateur utilisateur : listeUtilisateurs) {
            if(utilisateur.getId()==id){
                return true;
            }
        }
        return false;
    }
}
