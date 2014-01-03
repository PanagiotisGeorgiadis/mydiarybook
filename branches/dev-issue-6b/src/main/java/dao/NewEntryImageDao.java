/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Zarc
 */
public class NewEntryImageDao {
   
    private final String fSeparator = File.separator;
    
    public NewEntryImageDao()
    {
    }
    
    public boolean prepareImageForCopy(String entryTitle,String sourcePath)
    {
        INewEntryMockDefaultPath rootPathMock = mock(INewEntryMockDefaultPath.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator);
        
        INewEntryMockUsername userMock = mock(INewEntryMockUsername.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
    
        String imageDestPath = rootPathMock.getDefaultPath()+userMock.getUsername()+fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Images"+fSeparator;
        
        File destFile = new File(imageDestPath);
        File sourceFile = new File(sourcePath);        
        FilesDao copyDao = new FilesDao();
        
        try
        {
            copyDao.copyFile(sourceFile,destFile);
        }
        catch(IOException e)
        {
            return false;
        }
        
        return true;
    }
    
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
    
    public List<URI> getImageFiles(String entryTitle)
    {
        INewEntryMockDefaultPath rootPathMock = mock(INewEntryMockDefaultPath.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator);
        
        INewEntryMockUsername userMock = mock(INewEntryMockUsername.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
    
        String imagePath = rootPathMock.getDefaultPath()+userMock.getUsername()+fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Images"+fSeparator;
        
        FilesDao imageDao = new FilesDao();
        try{
            return imageDao.getSubFiles(imagePath);
        }catch(NullPointerException ex){
            return null;
        }
        
    }
    
    /**
     * This method try to prepare the user-choice from List for erase. 
     * @param username
     * @param entrytitle
     * @param imageName
     * @return true if the erasion was successful
     * @throws NullPointerException
     */
  
  public boolean prepareForDeleteFromList(String username, String entrytitle, String imageName){
      
      Path path = Paths.get(System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users"+ fSeparator + username + fSeparator + "Entries" + fSeparator + entrytitle + fSeparator
                                         + "Images" + fSeparator + imageName);
      System.out.println(path);
      
      if(path.toFile().exists()){
      
      try{
          FilesDao fileDelete = new FilesDao();
          fileDelete.deleteDirectory(path.toFile());
   
      }catch(Exception ex){
          //TODO logger
      }finally{
          
          if(path.toFile().exists())
           return false;
       else
           return true;
          }
      }
      else
          return false;
      
       
    }
     
  
  /**
   * This method try to prepare the whole user's Image folder
   * @param username
   * @param entrytitle
   * @return true if erasion was successful
   * @throws NullPointerException
   */
  public boolean prepareForDeleteAlbum(String username, String entrytitle){
    Path path = Paths.get(System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users"+ fSeparator + username + fSeparator + "Entries" + fSeparator + entrytitle + fSeparator
                                         + "Images");
    if(path.toFile().exists()){
      FilesDao fileDelete = new FilesDao();
      try{
          
          fileDelete.delete(path.toFile());
 
      }catch(Exception ex){
          return false;
          //TODO logger
      }finally{
          
          if(path.toFile().exists())
           return false;
       else
           return true;
          
      }
    }
    else
        return false;
  }
    
}
