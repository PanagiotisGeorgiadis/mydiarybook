/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import static ui.ChangePassword.username;
import controller.ChangePasswordController;
import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;



/**
 *
 * @author Stef
 */
public  class ChangePasswordDao {
     public static boolean ok;
    public static boolean correctpassword;
    public static String newpass;
    static public String jdbcDriver = "com.mysql.jdbc.Driver";
    static public  String dbURL = "jdbc:mysql://89.163.172.10/tl";
    static public  String dbUserId = "tl";
    static public  String dbPassword = "tl";
    static public  Connection c = null;
  
 
   
    
    public static void getOldPass() {

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException exp) {
            System.err.println("Could not load the JDBC driver " + jdbcDriver);
            return;
        }

        try {
            c = DriverManager.getConnection(dbURL, dbUserId, dbPassword);

            try {
                String currentuser = ui.ChangePassword.username.getText();
                String oldpassword2 = ui.ChangePassword.oldpassword.getText();

                String getOldPassword
                        = "Select * From accounts  where username ='" + currentuser + "' and password='" + oldpassword2 + "'";
                PreparedStatement s = c.prepareStatement(getOldPassword);

                ResultSet rset = s.executeQuery();

                if (rset.next()) {
                   correctpassword = true;
                }

                s.close();

            } catch (SQLException sqlexp) {
                JOptionPane.showMessageDialog(null, "Failed to execute one of the statements." + sqlexp.getMessage());

                ui.ChangePassword.ok = false;
            }

            c.close();

        } catch (SQLException sqlexp) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database." + sqlexp.getMessage());
            ui.ChangePassword.ok = false;

        }

    }
     public static  void updatePass() {

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException exp) {
            System.err.println("Could not load the JDBC driver " + jdbcDriver);
            return;
        }

        try {
            c = DriverManager.getConnection(dbURL, dbUserId, dbPassword);

            try {
                String currentuser = ui.ChangePassword.username.getText();
                String newpass = ui.ChangePassword.password.getText();

                String updatePassword
                        = "Update accounts set password='" +newpass + "' where username='" +currentuser + "'";
                PreparedStatement s = c.prepareStatement(updatePassword);

                s.execute();

                s.close();

            } catch (SQLException sqlexp) {
                JOptionPane.showMessageDialog(null, "Failed to execute one of the statements." + sqlexp.getMessage());

                ui.ChangePassword.ok = false;
            }

            c.close();

        } catch (SQLException sqlexp) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database." + sqlexp.getMessage());
            ui.ChangePassword.ok = false;

        }

    }

    
}
