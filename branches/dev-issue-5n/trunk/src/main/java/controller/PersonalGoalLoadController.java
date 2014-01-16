/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.PersonalGoalListDao;
import exception.EntryException;

/**
 * 
 * @author alex
 */
public class PersonalGoalLoadController {
    /**
     * function getting String[] of list 
     * @param userName
     * @return List 
     */
    public String[] getListOfPesronalGoal(String userName) 
    {
        PersonalGoalListDao personalGoalList = new PersonalGoalListDao();
        return personalGoalList.getListOfPersonalGoal(userName);
    }
    
}
