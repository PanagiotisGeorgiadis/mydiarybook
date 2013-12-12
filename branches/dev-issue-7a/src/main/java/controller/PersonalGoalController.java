/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IPersonalGoalDao;
import dao.PersonalGoalDao;
import ui.IPersonalGoalForm;
import ui.PersonalGoalForm;


/*
 **Ένας απλός controller που μέσω checkPersonalGoalTitle,checkPersonalGoalLocation,checkPersonalGoalWithPerson
 *checkPersonalGoalWhenDate checkPersonalGoalAnnouncement.
 *Ελένχει αν τα πεδία που δίνουμε είναι σωστά αλλίως επιστρέφει μήνυμα λάθους.
 * @param personalGoalTitle        : Ο τίτλος του προσωπικόυ στόχου (Personal Goal)
 * @param personalGoalLocation     : Το όνομα της τοποθεσίας.
 * @param personalGoalWithPerson   : Το όνομα του προσώπου που υλοποιούμε μαζι τον προσωπικό στόχο.
 * @param personalGoalWhenDate     : Η ημερομηνία του προσωπικόυ στόχου.
 * @param personalGoalAnnouncement : Το Announcement .
 * @return επιστρέφει ενα true εάν όλα τα πεδία είναι σωστά αλλίως false.
 * @throws 
 *@author alex
 */
public class PersonalGoalController implements IPersonalGoalController {

    private String title;
    private String location;
    private String withPerson;
    private String whenDate;
    private String announcement;

    public IPersonalGoalDao newPersonalGoalDao;

    public PersonalGoalController(IPersonalGoalDao personalGoalDao) {

        this.newPersonalGoalDao = personalGoalDao;

    }

    public PersonalGoalController() {

    }
 
    /**
     * Boolean συνάρτηση που ελένχει όλα τα πεδία της φόρμας εάν είναι σωστά
     *
     * @param title
     * @param location
     * @param withPerson
     * @param whenDate
     * @param announcement
     * @return βάζει την εγγραφή μέσα σε ενα αρχείο.
     * @throws Exception
     */
    //TODO : Make createPersonalGoal string for success testing
    @Override
    public boolean createPersonalGoal(String title, String location, String withPerson, String whenDate, String announcement) {
        this.title = title;
        this.location = location;
        this.withPerson = withPerson;
        this.whenDate = whenDate;
        this.announcement = announcement;


        PersonalGoalForm theForm = new PersonalGoalForm();
        PersonalGoalDao newDao = new PersonalGoalDao();
        PersonalGoalEvaluator eval = new PersonalGoalEvaluator();
        //check if allFieldSuccess 
        String allFieldSuccess = eval.CheckField(title, location, withPerson, whenDate, announcement);
        //if all is ok save to file
        if (allFieldSuccess == "success") {
            //TODO: make name of file the real name of user
            String file = "user.txt";
            newDao.saveToFile(file, title, location, withPerson, whenDate, announcement);
           theForm.displaySuccessMessage("success");
            return true;
        } else {
            theForm.displayErrorMessage(allFieldSuccess+" is incorect!");
            return false;
        }
        
        
    }
    

       
                    }
