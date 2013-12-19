/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.EntriesListDao;
import dao.NewEntryImageDao;

/**
 *
 * @author Zarc
 */
public class MyDiaryBookController {
    
    public MyDiaryBookController()
    {
        //File file = new File("");
    }
    
    public String[] getEntriesList()
    {
        EntriesListDao entryList = new EntriesListDao();
        return entryList.getListOfEntries();
    }
    
    public String[] getImageList(String entryTitle)
    {
        NewEntryImageDao imageDao = new NewEntryImageDao();
        return imageDao.getImageList(entryTitle);       
    }    
}
