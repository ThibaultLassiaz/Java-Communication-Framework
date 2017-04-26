/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connexionsgbdframework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author bodiangd
 */

public class DatabaseAccessProperties {
    private Properties prop = new Properties();
    private final String jdbcDriver;
    private final String dbUrl;
    private final String username, password;
    
    public DatabaseAccessProperties(String propertiesFile) {
        try {
            prop = new Properties();
            prop.load(new FileInputStream(propertiesFile));
        } catch (FileNotFoundException e) {
            System.err.println( "FileNotFoundException: "+ e.getMessage());
        } catch (IOException e) {
            System.err.println( "IOException: " +e.getMessage()) ;
        }
        jdbcDriver = prop.getProperty("jdbc.driver");
        dbUrl = prop.getProperty("database.url");
        username = prop.getProperty("database.username");
        password = prop.getProperty("database.password");
    }
    
    public String getJdbcDriver() {
        return jdbcDriver;
    }
    
    public String getDatabaseUrl() {
        return dbUrl;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
}