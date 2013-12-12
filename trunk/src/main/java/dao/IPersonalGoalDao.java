/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.File;
import java.io.FileWriter;

/**
 *
 * @author alex
 */
public interface IPersonalGoalDao {

    /**
     *
     * @param fileName
     */
    void txtLoadPersonalGoal(String fileName);

    //TODO: να ενώσω saveToFile και writeToFilePersonalGoal.
    /**
     *
     * @param fileName
     */
    void saveToFile(String fileName,String title, String location, String withPerson, String whenDate, String announcement);
    
}
