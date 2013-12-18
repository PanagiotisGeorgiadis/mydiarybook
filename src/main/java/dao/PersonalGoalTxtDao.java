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
 * @author alex
 */
public class PersonalGoalTxtDao {
    public  String fSeparator = File.separator;
    public boolean prepareForCreatingTextFile(String title, String location, String withPerson, String whenDate, String announcement)
    {
       IPersonalGoalDefaultPathMock userPathMock = mock(IPersonalGoalDefaultPathMock.class);
        when(userPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir")+ fSeparator +"MyDiaryBook"+fSeparator+"Users"+fSeparator);
       IPersonalGoalUserNameMock userNameMock = mock(IPersonalGoalUserNameMock.class);
        when(userNameMock.getUserName()).thenReturn("Alex Patsanis");
        
 
        String textDestPath = userPathMock.getDefaultPath()+userNameMock.getUserName()+fSeparator+"PersonalGoal"+fSeparator+title+fSeparator+"Texts"+fSeparator+title+fSeparator;
        PersonalGoalDao newTextDao = new PersonalGoalDao();
        FilesDao newFile = new FilesDao();
        return newTextDao.saveTextFile( textDestPath, title, location, withPerson, whenDate, announcement);
        
    }
    
}
