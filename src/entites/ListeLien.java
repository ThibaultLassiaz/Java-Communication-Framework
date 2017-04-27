/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;
import java.util.ArrayList;

/**
 *
 * @author Asus G75
 */
public class ListeLien<T> {
    
    private ArrayList<T> listelien;

    public ListeLien() {
        this.InstanceListeLien();
    }
    
    public void AddLienToList(T valeur) {
        this.listelien.add(valeur);
    }
    
    public void InstanceListeLien() {
        this.listelien = new ArrayList();
    }

    /**
     * @return the listeliaison
     */
    public ArrayList<T> getListelien() {
        return listelien;
    }
    
    
    
}