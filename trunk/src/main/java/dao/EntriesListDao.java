/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import exception.EntryException;
import java.io.File;

/**
 *
 * @author Zarc
 */
public class EntriesListDao {
    String fSeparator = File.separator;
    public String[] getListOfEntries()
    {
        String entriesPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries";
        FilesDao entriesDao = new FilesDao();
        try{
            return entriesDao.getDirectoryList(entriesPath);
        }catch(EntryException ex){
            return null;
        }
    }
    
}
