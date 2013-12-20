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
public class CheckUserController {
                public boolean checkUser(String Username)
    {
        RegisterController UserController = new RegisterController();
        return UserController.checkUsername(Username);
    }
    
    
}
