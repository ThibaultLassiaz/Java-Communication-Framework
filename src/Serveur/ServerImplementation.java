/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;

import Serveur.database.DatabaseConnection;
import inputStream.InputStreamImplementation;
import inputStream.InuputStreamDelegate;
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
import java.sql.SQLException;
import outputStream.OutputStreamDelegate;
import outputStream.OutputStreamImplementation;

/**
 *
 * @author guezel
 */
public class ServerImplementation extends UnicastRemoteObject implements ServerInterface {

    private static Registry rmiRegistry;
    private static DatabaseConnection connection;

    /**
     * @return the connection
     */
    public static DatabaseConnection getConnection() {
        return connection;
    }
    private File fileToSend;

    public ServerImplementation() throws RemoteException, SQLException, ClassNotFoundException {        
        super();
        connection = new DatabaseConnection();
    }

    /**
     * Démarre le serveur en créant le registre RMI et en le liant au registre RMI
     * @param ip l'adresse ip du serveur
     * @throws Exception 
     */
    public void start(String ip) throws Exception {
        System.setProperty("java.rmi.server.hostname", ip);
        rmiRegistry = LocateRegistry.createRegistry(1099);
        rmiRegistry.bind("server", this);
        System.out.println("Server started");
    }

    /**
     * Démarre le serveur en créant le registre RMI et en le liant au registre RMI
     * @param ip l'adresse ip du serveur
     * @param port le port du registre rmi
     * @throws Exception 
     */
    public void start(String ip, int port) throws Exception {
        System.setProperty("java.rmi.server.hostname", ip);
        rmiRegistry = LocateRegistry.createRegistry(port);
        connection = new DatabaseConnection();
        rmiRegistry.bind("server", this);
        System.out.println("Server started");
    }
    
    /**
     * Retir le serveur du registre RMI
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
        return new OutputStreamDelegate(new OutputStreamImplementation(new FileOutputStream(f)));
    }

    @Override
    public InputStream getInputStream(File f) throws IOException, RemoteException {
        return new InuputStreamDelegate(new InputStreamImplementation(new FileInputStream(f)));
    }

    @Override
    public File getFileToSend() throws RemoteException {
        return this.fileToSend;
    }
    
    public void setFileToSend(File f) throws RemoteException {
        this.fileToSend=f;
    }

    @Override
    public boolean connect(String login, String password) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
