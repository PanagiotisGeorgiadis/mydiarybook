/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package EditEntries;

import Mocks.MockEntry;
import Mocks.MockDaoSuccess;

/**
 *
 * @author JohnN'y
 */
public class EditEntries {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      
       MockDaoSuccess dao = new MockDaoSuccess() ;
        MockEntry entryObj = new MockEntry();
        String Text;
        
        Text =dao.displayEntry( entryObj);
        EditForm frameObj = new EditForm();
        
    }
    
}
