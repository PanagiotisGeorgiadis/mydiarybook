/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.Date;

/**
 *
 * @author alex
 */
public interface IPersonalGoalController {

    //---------------------------------------------------------------------------------------------
    //check if personalGoalAnnouncement is correctly..
    boolean checkPersonalGoalAnnouncement(String personalGoalAnnouncement) throws IllegalArgumentException;

    //---------------------------------------------------------------------------------------------
    // check if  title is correctly..
    boolean checkPersonalGoalLocation(String personalGoalLocation) throws IllegalArgumentException;

    // check if  title is correctly..
    boolean checkPersonalGoalTitle(String personalGoalTitle) throws IllegalArgumentException;

    //---------------------------------------------------------------------------------------------
    // check if WithPerson is correctly..
    boolean checkPersonalGoalWithPerson(String personalGoalWithPerson) throws IllegalArgumentException;

    //---------------------------------------------------------------------------------------------
    boolean checkPersonalGoalWhenDate(String personalGoalWhenDate) throws IllegalArgumentException;

    /*FIXME: Να ελένχει μέσα στην φόρμα μονο απο την createPersonalGoal όλα τα πεδία.
     * ui.PersonalGoalForm
     * line : 242-286
     */
    boolean createPersonalGoal(String personalGoalTitle, String personalGoalLocation, String personalGoalWithPerson, Date personalGoalWhenDate, String personalGoalAnnouncement) throws Exception, IllegalArgumentException;
    //FIXME: να τσεκάρει αν υπάρχει ίδιος τίτλος .και αν ναι να εμφανίζει μνμ λάθος
    /* check if the given personalGoalTitle exist in the file */
    /*
    try{
    boolean resultIfPersonalGoalTitle=false;
    resultIfPersonalGoalTitle=
    PersonalGoalAvailableDao.chechIfTitleIsAvailable(newPersonalGoal.getPersonalGoalTitle());
    if(resultIfPersonalGoalTitle=false){
    System.out.println("The Title exist..\n");
    return false;
    }
    else{
    System.out.println("Title is acceptable\n!");
    }
    }catch (Exception e){
    System.out.println(e);
    }
    // check if can write to file..
    try{
    personalGoalDao.writeToFilePersonalGoal(newPersonalGoal);
    return true;
    }catch (Exception ex){
    System.out.println("File Not Found!");
    return false;
    }
     */
    
}
