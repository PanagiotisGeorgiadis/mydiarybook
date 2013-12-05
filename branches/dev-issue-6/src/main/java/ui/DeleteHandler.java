/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import controller.DeleteController;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author JohnN'y
 */

public class DeleteHandler implements ActionListener {
    
       private DeleteController delObj = new DeleteController();
       private File fileText;
       private JFrame form = new JFrame();
       
/*
    public DeleteHandler(File fileText) {
    this.fileText = fileText;
    }
     */
    public DeleteHandler(Delete form) {
        this.form = form;
        //8a prepei na dimiourgisoume mia function getFile() sti form pou pros8etetai to DeleteHandler, wste na mporoume na paroume to filText apo ti forma
        fileText = form.getFile();
    }
       
       

    @Override
    public void actionPerformed(ActionEvent e) {
        
     int dialog =  JOptionPane.showConfirmDialog(form, "Are U sure that you want to delete it?");
     
     
      if(dialog == JOptionPane.YES_OPTION){
                
        try{
            if(delObj.checkFileExistance(fileText)){
                    delObj.delete(fileText);
                    JOptionPane.showMessageDialog(form, delObj.showSuccess(), "Success ", JOptionPane.DEFAULT_OPTION);
            }                    
            else
              // throw NullPointerException;
            JOptionPane.showMessageDialog(form, delObj.showNoFileFound(), "No File...", JOptionPane.DEFAULT_OPTION);
            
        }catch(NullPointerException exc){
            
            JOptionPane.showMessageDialog(form, delObj.showNoFileFound(), "No File...", JOptionPane.DEFAULT_OPTION);
            
        }catch(Exception exc){
            
            JOptionPane.showMessageDialog(form, delObj.showError(), "ERROR", JOptionPane.DEFAULT_OPTION);
            
        }
        
    }
  
    }
    
}
