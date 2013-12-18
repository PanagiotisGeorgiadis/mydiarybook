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
public class CheckQ1Controller {
         public boolean checkQ1(String Q1)
    {
        RegisterController q1Controller = new RegisterController();
        return q1Controller.checkPassword(Q1);
    }
    
}
