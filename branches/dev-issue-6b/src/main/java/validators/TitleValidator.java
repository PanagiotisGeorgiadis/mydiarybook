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
public class TitleValidator {
    
    /**
     * Boolean function that the control run title
     *
     * @param title
     * @return return true if title is right or return false if is not.
     * @throws IllegalArgumentException
     */
    
    public  boolean titleIsValid(String title) {

        if (title.length() > 0 && title.length() < 3 || title.length() > 25 || "".equals(title)|| title.matches("^\\s*$")
                || ((title.length() >=3 && title.length() <= 25 )&& title.matches("-?\\d+(\\.\\d+)?"))) {
            return false;
        }

        return true;
    }
    
}
