/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.File;
import java.io.IOException;
import model.Login;
import org.apache.commons.io.FileUtils;



/**
 *
 * @author PTsilopoulos
 */
public class EditTextEntryController {
       
    private final String fSeparator = File.separator;
    
    public void writeStringToFile(String EntryTitle, String Data) {
        String path = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+Login.getUsername()
        +fSeparator+"Entries"+fSeparator+EntryTitle+fSeparator+"Texts"+fSeparator+EntryTitle+".txt";
        File TextFile = new File(path);
        try {    
            FileUtils.writeStringToFile(TextFile, Data);
        } catch(IOException e) {   
           }
    }
    
    public boolean checkEdit(String textToEdit)
    {
        if(("").equals(textToEdit.trim())) {
            return false;
        }
        else {
        }
        return true;
    }
}
