/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import validators.ChangePasswordValidator;

/**
 *
 * @author w7user
 */
public class ChangePasswordController {
     public boolean changePassword(String password)
    {
        ChangePasswordValidator passController = new ChangePasswordValidator();
        return passController.checkChangePasswordController(password);
    }
    
}

