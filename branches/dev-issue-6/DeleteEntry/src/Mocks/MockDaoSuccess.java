/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mocks;

import Controller.IDaoController;

/**
 *
 * @author JohnN'y
 */
public class MockDaoSuccess implements IDaoController {
    
    @Override
    public String displayEntry(MockEntry mockObj) {
        String text = mockObj.getEntry();
        return text;
    }
    
    
}