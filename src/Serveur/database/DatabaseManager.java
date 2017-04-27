/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Lucas
 */
public class DatabaseManager {

    /**
     * Initialize database with create tables
     *
     * @param conn Connection
     * @throws SQLException
     */
    public static void initializeBD(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            stmt.executeQuery("create table Utilisateur(idUt int PRIMARY KEY, pseudo varchar(50), motDePasse varchar(50), dateCreation date)");

            stmt.executeQuery("create table Message(idMes int PRIMARY KEY, message varchar(50), dateMess date, expediteur int, destinataire int, "
                    + "constraint expediteur foreign key(expediteur) references Utilisateur(idUt), "
                    + "constraint destinataire foreign key(destinataire) references Utilisateur(idUt))");

            commit(conn);
            System.out.println("Initialized");
        } catch (SQLException e) {
            System.out.println("Erreur de création de la base : " + e.getMessage());
        }

    }

    /**
     * Drop every table of the database
     *
     * @param conn Connection
     * @throws SQLException
     */
    public static void deleteBD(Connection conn) throws SQLException {

        try (Statement stmt = conn.createStatement()) {
            stmt.executeQuery("drop table Utilisateur cascade constraints");
            stmt.executeQuery("drop table Message cascade constraints");

            commit(conn);
            System.out.println("Deleted");
        } catch (SQLException e) {
            rollback(conn);
            System.out.println("Erreur de destruction de base : " + e.getMessage());
        }

    }

    /**
     * Fills the database with inserts
     *
     * @param conn Connection
     * @throws SQLException
     */
    public static void fillBD(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            //utlisateur
            stmt.executeQuery("insert into Utilisateur values (1, 'bod2', '05fls' , to_date('2017-04-26','yyyy-MM-dd'))");
            stmt.executeQuery("insert into Utilisateur values (2, 'connard', 'enassa', to_date('2017-04-26','yyyy-MM-dd'))");

            //message
            stmt.executeQuery("insert into Message values (1, 'salut', to_date('2017-04-26','yyyy-MM-dd'), 1, 2)");

            commit(conn);
            System.out.println("Filled");
        } catch (SQLException e) {
            rollback(conn);
            System.out.println("Erreur de remplissage de la table : " + e.getMessage());
        }

    }

    /**
     * Commit in ORACLE
     *
     * @param conn Connection
     */
    public static void commit(Connection conn) {
        try {
            try (Statement stmt = conn.createStatement()) {
                stmt.executeQuery("commit");
            }
        } catch (SQLException E) {
            System.out.println("Erreur commit: " + E.getMessage());
        }
    }

    /**
     * Rollback in ORACLE
     *
     * @param conn Connection
     */
    public static void rollback(Connection conn) {
        try {
            try (Statement stmt = conn.createStatement()) {
                stmt.executeQuery("rollback");
            }
        } catch (SQLException E) {
            System.out.println("Erreur rollback: " + E.getMessage());
        }
    }
}
