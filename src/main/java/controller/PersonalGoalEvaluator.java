/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.PersonalGoalDao;
import javax.swing.JOptionPane;
import ui.IPersonalGoalForm;
import ui.PersonalGoalForm;

/*
 **Ένας απλός Evaluator που ελένχει αν είναι σωστά τα πεδία απο την φόρμα μας έμμεσα
 * @param personalGoalTitle        : Ο τίτλος του προσωπικόυ στόχου (Personal Goal)
 * @param personalGoalLocation     : Το όνομα της τοποθεσίας.
 * @param personalGoalWithPerson   : Το όνομα του προσώπου που υλοποιούμε μαζι τον προσωπικό στόχο.
 * @param personalGoalWhenDate     : Η ημερομηνία του προσωπικόυ στόχου.
 * @param personalGoalAnnouncement : Το Announcement .
 * @return επιστρέφει ενα true για την κάθε διαφορετική συνάρτηση εάν όλα τα πεδία είναι σωστά αλλίως επιστρέφει false.
 * @throws IllegalArgumentException
 *@author alex
 */
public class PersonalGoalEvaluator implements IPersonalGoalEvaluator {

    /**
     * Boolean συνάρτηση που ελένχει το title
     *
     * @param Title
     * @return επιστρέφει true αν είναι σωστό και false εαν δεν είναι σωστό.
     * @throws IllegalArgumentException
     */
    public PersonalGoalEvaluator() {

    }

    @Override
    public boolean checkPersonalGoalTitle(String Title) {

        if (Title.length() > 0 && Title.length() < 3 || Title.length() > 25 || "".equals(Title)) {
            return false;
        }

        return true;
    }
    //---------------------------------------------------------------------------------------------
    // check if  title is correctly.. 

    /**
     * Boolean συνάρτηση που ελένχει το Location .
     *
     * @param Location
     * @return επιστρέφει true αν το Location είναι σωστό και false εαν δεν
     * είναι σωστό.
     */
    @Override
    public boolean checkPersonalGoalLocation(String Location) {

        if (Location.length() > 0 && Location.length() < 3 || Location.length() > 25 || "".equals(Location)) {
            return false;
        }

        return true;
    }

    //---------------------------------------------------------------------------------------------
    // check if WithPerson is correctly.. 
    /**
     * Boolean συνάρτηση που ελένχει το WithPerson.
     *
     * @param WithPerson
     * @return επιστρέφει true αν το WithPerson είναι σωστό και false εαν δεν
     * είναι σωστό.
     * @throws IllegalArgumentException
     */
    @Override
    public boolean checkPersonalGoalWithPerson(String WithPerson) {

        if (WithPerson.length() > 0 && WithPerson.length() < 3 || WithPerson.length() > 25) {
            return false;
        }
        return true;
    }
   //---------------------------------------------------------------------------------------------

    /**
     * Boolean συνάρτηση που ελένχει το WhenDate.
     *
     * @param WhenDate
     * @return επιστρέφει true αν αν WhenDate είναι είναι και false εαν δεν
     * είναι σωστό.
     * @throws IllegalArgumentException
     */
    @Override
    public boolean checkPersonalGoalWhenDate(String WhenDate) {

        if ("".equals(WhenDate)) {
            return false;
        }

        return true;

    }
    //---------------------------------------------------------------------------------------------
    //check if personalGoalAnnouncement is correctly..
    /**
     * Boolean συνάρτηση που ελένχει το Announcement.
     *
     * @param personalGoalAnnouncement
     * @return επιστρέφει true αν το personalGoalAnnouncement είναι σωστό και
     * false εαν δεν είναι σωστό.
     * @throws IllegalArgumentException
     */

    @Override
    public boolean checkPersonalGoalAnnouncement(String Announcement) {

        if (Announcement.length() > 100) {
            return false;
        }

        return true;

    }

    /**
     * CheckField check if all Field is success!!
     *
     * @param form
     * @param title
     * @param location
     * @param withPerson
     * @param whenDate
     * @param announcement
     * @return true if is success or false if they don't
     */
    @Override
    public String CheckField(String title, String location, String withPerson, String whenDate, String announcement) {
        //boolean 
        int i, y;
        boolean FieldSuccess;
        //number 5 is the fields of personal goal model
        int checkField = 5;

        //   PersonalGoalEvaluator eval = new PersonalGoalEvaluator();
        PersonalGoalForm newPersonalGoalForm = new PersonalGoalForm();
        PersonalGoalDao newDao = new PersonalGoalDao();

        boolean[] Check = new boolean[5];
        Check[0] = this.checkPersonalGoalTitle(title);
        Check[1] = this.checkPersonalGoalLocation(location);
        Check[2] = this.checkPersonalGoalWithPerson(withPerson);
        Check[3] = this.checkPersonalGoalWhenDate(whenDate);
        Check[4] = this.checkPersonalGoalAnnouncement(announcement);

        boolean[] checkedField = new boolean[5];

        for (i = 0; i < 5; i++) {
            if (!Check[i]) {
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
