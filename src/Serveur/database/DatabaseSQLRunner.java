/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Serveur.database;

import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Lucas
 */
public class DatabaseSQLRunner {

    private static final String DEFAULT_DELITIMITER = ";";
    private static final String DELIMITER_LINE_REGEX = "(?i)DELIMITER.+";
    private static final String DELIMITER_LINE_SPLIT_REGEX = "(?i)DELIMITER";

    private final Connection conn;
    private String delimiter = DEFAULT_DELITIMITER;

    public DatabaseSQLRunner(Connection conn) {
        if (conn == null) {
            throw new RuntimeException("Il faut que la connexion à la bdd soit effectuée");
        }

        this.conn = conn;
    }
    
    public void runSQLScript(Reader reader) throws IOException, SQLException {
        runSQLScript(conn, reader);
    }

    private void runSQLScript(Connection conn, Reader reader) throws IOException, SQLException {
        StringBuffer command = null;
        try {
            LineNumberReader lineReader = new LineNumberReader(reader);
            String line;
            while ((line = lineReader.readLine()) != null) {
                if (command == null) {
                    command = new StringBuffer();
                }

                String trimmedLine = line.trim();
                if (trimmedLine.length() < 1 || trimmedLine.startsWith("//")) {
                } else if (trimmedLine.length() < 1 || trimmedLine.startsWith("--")) {
                } else if (trimmedLine.endsWith(getDelimiter()) || trimmedLine.equals(getDelimiter())) {
                    Pattern p = Pattern.compile(DELIMITER_LINE_REGEX);
                    Matcher m = p.matcher(trimmedLine);
                    if (m.matches()) {
                        setDelimiter(trimmedLine.split(DELIMITER_LINE_SPLIT_REGEX)[1].trim());
                        line = lineReader.readLine();
                        if (line == null) {
                            break;
                        }

                        trimmedLine = line.trim();
                    }
                    command.append(line.substring(0, line.lastIndexOf(getDelimiter())));
                    command.append(" ");
                    Statement stmt = conn.createStatement();
                    try {
                        stmt.execute(command.toString());
                    } catch (SQLException e) {
                        System.out.println("Erreur d'exécution : " + command);
                    }

                    command = null;
                    if (stmt != null) {
                        stmt.close();
                    }

                } else {
                    Pattern p = Pattern.compile(DELIMITER_LINE_REGEX);
                    Matcher m = p.matcher(trimmedLine);
                    if (m.matches()) {
                        setDelimiter(trimmedLine.split(DELIMITER_LINE_SPLIT_REGEX)[1].trim());
                        line = lineReader.readLine();
                        if (line == null) {
                            break;
                        }
                        trimmedLine = line.trim();
                    }
                    command.append(line);
                    command.append(" ");
                }

            }
            conn.commit();
        } catch (SQLException e) {
            System.out.println("Erreur d'exécution : " + command);
        } catch (IOException e) {
            System.out.println("Erreur d'exécution : " + command);
        }

    }

    /**
     * @return the delimiter
     */
    public String getDelimiter() {
        return delimiter;
    }

    /**
     * @param delimiter the delimiter to set
     */
    public void setDelimiter(String delimiter) {
        this.delimiter = delimiter;
    }
}
