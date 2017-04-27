/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package outputStream;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;

/**
 *
 * @author guezel
 */
public class OutputStreamDelegate extends OutputStream implements Serializable{

    private final OutputStreamInterface osi;
    
    public OutputStreamDelegate(OutputStreamInterface osi) {
        this.osi=osi;
    }
    
    /**
     * Délégation : Appel à la méthode write de OutputStreamInterface
     * @param b l'octet à écrire
     * @throws IOException 
     */
    @Override
    public void write(int b) throws IOException {
        osi.write(b);
    }
    
    /**
     * Délégation : Appel à la méthode write de OutputStreamInterface
     * @param b les données
     * @param off l'indice
     * @param len le nombre d'octets à écrire
     * @throws IOException 
     */
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        osi.write(b, off, len);
    }
    
    /**
     * Délégation : Appel à la méthode close de OutputStreamInterface
     * @throws IOException 
     */
    @Override
    public void close() throws IOException {
        osi.close();
    }
    
}
