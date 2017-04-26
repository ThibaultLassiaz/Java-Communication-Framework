package Serveur;

import java.io.File;

public class TestServer {

    public static void main(String[] args) throws Exception {
        ServerImplementation server = new ServerImplementation();
        server.setFileToSend(new File("/home/g/guezel/policy.all"));
        server.start();
        Thread.sleep(5 * 60 * 1000); // run for 5 minutes
        server.stop();
        System.exit(0);
    }
}