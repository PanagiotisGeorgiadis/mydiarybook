/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author Stef
 */
public class CheckLoginController {
     public boolean checkPassword(String pass)
    {
        LoginController passController = new LoginController();
        return passController.checkPass(pass);
        
    }
public boolean checkUsername(String username)
{
    LoginController userController = new LoginController();
        return userController.checkUsername(username);
}
}
