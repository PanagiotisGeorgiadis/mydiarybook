/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.PersonalGoalImageDao;

/**
 *
 * @author nova
 */
public class PersonalGoalImageController {
    
     public boolean saveImage(String userTitle,String imagePath)
    {
         
       PersonalGoalImageDao imageDao = new PersonalGoalImageDao();
        
       return imageDao.ImageForCopy(userTitle, imagePath);
    }   
    
}
