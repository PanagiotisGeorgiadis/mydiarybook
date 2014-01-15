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
public class MailController {
    public boolean checkMail(String email)
    {
        RegisterValidator mailController = new RegisterValidator();
        return mailController.checkMail(email);
    }
    
}
