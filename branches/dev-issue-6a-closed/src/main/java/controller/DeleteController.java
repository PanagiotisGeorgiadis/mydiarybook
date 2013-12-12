/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.IEntriesDao;
import dao.MockFileExist;
import java.io.File;

/**
 *
 * @author JohnN'y
 */
public class DeleteController {
    
    private IEntriesDao dao = null;   

    public DeleteController(IEntriesDao dao) {
        this.dao = dao;
    }
    
    public boolean checkFileExistance(File fileText){
        
        if(fileText.exists() && dao.getFile().equals(fileText.toString()))
            return true;
        else
            return false;
    }
    /**
     * Delete a folder or a file
     * 
     * @param fileText 
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
