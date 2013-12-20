/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.EntriesListDao;

/**
 *
 * @author Zarc
 */
public class LoadEntriesController {
    
    public String[] getEntriesList()
    {
        EntriesListDao listOfEntries = new EntriesListDao();
        return listOfEntries.getListOfEntries();
    }
    
}
