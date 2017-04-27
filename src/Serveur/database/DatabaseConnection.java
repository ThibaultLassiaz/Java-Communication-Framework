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

    private static Connection connection;

    public DatabaseConnection() throws SQLException, ClassNotFoundException {
        connection = this.databaseConnection();
    }

    /**
     * Connection to the ORACLE database using the DB.properties file
     *
     * @return The connection established, null otherwise
     * @throws SQLException
     * @throws ClassNotFoundException
     */
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

    /**
     * Check if the login + password tuple exists in the database Synchronised
     * method for future Threading
     *
     * @param conn Connection
     * @param login Potential login
     * @param password Potential password
     * @return true if the tuple exists, false otherwise
     * @throws SQLException
     */
    public synchronized boolean checkAuthenticity(Connection conn, String login, String password) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT idUt FROM Utilisateur WHERE pseudo='" + login + "' AND motDePasse='" + password + "'");
            if (rs.next()) {
                System.out.println("OK");
                return true;
            } else {
                System.out.println("NON");
                return false;
            }
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
