package Client;

import java.io.File;
import java.rmi.Naming;
import Serveur.ServerInterface;

public class TestClient {

    public static void main(String[] args) throws Exception {
        ClientImplementation ci = new ClientImplementation();
        String url = "rmi://localhost/server";
        ServerInterface server = (ServerInterface) Naming.lookup(url);

        ci.download(server, server.getFileToSend(), new File("/home/g/guezel/download.all"));
        System.exit(0);
    }
}
