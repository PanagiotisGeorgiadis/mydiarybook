package controller;

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

        return true;
    }
}

