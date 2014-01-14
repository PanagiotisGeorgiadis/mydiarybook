/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.NewEntryImageDao;
import java.net.URI;
import java.util.List;

/**
 *
 * @author JohnN'y
 */
public class DeleteImageController {
    private NewEntryImageDao imageDao = new NewEntryImageDao();
   // private IEntry entry;

    public DeleteImageController(){//IEntry entry) {
//               this.entry = entry;
    }
    
    /*
    * Gia tin periptwsi pou 8a xrisimopoihsw to Entry gian ton Constructor
    *
    public DeleteImageController(Entry entry){
        this.entry = entry;
    }
    */
    
    public boolean deleteAElementFromImageList (  String entryTitle, String imageName) throws NullPointerException{
//        boolean success = false;            
//          //  String[] imageNames = entry.getImageList();
//        //for(URI imageURI : entry.getEntryImages()){
//        for(URI imageURI : imageList){
//                     String image = imageURI.getPath();
//                     if(image.contains(imageName)){
//                    System.out.println("To Path einai: " + imageURI);
                            return imageDao.prepareForDeleteFromList( entryTitle, imageName);

//                    success = imageDao.prepareForDeleteFromList( image);
//                      }else continue;
//                     break;
//        }
//            System.out.println(success);
//            return success;
    }
    
    
    public boolean deleteImageAlbum(String entryTitle)throws NullPointerException{
        
            // entries // images  ****delete olo to album
            return imageDao.prepareForDeleteAlbum(entryTitle);
                   
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
