/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;


/**
 *
 * @author PTsilopoulos
 */
public class EditTextEntryDao {
    
    public String EditText(String EntryTitle) {
        
        NewEntryTextDao editTextDao = new NewEntryTextDao();
        
        return editTextDao.returnTextFromTextFile(EntryTitle);
    }
    
    
}