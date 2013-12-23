package ui;

import controller.CheckMailController;
import controller.CheckPasswordController;
import controller.CheckQ1Controller;
import controller.CheckQ2Controller;
import controller.CheckUserController;
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
    boolean passwordpass = false;
    boolean repeatpassowrdpass = false;
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
        usernameexistmsg.setName("usernameexistmsg");
        password.setName("password");
        repassword.setName("repassword");
        invalidpassword.setName("invalidpassword");
        email.setName("email");
        missmatchpasswords.setName("missmatchpasswords");
        FavoritePet.setName("FavoritePet");
        invalidemail.setName("invalidemail");
        FavoriteCar.setName("FavoriteCar");
        q1msg.setName("q1msg");

        q2msg.setVisible(false);
        username.setName("username");
        usernameexistmsg.setName("usernameexistmsg");
        password.setName("password");
        repassword.setName("repassword");
        invalidpassword.setName("invalidpassword");
        email.setName("email");
        missmatchpasswords.setName("missmatchpasswords");
        FavoritePet.setName("FavoritePet");
        invalidemail.setName("invalidemail");
        FavoriteCar.setName("FavoriteCar");
        q1msg.setName("q1msg");
        q2msg.setName("q2msg");
        SubmitAccountButton.setName("SubmitAccountButton");
        CancelButton.setName("CancelButton");
        msg.setVisible(false);

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
        msg = new javax.swing.JLabel();
        cnd = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("UserName");

        jLabel2.setText("Password");

        jLabel3.setText("Re-Password");

        jLabel4.setText("E-maiil");

        jLabel5.setText("Sign Up Here");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                usernameFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        username.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                usernameKeyTyped(evt);
            }
        });

        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });

        repassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                repasswordFocusLost(evt);
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

        jLabel7.setText("Αγαπημένο κατοικίδιο");

        jLabel8.setText("Αγαπημένη μάρκα αυτοκινήτου");

        FavoritePet.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FavoritePetFocusLost(evt);
            }
        });
        FavoritePet.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                FavoritePetKeyTyped(evt);
            }
        });

        FavoriteCar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                FavoriteCarFocusLost(evt);
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
        q1msg.setText("answer must be at least 3 chars ");

        q2msg.setForeground(new java.awt.Color(255, 0, 0));
        q2msg.setText("answer must be at least 3 chars");

        msg.setForeground(new java.awt.Color(255, 0, 0));
        msg.setText("invalid username");

        cnd.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        cnd.setForeground(new java.awt.Color(0, 51, 204));
        cnd.setText("Conditions & Terms");
        cnd.setBorder(null);
        cnd.setBorderPainted(false);
        cnd.setContentAreaFilled(false);
        cnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cndActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(CancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44)
                                .addComponent(cndaccept, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(136, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                    .addComponent(FavoriteCar))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invalidpassword, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(invalidemail, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(missmatchpasswords, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(q2msg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(q1msg, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(usernameexistmsg, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(msg, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(SubmitAccountButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cnd, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ConditionAndTemrsCheckBox)
                        .addGap(275, 275, 275))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(usernameexistmsg)
                                .addComponent(msg))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(38, 38, 38)
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
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cnd, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SubmitAccountButton)))
                    .addComponent(ConditionAndTemrsCheckBox))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cndaccept))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(CancelButton)))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jLabel5.getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelButtonActionPerformed
        this.dispose();
        LoginForm regFace = new LoginForm();
        regFace.setVisible(true);
    }//GEN-LAST:event_CancelButtonActionPerformed

    private void SubmitAccountButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitAccountButtonActionPerformed

        RegisterController controller2 = new RegisterController();
        RegisterFormDao formDao = new RegisterFormDao();
        if (!ConditionAndTemrsCheckBox.isSelected()) {
            cndaccept.setVisible(true);

        } else {

            formDao.registerValues(username.getText(), password.getText(), repassword.getText(), email.getText(), FavoritePet.getText(), FavoriteCar.getText());

            if (!formDao.ok) {
                JOptionPane.showMessageDialog(null, "Congratulations, \n Your Account Has Been Created!");

                dispose();
                LoginForm regFace = new LoginForm();
                regFace.setVisible(true);
            }

        }


    }//GEN-LAST:event_SubmitAccountButtonActionPerformed

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        CheckUsernameController controller = new CheckUsernameController();
        CheckUserController controller1 = new CheckUserController();
        if (controller.usernameExists(username.getText())) {
            usernamepass = false;
            usernameexistmsg.setVisible(true);
            SubmitAccountButton.setEnabled(false);

        }

        if (!controller1.checkUser(username.getText())) {
            usernamepass = false;

            msg.setVisible(true);
            SubmitAccountButton.setEnabled(false);

        } else {
            usernamepass = true;
            usernameexistmsg.setVisible(false);
            if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass) {
                SubmitAccountButton.setEnabled(true);
            }
        }


    }//GEN-LAST:event_usernameFocusLost

    private void ConditionAndTemrsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConditionAndTemrsCheckBoxActionPerformed

        cndaccept.setVisible(false);
    }//GEN-LAST:event_ConditionAndTemrsCheckBoxActionPerformed

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped

        CheckValidPassword controller = new CheckValidPassword();
        if (!controller.checkPassword(password.getText() + evt.getKeyChar())) {
            passwordpass = false;
            invalidpassword.setVisible(true);
            SubmitAccountButton.setEnabled(false);

        } else {
            passwordpass = true;
            invalidpassword.setVisible(false);
            if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass) {
                SubmitAccountButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_passwordKeyTyped

    private void repasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_repasswordKeyTyped
        CheckPasswordController controller = new CheckPasswordController();
        if (!controller.checkPassword(password.getText(), repassword.getText() + evt.getKeyChar())) {
            repeatpassowrdpass = false;
            missmatchpasswords.setVisible(true);
            SubmitAccountButton.setEnabled(false);

        } else {
            repeatpassowrdpass = true;
            missmatchpasswords.setVisible(false);
            if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass) {
                SubmitAccountButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_repasswordKeyTyped

    private void emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailKeyTyped
        CheckMailController controller = new CheckMailController();
        if (!controller.checkMail(email.getText() + evt.getKeyChar())) {
            mailpass = false;
            invalidemail.setVisible(true);
            SubmitAccountButton.setEnabled(false);

        } else {
            mailpass = true;
            invalidemail.setVisible(false);
            if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass) {
                SubmitAccountButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_emailKeyTyped

    private void FavoritePetKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FavoritePetKeyTyped

        CheckQ1Controller controller = new CheckQ1Controller();
        if (!controller.checkQ1(FavoritePet.getText() + evt.getKeyChar())) {
            q1pass = false;
            q1msg.setVisible(true);
            SubmitAccountButton.setEnabled(false);

        } else {
            q1pass = true;
            q1msg.setVisible(false);
            if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass) {
                SubmitAccountButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_FavoritePetKeyTyped

    private void FavoriteCarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_FavoriteCarKeyTyped
        CheckQ2Controller controller = new CheckQ2Controller();
        if (!controller.checkQ2(FavoriteCar.getText() + evt.getKeyChar())) {
            q2pass = false;
            q2msg.setVisible(true);
            SubmitAccountButton.setEnabled(false);

        } else {
            q2pass = true;
            q2msg.setVisible(false);
            if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass) {
                SubmitAccountButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_FavoriteCarKeyTyped

    private void usernameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameKeyTyped
        CheckUserController controller = new CheckUserController();
           //CheckUserController controller2 = new CheckUserController();

        if (!controller.checkUser(username.getText() + evt.getKeyChar())) //if (controller2.checkUser(username.getText()))     
        {
            usernamepass = false;

            msg.setVisible(true);
            SubmitAccountButton.setEnabled(false);

        } else {
            usernamepass = true;
            msg.setVisible(false);

            if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass) {
                SubmitAccountButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_usernameKeyTyped

    private void usernameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusGained
        usernameexistmsg.setVisible(false);
    }//GEN-LAST:event_usernameFocusGained

    private void cndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cndActionPerformed
        JOptionPane.showMessageDialog(null, "This is an open source application \n Owner rights: \n "
                + "ΜΥΡΩΝΙΔΗΣ ΔΗΜΗΤΡΗΣ, ΧΡΗΣΤΟΥ ΑΠΟΣΤΟΛΗΣ \n TΣΙΛΟΠΟΥΛΟΣ ΠΑΝΑΓΙΩΤΗΣ, ΓΕΩΣΡΓΙΑΔΗΣ ΠΑΝΑΓΙΩΤΗΣ,\n ΤΣΑΜΗΣ ΙΩΑΝΝΗΣ"
                + "ΣΤΕΦΑΝΙΔΗΣ ΣΤΕΦΑΝΟΣ,\n ΠΑΤΣΑΝΗΣ ΑΛΕΞΑΝΔΡΟΣ, ΤΑΣΣΙΟΣ ΜΑΡΙΟΣ, \n ΣΤΥΛΙΔΗΣ ΧΡΗΣΤΟΣ, ΔΗΜΤΣΑΣ ΒΙΚΤΩΡΑΣ ");
    }//GEN-LAST:event_cndActionPerformed

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        CheckValidPassword controller = new CheckValidPassword();
        CheckPasswordController controller1 = new CheckPasswordController();
        if (!controller.checkPassword(password.getText())) {
            passwordpass = false;
            invalidpassword.setVisible(true);
            SubmitAccountButton.setEnabled(false);

        }
        if (!controller1.checkPassword(password.getText(), repassword.getText())) {
            repeatpassowrdpass = false;
            missmatchpasswords.setVisible(true);
            SubmitAccountButton.setEnabled(false);
        } else {
            passwordpass = true;
            invalidpassword.setVisible(false);
            if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass) {
                SubmitAccountButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_passwordFocusLost

    private void FavoritePetFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FavoritePetFocusLost
        CheckQ1Controller controller = new CheckQ1Controller();
        if (!controller.checkQ1(FavoritePet.getText())) {
            q1pass = false;
            q1msg.setVisible(true);
            SubmitAccountButton.setEnabled(false);

        } else {
            q1pass = true;
            q1msg.setVisible(false);
            if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass) {
                SubmitAccountButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_FavoritePetFocusLost

    private void FavoriteCarFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_FavoriteCarFocusLost
        CheckQ2Controller controller = new CheckQ2Controller();
        if (!controller.checkQ2(FavoriteCar.getText())) {
            q2pass = false;
            q2msg.setVisible(true);
            SubmitAccountButton.setEnabled(false);

        } else {
            q2pass = true;
            q2msg.setVisible(false);
            if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass) {
                SubmitAccountButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_FavoriteCarFocusLost

    private void repasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_repasswordFocusLost
        CheckPasswordController controller = new CheckPasswordController();
        if (!controller.checkPassword(password.getText(), repassword.getText())) {
            repeatpassowrdpass = false;
            missmatchpasswords.setVisible(true);
            SubmitAccountButton.setEnabled(false);

        } else {
            repeatpassowrdpass = true;
            missmatchpasswords.setVisible(false);
            if (usernamepass && passwordpass && repeatpassowrdpass && mailpass && q1pass && q2pass) {
                SubmitAccountButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_repasswordFocusLost

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
    private javax.swing.JButton cnd;
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
    private javax.swing.JLabel msg;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel q1msg;
    private javax.swing.JLabel q2msg;
    private javax.swing.JPasswordField repassword;
    private javax.swing.JTextField username;
    private javax.swing.JLabel usernameexistmsg;
    // End of variables declaration//GEN-END:variables

}
