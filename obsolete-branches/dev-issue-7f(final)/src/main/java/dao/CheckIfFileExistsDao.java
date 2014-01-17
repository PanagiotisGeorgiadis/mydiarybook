/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.File;

/**
 *
 * @author Zarc
 */
public class CheckIfFileExistsDao {
    String fSeparator = File.separator;
    /**
    * Checks if the given string exists as file in the Directory you are looking for.
    * @param title
    * @return true if the filePathExists or false if not found
    */
    public boolean filePathExists(String title)
    {
        if(title==null || title.trim().isEmpty())
            return false;
        String path = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
                +fSeparator+"Entries"+fSeparator+title;
        File file = new File(path);
        return file.exists();
    }
    
}
