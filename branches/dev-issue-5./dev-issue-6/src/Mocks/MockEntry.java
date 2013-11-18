/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Mocks;

import Controller.IEntry;

/**
 *
 * @author JohnN'y
 */
public class MockEntry implements IEntry {
    
    private String text = "bla bla";
    @Override
    public String getEntry() {
        return text;
    }
    

    
    
}
