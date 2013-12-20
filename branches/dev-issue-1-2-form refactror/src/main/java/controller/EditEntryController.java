/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.IEditEntryDao;
//import exception.ExceptionDao;
import model.EditEntry;

/**
 *
 * @author PTsilopoulos
 */
public class EditEntryController {
    
    public EditEntry newEditEntry;
    public IEditEntryDao EditEntryDao;
    public EditEntryController()
    {
        
    }
    public EditEntryController(IEditEntryDao EditEntryDao) {
        this.EditEntryDao = EditEntryDao;
        this.newEditEntry = new EditEntry();
    }
       
    public boolean checkEdit(String textToEdit)
    {
        if(!("").equals(textToEdit.trim())) {
        }
        else {
            return false;
        }
        return true;
    }
}

/*public EditEntry displayEntry(String entryObj){
        try {
            if (!entryObj.equals(null))
                newEditEntry.setEntry(entryObj);
                return new EditEntry();    
        }
        catch (Exception e) {
                //throw new IllegalArgumentException("You forgot to add content to your entry!");
                return new EditEntry();
        }
    }*/