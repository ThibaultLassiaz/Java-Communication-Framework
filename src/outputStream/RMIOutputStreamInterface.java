/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outputStream;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author guezel
 */
public interface RMIOutputStreamInterface extends Remote {

    /**
     * Ecrit un octet b précis dans l'OutputStream
     * @param b l'octet à écrire
     * @throws IOException
     * @throws RemoteException 
     */
    public void write(int b) throws IOException, RemoteException;

    /**
     * Ecrit len octets des données b à partir de l'indice off dans l'OutputStream
     * @param b les données
     * @param off l'indice
     * @param len le nomre d'octets à écrire
     * @throws IOException
     * @throws RemoteException 
     */
    public void write(byte[] b, int off, int len) throws IOException, RemoteException;

    /**
     * Ferme l'OutputStream
     * @throws IOException
     * @throws RemoteException 
     */
    public void close() throws IOException, RemoteException;
}
