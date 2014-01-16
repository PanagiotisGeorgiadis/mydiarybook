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
public class ResetPasswordDao {

    static public String A = "0", B = "0", C = "0";
    static public int randomNum = 0;
    static String jdbcDriver = "com.mysql.jdbc.Driver";
    static String dbURL = "jdbc:mysql://89.163.172.10/tl";
    static public String dbUserId = "tl";
    static public String dbPassword = "tl";
    static public boolean ok = true;
    public boolean questionsok = false;
    static public String question1;
    static public String question2;
    static public int question3 = 0;

    static public Connection c = null;
    static public Connection c2 = null;



     public void saveNewPassword(String username) {

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException exp) {
            System.err.println("Could not load the JDBC driver " + jdbcDriver);
            return;
        }

        try {
            c = DriverManager.getConnection(dbURL, dbUserId, dbPassword);

            try {
                
                String newpass = B + A + C + randomNum + A + B + C;
                String updateString
                        = "update accounts set password = '" + newpass + "' where username ='" + username + "'";
                PreparedStatement s = c.prepareStatement(updateString);

          
                s.execute();

                s.close();

            } catch (SQLException sqlexp) {
                JOptionPane.showMessageDialog(null, "Failed to execute one of the statements." + sqlexp.getMessage());

                ok = false;
            }

            c.close();

        } catch (SQLException sqlexp) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database." + sqlexp.getMessage());
            ui.ResetPassword.ok = false;

        }

    }

     public void generateNewPassword() {
        randomNum = 99999 + (int) (Math.random() * 999999);

        int randomNum2 = 1 + (int) (Math.random() * 5);
        if (randomNum2 == 1) {
            A = "C";

        } else if (randomNum2 == 2) {
            A = "Y";
        } else if (randomNum2 == 3) {
            A = "X";
        } else if (randomNum2 == 4) {
            A = "J";
        } else if (randomNum2 == 5) {
            A = "F";
        }

        int randomNum3 = 1 + (int) (Math.random() * 5);
        if (randomNum3 == 1) {
            B = "C";

        } else if (randomNum3 == 2) {
            B = "Y";
        } else if (randomNum3 == 3) {
            B = "X";
        } else if (randomNum3 == 4) {
            B = "J";
        } else if (randomNum3 == 5) {
            B = "F";
        }
        int randomNum4 = 1 + (int) (Math.random() * 5);
        if (randomNum4 == 1) {
            C = "C";

        } else if (randomNum4 == 2) {
            C = "Y";
        } else if (randomNum4 == 3) {
            C = "X";
        } else if (randomNum4 == 4) {
            C = "J";
        } else if (randomNum4 == 5) {
            C = "F";
        }

    }
     public String getPass()
             {
                 String myString = B + A + C + randomNum + A + B + C;
                 return myString;
             }

    public boolean getSecurityQuestions(String username,String q1,String q2) {
        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException exp) {
            System.err.println("Could not load the JDBC driver " + jdbcDriver);
            return questionsok;
        }

        try {
            c2 = DriverManager.getConnection(dbURL, dbUserId, dbPassword);

            try {

                String getQuestions1 = "SELECT * FROM accounts where username='" + username + "' and q1='" + q1 + "' and q2='" + q2 + "';";
                PreparedStatement s = c2.prepareStatement(getQuestions1);
                ResultSet rset = s.executeQuery();

                if (rset.next()) {
                    questionsok = true;
                }

                s.close();

            } catch (SQLException sqlexp) {
                JOptionPane.showMessageDialog(null, "Failed to execute one of the statements." + sqlexp.getMessage());
                questionsok = false;
            }

            c2.close();

        } catch (SQLException sqlexp) {
            JOptionPane.showMessageDialog(null, "Failed to connect to the database." + sqlexp.getMessage());
            questionsok = false;

        }
    return questionsok;
    }

    

}
