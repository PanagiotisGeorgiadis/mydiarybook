/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package editentry;

import dao.MockSuccessfullDao;
import ui.EditForm;

/**
 *
 * @author PTsilopoulos
 */
public class EditEntry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MockSuccessfullDao dao = new MockSuccessfullDao() ;
        MockEntry entryObj = new MockEntry();
        String Text;
        
        Text =dao.displayEntry( entryObj);
        EditForm frameObj = new EditForm();
    }
    
}
