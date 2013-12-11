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
import static ui.LoginForm.pass;
import static ui.LoginForm.username;

/**
 *
 * @author Stef
 */
public class LoginFormDao   {
    
  
   
    
   static public String jdbcDriver = "com.mysql.jdbc.Driver";
   static public  String dbURL = "jdbc:mysql://89.163.172.10/tl";
   static public  String dbUserId = "tl";
   static public  String dbPassword = "tl";
   static public Connection c = null;
   static public  boolean ok = false;
   static public boolean correctpassword = false;

    /**
     * Creates new form LoginForm
     */
     public   LoginFormDao() {
        initComponents();
        
    }
    
    
            public static void checkLogin() {

      try {    
        Class.forName(jdbcDriver);
      } catch (ClassNotFoundException exp) {
        System.err.println("Could not load the JDBC driver " + jdbcDriver);
        return;
      }
        
      try {
        c = DriverManager.getConnection(dbURL, dbUserId, dbPassword);
                
        try {
            String currentuser = username.getText();
            String oldpassword2 = pass.getText();
            
            String getOldPassword =
        "Select * From accounts  where username ='"+currentuser+"' and password='"+oldpassword2+"'";
         PreparedStatement  s= c.prepareStatement(getOldPassword);
         

            ResultSet rset = s.executeQuery();
            
            
             if (rset.next())
            {
                correctpassword=true;
            }

          	    
	    s.close();
             
            
          
          
        } catch (SQLException sqlexp) {
            JOptionPane.showMessageDialog(null,"Failed to execute one of the statements."+sqlexp.getMessage());

            ok =false;
        }
        
        c.close();
        
      } catch (SQLException sqlexp) {
          JOptionPane.showMessageDialog(null,"Failed to connect to the database."+sqlexp.getMessage());
          ok=false;

      }
    
}

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }}
