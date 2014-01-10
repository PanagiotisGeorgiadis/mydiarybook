/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.File;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Zarc
 */
public class NewEntryTextDao {
    
    private final String fSeparator = File.separator;
    
    public NewEntryTextDao()
    {
        
    }
    
    public boolean createTextFile(String entryTitle,String userText)
    {
        String textDestPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
                +fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Texts"+fSeparator;
        
        FilesDao textDao = new FilesDao();
        
        return textDao.createTextFile(textDestPath, userText, entryTitle);
        
    }
    
    public String returnTextFromTextFile(String entryTitle)
    {
        String textPath =System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Texts"+fSeparator+entryTitle+".txt";
        FilesDao textDao = new FilesDao();
        try{
            return textDao.returnTextFile(textPath);
        }catch(IOException ex){
            return "";
        }
    }
    
    public String returnTextFilePath(String entryTitle,String userName)
    {
        String textPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+
                userName+fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Texts";
        return textPath;
    }
    
}
