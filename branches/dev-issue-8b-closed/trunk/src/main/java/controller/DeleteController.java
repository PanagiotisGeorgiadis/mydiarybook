/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.MockFileExist;
import dao.MockFileNoExist;
import dao.IEntriesDao;
import java.io.File;


/**
 *
 * @author JohnN'y
 */
public class DeleteController {
    
        private IEntriesDao dao = new MockFileExist();
        private String message = null;
        private String path = null;

        public DeleteController() {
        }
        
        
        public DeleteController(IEntriesDao dao) {
            
            this.dao = dao;
            
        }

        public boolean checkFileExistance(File fileText){

            path = fileText.toString();
            try{
                if(dao.getFile().equals(path) && fileText.exists() )
                return true;
                else{
             //   message = showNoFileFound();
                return false;
                }
            }catch(NullPointerException e){
                return false;
            }
            }
        
        //Ginete i diagrafi tou arxeiou
        public boolean delete(File fileText){
          if(checkFileExistance(fileText)){             
           
                fileText.delete();
                dao.setFile(null);
               if(fileText.exists()  && dao.getFile().equals(null))
                   return false;
               
               else
                   return true;
          }
         else
              return false;
         }
        
        //Emfanizei mnm la8ous
         public String showNoFileFound(){
                 String message = "There is not such a file";
                return   message;
                      
        }
        
         public String showError(){
             String message = "There was  a undefinied error";
             return message;
         }
         
         public String showSuccess(){
             String message = "Successful Erase";
             return message;
         }
    
}
