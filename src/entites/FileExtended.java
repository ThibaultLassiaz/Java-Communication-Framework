/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author guezel
 */
public class FileExtended {

    private File file;
    private String name;
    private String path;
    private long lastModifiedDate;
    private long size;
    private String extension;
    private FileTime creationDate;
    private final static List<String> VIDEO_EXTENSION_LIST = new ArrayList() {
        {
            add("mkv");
            add("mp4");
            add("avi");
            add("wmv");
            add("mov");
            add("mpg");
        }
    };

    public FileExtended(File f) throws IOException {
        try {
            this.file = f;
            this.name = f.getName();
            this.path = f.getPath();
            this.lastModifiedDate = f.lastModified();
            this.size = f.length();
            this.extension = this.fileExtension(f);
            this.creationDate = this.creationDate(f);
        } catch (IOException e) {
            System.out.println("Erreur création fichier : " + e.getMessage());
        }

    }

    /**
     * @return the file
     */
    public File getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(File file) {
        this.file = file;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the lastModifiedDate
     */
    public long getLastModifiedDate() {
        return lastModifiedDate;
    }

    /**
     * @param lastModifiedDate the lastModifiedDate to set
     */
    public void setLastModifiedDate(long lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    /**
     * @return the size
     */
    public long getSize() {
        return size;
    }

    /**
     * @param size the size to set
     */
    public void setSize(long size) {
        this.size = size;
    }

    public boolean isFile() {
        return this.getFile().isFile();
    }

    /**
     * Return the extension of a file
     *
     * @param f the file to evaluate
     * @return the extension of the file or "" is there is no one
     */
    private String fileExtension(File f) {
        String n = this.getName();
        if (n.lastIndexOf(".") != -1 && n.lastIndexOf(".") != 0) {
            return n.substring(n.lastIndexOf(".") + 1);
        } else {
            return "";
        }
    }

    /**
     * @return the extension
     */
    public String getExtension() {
        return extension;
    }

    /**
     * @param extension the extension to set
     */
    public void setExtension(String extension) {
        this.extension = extension;
    }

    /**
     *
     * @param f Le fichier dont on veut connaitre la date de création
     * @return Un FileTime correspond à la date de création du fichier
     * @throws IOException
     */
    public FileTime creationDate(File f) throws IOException {
        try {
            Path p = Paths.get(this.getPath());
            BasicFileAttributes attributes = Files.readAttributes(p, BasicFileAttributes.class);
            return attributes.creationTime();
        } catch (IOException e) {
            System.out.println("Erreur détermination date de création du fichier : " + e.getMessage());
            return null;
        }
    }

    /**
     *
     * @return true if the extension is included in VIDEO_EXTENSION_LIST
     */
    public boolean isVideo() {
        return getVIDEO_EXTENSION_LIST().stream().anyMatch((s) -> (this.getExtension().equals(s)));
    }

    /**
     * @return the creationDate
     */
    public FileTime getCreationDate() {
        return this.creationDate;
    }

    /**
     * @param creationDate the creationDate to set
     */
    public void setCreationDate(FileTime creationDate) {
        this.creationDate = creationDate;
    }
    
     /**
     * @return the VIDEO_EXTENSION_LIST
     */
    public static List<String> getVIDEO_EXTENSION_LIST() {
        return VIDEO_EXTENSION_LIST;
    }
}
