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
public class PasswordController {
     public boolean checkPassword(String pass, String repass)
    {
        RegisterValidator passController = new RegisterValidator();
        return passController.checkPassword(pass,repass);
    }
}
