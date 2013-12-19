/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.NewEntryImageDao;
import java.io.File;

/**
 *
 * @author Zarc
 */
public class NewEntryImageController {
    
    public boolean copyImage(String userTitle,String sourcePath)
    {
        NewEntryImageDao imageDao = new NewEntryImageDao();
        
        return imageDao.prepareImageForCopy(userTitle, sourcePath);
    }
    
    public File[] getImageFiles(String entryTitle)
    {
        NewEntryImageDao imageFilesDao = new NewEntryImageDao();
        return imageFilesDao.getImageFiles(entryTitle);
    }
    
}
