/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import validators.LoginValidator;

/**
 *
 * @author Stef
 */
public class LoginController {
     public boolean checkPassword(String pass)
    {
        LoginValidator passController = new LoginValidator();
        return passController.checkPass(pass);
        
    }
public boolean checkUsername(String username)
{
    LoginValidator userController = new LoginValidator();
        return userController.checkUsername(username);
}
}
