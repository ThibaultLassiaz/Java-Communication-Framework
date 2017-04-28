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
        
        FileExtended test = new FileExtended(new File("/home/g/guezel/Téléchargements/test.mp4"));
        if(test.isVideo())
        {
            Video vid = new Video(new File("/home/g/guezel/Téléchargements/test.mp4"));
            System.out.println(vid.getExtension());
        }
        else
            System.out.println("pas vidéo");

        //ci.download(server, server.getFileToSend(), new File("/home/g/guezel/download.all"));
        
    }
}
