/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputStream;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;

/**
 *
 * @author guezel
 */
public class InuputStreamDelegate extends InputStream implements Serializable{

    private final InputStreamInterface isi;
    
    public InuputStreamDelegate(InputStreamInterface isi) {
        this.isi=isi;
    }
    
    /**
     * Délégation : Fait un appel à la méthode read de InputStreamInterface
     * @return Un entier de 1 à 255 correspondant au prochain octet de donnée,
     * -1 si fin du stream
     * @throws IOException 
     */
    @Override
    public int read() throws IOException {
        return isi.read();
    }
    
    /**
     * Lis len octets d'un tableau d'octets b à partir de l'indice off
     * et retourne le nombre d'octets lus
     * @param b la tableau dans lequel on lit les données
     * @param off l'indice à partir duquel les données sont lus
     * @param len le nombre maximum d'octets à lire
     * @return le nombre d'octets lus, -1 si le tableau d'octets est null
     * @throws IOException 
     */
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        byte[] b2 = isi.read(len);
        if(b2 == null)
        {
            return -1;
        }
        int i = b2.length;
        System.arraycopy(b2, 0, b, off, i);
        return i;
    }
    
    /**
     * Délégation : Appel la méthode close de InputStream
     * @throws IOException 
     */
    @Override
    public void close() throws IOException {
        super.close();
    }
}
