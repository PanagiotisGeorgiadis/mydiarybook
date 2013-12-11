/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    static public boolean ok = true;
    

    static public void saveFavorite() {

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException exp) {
            System.err.println("Could not load the JDBC driver " + jdbcDriver);
            return;
        }

        try {
            c = DriverManager.getConnection(dbURL, dbUserId, dbPassword);

            try {
                String link = ui.FavoritesForm.link.getText();
                String comment = ui.FavoritesForm.comment.getText();
                String username = "test";


                String registerValues
                        = "Insert Into favorites (username,link,comment) VALUES ('" + username + "','" + link + "','" + comment + "')";
                try (PreparedStatement s = c.prepareStatement(registerValues)) {
                    s.execute();
                }

            } catch (SQLException sqlexp) {
                JOptionPane.showMessageDialog(null, "Failed to execute one of the statements." + sqlexp.getMessage());

                ok = false;
            }

            c.close();

        } catch (SQLException sqlexp) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database." + sqlexp.getMessage());
            ok = false;

        }

    }
    
       

   
}

