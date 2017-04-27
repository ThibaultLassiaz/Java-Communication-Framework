/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.java;

import entites.Cercle;
import entites.Lien;
import entites.ListeLien;
import entites.Utilisateur;
import static framework.java.Employe.Sexe.homme;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Asus G75
 */
public class FrameworkJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
          
        ArrayList<Employe> a1 = new ArrayList<Employe>();
        Employe e1 = new Employe(1, "Thibault", "Test", "prenom", "nom", new Date(), homme , "Test@gmail.com"); 
        a1.add(e1);
        
        ArrayList<Manager> a2 = new ArrayList<Manager>();
        Manager m1 = new Manager(4, "Bapt", "Teeeest");
        Manager m2 = new Manager(5, "Hello", "Teeeest");
        a2.add(m1);
        
        Cercle c1 = new Cercle<Manager>(a2,"Test");
        Groupe<Employe> g1 = new Groupe<Employe>(a1, "Mon groupe de projet");
        
        System.out.println(g1);
        
        /*
        // L'employé Thibault est ami avec le manager Bapt
        Amitie am1 = new Amitie(e1,m1);
        Map map = new HashMap<Integer,Amitie>();
        // A l'emplacement 1, on a l'amitié entre Thibault et Bapt
        map.put(1, am1);
        ListeLiens<Amitie> l1 = new ListeLiens(map);
        l1.getM().put(2, am1);
        
        ArrayList<Amitie> ar1 = new ArrayList();
        ar1.push(am1);
        Utilisateur.setLien(new ArrayList<ArrayList>());
        */      
        Amitie am1 = new Amitie(e1,m1);
        Amitie am2 = new Amitie(e1,m2);
        Famille fm1 = new Famille(e1,m1);
        
        ArrayList<Amitie> arm = new ArrayList();
        arm.add(am1);
        arm.add(am2);
        
        ListeLien<Amitie> l1 = new ListeLien();
        l1.AddLienToList(am2);
        

        e1.InitTousLesLiens(l1); 
        
        Canal canal1 = new Canal("Bonjour");
        canal1.setListeUtilisateurs();
        
        Utilisateur u5 = new Utilisateur(6,"Le petit génie", "Drogue_dure");
        canal1.addUser(u5);
    }
}
