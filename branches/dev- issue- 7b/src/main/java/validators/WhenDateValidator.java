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
public class WhenDateValidator {
     /**
     * Boolean function control run the right thing WhenDate.
     *
     * @param whenDate
     * @return return true if withPerson is right or return false if is not.
     */
    public boolean whenDateIsValid(String whenDate) {

        if ("".equals(whenDate)|| whenDate.matches("^\\s*$") ) {
            return false;
        }

        return true;
    }
}
