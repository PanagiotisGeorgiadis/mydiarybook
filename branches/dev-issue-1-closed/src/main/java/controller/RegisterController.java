/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author user
 */
public class RegisterController
{
    public boolean checkMail(String email)
    {
        
        if(email.length() <= 2) return false;
        if(!email.contains("@") || email.indexOf("@") == 0 || email.indexOf("@") == email.length()-1) return false;
        return true;
    }
    public boolean checkUsername(String username)
    {
        if(username.length() > 20) return false;
        if(username.length() <= 2) return false;
        return true;
    }
    public boolean checkPassword(String password, String repeatedpassword)
    {
        if(!password.equals(repeatedpassword)) return false;
        if(password.length() > 8 || password.length() < 2) return false;
        return true;
    }
    
}
