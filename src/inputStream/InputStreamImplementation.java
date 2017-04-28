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
public class InputStreamImplementation implements InputStreamInterface{
    
    private final InputStream is;
    private byte[] data;
    
    public InputStreamImplementation(InputStream is) throws IOException {
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
        if(data==null||data.length!=length)
        {
            data = new byte[length];
        }
        int realLength = is.read(data);
        if(realLength < 0)
            return null;
        if(realLength!=length)
        {
            byte[] realData = new byte[realLength];
            System.arraycopy(data, 0, realData, 0, realLength);
            return realData;
        }
        else 
        {
            return data;
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
