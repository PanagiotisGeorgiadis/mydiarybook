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
public class AnnouncementValidator {
    /**
     * Boolean function control run the right thing Announcement.
     *
     * @param announcement
     * @return  true if Announcement is right or return false if is not.
     */

    
    public boolean announcementIsValid(String announcement) {

        if (announcement.length() > 100 ) {
            return false;
        }

        return true;
    }
 
}
