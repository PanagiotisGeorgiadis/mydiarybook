/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import javax.swing.JOptionPane;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import controller.ResetPasswordController;

import java.awt.datatransfer.*;
import java.awt.Toolkit;



/**
 *
 * @author w7user
 */
public class ResetPassword extends javax.swing.JFrame {
    String A="0",B="0",C="0"; 
    int randomNum = 0;
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String dbURL = "jdbc:mysql://89.163.172.10/tl";
    String dbUserId = "tl";
    String dbPassword = "tl";
    boolean ok = true;
    boolean questionsok = false;
    String question1;
    String question2;
    int question3 = 0;
    
      Connection c = null;
      Connection c2 = null;
    /**
     * Creates new form ResetPassword
     */
    public ResetPassword() {
        initComponents();
    }
     public void saveNewPassword() {

      try {    
        Class.forName(jdbcDriver);
      } catch (ClassNotFoundException exp) {
        System.err.println("Could not load the JDBC driver " + jdbcDriver);
        return;
      }
        
      try {
        c = DriverManager.getConnection(dbURL, dbUserId, dbPassword);
                
        try {
            String currentuser=username.getText();
            String newpass = B+A+C+randomNum+A+B+C;
            String updateString =
        "update accounts set password = '"+newpass+"' where username ='"+currentuser+"'";
         PreparedStatement  s= c.prepareStatement(updateString);
         
        
        
                
          // In case you want to see the update results from each statement
          // Normally not needed to store the results.
          s.execute();
          	    
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
     public void generateNewPassword(){
             randomNum = 99999 + (int)(Math.random()*999999);
    
    int randomNum2 =1 +(int)(Math.random()* 5);
    if (randomNum2 == 1)
    {
        A = "C";
        
    }
    else if (randomNum2 == 2)
            {
             A = "Y";   
            }
        else if (randomNum2 == 3)
            {
             A = "X";   
            }
        else if (randomNum2 == 4)
            {
             A = "J";   
            }
        else if (randomNum2 == 5)
            {
             A = "F";   
            }
    
    int randomNum3 =1 +(int)(Math.random()* 5);
        if (randomNum3 == 1)
    {
        B = "C";
        
    }
    else if (randomNum3 == 2)
            {
             B = "Y";   
            }
        else if (randomNum3 == 3)
            {
             B = "X";   
            }
        else if (randomNum3 == 4)
            {
             B = "J";   
            }
        else if (randomNum3 == 5)
            {
             B = "F";   
            }
    int randomNum4 =1 +(int)(Math.random()* 5);
        if (randomNum4 == 1)
    {
        C = "C";
        
    }
    else if (randomNum4 == 2)
            {
             C = "Y";   
            }
        else if (randomNum4 == 3)
            {
             C = "X";   
            }
        else if (randomNum4 == 4)
            {
             C = "J";   
            }
        else if (randomNum4 == 5)
            {
             C = "F";   
            }
     }
     public void getSecurityQuestions(){
               try {    
        Class.forName(jdbcDriver);
      } catch (ClassNotFoundException exp) {
        System.err.println("Could not load the JDBC driver " + jdbcDriver);
        return;
      }
        
      try {
        c2 = DriverManager.getConnection(dbURL, dbUserId, dbPassword);
                
        try {
            String currentuser2=username.getText();
            question1=q1.getText();
            question2=q2.getText();
            String getQuestions1 ="SELECT * FROM accounts where username='"+currentuser2+"' and q1='"+question1+"' and q2='"+question2+"';";
            PreparedStatement  s= c2.prepareStatement(getQuestions1);
            ResultSet rset = s.executeQuery();
            
            
             if (rset.next())
            {
                questionsok=true;
            }

            
            s.close();
            

        
        
                
      
          
           
          	    
	   
             
            
          
          
        } catch (SQLException sqlexp) {
           JOptionPane.showMessageDialog(null,"Failed to execute one of the statements."+sqlexp.getMessage());
            ok =false;
        }
        
        c2.close();
        
      } catch (SQLException sqlexp) {
          JOptionPane.showMessageDialog(null,"Failed to connect to the database."+sqlexp.getMessage());
          ok=false;

      }
         
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        q1 = new javax.swing.JTextField();
        q2 = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        username = new javax.swing.JTextField();
        usernamelabel = new javax.swing.JLabel();
        question1label = new javax.swing.JLabel();
        question1label1 = new javax.swing.JLabel();
        close = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reset Password");

        submit.setText("Reset");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        usernamelabel.setText("Username");

        question1label.setText("Αγαπημένο Κατοικίδιο");

        question1label1.setText("Αγαπημένη Μάρκα Αυτοκινήτου");

        close.setText("Close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(128, 128, 128)
                        .addComponent(question1label))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(q2)
                            .addComponent(question1label1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(q1)
                            .addComponent(username)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addComponent(usernamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(submit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(85, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(usernamelabel)
                .addGap(8, 8, 8)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(question1label, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(q1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(question1label1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(q2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(close, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        // TODO add your handling code here:
        if (!checkValues())
    {
        JOptionPane.showMessageDialog(null, "Some Of Your Answers Are Too Small!");
        q1.setText(null);
        q2.setText(null);
        q1.requestFocus();
    }
        else
        {
      getSecurityQuestions();
    
    if (questionsok==false)
    {
        JOptionPane.showMessageDialog(null,"At Least One Of Your Answers Is Wrong!");
        q1.requestFocus();
        return;
    }

            

    generateNewPassword(); 
    questionsok=false;
    
    
    
    //update new pass in db
    
    saveNewPassword();
    if (ok==true)
    {
    String myString = B+A+C+randomNum+A+B+C;
    StringSelection stringSelection = new StringSelection (myString);
    Clipboard clpbrd = Toolkit.getDefaultToolkit ().getSystemClipboard ();
    clpbrd.setContents (stringSelection, null);    
    JOptionPane.showMessageDialog(null,"New Pass Is " +B+A+C+randomNum+A+B+C+" And Autocopied To Clipboard");
    }
    
        }
    }//GEN-LAST:event_submitActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeActionPerformed
    


    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResetPassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResetPassword().setVisible(true);
            }
        });
    }

    
    public boolean checkValues() {
        ResetPasswordController e = new ResetPasswordController();
       
        
      
   
        if (!e.ResetPasswordController(q1.getText(), q2.getText())) {
            return false;
        }
       return true;
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JTextField q1;
    private javax.swing.JTextField q2;
    private javax.swing.JLabel question1label;
    private javax.swing.JLabel question1label1;
    private javax.swing.JButton submit;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernamelabel;
    // End of variables declaration//GEN-END:variables
}
