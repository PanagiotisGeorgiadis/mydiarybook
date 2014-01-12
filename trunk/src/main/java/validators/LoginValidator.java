package validators;

/**
 *
 * @author Stef
 */
public class LoginValidator {

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

    public boolean checkPass(String pass) {
        if (pass.length() > 12 || pass.length() <= 2) {
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

//public boolean checkValues(String username, String pass) {
//        LoginValidator e = new LoginValidator();
//
//        if (!e.checkPass (pass)) {
//            return false;
//        }
//        if (!e.checkUsername(username))
//        {
//            return false;
//        }
//            return true;
//    } 
}
