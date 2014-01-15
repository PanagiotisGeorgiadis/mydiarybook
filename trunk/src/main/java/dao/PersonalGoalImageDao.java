/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import exception.EntryException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author alex
 */
public class PersonalGoalImageDao {
    
    private final String fSeparator = File.separator;
    /**
     * Function for copy a image..
     * @param title string
     * @param path  string
     * @param userName  string
     * @return true if copy is success or  false if is not.
     */
     public boolean ImageForCopy(String title,String path,String userName)
    {
      
    
       
        String imageDestPath = System.getProperty("user.dir")+ fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+userName+fSeparator+"PersonalGoal"+ fSeparator + title + fSeparator + "Images" + fSeparator;
        
        
        File destFile = new File(imageDestPath);
        File sourceFile = new File(path);        
        FilesDao copyDao = new FilesDao();
        
        try
        {
            copyDao.copyFile(sourceFile,destFile);
            
            File  imageStringFile =  new File(imageDestPath + "imageString.txt");
           
           
                FileWriter imageStringWritter = new FileWriter(imageStringFile, true);
                BufferedWriter imageStringBufferedWriter = new BufferedWriter(imageStringWritter);
                imageStringBufferedWriter.write(path);
                imageStringBufferedWriter.close();
                imageStringWritter.close();
           
        }
        catch(IOException e)
        {
            return false;
        }catch(EntryException ex){
            return false;
        }
        
        return true;
    }
   
}
