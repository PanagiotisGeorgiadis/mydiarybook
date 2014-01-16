/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import model.Login;

/**
 *
 * @author w7user
 */
public class LoggedInController {
    
    public boolean loggedIn()
    {
        try{
            if(Login.getUsername().equalsIgnoreCase(""))
            {
                return false;
            }
            return true;
        }catch(NullPointerException ex){
            return false;
        }
    }
    
}
