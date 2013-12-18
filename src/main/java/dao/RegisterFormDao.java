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
 * @author Stef
 */
public class RegisterFormDao {

    static public String jdbcDriver = "com.mysql.jdbc.Driver";
    static public String dbURL = "jdbc:mysql://89.163.172.10/tl";
    static public String dbUserId = "tl";
    static public String dbPassword = "tl";
    static public Connection c = null;
    public boolean ok = false;
    static public boolean usernameexist = false;

   
    public boolean checkUsername(String username) {

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException exp) {
            System.err.println("Could not load the JDBC driver " + jdbcDriver);
            return false;
        }

        try {
            c = DriverManager.getConnection(dbURL, dbUserId, dbPassword);

            try {

                String getUsername
                        = "Select * From accounts  where username ='" + username + "'";
                try (PreparedStatement s = c.prepareStatement(getUsername)) {
                    ResultSet rset = s.executeQuery();

                    if (rset.next()) {
                        ok = true;
                    }
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
        
        return ok;

    }

    public void registerValues(String Username,String Password,String RePassword,String Email,String Q1,String Q2 ) {

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException exp) {
            System.err.println("Could not load the JDBC driver " + jdbcDriver);
            return;
        }

        try {
            c = DriverManager.getConnection(dbURL, dbUserId, dbPassword);

            try {
                
                
                
               

                String registerValues
                        = "Insert Into accounts (username,password,mail,q1,q2) VALUES ('" + Username + "','" + Password + "','" + Email + "','" + Q1 + "','" + Q2 + "')";
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
