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
public class ClientImplementation extends UnicastRemoteObject implements ClientInterface {

    /**
     *
     * @throws RemoteException
     */

    public ClientImplementation() throws RemoteException {
        super();
    }
}
