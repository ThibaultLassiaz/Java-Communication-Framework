/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//import javax.ws.rs.core;
package entites;

/**
 *
 * @author hanene
 */
public class Video {
    private int id;
    private String video;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the link
     */
    public String getVideo() {
        return video;
    }

    /**
     * @param link the link to set
     */
    public void setLink(String video) {
        this.video = video;
        
    }
    
    
    
}
