package Serveur;

import Serveur.database.DatabaseConnection;
import Serveur.database.DatabaseSQLRunner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class TestServer {

    public static void main(String[] args) throws Exception {
        ServerImplementation server = new ServerImplementation();
        DatabaseConnection dc = ServerImplementation.getConnection();
        DatabaseSQLRunner sqlrunner = new DatabaseSQLRunner(dc.getConnection());
        sqlrunner.runSQLScript(new BufferedReader(new FileReader("chemin_script_sql.sql")));
        /*DatabaseManager.deleteBD(dc.getConnection());
        DatabaseManager.initializeBD(dc.getConnection());
        DatabaseManager.fillBD(dc.getConnection());*/
        server.start("localhost");
        /*Thread.sleep(5 * 60 * 1000); // run for 5 minutes
        server.stop();
        System.exit(0);*/
    }
}
