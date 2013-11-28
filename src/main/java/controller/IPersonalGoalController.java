/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import ui.PersonalGoalForm;

/**
 * Interface του PersonalGoalController.
 * @author alex
 */
public interface IPersonalGoalController {

    boolean createPersonalGoal(PersonalGoalForm theForm) throws Exception, IllegalArgumentException;
    
}
