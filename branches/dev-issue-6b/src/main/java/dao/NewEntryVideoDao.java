/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

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
        INewEntryMockDefaultPath rootPathMock = mock(INewEntryMockDefaultPath.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator);
        INewEntryMockUsername userMock = mock(INewEntryMockUsername.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
        
        String videoDestPath = rootPathMock.getDefaultPath()+userMock.getUsername()+fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Videos"+fSeparator;
        
        File destFile = new File(videoDestPath);
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
    //tsamis
    public boolean videoDelete(String sourcePath, String destPath)
    {
        return true;
    }
    
    public File getVideo(String entryTitle)
    {
        INewEntryMockDefaultPath rootPathMock = mock(INewEntryMockDefaultPath.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator);
        INewEntryMockUsername userMock = mock(INewEntryMockUsername.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
        
        String videoPath = rootPathMock.getDefaultPath()+userMock.getUsername()+fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Videos"+fSeparator;
        
        FilesDao video = new FilesDao();
        try{
            return video.getFile(videoPath);
        }catch(NullPointerException ex){
            return null;
        }
    }
}
