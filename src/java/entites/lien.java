/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

/**
 *
 * @author hanene
 */
public class lien {
    private int id;
    private String link;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the link
     */
    public String getLink() {
        return link;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
        //baseUri(link);
    }
}
