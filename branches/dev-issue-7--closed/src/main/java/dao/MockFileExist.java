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
public class MockFileExist implements IEntriesDao{
    private String textFile = new String("C:\\MyJavaApp\\dev-issu-6\\src\\Controller\\text.txt");

   
   /* 
     @Override
    public String getTextFile() {
        return textFile;
    }
*/
    @Override
    public String getFile() {
        String path = "C:\\MyJavaApp\\dev-issu-6\\src\\Controller\\text.txt";
        return  path;
    }

    @Override
    public void setFile(String textFile) {
        this.textFile = textFile;
    }
    
}
