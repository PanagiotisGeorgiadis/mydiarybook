/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import exception.EntryException;
import java.io.File;
import java.net.URI;
import java.util.List;
import model.Login;

/**
 *
 * @author Zarc
 */
public class NewEntryImageDao {
   
    private final String fSeparator = File.separator;
    
    public NewEntryImageDao()
    {
    }
    
    public boolean prepareImageForCopy(String entryTitle,String sourcePath)
    {
        String imageDestPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+Login.getUsername()
                +fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Images"+fSeparator;
        
        File destFile = new File(imageDestPath);
        File sourceFile = new File(sourcePath);        
        FilesDao copyDao = new FilesDao();
        
        try
        {
            copyDao.copyFile(sourceFile,destFile);
        }catch(EntryException ex){
            return false;
        }
        
        return true;
    }
    
    public String[] getImageList(String entryTitle)
    {
        String imagePath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+Login.getUsername()
                +fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Images"+fSeparator;
        
        FilesDao imageDao = new FilesDao();
        try{
            return imageDao.getFilesList(imagePath);
        }
        catch(EntryException ex)
        {
            String[] exception = null;
            
            return exception;
        }
    }
    
    public List<URI> getImageFiles(String entryTitle)
    {
        String imagePath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+Login.getUsername()
                +fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Images"+fSeparator;
        
        FilesDao imageDao = new FilesDao();
        try{
            return imageDao.getSubFiles(imagePath);
        }catch(EntryException ex){
            return null;
        }
        
    }
    
    /**
     * This method try to prepare the user-choice from List for erase.
     *
     * @param entrytitle
     * @param imageName
     * @return true if the erasion was successful
     * @throws NullPointerException
     */
    public boolean prepareForDeleteFromList(String entrytitle, String imageName) {
        List<URI> imagePath = getImageFiles(entrytitle);
        String image = "";
        for (URI imageURI : imagePath) {
            image = imageURI.toString();
            if (image.contains(imageName)) {
                image = imageURI.getPath();
            } else {
                continue;
            }
            break;
        }
        File file = new File(image);

        FilesDao fileDelete = new FilesDao();
        try {

            return fileDelete.delete(file);

        } catch (Exception ex) {
            return false;
            //TODO logger
        }

    }

    /**
     * This method try to prepare the whole user's Image folder
     *
     * @param entryTitle
     * @return true if erasion was successful
     * @throws NullPointerException
     */
    public boolean prepareForDeleteAlbum(String entryTitle) throws NullPointerException {
        List<URI> imagePath = getImageFiles(entryTitle);
        File image;
        URI imageEntry;
        if (imagePath == null) {
            return false;
        } else {
            imageEntry = imagePath.get(0);
            image = new File(imageEntry);
            System.out.println(imageEntry);

            FilesDao fileDelete = new FilesDao();
            return fileDelete.delete(image.getParentFile());
        }
    }
    
}
