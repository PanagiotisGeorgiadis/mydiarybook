/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.IDeleteEntriesDao;
import dao.MockFileExist;
import java.io.File;

/**
 *
 * @author JohnN'y
 */
public class DeleteController {
    
    private IDeleteEntriesDao dao = null;   

    public DeleteController(IDeleteEntriesDao dao) {
        this.dao = dao;
    }
    
    public boolean checkFileExistance(File fileText){
        boolean daoFile = dao.findFile(fileText.toString());
        
        if(fileText.exists() && daoFile == true)
            return true;
        else
            return false;
    }
    /**
     * Delete a folder or a file
     * 
     * @param fileText 
     * @return return true if the erase was success
     */
    public boolean delete(File fileText){
    
 
        if(fileText.isDirectory()){
            String subdir[] = fileText.list();
            for(int i = 0 ; i < subdir.length ; i++)
                delete(new File(fileText,subdir[i]));
            fileText.delete();
                }
        else if(fileText.isFile())
            fileText.delete();
        else 
            return false;
        
       if(checkFileExistance(fileText))
           return false;
       else
           return true;      
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
