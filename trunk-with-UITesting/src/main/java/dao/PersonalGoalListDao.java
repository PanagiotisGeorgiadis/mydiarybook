/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import exception.EntryException;
import java.io.File;

/**
 *
 * @author nova
 */
public class PersonalGoalListDao {
    String fSeparator = File.separator;
    /**
     * Function for take list of personal goal as String[]
     * @param userName String
     * @return  the list String[]
     */
    public String[] getListOfPersonalGoal(String userName)
    {
        try {
            String personalGoalPath = System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator + userName + fSeparator + "PersonalGoal";
            FilesDao personalGoalDao = new FilesDao();
            return personalGoalDao.getDirectoryList(personalGoalPath);
        } catch (EntryException ex) {
            return null;
        }
    
    }
    
    
}
