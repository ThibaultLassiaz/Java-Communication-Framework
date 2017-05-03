/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import entites.interfaces._FileExtended;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author guezel
 */
public class FileExtended implements Serializable, _FileExtended {

    private int id;
    private final File file;
    private String name;
    private String path;
    private long lastModifiedDate;
    private long size;
    private String extension;
    private TypeFichier type;
    private static final List<String> VIDEO_EXTENSIONS = new ArrayList() {
        {
            add("mkv");
            add("mp4");
            add("avi");
            add("wmv");
            add("mov");
            add("mpg");
        }
    };

    private static final List<String> TEXT_EXTENSIONS = new ArrayList() {
        {
            add("txt");
            add("doc");
            add("docx");
        }
    };

    public FileExtended(File f) throws IOException {
        this.file = f;
        this.name = f.getName();
        this.path = f.getPath();
        this.size = f.length();
        this.lastModifiedDate = f.lastModified();
        this.fileExtension();
        this.type();

    }

    // Getters
    /**
     * @return the id
     */
    @Override
    public int getId() throws RemoteException{
        return id;
    }

    /**
     * @return the file
     */
    @Override
    public File getFile() throws RemoteException{
        return file;
    }

    /**
     * @return the name
     */
    @Override
    public String getName() throws RemoteException{
        return name;
    }

    /**
     * @return the path
     */
    @Override
    public String getPath() throws RemoteException{
        return path;
    }

    /**
     * @return the lastModifiedDate
     */
    @Override
    public long getLastModifiedDate() throws RemoteException{
        return lastModifiedDate;
    }

    /**
     * @return the size
     */
    @Override
    public long getSize() throws RemoteException{
        return size;
    }

    /**
     * @return the extension
     */
    @Override
    public String getExtension() throws RemoteException{
        return extension;
    }

    /**
     * @return the type
     */
    @Override
    public TypeFichier getType() throws RemoteException{
        return type;
    }

    /**
     * @return the VIDEO_EXTENSION_LIST
     */
    public static List<String> getVIDEO_EXTENSIONS() {
        return VIDEO_EXTENSIONS;
    }

    /**
     * @return the TEXTFILE_EXTENSION_LIST
     */
    public static List<String> getTEXT_EXTENSIONS() {
        return TEXT_EXTENSIONS;
    }

    // Setters
    /**
     * @param id the id to set
     */
    @Override
    public void setId(int id) throws RemoteException{
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    @Override
    public void setName(String name) throws RemoteException{
        this.name = name;
    }

    /**
     * @param path the path to set
     */
    @Override
    public void setPath(String path) throws RemoteException{
        this.path = path;
    }

    /**
     */
    @Override
    public void setLastModifiedDate() throws RemoteException{
        this.lastModifiedDate = this.file.lastModified();
    }

    /**
     * @param size the size to set
     */
    @Override
    public void setSize(long size) throws RemoteException{
        this.size = size;
    }

    /**
     * @param extension the extension to set
     */
    @Override
    public void setExtension(String extension) throws RemoteException{
        this.extension = extension;
    }

    private void fileExtension() throws RemoteException {
        String n = this.getName();
        if (n.lastIndexOf(".") != -1 && n.lastIndexOf(".") != 0) {
            this.setExtension(n.substring(n.lastIndexOf(".") + 1));
        } else {
            this.setExtension("");
        }
    }

    /**
     * @param type the type to set
     */
    public void setType(TypeFichier type) {
        this.type = type;
    }

    private void type() throws RemoteException {
        if (this.isVideo()) {
            this.setType(TypeFichier.V);
        } else if (this.isText()) {
            this.setType(TypeFichier.T);
        } else {
            this.setType(TypeFichier.I);
        }
    }

    /**
     *
     * @return vrai si l'extension est présente dans la VIDEO_EXTENSION_LIST
     */
    public boolean isVideo() throws RemoteException{
        return getVIDEO_EXTENSIONS().stream().anyMatch((s) -> {
            try {
                this.getExtension().equals(s);
            } catch (RemoteException ex) {
                Logger.getLogger(FileExtended.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        });
        
    }

    /**
     *
     * @return vrai si l'extension est présente dans la TEXTFILE_EXTENSION_LIST
     */
    public boolean isText() {
        return getTEXT_EXTENSIONS().stream().anyMatch((s) -> {
            try {
                this.getExtension().equals(s);
            } catch (RemoteException ex) {
                Logger.getLogger(FileExtended.class.getName()).log(Level.SEVERE, null, ex);
            }
            return false;
        });
    }

    public void addVideoExtension(String ext) {
        getVIDEO_EXTENSIONS().add(ext);
    }

    public void addTextExtension(String ext) {
        getTEXT_EXTENSIONS().add(ext);
    }

}
