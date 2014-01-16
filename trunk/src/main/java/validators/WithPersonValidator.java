/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validators;

import java.text.NumberFormat;
import java.text.ParsePosition;

/**
 *
 * @author alex
 */
public class WithPersonValidator {
    
     /**
     * Boolean function control run the right thing WithPerson.
     *
     * @param withPerson
     * @return return true if withPerson is right or return false if is not.
     */

    
    public boolean withPersonIsValid(String withPerson) {
        //||  withPerson.matches("^\\s*$")
       

        if (withPerson.length() > 0 && withPerson.length() < 3 || withPerson.length() > 25 ||  
                ((withPerson.length() >=3 && withPerson.length() <= 25 )&& withPerson.matches(".*\\d.*"))){
            return false;
        }
        return true;
 
 
  
            
                
        }

        
    
  }
    



