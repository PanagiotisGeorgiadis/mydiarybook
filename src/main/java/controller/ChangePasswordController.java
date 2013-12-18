package controller;

import static ui.ChangePassword.password;
import static ui.ChangePassword.repeatpassword;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author w7user
 */
public class ChangePasswordController {
    

 public boolean checkChangePasswordController(String pass, String repeatpass)
    {
        if(!pass.equals(repeatpass)) return false;
        if(pass.length() > 40 || pass.length() < 2) return false;
        if(pass.contains(" ")) return false;
       if(pass.matches("[0-9]+")==true) return false;
            
        return true;
    }

 public static boolean checkValues() {
        ChangePasswordController e = new ChangePasswordController();

        if (!e.checkChangePasswordController(password.getText(), repeatpassword.getText())) {
            return false;
        }
        return true;
    }


}

