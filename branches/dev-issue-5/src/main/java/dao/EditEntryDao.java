/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import exception.ExceptionDao;
import model.EditEntry;

/**
 *
 * @author PTsilopoulos
 */
public class EditEntryDao implements IEditEntryDao {
    //FIX replace string to mockobject
    @Override
    public EditEntry displayEntry(String text) throws ExceptionDao
    {
        return new EditEntry();
    }
}
