/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author w7user
 */
public class CheckChangePasswordController {
     public boolean changePassword(String password)
    {
        ChangePasswordController passController = new ChangePasswordController();
        return passController.checkChangePasswordController(password);
    }
    
}

