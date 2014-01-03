/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.NewEntryImageDao;

/**
 *
 * @author JohnN'y
 */
public class DeleteImageController {
    NewEntryImageDao imageDao = new NewEntryImageDao();
   // Entry entry;

    public DeleteImageController() {
    }
    
    /*
    * Gia tin periptwsi pou 8a xrisimopoihsw to Entry gian ton Constructor
    *
    public DeleteImageController(Entry entry){
        this.entry = entry;
    }
    */
    
    public boolean deleteAElementFromImageList(String username, String entrytitle, String imageName){
        try{
          //  String[] imageNames = entry.getImageList();
        
                    return imageDao.prepareForDeleteFromList(username, entrytitle, imageName);
                
        }catch(NullPointerException ex){
            return false;
            //TODO logger
        }catch(Exception ex){
            return false;
            //TODO logger
        }
    }
    
    public boolean deleteImageAlbum(String username, String entrytitle){
        
        try{
            
            return imageDao.prepareForDeleteAlbum(username, entrytitle);
            
        }catch(Exception ex){
            return false;
            //TODO logger
        }
    }
    
    
 /*
    Se periptwsi pou xrisimopoihsoume to Entry
    */
//    public boolean checkFileExist(String imageName){
//        int imageCounter = 0;
//            for(String imageNames : entry.getImageList()){
//                if(imageNames.equals(imageName))
//                    imageCounter++;
//            }
//            if(imageCounter > 0)
//                return true;
//            else
//                return false;
//    }
    
}
