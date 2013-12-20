/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.NewEntryVideoDao;
import java.io.File;

/**
 *
 * @author Zarc
 */
public class NewEntryVideoController {
    
    public boolean copyVideo(String userTitle,String sourcePath)
    {
        NewEntryVideoDao videoDao = new NewEntryVideoDao();
        
        return videoDao.copyVideo(userTitle, sourcePath);
    }    
}
