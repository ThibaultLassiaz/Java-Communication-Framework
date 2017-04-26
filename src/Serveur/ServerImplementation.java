/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;

import inputStream.RMIInputStreamImplementation;
import inputStream.RMIInuputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import static java.rmi.server.UnicastRemoteObject.unexportObject;
import outputStream.RMIOutputStream;
import outputStream.RMIOutputStreamImplementation;

/**
 *
 * @author guezel
 */
public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {

    private static Registry rmiRegistry;
    private File fileToSend;

    public ServerImplementation() throws RemoteException {        
        super();
    }

    /**
     * Démarre le serveur en créant le registre RMI et en le liant au registre RMI
     * @throws Exception 
     */
    public void start() throws Exception {
        //System.setProperty("java.rmi.server.hostname", "152.77.82.105");
        rmiRegistry = LocateRegistry.createRegistry(1099);
        rmiRegistry.bind("server", this);
        System.out.println("Server started");
    }

    /**
     * 
     * @throws Exception 
     */
    public void stop() throws Exception {
        rmiRegistry.unbind("server");
        unexportObject(this, true);
        unexportObject(rmiRegistry, true);
        System.out.println("Server stopped");
    }
    
    @Override
    public OutputStream getOutputStream(File f) throws IOException, RemoteException {
        return new RMIOutputStream(new RMIOutputStreamImplementation(new FileOutputStream(f)));
    }

    @Override
    public InputStream getInputStream(File f) throws IOException, RemoteException {
        return new RMIInuputStream(new RMIInputStreamImplementation(new FileInputStream(f)));
    }

    @Override
    public File getFileToSend() throws RemoteException {
        return this.fileToSend;
    }
    
    public void setFileToSend(File f) throws RemoteException {
        this.fileToSend=f;
    }
}
