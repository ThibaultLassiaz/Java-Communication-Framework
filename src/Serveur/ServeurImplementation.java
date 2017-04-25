/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;
import java.io.Serializable;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
/**
 *
 * @author hanene
 */
public class ServeurImplementation extends UnicastRemoteObject implements ServeurInterface{
    
    private static final long serialVersionUID = 2674880711467464646L;
    
    protected ServeurImplementation() throws RemoteException{
        super();
        
    }
   
}
