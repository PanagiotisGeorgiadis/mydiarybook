/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.NewEntryTextDao;

/**
 *
 * @author Zarc
 */
public class NewEntryTextController {
    
    public boolean createTextFile(String userTitle, String userText)
    {
       NewEntryTextDao textDao = new NewEntryTextDao();
       
       return textDao.prepareForCreatingTextFile(userTitle, userText);
    }
    
}
