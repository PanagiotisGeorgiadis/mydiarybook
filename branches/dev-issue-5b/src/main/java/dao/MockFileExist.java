/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.File;

/**
 *
 * @author JohnN'y
 */
public class MockFileExist implements IDeleteEntriesDao{
    private String textFile = new String(System.getProperty("user.dir")+"\\Text");

   
   /* 
     @Override
    public String getTextFile() {
        return textFile;
    }
*/
    @Override
    public String getFile() {
        return  textFile;
    }

    @Override
    public void setFile(String textFile) {
        this.textFile = textFile;
    }

    @Override
    public boolean findFile(String textFile) {
            return true;
    }
    
}
