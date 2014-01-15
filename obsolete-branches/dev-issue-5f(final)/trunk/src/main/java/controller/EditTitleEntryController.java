/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.EditTitleEntryDao;

/**
 *
 * @author PTsilopoulos */

public class EditTitleEntryController {
    
     public boolean editFileTitle(String FileTitle) {
         EditTitleEntryDao fileTitleDao = new EditTitleEntryDao();
         
         return fileTitleDao.editEntryTitle(FileTitle);
     }        
}    