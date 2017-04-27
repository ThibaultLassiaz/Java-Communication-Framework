/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author guezel
 */
public class OutputStreamImplementation implements OutputStreamInterface{

    private final OutputStream os;
    
    public OutputStreamImplementation(OutputStream os) throws IOException {
        this.os=os;
        UnicastRemoteObject.exportObject(this, 1099);
    }
    
    /**
     * Délégation : Appel la méthode write de OutputStream
     * @param b l'octet à écrire
     * @throws IOException
     * @throws RemoteException 
     */
    @Override
    public void write(int b) throws IOException, RemoteException {
        os.write(b);
    }

    /**
     * Délégation : Appel à la méthode write de OutputStream
     * @param b les données à écrire
     * @param off l'indice à partir duquel on écrit les données de b
     * @param len le nombre d'octets à écrire
     * @throws IOException
     * @throws RemoteException 
     */
    @Override
    public void write(byte[] b, int off, int len) throws IOException, RemoteException {
        os.write(b, off, len);
    }

    /**
     * Délégation : Appel à la méthode close du OutputStream
     * @throws IOException
     * @throws RemoteException 
     */
    @Override
    public void close() throws IOException, RemoteException {
        os.close();
    }
    
}
