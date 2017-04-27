/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Serveur.ServerInterface;

/**
 *
 * @author guezel
 */
public class ClientImplementation extends UnicastRemoteObject implements ClientInterface{
    
    public final static int BUFFER_SIZE = 1024*64;

    public ClientImplementation() throws RemoteException{
        super();
    }
    
    @Override
    public void copy(InputStream is, OutputStream os) throws IOException, RemoteException {
        byte[] b = new byte[BUFFER_SIZE];
        int length;
        while((length=is.read(b)) >= 0)
        {
            os.write(b, 0, length);
        }
        is.close();
        os.close();
    }

    @Override
    public void download(ServerInterface server, File src, File dest) throws IOException, RemoteException {
        copy(server.getInputStream(src), server.getOutputStream(dest));
    }

    @Override
    public void connect(ServerInterface server, String login, String password) throws RemoteException {
        
    }
    
}
