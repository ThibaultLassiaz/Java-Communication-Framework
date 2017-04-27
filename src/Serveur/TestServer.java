package Serveur;

import Serveur.database.DatabaseConnection;
import Serveur.database.DatabaseManager;
import java.io.File;

public class TestServer {

    public static void main(String[] args) throws Exception {
        ServerImplementation server = new ServerImplementation();
        DatabaseConnection dc = new DatabaseConnection();
        //server.setFileToSend(new File("/home/g/guezel/policy.all"));
        DatabaseManager.initializeBD(dc.getConnection());
        DatabaseManager.fillBD(dc.getConnection());
        server.start();
        Thread.sleep(5 * 60 * 1000); // run for 5 minutes
        server.stop();
        System.exit(0);
    }
}