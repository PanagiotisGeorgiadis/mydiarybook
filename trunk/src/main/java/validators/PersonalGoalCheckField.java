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
public class PersonalGoalCheckField {
    
    /**
     * CheckField check if all Field is success!!
     *
     * @param title
     * @param location
     * @param withPerson
     * @param whenDate
     * @param announcement
     * @return true if is success or false if they don't
     */
    
     public String CheckField(String title, String location, String withPerson, String whenDate, String announcement) {
        //boolean 
        int i, y;
        boolean FieldSuccess;
        //number 5 is the fields of personal goal model
        int checkField = 5;

  
        TitleValidator titleValidator = new TitleValidator();
        LocationValidator locationValidator = new LocationValidator();
        WithPersonValidator withPersonValidator = new WithPersonValidator();
        WhenDateValidator whenDateValidator = new WhenDateValidator();
        AnnouncementValidator announcementValidator = new AnnouncementValidator();

        boolean[] check = new boolean[5];
        check[0] = titleValidator.titleIsValid(title);
        check[1] = locationValidator.locationIsValid(location);
        check[2] = withPersonValidator.withPersonIsValid(withPerson);
        check[3] = whenDateValidator.whenDateIsValid(whenDate);
        check[4] = announcementValidator.announcementIsValid(announcement);

 

        for (i = 0; i < 5; i++) {
            if (!check[i]) {
                switch (i) {
                    case 0:
                        return "Title";
                    case 1:
                        return "Location";

                    case 2:
                        return "WithPerson";
                    case 3:
                        return "WhenDate";
                    case 4:
                        return "Announcement";
                }

            }

        }
        return "success";

    }
    
}
