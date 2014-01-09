/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.File;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Zarc
 */
public class CheckIfFileExistsDao {
    
    /**
    * Checks if the given string exists as file in the Directory you are looking for.
    * @param title
    * @return true if the filePathExists or false if not found
    */
    public boolean filePathExists(String title)
    {
        String fSeparator = File.separator;
        INewEntryMockDefaultPath rootPathMock = mock(INewEntryMockDefaultPath.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator);
        
        INewEntryMockUsername userMock = mock(INewEntryMockUsername.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
        
        if(title==null || title.trim().isEmpty())
            return false;
        File file = new File(rootPathMock.getDefaultPath()+userMock.getUsername()+fSeparator+"Entries"+fSeparator+title);
        return file.exists();
    }
    
}
