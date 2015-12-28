/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO_Util;

/**
 *
 * @author Devjl Ladykillah
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.awt.Component;

/**
 *
 * @author Devjl Ladykillah
 */
public class Util {

    public Connection getConnection() throws  SQLException {
      
            
            
            try {
                Config co;
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("config.dat"))) {
                    co = (Config) in.readObject();
                }
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection("jdbc:sqlserver://" + co.getAddress() + ":" + co.getPort() + ";databaseName=" + co.getData(), co.getUser(), co.getPass());
        } catch (FileNotFoundException ex) {
                Component Main = null;
             JOptionPane.showMessageDialog(Main,"No config connection file please click File->Config connection","Error File config.dat not found !", 2);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
            }
            return null;

    }
}
