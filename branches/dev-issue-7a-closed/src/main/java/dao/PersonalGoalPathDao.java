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
public class PersonalGoalPathDao implements IPersonalGoalPathDao {
    
    public PersonalGoalPathDao()
    {
        
    }
    
    @Override
    public String getDefaultPath()
    {
        return "hi";
    }
    @Override
    public String getUserName()
    {
        return "bye";
    }
}
