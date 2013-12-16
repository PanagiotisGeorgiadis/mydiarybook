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
public class LoginDao   {
    
  
   
    
   static public String jdbcDriver = "com.mysql.jdbc.Driver";
   static public  String dbURL = "jdbc:mysql://89.163.172.10/tl";
   static public  String dbUserId = "tl";
   static public  String dbPassword = "tl";
   static public Connection c = null;
   static public  boolean ok = false;
   public boolean correctpassword = false;


    
    
            public boolean checkLogin(String username,String password) {

      try {    
        Class.forName(jdbcDriver);
      } catch (ClassNotFoundException exp) {
        System.err.println("Could not load the JDBC driver " + jdbcDriver);
        
        return correctpassword;
      }
        
      try {
        c = DriverManager.getConnection(dbURL, dbUserId, dbPassword);
                
        try {
          
            
            String getOldPassword =
        "Select * From accounts  where username ='"+username+"' and password='"+password+"'";
         PreparedStatement  s= c.prepareStatement(getOldPassword);
         

            ResultSet rset = s.executeQuery();
            
            
             if (rset.next())
            {
                correctpassword=true;
            }

          	    
	    s.close();
             
            
          
          
        } catch (SQLException sqlexp) {
            JOptionPane.showMessageDialog(null,"Failed to execute one of the statements."+sqlexp.getMessage());

            correctpassword =false;
        }
        
        c.close();
        
      } catch (SQLException sqlexp) {
          JOptionPane.showMessageDialog(null,"Failed to connect to the database."+sqlexp.getMessage());
          correctpassword=false;

      }
      return correctpassword;
    
}

}
