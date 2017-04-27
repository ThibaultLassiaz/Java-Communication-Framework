/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionsgbdframework;

import Serveur.database.DatabaseAccessProperties;
import connexionsgbdframework.SQLWarningsExceptions;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 *
 * @author bodiangd
 */
    public class ConnexionSGBDFrameWork {

    /**
     * @param args the command line arguments
     */
    
    
    private static final String configurationFile = "BD.properties";
    
    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        int choix=1, choix2=1, choix3=1;
        int idU;
        
       while(choix!=0){
             RequetesBD.afficherMenuPrincipal();
             Scanner scanner = new Scanner(System.in);
             System.out.println("Faire un choix) : ");
             choix = scanner.nextInt();
     try{
            	 String jdbcDriver, dbUrl, username, password;
            	 DatabaseAccessProperties dap = new DatabaseAccessProperties(configurationFile);
            	 jdbcDriver = dap.getJdbcDriver();
            	 dbUrl = dap.getDatabaseUrl();
            	 username = dap.getUsername();
            	 password = dap.getPassword();
            
            	 if(choix ==0)return;
            // Load the database driver
            	 Class.forName(jdbcDriver);
                    // Get a connection to the database
            	 try (Connection conn = DriverManager.getConnection(dbUrl, username, password)) {
            		 System.out.println("Connectee");
               
                
            	switch(choix){
                
                case 1 : RequetesBD.initializeBD(conn);
                	break;
                
                case 2 : RequetesBD.fillBD(conn);
                	break;
                case 3 :	
                	while(choix2!=0){
                		RequetesBD.tableAVoir();
                		System.out.println("");
                		System.out.println("Faire un choix) : ");
                        choix2 = scanner.nextInt();
                	switch(choix2){
                	case 1 :
                		System.out.println("");
                		System.out.println("Utilisateur : ");
                		RequetesBD.Utilisateur(conn);
                		break;
                	case 2 :
                		System.out.println("");
                		System.out.println("Message : ");
                		RequetesBD.Message(conn);
                		break;
                                
                        case 0 : break;
                	default : break;
                	
       }
                 }
                break;
                case 4 :	
                	while(choix3!=0){
                		RequetesBD.tableAVoir();
                		System.out.println("");
                		System.out.println("Faire un choix : ");
                        choix3 = scanner.nextInt();
                	switch(choix3){
                	case 1 :
                		RequetesBD.addUtilisateur(conn);
                		break;
                	case 2 :
                		RequetesBD.addMessage(conn);
                		break; 
                                
                                case 0 : break;
                	default : break;
                 
      }
               
                 }
                }
                 }
     catch (SQLException se) {
            // Print information about SQL exceptions
            SQLWarningsExceptions.printExceptions(se);
        } 
     }
                 catch (ClassNotFoundException e) {
            System.err.println("Exception classNotFound : " + e.getMessage());
           
        }
       }
    }
    }
  
    
   