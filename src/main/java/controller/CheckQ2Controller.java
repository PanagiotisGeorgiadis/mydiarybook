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
public class CheckQ2Controller {
             public boolean checkQ2(String Q2)
    {
        RegisterController q2Controller = new RegisterController();
        return q2Controller.checkPassword(Q2);
    }
    
}
