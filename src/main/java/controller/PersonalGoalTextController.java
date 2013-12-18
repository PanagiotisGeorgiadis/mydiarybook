/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.PersonalGoalTxtDao;

/**
 *
 * @author alex
 */
public class PersonalGoalTextController {
    
     public boolean createTextFile(String title, String location, String withPerson, String whenDate, String announcement)
    {
       PersonalGoalTxtDao newTextDao = new PersonalGoalTxtDao();
       return newTextDao.prepareForCreatingTextFile( title,  location,  withPerson,  whenDate,  announcement);
    }
    
}
