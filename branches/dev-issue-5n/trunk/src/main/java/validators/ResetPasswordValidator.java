/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validators;



/**
 *
 * @author w7user
 */
public class ResetPasswordValidator {
    public boolean ResetPasswordController(String q1, String q2)
    {
        
        if(q1.length() < 2 || q2.length() < 2 || q2.length() > 20 || q1.length() > 20) 
        {return false;}
        if(q1.contains("[0-9]") || q2.contains("[0-9]")) {return false;}
        

        return true;
    }
  
    
    public boolean checkValues(String q1,String q2) {
        ResetPasswordValidator e = new ResetPasswordValidator();

        if (!e.ResetPasswordController(q1, q2)) {
            return false;
        }
        return true;
    }
    
    
}
