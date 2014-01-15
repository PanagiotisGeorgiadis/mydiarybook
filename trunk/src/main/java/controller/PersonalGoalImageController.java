/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.PersonalGoalImageDao;

/**
 *
 * @author alex
 */
public class PersonalGoalImageController {
    /**
     * function for save image
     * @param userTitle String
     * @param imagePath String
     * @param userName String
     * @return  true if success or false if fail
     */
     public boolean saveImage(String userTitle,String imagePath,String userName)
    {
         
       PersonalGoalImageDao imageDao = new PersonalGoalImageDao();
        
       return imageDao.ImageForCopy(userTitle, imagePath,userName);
    }   
    
}
