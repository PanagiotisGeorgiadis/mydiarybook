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
public class Q2Controller {
             public boolean checkQ2(String Q2)
    {
        RegisterValidator q2Controller = new RegisterValidator();
        return q2Controller.checkPassword(Q2);
    }
    
}
