/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static ui.RegisterForm.PasswordPasswordField;
import static ui.RegisterForm.RePasswordPasswordField;
import static ui.RegisterForm.UserNameTextField;
import static ui.RegisterForm.EmailTextField;

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
        if (!e.checkMail(EmailTextField.getText())) {
            return false;

        }

        if (!e.checkUsername(UserNameTextField.getText())) {
            return false;
        }
        if (!e.checkPassword(RePasswordPasswordField.getText(), PasswordPasswordField.getText())) {
            return false;
        }
        return true;
    }    



}
