/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import validators.RegisterValidator;

/**
 *
 * @author w7user
 */
public class CheckValidPassword {
     public boolean checkPassword(String password)
    {
        RegisterValidator passController = new RegisterValidator();
        return passController.checkPassword(password);
    }
    
    
}
