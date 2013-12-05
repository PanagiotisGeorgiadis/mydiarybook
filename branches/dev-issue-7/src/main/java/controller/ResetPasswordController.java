/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import static ui.ResetPassword.q1;
import static ui.ResetPassword.q2;

/**
 *
 * @author w7user
 */
public class ResetPasswordController {
    public boolean ResetPasswordController(String q1, String q2)
    {
        
        if(q1.length() < 2 || q2.length() < 2 || q2.length() > 20 || q1.length() > 20) 
        {return false;}
        if(q1.contains("[0-9]") || q2.contains("[0-9]")) {return false;}
        

        return true;
    }
  
    
    public static boolean checkValues() {
        ResetPasswordController e = new ResetPasswordController();

        if (!e.ResetPasswordController(q1.getText(), q2.getText())) {
            return false;
        }
        return true;
    }
    
    
}
