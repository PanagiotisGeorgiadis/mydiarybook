/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static ui.RegisterForm.jPasswordField1;
import static ui.RegisterForm.jPasswordField2;
import static ui.RegisterForm.jTextField1;
import static ui.RegisterForm.jTextField2;

/**
 *
 * @author user
 */
public class RegisterController
{
    public boolean checkMail(String email)
    {
        
        if(email.length() <= 4) return false;
        if(!email.contains("@") || email.indexOf("@") == 0 || email.indexOf("@") == email.length()-1 || email.contains("@@")) 
            return false;
        return true;
    }
    public boolean checkUsername(String username)
    {
        if(username.length() > 20) return false;
        if(username.length() <= 2) return false;
        if(username.contains(" ")) return false;
                
        return true;
    }
    public boolean checkPassword(String password, String repeatedpassword)
    {
        if(!password.equals(repeatedpassword)) return false;
        if(password.length() > 12 || password.length() <= 2) return false;
       if(password.contains(" ")) return false;
        
        if(password.matches("[0-9]+")==true) return false;
            
        return true;
    }

    public static boolean checkValues() {
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



}
