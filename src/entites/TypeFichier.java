/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author guezel
 */
public enum TypeFichier {

    /**
     *
     */
    V("Video"),

    /**
     *
     */
    T("Texte"),

    /**
     *
     */
    I("Inconnu");
    
    private String type="";

    TypeFichier(String type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return this.type;
    }
}
