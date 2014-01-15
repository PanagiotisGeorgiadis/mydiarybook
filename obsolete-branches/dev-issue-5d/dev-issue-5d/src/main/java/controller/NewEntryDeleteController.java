/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.NewEntryDeleteDao;

/**
 *
 * @author Zarc
 */
public class NewEntryDeleteController {
    
    public boolean deleteDirectory(String userTitle)
    {
        NewEntryDeleteDao deleteDao = new NewEntryDeleteDao();
        
        return deleteDao.prepareForDeleting(userTitle);
        
        
    }
    
}
