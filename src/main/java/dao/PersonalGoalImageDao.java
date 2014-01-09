/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 *
 * @author nova
 */
public class PersonalGoalImageDao {
    
    private final String fSeparator = File.separator;
     public boolean ImageForCopy(String title,String path)
    {
      
    
       
        String imageDestPath = System.getProperty("user.dir")+ fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Alex Patsanis"+fSeparator+"PersonalGoal"+ fSeparator + title + fSeparator + "Images" + fSeparator;
        
        
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
        }
        
        return true;
    }
    /*
    public String[] getImageList(String entryTitle)
    {
        INewEntryMockDefaultPath rootPathMock = mock(INewEntryMockDefaultPath.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator);
        
        INewEntryMockUsername userMock = mock(INewEntryMockUsername.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
    
        String imagePath = rootPathMock.getDefaultPath()+userMock.getUsername()+fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Images"+fSeparator;
        
        FilesDao imageDao = new FilesDao();
        try{
            return imageDao.getFilesList(imagePath);
        }
        catch(NullPointerException e)
        {
            String[] exception = null;
            
            return exception;
        }
    }
    */
}
