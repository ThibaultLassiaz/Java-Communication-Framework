/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connexionsgbdframework;

import static connexionsgbdframework.RequetesBD.Utilisateur;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author bodiangd
 */
    public class RequetesBD {
    /*Afficher toutes les informations concernannt l'utilsateur,
    les messsages.
    
    */
    public static void initializeBD(Connection conn) throws SQLException{
		Statement stmt = conn.createStatement() ;
               
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
     public static void deleteBD(Connection conn) throws SQLException{
        
        Statement stmt=conn.createStatement();
        
       
        stmt.executeQuery("drop table Utilisateur cascade constraints");
        stmt.executeQuery("drop table Message cascade constraints");
        stmt.executeQuery("drop table Employe cascade constraints");
        stmt.close();
        
        
        
    } 
    
     public static void fillBD(Connection conn) throws SQLException{
         Statement stmt = conn.createStatement() ;
         
         //utlisateur
         stmt.executeQuery("insert into Utilisateur values ('001','bod2','05fls,'26-04-2017')");
         
         //message
         stmt.executeQuery("insert into Message values ('001','salut','26-04-2017,'001')");
         //Employe
         stmt.executeQuery("insert into Employe values('assane',bod','5-10-94','homme','azoub@outlook.com')");
     }   
     public static void Utilisateur(Connection conn) throws SQLException{
           
         Statement stmt=conn.createStatement();
         
         ResultSet rs = stmt.executeQuery("SELECT * FROM Utilisateur") ;
        while( rs.next() ){
             System.out.print("idU : " +rs.getInt(1) + ",   ") ;
             System.out.print("pseudo" +rs.getString(2)+ ",");
             System.out.print("dateCreation" +rs.getDate(3)+",");
             System.out.print("motDePasse"+rs.getString(4)+",");
            
             
             rs.close();
             stmt.close();
             
        }
     }
   /*  public static void Employe (Connection conn) throws SQLException{
                  Statement stmt=conn.createStatement();
                   ResultSet rs = stmt.executeQuery("SELECT * FROM Employe") ;
        while( rs.next() ){
             System.out.print("nom : " +rs.getString(1) + ",   ") ;
             System.out.print("prenom" +rs.getString(2)+ ",");
             System.out.print("dateNaiss" +rs.getDate(3)+",");
             System.out.print("sexe"+rs.getInt(4)+",");
             System.out.print("email"+rs.getString(5)+",");
             
             if (rs.getInt(4)==1){
                 System.out.print("sexe:homme");
                 
            }
             else
             System.out.print("sexe:femme");
             
           
             rs.close();
             stmt.close();
             
                  
        
  
        }
     }
        */
    
   
     
     
        public static void Message(Connection conn) throws SQLException{
            Statement stmt=conn.createStatement();
            ResultSet rs=stmt.executeQuery("SELECT * FROM Message");
            
          while(rs.next()){
            System.out.print("idMess :"+rs.getInt(1)+",");
            System.out.print("message :"+rs.getString(2)+",");
            System.out.print("dateMess :"+rs.getDate(3)+",");
            System.out.print("idU:"+rs.getInt(4)+",");
            
            
            
            rs.close();
            stmt.close();
           
               
        }
        }
        public static void addUtilisateur(Connection conn) throws SQLException{
            int idUt;
            String pseudo;
            String motDePasse;
            String dateCreation;
            
            Scanner scanner = new Scanner(System.in);
		 
            Statement stmt = conn.createStatement() ;
            ResultSet rs1 = stmt.executeQuery("select count(*) from Utilisateur");
                 
                  while(rs1.next()){  
                         idUt= rs1.getInt(1) +1;
                     }
                    rs1.close();
                 
                 System.out.print("Creation d'un utilsateur");
                System.out.println("-----------------------------");
                
                System.out.print("idUtilisateur : ");
	        idUt=scanner.nextInt();
                
                System.out.print("Creer un pseudo : ");
	        pseudo= scanner.next();
	       
                System.out.print("Creer un mot de passe : ");
	        motDePasse= scanner.next();
	        
                
                System.out.print("Saisir date de creation (type: 24-avr-2017)");
                dateCreation=scanner.next();
                 
               
                
                //exceution de la requete
                ResultSet rs = stmt.executeQuery("insert into Utilisateur values(" + idUt + ",'" + pseudo + "','" +  "',"+ motDePasse +"','" + dateCreation + ")" ) ;
               
             rs.close() ;
		 stmt.close();
            
        }
        
        public static void addMessage(Connection conn) throws SQLException{
                int idM;
                String message;
                String dateMess;
                int idUt;
                 Scanner scanner = new Scanner(System.in);
		 
            Statement stmt = conn.createStatement() ;
            ResultSet rs1 = stmt.executeQuery("select count(*) from Message");
            
             System.out.print("Envoi d'un message");
                System.out.println("-----------------------------");
                
                System.out.print("idM : ");
	        idM=scanner.nextInt();
                
                System.out.print("Envoi d'un message : ");
	        message= scanner.next();
	       
                System.out.print("Saisir date de naissance (type: 24-avr-2017)");
	        dateMess= scanner.next();
	        
                
                System.out.print("identfiant destinataire");
                idUt=scanner.nextInt();
                
                
                 //exceution de la requete
                ResultSet rs = stmt.executeQuery("insert into Message values(" + idM + ",'" + message + "','" +  "',"+ dateMess +"','" + idUt + ")" ) ;
               
             rs.close() ;
		 stmt.close();
            
                
                
        }
        
    /*    public static void consulterMessage(Connection conn) throws SQLException{
	int idMess;
	
	Scanner scanner = new Scanner(System.in);
	 
	 Statement stmt = conn.createStatement() ;
	 
	 System.out.println("Messages de l'utilisateur");
     System.out.println("-----------------------------");
     
     System.out.print("Quel est le ID de l'utilisateur : ");
     idMess= scanner.nextInt();
     
     ResultSet rs = stmt.executeQuery("select idUt from Utilisateur where idUt=" + idMess ) ;
     while(rs.next()){
    	 System.out.println("Le message idMess " + idMess + "   : " + rs.getInt(1)); 
     }
     rs.close();
     stmt.close();

     
}
*/
        
      
	 static void afficherMenuPrincipal() {
		System.out.println("");
        System.out.println("            MENU             ");
        System.out.println("-----------------------------");
        System.out.println("");
        System.out.println("    - 1 : Creer la base");
        System.out.println("    - 2 : Remplir la base");
        System.out.println("    - 5 : se Loger");
       // System.out.println("    - 7 : Consulter messages ");
        System.out.println("    - 0 : Quitter");
    }
	 
	 static void tableAVoir(){
		 System.out.println("");
		 System.out.println("          Tables             ");
	     System.out.println("-----------------------------");
	     System.out.println("");
	     System.out.println("    - 1 : table Utilisateur");
	    // System.out.println("    - 2 : table Login");
	     System.out.println("    - 3 : table Message");
	    // System.out.println("    - 4 : table groupe");
             System.out.println("    - 0 : Quitter");
	 }  
        
        
        
    }
