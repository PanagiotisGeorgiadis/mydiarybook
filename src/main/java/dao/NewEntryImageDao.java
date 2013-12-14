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
public class NewEntryImageDao {
   
    private final String fSeparator = File.separator;
    
    public NewEntryImageDao()
    {
    }
    
    public boolean prepareImageForCopy(String userTitle,String sourcePath)
    {
        INewEntryMockDefaultPath rootPathMock = mock(INewEntryMockDefaultPath.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator);
        
        INewEntryMockUsername userMock = mock(INewEntryMockUsername.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
    
        String imageDestPath = rootPathMock.getDefaultPath()+userMock.getUsername()+fSeparator+userTitle+fSeparator+"Images"+fSeparator;
        
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
    
}
