/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author guezel
 */
public interface ServerInterface extends Remote {

    /**
     * Renvoie le fichier à écrire sur le client
     * @return le fichier à écrire
     * @throws RemoteException 
     */
    public File getFileToSend() throws RemoteException;

    /**
     * Renvoie un OutputStream correspondant au fichier à écrire sur le client
     * @param f le fichier à écrire
     * @return l'OutputStream
     * @throws IOException
     * @throws RemoteException 
     */
    public OutputStream getOutputStream(File f) throws IOException, RemoteException;

    /**
     * Renvoie un InputStream correspondant au fichier à écrire sur le client
     * @param f le fichier à écrire
     * @return l'InputStream
     * @throws IOException
     * @throws RemoteException 
     */
    public InputStream getInputStream(File f) throws IOException, RemoteException;
    
    public boolean connect(String login, String password) throws RemoteException;

}
