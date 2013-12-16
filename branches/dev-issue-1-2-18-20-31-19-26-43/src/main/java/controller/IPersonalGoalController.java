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
public interface IPersonalGoalController {

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
    boolean createPersonalGoal( String title, String location, String withPerson, String whenDate, String announcement);
    
}
