/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author w7user
 */
public class FavoritesDao {
    


    static public String jdbcDriver = "com.mysql.jdbc.Driver";
    static public String dbURL = "jdbc:mysql://89.163.172.10/tl";
    static public String dbUserId = "tl";
    static public String dbPassword = "tl";
    static public Connection c = null;
    public boolean ok = true;
    

     public boolean saveFavorite(String link,String comment,String username) {

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException exp) {
            System.err.println("Could not load the JDBC driver " + jdbcDriver);
            ok = false;
        }

        try {
            c = DriverManager.getConnection(dbURL, dbUserId, dbPassword);

            try {



                String registerValues
                        = "Insert Into favorites (username,link,comment) VALUES ('" + username + "','" + link + "','" + comment + "')";
                PreparedStatement s = c.prepareStatement(registerValues);
                s.execute();
                

            } catch (SQLException sqlexp) {
                JOptionPane.showMessageDialog(null, "Failed to execute one of the statements." + sqlexp.getMessage());

                ok = false;
            }

            c.close();

        } catch (SQLException sqlexp) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database." + sqlexp.getMessage());
            ok = false;

        }
        return ok;
    }
    
       

   
}

