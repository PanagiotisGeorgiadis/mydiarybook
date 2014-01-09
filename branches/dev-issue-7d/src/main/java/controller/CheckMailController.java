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
public class CheckMailController {
    public boolean checkMail(String email)
    {
        RegisterController mailController = new RegisterController();
        return mailController.checkMail(email);
    }
    
}
