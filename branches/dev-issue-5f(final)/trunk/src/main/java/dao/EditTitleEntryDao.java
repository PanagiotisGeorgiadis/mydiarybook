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

/**
 *
 * @author PTSilopoulos
 */
public class EditTitleEntryDao {
    
    private final String fSeparator = File.separator;    
        
    /**
     * 
     * @param FileTitle is the plain name of the file we wish to change it's name
     * @return true or false depending on whether the rename of FileTitle was successfull
     */
    
    public boolean editEntryTitle(String FileTitle) {
       
        String FileToEditPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
             +fSeparator+"Entries"+fSeparator+FileTitle+fSeparator+"Texts"+fSeparator;
        Path Source = Paths.get(FileToEditPath);
        
        try {
            Files.move(Source, Source.resolveSibling("NewFileTitle"));
            return true;
        } catch(IOException e) {
            return false;
        }  
     }
   }   

