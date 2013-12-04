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
import static ui.RegisterForm.favoritecar;
import static ui.RegisterForm.favoritepet;
import static ui.RegisterForm.jPasswordField1;
import static ui.RegisterForm.jTextField1;
import static ui.RegisterForm.jTextField2;

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
    static public boolean ok = true;
    static public boolean usernameexist = false;

   
    static public void checkUsername() {

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException exp) {
            System.err.println("Could not load the JDBC driver " + jdbcDriver);
            return;
        }

        try {
            c = DriverManager.getConnection(dbURL, dbUserId, dbPassword);

            try {
                String currentuser = jTextField1.getText();

                String getUsername
                        = "Select * From accounts  where username ='" + currentuser + "'";
                try (PreparedStatement s = c.prepareStatement(getUsername)) {
                    ResultSet rset = s.executeQuery();

                    if (rset.next()) {
                        usernameexist = true;
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

    }

    static public void registerValues() {

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException exp) {
            System.err.println("Could not load the JDBC driver " + jdbcDriver);
            return;
        }

        try {
            c = DriverManager.getConnection(dbURL, dbUserId, dbPassword);

            try {
                String currentuser = jTextField1.getText();
                String mail = jTextField2.getText();
                String password = jPasswordField1.getText();
                String q1 = favoritepet.getText();
                String q2 = favoritecar.getText();

                String registerValues
                        = "Insert Into accounts (username,password,mail,q1,q2) VALUES ('" + currentuser + "','" + password + "','" + mail + "','" + q1 + "','" + q2 + "')";
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
