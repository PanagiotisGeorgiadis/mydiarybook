/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import validators.ChangePasswordValidator;
import dao.ChangePasswordDao;
import javax.swing.JOptionPane;


/**
 *
 * @author w7user
 */
public class ChangePassword extends javax.swing.JFrame {

    public static boolean ok;
    public static boolean correctpassword;

    public ChangePassword() {
        initComponents();
        passwordsmsg.setVisible(false);
        wrongmsg.setVisible(false);
        username.setName("username");
        oldpassword.setName("oldpassword");
        password.setName("password");
        repeatpassword.setName("repeatpassword");
        wrongmsg.setName("wrongmsg");
        passwordsmsg.setName("passwordsmsg");
        submit.setName("submit");
        close.setName("close");
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        username = new javax.swing.JTextField();
        submit = new javax.swing.JButton();
        usernamelabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        oldpassword = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        repeatpassword = new javax.swing.JTextField();
        close = new javax.swing.JButton();
        passwordsmsg = new javax.swing.JLabel();
        wrongmsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Change Password");

        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });

        submit.setText("submit");
        submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitActionPerformed(evt);
            }
        });

        usernamelabel.setText("Username");

        jLabel1.setText("Old Password");

        oldpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                oldpasswordKeyTyped(evt);
            }
        });

        jLabel2.setText("New Password");

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });

        jLabel3.setText("Repeat Password");

        repeatpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                repeatpasswordKeyTyped(evt);
            }
        });

        close.setText("close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        passwordsmsg.setForeground(new java.awt.Color(255, 0, 51));
        passwordsmsg.setText("Passwords dont match");

        wrongmsg.setForeground(new java.awt.Color(255, 0, 51));
        wrongmsg.setText("Wrong username/password");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(usernamelabel, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(username)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(password)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(repeatpassword)
                        .addComponent(oldpassword)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(submit, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wrongmsg, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordsmsg, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(usernamelabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(wrongmsg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(oldpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(passwordsmsg))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(repeatpassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(submit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(close)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitActionPerformed
        ChangePasswordValidator controller = new ChangePasswordValidator();
        
        if (!controller.checkValues(password.getText(),repeatpassword.getText())) {
            passwordsmsg.setVisible(true);
            password.setText(null);
            repeatpassword.setText(null);
            password.requestFocus();
        } else {
            ChangePasswordDao dao = new ChangePasswordDao();

            
            if (dao.getOldPass(username.getText(),oldpassword.getText())) {

                String newpass = password.getText();
                JOptionPane.showMessageDialog(null, "Password Successfully Changed To " + newpass);
                dao.updatePass(username.getText(),repeatpassword.getText());
                dispose();
                
                
            } else {
                wrongmsg.setVisible(true);
            }
        }

    }//GEN-LAST:event_submitActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_closeActionPerformed

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        passwordsmsg.setVisible(false);
    }//GEN-LAST:event_passwordKeyTyped

    private void repeatpasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repeatpasswordKeyTyped
        passwordsmsg.setVisible(false);
    }//GEN-LAST:event_repeatpasswordKeyTyped

    private void usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyTyped
        wrongmsg.setVisible(false);
    }//GEN-LAST:event_usernameKeyTyped

    private void oldpasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_oldpasswordKeyTyped
        wrongmsg.setVisible(false);
    }//GEN-LAST:event_oldpasswordKeyTyped

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
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChangePassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChangePassword().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField oldpassword;
    private javax.swing.JTextField password;
    private javax.swing.JLabel passwordsmsg;
    private javax.swing.JTextField repeatpassword;
    private static javax.swing.JButton submit;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernamelabel;
    private javax.swing.JLabel wrongmsg;
    // End of variables declaration//GEN-END:variables
}
