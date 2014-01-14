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
    public String[] getListOfPersonalGoal()
    {
        String personalGoalPath = System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator + "Alex Patsanis"  + fSeparator + "PersonalGoal";
        FilesDao personalGoalDao = new FilesDao();
        try{
            return personalGoalDao.getDirectoryList(personalGoalPath);
        }catch(EntryException ex){
            return null;
        }
        //check apo to FilesDaos to getDirectoryList an yparxei kapoio problima
    }
    
}