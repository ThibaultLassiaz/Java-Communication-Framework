/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entites.interfaces;

import entites.TypeFichier;
import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Lucas
 */
public interface _FileExtended extends Remote{
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    public int getId() throws RemoteException;
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    public File getFile() throws RemoteException;
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    public String getName() throws RemoteException;
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    public String getPath() throws RemoteException;
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    public long getLastModifiedDate() throws RemoteException;
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    public long getSize() throws RemoteException;
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    public String getExtension() throws RemoteException;
    
    /**
     *
     * @return
     * @throws RemoteException
     */
    public TypeFichier getType() throws RemoteException;
    
    /**
     *
     * @param id
     * @throws RemoteException
     */
    public void setId(int id) throws RemoteException;
    
    /**
     *
     * @param name
     * @throws RemoteException
     */
    public void setName(String name) throws RemoteException;
    
    /**
     *
     * @param path
     * @throws RemoteException
     */
    public void setPath(String path) throws RemoteException;
    
    /**
     *
     * @throws RemoteException
     */
    public void setLastModifiedDate() throws RemoteException;
    
    /**
     *
     * @param size
     * @throws RemoteException
     */
    public void setSize(long size) throws RemoteException;
    
    /**
     *
     * @param extension
     * @throws RemoteException
     */
    public void setExtension(String extension) throws RemoteException;
    
    /**
     *
     * @param type
     * @throws RemoteException
     */
    public void setType(TypeFichier type) throws RemoteException;
    
}
