/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputStream;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author guezel
 */
public interface InputStreamInterface extends Remote {
    /**
     * Lit un nombre d'octets dans un InputStream
     * @param length le nombre d'octets à lire
     * @return les données lues
     * @throws IOException
     * @throws RemoteException 
     */
    public byte[] read(int length) throws IOException, RemoteException;

    /**
     * Lit le prochain octet de donnée dans un InputStream
     * @return le prochain octet de donnée, -1 si la fin du stream est atteinte
     * @throws IOException
     * @throws RemoteException 
     */
    public int read() throws IOException, RemoteException;

    /**
     * Ferme l'InputStream
     * @throws IOException
     * @throws RemoteException 
     */
    public void close() throws IOException, RemoteException;
}
