/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import validators.RegisterValidator;

/**
 *
 * @author Stef
 */
public class CheckUserController {
                public boolean checkUser(String Username)
    {
        RegisterValidator UserController = new RegisterValidator();
        return UserController.checkUsername(Username);
    }
    
    
}
