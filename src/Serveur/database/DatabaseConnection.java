/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lucas
 */
public class DatabaseConnection {

    private static final String configureFile = "BD.properties";

    private final Connection connection;

    public DatabaseConnection() throws SQLException, ClassNotFoundException {
        this.connection = this.databaseConnection();
    }

    private Connection databaseConnection() throws SQLException, ClassNotFoundException {
        try {
            String jdbcDrive, dbUrl, username, password;
            DatabaseAccessProperties dab = new DatabaseAccessProperties(getConfigureFile());
            jdbcDrive = dab.getJdbcDriver();
            dbUrl = dab.getDatabaseUrl();
            username = dab.getUsername();
            password = dab.getPassword();
            Class.forName(jdbcDrive);

            return DriverManager.getConnection(dbUrl, username, password);
        } catch (SQLException e) {
            System.out.println("Erreur lors de la connexion à la base de données : " + e.getMessage());
            return null;
        }

    }

    public synchronized boolean checkAuthenticity(Connection conn, String login, String password) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT idUt FROM Utilisateur WHERE login='" + login + "' AND password='" + password + "'");
            return rs.next();
        } catch (SQLException e) {
            System.out.println("Erreur de connexion : " + e.getMessage());
            DatabaseManager.rollback(this.getConnection());
            return false;
        }
    }

    /**
     * @return the configureFile
     */
    public static String getConfigureFile() {
        return configureFile;
    }

    /**
     * @return the connection
     */
    public Connection getConnection() {
        return connection;
    }
}
