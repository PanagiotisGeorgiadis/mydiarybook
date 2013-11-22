/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editentry;

import controllers.IEditEntry;
/**
 *
 * @author PTsilopoulos
 */
public class MockEntry implements IEditEntry {
    
    private String text = "Edit this string";
    @Override
    public String getEntry() {
        return text;
    }
}