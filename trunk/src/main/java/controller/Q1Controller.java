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
public class Q1Controller {
         public boolean checkQ1(String Q1)
    {
        RegisterValidator q1Controller = new RegisterValidator();
        return q1Controller.checkPassword(Q1);
    }
    
}
