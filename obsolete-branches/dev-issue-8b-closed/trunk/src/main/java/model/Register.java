/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Stef
 */
public class Register {

    private String username;
    private String password;
    private String repeatedpassword;
    private String email;

    public String getusername() {
        return username;
    }

    public String getpassword() {
        return password;
    }

    public String getrepeatedpassword() {
        return repeatedpassword;
    }

    public String getemail() {
        return email;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public void setpassword(String password) {
        this.password = password;
    }

    public void setrepeatedpassword(String repeatedpassword) {
        this.repeatedpassword = repeatedpassword;
    }

    public void setmail(String email) {
        this.email = email;
    }

}
