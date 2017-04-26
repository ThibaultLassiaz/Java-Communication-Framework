/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package framework.java;

import entites.Cercle;
import entites.Employe;
import java.util.ArrayList;

/**
 *
 * @author Asus G75
 */
public class FrameworkJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Employe e1 = new Employe(1, "Thibault", "Test");
        Employe e2 = new Employe(2, "Hanene", "Test1");
        Manager m1 = new Manager(4, "Bapt", "Teeeest");
        
        ArrayList<Employe> a1 = new ArrayList<Employe>();
        a1.add(e1);
        a1.add(e2);
        
        ArrayList<Employe> a2 = new ArrayList<Employe>();
        
        Employe u1 = new Employe(3, "Thivault", "Test1");
        
        a2.add(m1);
        a2.add(e1);
        
        Groupe g1 = new Groupe(a2, "Mon groupe de projet");
        
        System.out.println(g1);
    }
    
}
