/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.java;

import entites.Cercle;
import static framework.java.Employe.Sexe.homme;
import java.util.ArrayList;
import java.util.Date;

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
        a2.add(m1);
        
        Cercle c1 = new Cercle<Manager>(a2,"Test");
        Groupe<Employe> g1 = new Groupe<Employe>(a1, "Mon groupe de projet");
        
        System.out.println(g1);
    }
}
