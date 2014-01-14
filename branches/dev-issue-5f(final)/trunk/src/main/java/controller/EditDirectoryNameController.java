/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.EditDirectoryNameDao;

/**
 *
 * @author PTsilopoulos
 */
public class EditDirectoryNameController {
    
     public boolean editDirectoryTitle(String FileTitle) {
         EditDirectoryNameDao directoryTitleDao = new EditDirectoryNameDao();
         
         return directoryTitleDao.editDirectoryTitle(FileTitle);
     }
}
