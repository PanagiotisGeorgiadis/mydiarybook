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

    public boolean checkChangePasswordController(String pass, String repeatpass) {
        if (!pass.equals(repeatpass) || pass.length()<4) {
            return false;
        }

        return true;
    }

    public boolean checkChangePasswordController(String pass) {

        if (pass.length() > 40 || pass.length() < 2) {
            return false;
        }
        if (pass.contains(" ")) {
            return false;
        }
        if (pass.matches("[0-9]+") == true) {
            return false;
        }

        return true;
    }

    public boolean checkValues(String password,String repeatpassword ) {
        ChangePasswordController e = new ChangePasswordController();

        if (!e.checkChangePasswordController(password,repeatpassword)) {
            return false;
        }
        return true;
    }

}
