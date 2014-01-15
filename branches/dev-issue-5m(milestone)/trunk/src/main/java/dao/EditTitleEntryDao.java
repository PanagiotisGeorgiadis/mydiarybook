/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.File;
import model.Login;

/**
 *
 * @author PTSilopoulos
 */
public class EditTitleEntryDao {
    
    private final String fSeparator = File.separator;    
        
    /**
     * 
     * @param oldFileTitle is the plain name of the file we wish to change it's name
     * @param newFileTitle is the name of the new file that we will create
     * @return true or false depending on whether the rename of FileTitle was successful
     */
    
    public boolean editEntryTitle(String oldFileTitle, String newFileTitle) {
       
        String oldFolderPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+Login.getUsername()
             +fSeparator+"Entries"+fSeparator+oldFileTitle;
        File oldFolder = new File(oldFolderPath);
        
        String newFolderPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+Login.getUsername()
             +fSeparator+"Entries"+fSeparator+newFileTitle;
        File newFolder = new File(newFolderPath);
        
        oldFolder.renameTo(newFolder);
        
        if(newFolder.exists())
        {
            String oldFilePath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+Login.getUsername()
             +fSeparator+"Entries"+fSeparator+newFileTitle+fSeparator+"Texts"+fSeparator+oldFileTitle+".txt";
            File oldFile = new File(oldFilePath);
            
            String newFilePath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+Login.getUsername()
             +fSeparator+"Entries"+fSeparator+newFileTitle+fSeparator+"Texts"+fSeparator+newFileTitle+".txt";
            File newFile = new File(newFilePath);
            
            oldFile.renameTo(newFile);
            
            if(newFile.exists())
                return true;
        }
        return false;
  
     }
   }   

