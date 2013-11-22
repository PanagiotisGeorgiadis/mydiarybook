/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import editentry.MockEntry;

/**
 *
 * @author PTsilopoulos
 */
public class MockSuccessfullDao implements IDaoController {
    
    @Override
    public String displayEntry(MockEntry mockObj) {
        String text = mockObj.getEntry();
        return text;
    }
    
}   

