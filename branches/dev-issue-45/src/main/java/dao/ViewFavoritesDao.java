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
public class ViewFavoritesDao {
   static public String jdbcDriver = "com.mysql.jdbc.Driver";
   static public  String dbURL = "jdbc:mysql://89.163.172.10/tl";
   static public  String dbUserId = "tl";
   static public  String dbPassword = "tl";
   static public Connection c = null;
   public String str ="";
   public boolean ok = true;
    
    public String viewFavorites(String username) {

      try {    
        Class.forName(jdbcDriver);
      } catch (ClassNotFoundException exp) {
        System.err.println("Could not load the JDBC driver " + jdbcDriver);
        return str;
      }
        
      try {
        c = DriverManager.getConnection(dbURL, dbUserId, dbPassword);
                
        try {
            
            
            
            String viewlinks =
        "Select link,comment From favorites where username = '"+username+"' ";
         PreparedStatement  s= c.prepareStatement(viewlinks);
         

            ResultSet rset = s.executeQuery();
            

            

                while (rset.next())
                {
                
                  str+="Link: "+rset.getString("link")+"\nComment: "+rset.getString("comment")+"\n\n";
                
                
                }
            

            
             rset.close();

          	    
	    s.close();
             
            
          
          
        } catch (SQLException sqlexp) {
            JOptionPane.showMessageDialog(null,"Failed to execute one of the statements."+sqlexp.getMessage());

            str ="Failed To Retrieve Your Links";
        }
        
        c.close();
        
      } catch (SQLException sqlexp) {
          JOptionPane.showMessageDialog(null,"Failed to connect to the database."+sqlexp.getMessage());
          str ="Failed To Retrieve Your Links";

      }
    return str;
}
    
     public boolean clearfavorites(String username) {

        try {
            Class.forName(jdbcDriver);
        } catch (ClassNotFoundException exp) {
            System.err.println("Could not load the JDBC driver " + jdbcDriver);
            ok =false;
        }

        try {
            c = DriverManager.getConnection(dbURL, dbUserId, dbPassword);

            try {


                      String delete = ("Delete From favorites where username='test'");
                
                try (PreparedStatement s = c.prepareStatement(delete)) {
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
        return ok;
    }
    
}
