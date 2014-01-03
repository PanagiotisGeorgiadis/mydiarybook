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
    
    public boolean deleteAElementFromTextList(String username, String entrytitle, String textName){
        
        try{
            return textDao.prepareForDeleteFromList(username, entrytitle, textName);
        }catch(NullPointerException ex){
            return false;
            //TODO logger
        }catch(Exception ex){
            return false;
            //TODO logger
        }
    }
    
     public boolean deleteTextAlbum(String username, String entrytitle){
        
        try{
            
            return textDao.prepareForDeleteAlbum(username, entrytitle);
            
        }catch(Exception ex){
            return false;
            //TODO logger
        }
    }
}
