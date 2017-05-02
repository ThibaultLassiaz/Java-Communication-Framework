/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;

import Serveur.database.DatabaseConnection;
import entites.FileExtended;
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
    private static DatabaseConnection dc;
    private File fileToSend;
    public final static int BUFFER_SIZE = 1024 * 64;

    public ServerImplementation() throws RemoteException, SQLException, ClassNotFoundException {
        super();
        dc = new DatabaseConnection();
    }

    /**
     * Démarre le serveur en créant le registre RMI et en le liant au registre
     * RMI
     *
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
     * Démarre le serveur en créant le registre RMI et en le liant au registre
     * RMI
     *
     * @param ip l'adresse ip du serveur
     * @param port le port du registre rmi
     * @throws Exception
     */
    public void start(String ip, int port) throws Exception {
        System.setProperty("java.rmi.server.hostname", ip);
        rmiRegistry = LocateRegistry.createRegistry(port);
        rmiRegistry.bind("server", this);
        System.out.println("Server started");
    }

    /**
     * Retire le serveur du registre RMI
     *
     * @throws Exception
     */
    public void stop() throws Exception {
        rmiRegistry.unbind("server");
        unexportObject(this, true);
        unexportObject(rmiRegistry, true);
        System.out.println("Server stopped");
    }

    /**
     * Renvoie l'outputstream prévu pour la délégation pour un fichier donné
     *
     * @return L'outputstream de délégation
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public OutputStream getOutputStream(FileExtended fe) throws IOException, RemoteException {
        return new OutputStreamDelegate(new OutputStreamImplementation(new FileOutputStream(fe.getFile())));
    }

    /**
     * Renvoie l'inputstream prévu pour la délégation pour un fichier donné
     *
     * @return L'inputstream de délégation
     * @throws IOException
     * @throws RemoteException
     */
    @Override
    public InputStream getInputStream(FileExtended fe) throws IOException, RemoteException {
        return new InuputStreamDelegate(new InputStreamImplementation(new FileInputStream(fe.getFile())));
    }

    /**
     * Renvoie le fichier à envoyer sur un client
     *
     * @return Le fichier à envoyer
     * @throws RemoteException
     */
    @Override
    public File getFileToSend() throws RemoteException {
        return this.fileToSend;
    }

    /**
     * Enregistre le fichier à envoyer
     *
     * @param f Le fichier à envoyer
     * @throws RemoteException
     */
    public void setFileToSend(File f) throws RemoteException {
        this.fileToSend = f;
    }

    /**
     *
     * @param login le potentiel login
     * @param password le potentiel mot de passe
     * @return
     * @throws RemoteException
     * @throws SQLException
     */
    @Override
    public boolean connect(String login, String password) throws RemoteException, SQLException {
        return dc.checkAuthenticity(dc.getConnection(), login, password);
    }

    /**
     * @return the connection
     */
    public static DatabaseConnection getConnection() {
        return dc;
    }

    public void copy(InputStream is, OutputStream os) throws IOException, RemoteException {
        byte[] b = new byte[BUFFER_SIZE];
        int length;
        while ((length = is.read(b)) >= 0) {
            os.write(b, 0, length);
        }
        is.close();
        os.close();
    }

    @Override
    public void uploadFichier(FileExtended fe) throws IOException, RemoteException {
        this.copy(this.getInputStream(fe), this.getOutputStream(new FileExtended(new File("D:\\RMI\\upload.mp4"))));
        // Appeler insert pour mettre les infos du fichier en bd
    }
    
    public void downloadFichier(String nomFichier) throws IOException, RemoteException {
        // Appeler select pour recuperer le fichier
        FileExtended fe = null;
        // Récupérer le fichier sur le server
        this.copy(this.getInputStream(fe), this.getOutputStream(fe));
    }

}
