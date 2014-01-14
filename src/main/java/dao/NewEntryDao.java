/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.File;
import java.text.SimpleDateFormat;
import model.Login;

/**
 *
 * @author Zarc
 */
public class NewEntryDao {
    String fSeparator = File.separator;
    public boolean deleteEntry(String entryTitle)
    {
        String fileToDeletePath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+Login.getUsername()
                +fSeparator+"Entries"+fSeparator+entryTitle+fSeparator;
        
        FilesDao deleteDao = new FilesDao();
        File file = new File(fileToDeletePath);
        return deleteDao.deleteDirectory(file);
    }
    
    public String getEntryLastModified(String entryTitle)
    {
        
        String entryPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+
                fSeparator+"Entries"+fSeparator+entryTitle+fSeparator;
        File entryFile = new File(entryPath);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy     HH:mm:ss");
        return sdf.format(entryFile.lastModified());
    }
    

    
}
