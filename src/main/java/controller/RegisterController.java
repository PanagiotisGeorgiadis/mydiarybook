/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

/**
 *
 * @author user
 */
public class RegisterController {

    public boolean checkMail(String email) {

        if (email.length() <= 4) {
            return false;
        }
        if (!email.contains("@") || email.indexOf("@") == 0 || email.indexOf("@") == email.length() - 1 || email.contains("@@")) {
            return false;
        }
        return true;
    }

    public boolean checkUsername(String username) {
        if (username.length() > 20) {
            return false;
        }
        if (username.length() <= 2) {
            return false;
        }
        if (username.contains(" ")) {
            return false;
        }

        return true;
    }

    public boolean checkPassword(String password, String repeatedpassword) {
        if (password.equals(repeatedpassword)) {
            return true;
        }
       
        return false;
    }
        public boolean checkQ1(String Q1) {
        if (Q1.length()>2) {
            return true;
        }
       
        return false;
    }
        public boolean checkQ2(String Q2) {
        if (Q2.length()>2) {
            return true;
        }
       
        return false;
    }

    public boolean checkPassword(String password) {
        if (password.length() > 12 || password.length() <= 2) {
            return false;
        }
        if (password.contains(" ")) {
            return false;
        }

        if (password.matches("[0-9]+") == true) {
            return false;
        }

        return true;
    }

    public static boolean checkValues(String username, String password, String repeatedpassword, String email,String Q1,String Q2) {
        RegisterController e = new RegisterController();
        if (!e.checkMail(email)) {
            return false;

        }
        if (!e.checkQ1(Q1))
        {
            return false;
        }
        if (!e.checkQ1(Q2))
        {
            return false;
        }
        

        if (!e.checkUsername(username)) {
            return false;
        }
        if (!e.checkPassword(password, repeatedpassword)) {
            return false;
        }
        return true;
    }

}
