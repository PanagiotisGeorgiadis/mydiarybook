/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

/**
 *
 * @author alex
 */
public interface IPersonalGoalDao {

    boolean saveTextFile(String path, String title, String location, String withPerson, String whenDate, String announcement);

    /**
     *
     * @param fileName
     */
    
    
}
