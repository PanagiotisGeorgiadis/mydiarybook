/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import ui.IPersonalGoalForm;

/**
 *
 * @author alex
 */
public interface IPersonalGoalEvaluator {

    /**
     * CheckField check if all Field is success!!
     * @param form
     * @param title
     * @param location
     * @param withPerson
     * @param whenDate
     * @param announcement
     * @return true if is success or false if they don't
     */
    String CheckField(String title, String location, String withPerson, String whenDate, String announcement);

    boolean checkPersonalGoalAnnouncement(String Announcement);

    /**
     *  Boolean συνάρτηση που ελένχει το Location .
     * @param Location
     * @return επιστρέφει true αν το Location είναι σωστό και false εαν δεν είναι σωστό.
     */
    boolean checkPersonalGoalLocation(String Location);

    /**
     * Boolean συνάρτηση που ελένχει το title
     * @param Title
     * @return επιστρέφει true αν είναι σωστό και false εαν δεν είναι σωστό.
     * @throws IllegalArgumentException
     */
    boolean checkPersonalGoalTitle(String Title);
    //---------------------------------------------------------------------------------------------
    // check if  title is correctly..

    //---------------------------------------------------------------------------------------------
    /**
     * Boolean συνάρτηση που ελένχει το WhenDate.
     * @param WhenDate
     * @return επιστρέφει true αν αν WhenDate είναι είναι και false εαν δεν είναι σωστό.
     * @throws IllegalArgumentException
     */
    boolean checkPersonalGoalWhenDate(String WhenDate);
    //---------------------------------------------------------------------------------------------
    //check if personalGoalAnnouncement is correctly..
    /**
     * Boolean συνάρτηση που ελένχει το Announcement.
     * @param personalGoalAnnouncement
     * @return επιστρέφει true αν το personalGoalAnnouncement είναι σωστό και false εαν δεν είναι σωστό.
     * @throws IllegalArgumentException
     */

    //---------------------------------------------------------------------------------------------
    // check if WithPerson is correctly..
    /**
     * Boolean συνάρτηση που ελένχει το WithPerson.
     * @param WithPerson
     * @return επιστρέφει true αν το WithPerson είναι σωστό και false εαν δεν είναι σωστό.
     * @throws IllegalArgumentException
     */
    boolean checkPersonalGoalWithPerson(String WithPerson);
    
}
