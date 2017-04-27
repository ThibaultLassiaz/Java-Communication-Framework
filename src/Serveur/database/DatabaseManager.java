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

    public static void initializeBD(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            /* stmt.executeQuery("create table Utilisateur (idUt int NULL AUTO_INCREMENT,pseudo varchar(50),nom varchar(50),prenom varchar(50),dateNaiss date(6),sexe varchar(40),"
                        + " constraint uti_c1 primary key (idU),"
                        + " constraint uti_c2 check (sexe='homme' or sexe='femme')");
             */
            stmt.executeQuery("create table Utilisateur (idUt int NULL AUTO_INCREMENT,pseudo varchar(50),motDePasse varchar(50),dateCreation date(8),"
                    + "constraint log_c1 primary key(idUt),");

            stmt.executeQuery("create table Message(idMes int NULL AUTO_INCREMENT,message varchar(50),dateMess date,idUt int(50),"
                    + " constraint mess_c1 primary key(idMess), "
                    + "constraint mess_c2 (idUt) references Utilisateur(idUt))");
            stmt.executeQuery("create table Employe(nom varchar(50),prenom varchar(50),dateNaiss Date(8),sexe varchar(50)"
                    + " email varchar(50),");

            /* stmt.executeQuery("create table groupe(idG int NULL AUTO_INCREMENT,idU int(5),"
                        + "constraint grp_c1 primary key(idG),"
                        + "constraint grp_c2 foreign key(idU) references Utilisateur(idU)");
             */
        }

    }

    public static void deleteBD(Connection conn) throws SQLException {

        try (Statement stmt = conn.createStatement()) {
            stmt.executeQuery("drop table Utilisateur cascade constraints");
            stmt.executeQuery("drop table Message cascade constraints");
            stmt.executeQuery("drop table Employe cascade constraints");
        }

    }

    public static void fillBD(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            //utlisateur
            stmt.executeQuery("insert into Utilisateur values ('001','bod2','05fls,'26-04-2017')");

            //message
            stmt.executeQuery("insert into Message values ('001','salut','26-04-2017,'001')");
            //Employe
            stmt.executeQuery("insert into Employe values('assane',bod','5-10-94','homme','azoub@outlook.com')");
        }

    }

    /**
     * Commit est une procédure permettant de mettre à jour la base de donnée
     * Oracle
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
     * rollback est une procédure permettant d'annuler toutes les modifications
     * jusqu'au précédant commit
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
