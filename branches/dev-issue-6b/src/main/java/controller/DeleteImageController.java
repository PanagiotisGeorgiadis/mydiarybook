/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.NewEntryImageDao;
import java.net.URI;
import model.IEntry;

/**
 *
 * @author JohnN'y
 */
public class DeleteImageController {
    private NewEntryImageDao imageDao = new NewEntryImageDao();
    private IEntry entry;

    public DeleteImageController(IEntry entry) {
               this.entry = entry;
    }
    
    /*
    * Gia tin periptwsi pou 8a xrisimopoihsw to Entry gian ton Constructor
    *
    public DeleteImageController(Entry entry){
        this.entry = entry;
    }
    */
    
    public boolean deleteAElementFromImageList ( String imageName) throws NullPointerException{
        boolean success = false;            
          //  String[] imageNames = entry.getImageList();
        for(URI imageURI : entry.getEntryImages()){
                     String image = imageURI.getPath();
                     if(image.contains(imageName)){
                    System.out.println("To Path einai: " + image);
                    success = imageDao.prepareForDeleteFromList( image);
                      }else continue;
                     break;
        }
            System.out.println(success);
            return success;
    }
    
    
    public boolean deleteImageAlbum(String imagePath)throws NullPointerException{
        
            // entries // images  ****delete olo to album
            return imageDao.prepareForDeleteAlbum(imagePath);
                   
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
