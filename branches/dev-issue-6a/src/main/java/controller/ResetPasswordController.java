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
public class ResetPasswordController {
    public boolean ResetPasswordController(String q1, String q2)
    {
        
        if(q1.length() < 2 || q2.length() < 2) return false;
        

        return true;
    }
    
}
