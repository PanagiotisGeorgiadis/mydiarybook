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
public class EntriesListDao {
    
    public String[] getListOfEntries()
    {
        String fSeparator = File.separator;
        INewEntryMockDefaultPath rootPathMock = mock(INewEntryMockDefaultPath.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator);
        INewEntryMockUsername userMock = mock(INewEntryMockUsername.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
    
        String entriesPath = rootPathMock.getDefaultPath()+userMock.getUsername()+fSeparator+"Entries";
        FilesDao entriesDao = new FilesDao();
        return entriesDao.getDirectoryList(entriesPath);
    }
    
}
