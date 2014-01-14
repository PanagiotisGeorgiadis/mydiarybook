/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.PersonalGoalDao;
import java.io.IOException;

/**
 *
 * @author JohnN'y
 */
public class DeletePersonalGoalController {
    PersonalGoalDao dao = new PersonalGoalDao();
    
    public boolean deleteElementFromList(String userName, String entryTitle) throws IOException{
        
        return dao.prepareForDelete(userName, entryTitle);
    }
    
     /**
      * Display a message, which inform us that the file no exist
      * 
      * @return There is not such a file
      */
              public String showNoFileFound(){
                      String message = "There is not such a file";
                     return   message;

             }
     /**
      * Display a error message
      * 
      * @return There was  a undefinied error
      */

              public String showError(){
                  String message = "There was  a undefinied error";
                  return message;
              }
     /**
      * Display a successfull message
      * 
      * @return Successfull Erase
      */

              public String showSuccess(){
                  String message = "Successful Erase";
                  return message;
              }
    
}
