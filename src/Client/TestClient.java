package Client;

import java.io.File;
import java.rmi.Naming;
import Serveur.ServerInterface;
import entites.FileExtended;

public class TestClient {

    public static void main(String[] args) throws Exception {
        //ClientImplementation ci = new ClientImplementation();
        String url = "rmi://localhost/server";
        ServerInterface server = (ServerInterface) Naming.lookup(url);
        FileExtended fe = new FileExtended(new File("C:\\Users\\Lucas\\Pictures\\Camera Roll\\test.mp4"));
        server.uploadFichier(fe);
    }
}
