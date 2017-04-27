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
public class RMIOutputStream extends OutputStream implements Serializable{

    private final RMIOutputStreamInterface RMIosi;
    
    public RMIOutputStream(RMIOutputStreamInterface RMIosi) {
        this.RMIosi=RMIosi;
    }
    
    /**
     * Délégation : Appel à la méthode write de RMIOutputStreamInterface
     * @param b l'octet à écrire
     * @throws IOException 
     */
    @Override
    public void write(int b) throws IOException {
        RMIosi.write(b);
    }
    
    /**
     * Délégation : Appel à la méthode write de RMIOutputStreamInterface
     * @param b les données
     * @param off l'indice
     * @param len le nombre d'octets à écrire
     * @throws IOException 
     */
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        RMIosi.write(b, off, len);
    }
    
    /**
     * Délégation : Appel à la méthode close de RMIOutputStreamInterface
     * @throws IOException 
     */
    @Override
    public void close() throws IOException {
        RMIosi.close();
    }
    
}
