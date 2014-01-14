/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/**
 *
 * @author PTsilopoulos */

public class EditDirectoryNameDao {
    
     private final String fSeparator = File.separator;    
    
    /**
     * 
     * @param DirectoryTitle is the name of the new Directory we want to move an existing file into
     * @return true or false depending on whether the creation of the new Directory, was successfull
     */
    
     public boolean editDirectoryTitle(String DirectoryTitle) {
         
         String SourcePath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
             +fSeparator+"Entries"+fSeparator+"Texts"+fSeparator;
         String NewPath =  System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
             +fSeparator+DirectoryTitle+fSeparator;
        Path Source = Paths.get(SourcePath);
        
        try {
            Path NewDirPath = Paths.get(NewPath);
            Files.move(Source, NewDirPath.resolve(Source.getFileName()), REPLACE_EXISTING);
            return true;
        } catch(IOException e) {
            return false;
        } 
     }        
}    