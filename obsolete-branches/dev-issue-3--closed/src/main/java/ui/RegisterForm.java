package ui;

import controller.RegisterController;
import java.io.PrintWriter;
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


public class RegisterForm extends javax.swing.JFrame implements IRegisterForm {
    String jdbcDriver = "com.mysql.jdbc.Driver";
    String dbURL = "jdbc:mysql://89.163.172.10/tl";
    String dbUserId = "tl";
    String dbPassword = "tl";
    Connection c = null;
    boolean ok = true;
    boolean usernameexist = false;
    @Override
    
    public void display(String msg) {

        JOptionPane.showMessageDialog(this, msg);
    }

    public RegisterForm() {
        initComponents();
    }
             public void checkUsername() {

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
            
            
            String getUsername =
        "Select * From accounts  where username ='"+currentuser+"'";
         PreparedStatement  s= c.prepareStatement(getUsername);
         

            ResultSet rset = s.executeQuery();
            
            
             if (rset.next())
            {
                usernameexist=true;
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
             
                          public void registerValues() {

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
            String password= jPasswordField1.getText();
            String q1 = favoritepet.getText();
            String q2=  favoritecar.getText();      
            
            
            String registerValues =
        "Insert Into accounts (username,password,mail,q1,q2) VALUES ('"+currentuser+"','"+password+"','"+mail+"','"+q1+"','"+q2+"')";
         PreparedStatement  s= c.prepareStatement(registerValues);
         

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
    
    
    
    
    


    public void createRegister (PrintWriter xwriteOutput) {
       
      String  Registerinfo = jTextField1.getText() + " " + jPasswordField1.getText() + " " + jPasswordField2.getText()
                + " " + jTextField2.getText();
       
      xwriteOutput.println(Registerinfo);
      

    }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jTextField2 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        favoritepet = new javax.swing.JTextField();
        favoritecar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("UserName");

        jLabel2.setText("Password");

        jLabel3.setText("Re-Password");

        jLabel4.setText("E-maiil");

        jLabel5.setText("Sign Up Here");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jButton1.setText("CreateAccount");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 255));
        jLabel6.setText("C&D");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        jLabel7.setText("Αγαπημένο κατοικίδιο");

        jLabel8.setText("Αγαπημένη μάρκα αυτοκινήτου");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jCheckBox1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1))
                            .addGap(128, 128, 128)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                .addComponent(jTextField1)
                                .addComponent(jPasswordField2)
                                .addComponent(jTextField2)
                                .addComponent(favoritepet)
                                .addComponent(favoritecar))))
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(favoritepet, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(favoritecar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jCheckBox1))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jLabel5.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        JOptionPane.showMessageDialog(null, "you can not re-create this \n application "
                + "or gain any profit \n RIGHTS BY THE DIARY ppl :P");
    }//GEN-LAST:event_jLabel6MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     checkUsername();
        if (usernameexist==false)
      {
        if (jCheckBox1.isSelected()) {
            if (checkValues()) {
                registerValues();
                if (ok==true)
                {
            JOptionPane.showMessageDialog(null,"Your Account Created!.");
            ok=false;
          
                }
                
                
                
                
                
                
            } else {
                JOptionPane.showMessageDialog(null, "Invalid input values");
            }
        } else {
            JOptionPane.showMessageDialog(null, "CHECK THE CONDITIONS BOX");

    }  
        
      }
      else 
      {
          JOptionPane.showMessageDialog(null, "Username Already Exists!");
          usernameexist = false;
      }
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }
     private boolean checkValues() {
        RegisterController e = new RegisterController();
        if (!e.checkMail(jTextField2.getText())) {
            return false;
         
        }
        
        if (!e.checkUsername(jTextField1.getText())) {
            return false;
        }
        if (!e.checkPassword(jPasswordField2.getText(), jPasswordField1.getText())) {
            return false;
        }
        return true;
     }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField favoritecar;
    private javax.swing.JTextField favoritepet;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

}
