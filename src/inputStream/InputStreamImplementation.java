/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputStream;

import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author guezel
 */
public class RMIInputStreamImplementation implements RMIInputStreamInterface{
    
    private final InputStream is;
    private byte[] b;
    
    public RMIInputStreamImplementation(InputStream is) throws IOException {
        this.is=is;
        UnicastRemoteObject.exportObject(this, 1099);
    }

    /**
     * Lit un nombre d'octets dans un InputStream
     * Si un nombre d'octets inférieur à length est lu, le tableau renvoyé
     * aura une nouvelle taille égale au nombre d'octets réellement lus
     * @param length Le nombre d'octets à lire
     * @return les données lues, null si la fin est atteinte
     * @throws IOException
     * @throws RemoteException 
     */
    @Override
    public byte[] read(int length) throws IOException, RemoteException {
        if(b==null||b.length!=length)
        {
            b = new byte[length];
        }
        int length2 = is.read(b);
        if(length2 < 0)
            return null;
        if(length2!=length)
        {
            byte[] b2 = new byte[length2];
            System.arraycopy(b, 0, b2, 0, length2);
            return b2;
        }
        else 
        {
            return b;
        }
    }

    /**
     * Délégation : Fait un appel à la méthode read de InputStream
     * @return Un entier de 1 à 255 correspondant au prochain octet de donnée,
     * -1 si fin du stream
     * @throws IOException
     * @throws RemoteException 
     */
    @Override
    public int read() throws IOException, RemoteException {
        return is.read();
    }

    /**
     * Délégation : Fait un appel à la méthode close de InputStream
     * @throws IOException
     * @throws RemoteException 
     */
    @Override
    public void close() throws IOException, RemoteException {
        is.close();
    }
}
