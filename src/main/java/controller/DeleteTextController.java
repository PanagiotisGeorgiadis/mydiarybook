/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.NewEntryTextDao;

/**
 *
 * @author JohnN'y
 */
public class DeleteTextController {
    
    private NewEntryTextDao textDao = new NewEntryTextDao();

    public DeleteTextController() {
    }
   
    
    public boolean deleteAElementFromTextList( String textName) throws NullPointerException{
        
            return textDao.prepareForDeleteFromList( textName);
        
    }
    
     public boolean deleteTextAlbum (String textPath){
         
            return textDao.prepareForDeleteTextFile( textPath);
            
    }
     
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
