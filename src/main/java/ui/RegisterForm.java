package ui;


import controller.CheckMailController;
import controller.CheckPasswordController;
import controller.CheckQ1Controller;
import controller.CheckQ2Controller;
import controller.CheckUsernameController;
import controller.CheckValidPassword;
import controller.RegisterController;
import dao.RegisterFormDao;
import javax.swing.JOptionPane;



/**
 *
 * @author Stef
 */
public class RegisterForm extends javax.swing.JFrame {
    
    boolean usernamepass = false;
    boolean passwordpass =false;
    boolean repeatpassowrdpass=false;
    boolean mailpass = false;
    boolean q1pass = false;
    boolean q2pass = false;
    
    

    public RegisterForm() {
        initComponents();
        usernameexistmsg.setVisible(false);
        missmatchpasswords.setVisible(false);
        invalidemail.setVisible(false);
        invalidpassword.setVisible(false);
        cndaccept.setVisible(false);
        SubmitAccountButton.setEnabled(false);
        q1msg.setVisible(false);
        q2msg.setVisible(false);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        repassword = new javax.swing.JPasswordField();
        email = new javax.swing.JTextField();
        ConditionAndTemrsCheckBox = new javax.swing.JCheckBox();
        SubmitAccountButton = new javax.swing.JButton();
        CancelButton = new javax.swing.JButton();
        cnd = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        FavoritePet = new javax.swing.JTextField();
        FavoriteCar = new javax.swing.JTextField();
        usernameexistmsg = new javax.swing.JLabel();
        invalidpassword = new javax.swing.JLabel();
        missmatchpasswords = new javax.swing.JLabel();
        invalidemail = new javax.swing.JLabel();
        cndaccept = new javax.swing.JLabel();
        q1msg = new javax.swing.JLabel();
        q2msg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("UserName");

        jLabel2.setText("Password");

        jLabel3.setText("Re-Password");

        jLabel4.setText("E-maiil");

        jLabel5.setText("Sign Up Here");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });

        repassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                repasswordKeyTyped(evt);
            }
        });

        email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailKeyTyped(evt);
            }
        });

        ConditionAndTemrsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConditionAndTemrsCheckBoxActionPerformed(evt);
            }
        });

        SubmitAccountButton.setText("CreateAccount");
        SubmitAccountButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitAccountButtonActionPerformed(evt);
            }
        });

        CancelButton.setText("Cancel");
        CancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelButtonActionPerformed(evt);
            }
        });

        cnd.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        cnd.setForeground(new java.awt.Color(0, 0, 255));
        cnd.setText("C&D");
        cnd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cndMouseClicked(evt);
            }
        });
        cnd.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cndPropertyChange(evt);
            }
        });

        jLabel7.setText("Αγαπημένο κατοικίδιο");

        jLabel8.setText("Αγαπημένη μάρκα αυτοκινήτου");

        FavoritePet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FavoritePetKeyTyped(evt);
            }
        });

        FavoriteCar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FavoriteCarActionPerformed(evt);
            }
        });
        FavoriteCar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FavoriteCarKeyTyped(evt);
            }
        });

        usernameexistmsg.setForeground(new java.awt.Color(255, 0, 0));
        usernameexistmsg.setText("username exist");

        invalidpassword.setForeground(new java.awt.Color(255, 0, 0));
        invalidpassword.setText("invalid password");

        missmatchpasswords.setForeground(new java.awt.Color(255, 0, 0));
        missmatchpasswords.setText("miss-match passwords");

        invalidemail.setForeground(new java.awt.Color(255, 0, 0));
        invalidemail.setText("invalid email");

        cndaccept.setForeground(new java.awt.Color(255, 51, 51));
        cndaccept.setText("please accept the terms and conditions");

        q1msg.setForeground(new java.awt.Color(255, 0, 0));
        q1msg.setText("answer must be at least 3 chars long");

        q2msg.setForeground(new java.awt.Color(255, 0, 0));
        q2msg.setText("answer must be at least 3 chars long");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CancelButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SubmitAccountButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cnd, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ConditionAndTemrsCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cndaccept, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 108, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGap(128, 128, 128)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 104, Short.MAX_VALUE)
                                    .addComponent(username)
                                    .addComponent(repassword)
                                    .addComponent(email)
                                    .addComponent(FavoritePet)
                                    .addComponent(FavoriteCar)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameexistmsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(invalidpassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(q2msg, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(invalidemail, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(q1msg, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(missmatchpasswords, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameexistmsg))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invalidpassword))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(repassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(missmatchpasswords))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(invalidemail)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(FavoritePet, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q1msg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FavoriteCar, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(q2msg))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SubmitAccountButton)
                        .addComponent(cnd, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ConditionAndTemrsCheckBox)
                    .addComponent(cndaccept))
                .addGap(18, 18, 18)
                .addComponent(CancelButton)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel5.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void cndMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cndMouseClicked
        JOptionPane.showMessageDialog(null, "you can not re-create this \n application "
                + "or gain any profit \n RIGHTS BY THE DIARY ppl :P");
    }//GEN-LAST:event_cndMouseClicked

    private void SubmitAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitAccountButtonActionPerformed
         
        RegisterController controller2 = new RegisterController(); 
        RegisterFormDao formDao = new RegisterFormDao();
        if (!ConditionAndTemrsCheckBox.isSelected()) {
            cndaccept.setVisible(true);
            
           
        }
               
        else
        {
            
        
         
        
        formDao.registerValues(username.getText(),password.getText(),repassword.getText(),email.getText(),FavoritePet.getText(),FavoriteCar.getText());
                     
        if (!formDao.ok) {
                        JOptionPane.showMessageDialog(null, "Congratulations, \n Your Account Has Been Created!");
                        
                        dispose();
                        LoginForm regFace = new LoginForm();
                        regFace.setVisible(true);
                    }
                   

        }
        
                
            

            
    }//GEN-LAST:event_SubmitAccountButtonActionPerformed

    private void FavoriteCarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FavoriteCarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FavoriteCarActionPerformed

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        CheckUsernameController controller = new CheckUsernameController();        
        if (controller.usernameExists(username.getText()))
                {
                    usernamepass =false;
                    usernameexistmsg.setVisible(true);
                    SubmitAccountButton.setEnabled(false); 

                }      
        else
                            {
                    usernamepass =true;
                    usernameexistmsg.setVisible(false);
                    if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass )
                    {
                     SubmitAccountButton.setEnabled(true);   
                    }
                } 
            

        
           
    }//GEN-LAST:event_usernameFocusLost

    private void cndPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cndPropertyChange
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cndPropertyChange

    private void ConditionAndTemrsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConditionAndTemrsCheckBoxActionPerformed
        
        cndaccept.setVisible(false);
    }//GEN-LAST:event_ConditionAndTemrsCheckBoxActionPerformed

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped

        CheckValidPassword controller = new CheckValidPassword();        
        if (!controller.checkPassword(password.getText()+evt.getKeyChar()))
                {
                    passwordpass = false;
                    invalidpassword.setVisible(true);
                    SubmitAccountButton.setEnabled(false); 

                }      
        else
                            {
                    passwordpass = true;
                    invalidpassword.setVisible(false);
                    if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass )
                    {
                     SubmitAccountButton.setEnabled(true);   
                    }
                } 
    }//GEN-LAST:event_passwordKeyTyped

    private void repasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repasswordKeyTyped
           CheckPasswordController controller = new CheckPasswordController();        
        if (!controller.checkPassword(password.getText(),repassword.getText()+evt.getKeyChar()))
                {
                    repeatpassowrdpass=false;
                    missmatchpasswords.setVisible(true);
                    SubmitAccountButton.setEnabled(false); 

                }      
        else
                            {
                    repeatpassowrdpass=true;
                    missmatchpasswords.setVisible(false);
                    if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass )
                    {
                     SubmitAccountButton.setEnabled(true);   
                    }
                }         
    }//GEN-LAST:event_repasswordKeyTyped

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped
        CheckMailController controller = new CheckMailController();        
        if (!controller.checkMail(email.getText()+evt.getKeyChar()))
                {
                    mailpass = false;
                    invalidemail.setVisible(true);
                    SubmitAccountButton.setEnabled(false); 

                }      
        else
                            {
                    mailpass = true;
                    invalidemail.setVisible(false);
                    if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass )
                    {
                     SubmitAccountButton.setEnabled(true);   
                    }
                }         
    }//GEN-LAST:event_emailKeyTyped

    private void FavoritePetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FavoritePetKeyTyped
        
        CheckQ1Controller controller = new CheckQ1Controller();        
        if (!controller.checkQ1(FavoritePet.getText()+evt.getKeyChar()))
                {
                    q1pass = false;
                    q1msg.setVisible(true);
                    SubmitAccountButton.setEnabled(false); 

                }      
        else
                            {
                    q1pass = true;
                    q1msg.setVisible(false);
                    if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass )
                    {
                     SubmitAccountButton.setEnabled(true);   
                    }
                }         
    }//GEN-LAST:event_FavoritePetKeyTyped

    private void FavoriteCarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FavoriteCarKeyTyped
        CheckQ2Controller controller = new CheckQ2Controller();        
        if (!controller.checkQ2(FavoriteCar.getText()+evt.getKeyChar()))
                {
                    q2pass = false;
                    q2msg.setVisible(true);
                    SubmitAccountButton.setEnabled(false); 

                }      
        else
                            {
                    q2pass = true;
                    q2msg.setVisible(false);
                    if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass )
                    {
                     SubmitAccountButton.setEnabled(true);   
                    }
                }         
    }//GEN-LAST:event_FavoriteCarKeyTyped

    /**
     * @param args
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RegisterForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelButton;
    private javax.swing.JCheckBox ConditionAndTemrsCheckBox;
    private javax.swing.JTextField FavoriteCar;
    private javax.swing.JTextField FavoritePet;
    private javax.swing.JButton SubmitAccountButton;
    private javax.swing.JLabel cnd;
    private javax.swing.JLabel cndaccept;
    private javax.swing.JTextField email;
    private javax.swing.JLabel invalidemail;
    private javax.swing.JLabel invalidpassword;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel missmatchpasswords;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel q1msg;
    private javax.swing.JLabel q2msg;
    private javax.swing.JPasswordField repassword;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernameexistmsg;
    // End of variables declaration//GEN-END:variables

}
