/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.java;

import entites.Cercle;
import entites.Lien;
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
        a2.add(m1);
        
        Cercle c1 = new Cercle<Manager>(a2,"Test");
        Groupe<Employe> g1 = new Groupe<Employe>(a1, "Mon groupe de projet");
        
        System.out.println(g1);
        
        // L'employé Thibault est ami avec le manager Bapt
        Amitie am1 = new Amitie(e1,m1);
        Map map = new HashMap<Integer,Amitie>();
        // A l'emplacement 1, on a l'amitié entre Thibault et Bapt
        map.put(1, am1);
        Lien<Amitie> l1 = new Lien(map);
        l1.getM().put(2, am1);
        
        
    }
}
