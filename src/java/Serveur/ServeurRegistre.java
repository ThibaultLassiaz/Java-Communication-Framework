/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author hanene
 */
public class ServeurRegistre {
   /* public static void main(String[] args) {
try {
    LocateRegistry.createRegistry(1099);
    System.out.println("Mise en place du Security Manager ...");
    if (System.getSecurityManager() == null) {
    System.setSecurityManager(new RMISecurityManager());
}
 
ServeurImplementation serveurImplementation = new ServeurImplementation();
String url = "rmi://" + InetAddress.getLocalHost().getHostAddress() + "/TestRMI";
System.out.println("Enregistrement de l'objet avec l'url : " + url);
Naming.rebind(url, serveurImplementation);
 
System.out.println("Serveur lancé");
} catch (RemoteException e) {
e.printStackTrace();
} catch (MalformedURLException e) {
e.printStackTrace();
} catch (UnknownHostException e) {
e.printStackTrace();
}
}*/
}
