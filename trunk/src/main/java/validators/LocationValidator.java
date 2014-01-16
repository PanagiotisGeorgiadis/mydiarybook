/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validators;

/**
 *
 * @author alex
 */
public class LocationValidator {
    
     /**
     * Boolean function control run the right thing Location .
     *
     * @param location
     * @return return true if location is right or return false if is not.
      * @author alex
     */
     public  boolean locationIsValid(String location) {

        if (location.length() > 0 && location.length() < 3 || location.length() > 25 || "".equals(location) || location.matches("^\\s*$")
                || ((location.length() >=3 && location.length() <= 25 )&& location.matches("-?\\d+(\\.\\d+)?"))) {
            return false;
        }

        return true;
    }
}
