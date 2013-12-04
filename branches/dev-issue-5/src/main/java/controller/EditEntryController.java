/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.IEditEntryDao;
import exception.ExceptionDao;
import model.EditEntry;

/**
 *
 * @author PTsilopoulos
 */
public class EditEntryController {
    
    private IEditEntryDao EditEntryDao;
    
    public EditEntryController(IEditEntryDao EditEntryDao) {
        this.EditEntryDao = EditEntryDao;
    }
    
    public EditEntry displayEntry(String entryObj)
            throws IllegalArgumentException, ExceptionDao {
        // TO-DO έλεγχος ημερομηνίας, έλεγχος αν το text είναι null κτλ.
        String 
    }
    
}
