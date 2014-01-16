/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.CheckUsernameController;
import dao.LoginFormDao;
import javax.swing.UIManager;
import model.DefaultPath;
import model.Login;

/**
 *
 * @author user
 */
public class LoginForm extends javax.swing.JFrame {

    public LoginForm() {
        initComponents();
        wrongmsg.setVisible(false);
        username.setName("username");
        pass.setName("pass");
        login.setName("login");
        exit.setName("exit");
        wrongmsg.setName("wrongmsg");
        this.setLocationRelativeTo(null);
        CreateAccountPopUpButton.setName("CreateAccountPopUpButton");
        ResetPasswordPopUpButton.setName("ResetPasswordPopUpButton");
     
//        usermsg.setVisible(false);
     

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        pass = new javax.swing.JPasswordField();
        login = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        exit = new javax.swing.JButton();
        wrongmsg = new javax.swing.JLabel();
        CreateAccountPopUpButton = new javax.swing.JButton();
        ResetPasswordPopUpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("User Login");

        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });

        login.setText("Login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        jLabel1.setText("Username");

        jLabel2.setText("Password");

        jLabel3.setFont(new java.awt.Font("Wide Latin", 3, 11)); // NOI18N
        jLabel3.setText("LOGIN FORM");

        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });

        wrongmsg.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        wrongmsg.setForeground(new java.awt.Color(255, 51, 51));
        wrongmsg.setText("Wrong Password!");

        CreateAccountPopUpButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        CreateAccountPopUpButton.setForeground(new java.awt.Color(0, 51, 255));
        CreateAccountPopUpButton.setText("Create New Account");
        CreateAccountPopUpButton.setBorder(null);
        CreateAccountPopUpButton.setBorderPainted(false);
        CreateAccountPopUpButton.setContentAreaFilled(false);
        CreateAccountPopUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAccountPopUpButtonActionPerformed(evt);
            }
        });

        ResetPasswordPopUpButton.setForeground(new java.awt.Color(0, 51, 255));
        ResetPasswordPopUpButton.setText("Forgot your password?");
        ResetPasswordPopUpButton.setBorder(null);
        ResetPasswordPopUpButton.setBorderPainted(false);
        ResetPasswordPopUpButton.setContentAreaFilled(false);
        ResetPasswordPopUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetPasswordPopUpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(wrongmsg, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                        .addGap(145, 145, 145))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pass)
                                .addComponent(username)
                                .addComponent(login, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(ResetPasswordPopUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CreateAccountPopUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(exit, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(wrongmsg)
                .addGap(18, 18, 18)
                .addComponent(CreateAccountPopUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ResetPasswordPopUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        LoginFormDao dao = new LoginFormDao();

        if (dao.checkLogin(username.getText(), pass.getText())) {
            Login lgn = new Login();
            lgn.setUsername(username.getText());
            DefaultPath defaultPath = new DefaultPath();
            defaultPath.setDefaultPath(System.getProperty("user.dir"));
//            try {
//                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
            MyDiaryBook theView = new MyDiaryBook();

 //           theView.setDefaultLookAndFeelDecorated(true);
            theView.setLocationRelativeTo(null);
            theView.setVisible(true);

            dispose();

        } else {
            wrongmsg.setVisible(true);
            username.setText("");
            pass.setText("");
            username.requestFocus();
          
        }


    }//GEN-LAST:event_loginActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        this.dispose();
    }//GEN-LAST:event_exitActionPerformed

    private void usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusGained

    }//GEN-LAST:event_usernameFocusGained

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
//        wrongmsg.setVisible(false);
//        CheckUsernameController controller = new CheckUsernameController();
//        if (controller.usernameExists(username.getText())) {
//            usermsg.setVisible(false);
//            login.setEnabled(true);
//
//
//        } else {
//            usermsg.setVisible(true);
//
//        }
    }//GEN-LAST:event_usernameFocusLost

    private void CreateAccountPopUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAccountPopUpButtonActionPerformed
       RegisterForm regFace = new RegisterForm();
        regFace.setVisible(true);
    }//GEN-LAST:event_CreateAccountPopUpButtonActionPerformed

    private void ResetPasswordPopUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetPasswordPopUpButtonActionPerformed
         ResetPassword regFace = new ResetPassword();
        regFace.setVisible(true);
    }//GEN-LAST:event_ResetPasswordPopUpButtonActionPerformed

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
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginForm().setVisible(true);

            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateAccountPopUpButton;
    private javax.swing.JButton ResetPasswordPopUpButton;
    private javax.swing.JButton exit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    public static javax.swing.JButton login;
    private javax.swing.JPasswordField pass;
    private javax.swing.JTextField username;
    private javax.swing.JLabel wrongmsg;
    // End of variables declaration//GEN-END:variables
}
