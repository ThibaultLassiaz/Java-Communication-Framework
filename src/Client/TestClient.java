package Client;

import java.io.File;
import java.rmi.Naming;
import Serveur.ServerInterface;
import entites.FileExtended;
import framework.java.Video;

public class TestClient {

    public static void main(String[] args) throws Exception {
        ClientImplementation ci = new ClientImplementation();
        String url = "rmi://localhost/server";
        ServerInterface server = (ServerInterface) Naming.lookup(url);
    }
}
