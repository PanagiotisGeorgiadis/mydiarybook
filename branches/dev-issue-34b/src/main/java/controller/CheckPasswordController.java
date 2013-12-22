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
public class CheckPasswordController {
     public boolean checkPassword(String pass, String repass)
    {
        RegisterController passController = new RegisterController();
        return passController.checkPassword(pass,repass);
    }
}
