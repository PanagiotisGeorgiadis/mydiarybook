/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;



/**
 *
 * @author user
 */
public class Login {
    public String username;
    public String password;
    
    public String getusername() {
        return username;
    }
    
    public String getpassword() {
        return password;
    }
    
    public void setusername(String user) {
        this.username = user;
    }
    
    public void setpassword(String pass) {
        this.password = pass;
    }
}

