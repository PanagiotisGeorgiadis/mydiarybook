/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
public class PersonalGoalEvaluator {
    
    /**
     * Boolean συνάρτηση που ελένχει το title 
     * @param personalGoalTitle
     * @return επιστρέφει true αν είναι σωστό και false εαν δεν είναι σωστό.
     * @throws IllegalArgumentException 
     */

    public boolean checkPersonalGoalTitle(String personalGoalTitle) throws IllegalArgumentException {

        boolean result;
        String checkNull = "";

        if (personalGoalTitle.length() > 0 && personalGoalTitle.length() < 3) {

            result = false;

        } else if (personalGoalTitle.length() > 25) {

            result = false;

        } else if (personalGoalTitle.equals(checkNull)) {

            result = false;

        } else {
            result = true;
        }
        return result;

    }
   //---------------------------------------------------------------------------------------------
    // check if  title is correctly.. 
    
    /**
     *  Boolean συνάρτηση που ελένχει το Location .
     * @param personalGoalLocation
     * @return επιστρέφει true αν το Location είναι σωστό και false εαν δεν είναι σωστό.
     */

    public boolean checkPersonalGoalLocation(String personalGoalLocation)  {
        boolean result;
        String checkNull = "";

        if (personalGoalLocation.length() > 0 && personalGoalLocation.length() < 3) {

            result = false;

        } else if (personalGoalLocation.length() > 25) {

            result = false;

        } else if (personalGoalLocation.equals(checkNull)) {

            result = false;

        } else {
            result = true;
        }
        return result;

    }
    //---------------------------------------------------------------------------------------------
    // check if WithPerson is correctly.. 
    /**
     * Boolean συνάρτηση που ελένχει το WithPerson.
     * @param personalGoalWithPerson
     * @return επιστρέφει true αν το WithPerson είναι σωστό και false εαν δεν είναι σωστό.
     * @throws IllegalArgumentException 
     */

    public boolean checkPersonalGoalWithPerson(String personalGoalWithPerson) throws IllegalArgumentException {
        boolean result;

        if (personalGoalWithPerson.length() > 0 && personalGoalWithPerson.length() < 3) {

            result = false;

        } else if (personalGoalWithPerson.length() > 25) {
            result = false;

        } else {
            result = true;
        }
        return result;

    }
   //---------------------------------------------------------------------------------------------
/**
 * Boolean συνάρτηση που ελένχει το WhenDate.
 * @param personalGoalWhenDate
 * @return επιστρέφει true αν το WhenDate είναι σωστό και false εαν δεν είναι σωστό.
 * @throws IllegalArgumentException 
 */
    public boolean checkPersonalGoalWhenDate(String personalGoalWhenDate) throws IllegalArgumentException {
        boolean result;
        String checkNull;
        checkNull = " ";

        if (personalGoalWhenDate.equals(checkNull)) {

            result = false;

        } else {
            result = true;
        }
        return result;

    }
     //---------------------------------------------------------------------------------------------
    //check if personalGoalAnnouncement is correctly..
    /**
     * Boolean συνάρτηση που ελένχει το Announcement.
     * @param personalGoalAnnouncement
     * @return επιστρέφει true αν το personalGoalAnnouncement είναι σωστό και false εαν δεν είναι σωστό.
     * @throws IllegalArgumentException 
     */

    public boolean checkPersonalGoalAnnouncement(String personalGoalAnnouncement) throws IllegalArgumentException {
        boolean result;

        if (personalGoalAnnouncement.length() > 150) {

            result = false;

        } else {
            result = true;
        }
        return result;

    }

}
