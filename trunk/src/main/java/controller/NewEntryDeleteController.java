/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.NewEntryDao;

/**
 *
 * @author Zarc
 */
public class NewEntryDeleteController {
    
    public boolean deleteDirectory(String userTitle)
    {
        NewEntryDao deleteDao = new NewEntryDao();
        
        return deleteDao.deleteEntry(userTitle);
        
        
    }
    
}
