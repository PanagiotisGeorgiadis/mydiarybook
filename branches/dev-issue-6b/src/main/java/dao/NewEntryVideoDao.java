/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import exception.EntryException;
import java.io.File;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Zarc
 */
public class NewEntryVideoDao {

    private final String fSeparator = File.separator;
    
    public NewEntryVideoDao()
    {     
    }
        
    public boolean copyVideo(String entryTitle,String sourcePath)
    {
        if(entryTitle==null || sourcePath == null || entryTitle.trim().equals("") || sourcePath.trim().equals("")) 
            return false;
        String videoDestPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
                +fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Videos"+fSeparator;
        try
        {
            File destFile = new File(videoDestPath);
            File sourceFile = new File(sourcePath);        
            FilesDao copyDao = new FilesDao();
            copyDao.copyFile(sourceFile,destFile);
        }
        catch(EntryException ex)
        {
            return false;
        }
        return true;
    }

//    public boolean videoDelete(String sourcePath, String destPath)
//    {
//        return true;
//    }
    
    public File getVideoFile(String entryTitle)
    {
        String videoPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
                +fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Videos"+fSeparator;
        
        FilesDao video = new FilesDao();
        try{
            return video.getFile(videoPath);
        }catch(EntryException ex){
            return null;
        }
    }
    
    public boolean prepareForDeleteAlbum(File videoFile){
//    Path path = Paths.get(System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users"+ fSeparator + username + fSeparator + "Entries" + fSeparator + entrytitle + fSeparator
//                                         + "Videos");
//    if(videoFile.exists()){
      FilesDao fileDelete = new FilesDao();
      try{
          
          return fileDelete.delete(videoFile);
 
      }catch(Exception ex){
          return false;
          //TODO logger
      }
//      finally{
//          
//          if(videoFile.exists())
//           return false;
//       else
//           return true;
//          
//      }
//    }
//    else
//        return false;
  }
    
}
