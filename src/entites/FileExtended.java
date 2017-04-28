/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guezel
 */
public class FileExtended implements Serializable {

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
    public int getId() {
        return id;
    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @return the lastModifiedDate
     */
    public long getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * @return the size
     */
    public long getSize() {
        return size;
    }

    /**
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @return the type
     */
    public TypeFichier getType() {
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
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     */
    public void setLastModifiedDate() {
        this.lastModifiedDate = this.file.lastModified();
    }

    /**
     * @param size the size to set
     */
    public void setSize(long size) {
        this.size = size;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    private void fileExtension() {
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

    private void type() {
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
    public boolean isVideo() {
        return getVIDEO_EXTENSIONS().stream().anyMatch((s) -> (this.getExtension().equals(s)));
    }

    /**
     *
     * @return vrai si l'extension est présente dans la TEXTFILE_EXTENSION_LIST
     */
    public boolean isText() {
        return getTEXT_EXTENSIONS().stream().anyMatch((s) -> (this.getExtension().equals(s)));
    }

    public void addVideoExtension(String ext) {
        getVIDEO_EXTENSIONS().add(ext);
    }

    public void addTextExtension(String ext) {
        getTEXT_EXTENSIONS().add(ext);
    }

}
