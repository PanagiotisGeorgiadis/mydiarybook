/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Path;
import javax.swing.JOptionPane;

/**
 *
 * @author JohnN'y
 */
public class DeleteHandler  {

    private Path textPath =  null;
    private File textFile = null;
  //  private String textPathToString = null;
    
    
    public DeleteHandler(Path textPath){
        
        this.textPath = textPath;
//        textPathToString = textPath.toString();
        textFile = new File(textPath.toString());
    }

  
    public boolean delete(){
  //      public void delete(){
            if(textFile.exists()){
                try{
                    textFile.delete();
//                    delObj.deleteFile(textPath);
                    textPath = null;
                   JOptionPane.showMessageDialog(null, "The Erase was Successfull", "Delete...", JOptionPane.CLOSED_OPTION);
                }      
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,"I can't Delete this File", "Delete Failure", JOptionPane.CLOSED_OPTION);
                   // this.delete();
                }finally{
                     //this.delete();
                    return true;                         
                }
              
            }
            else{
                JOptionPane.showMessageDialog(null, "There is no File", "No File",JOptionPane.CLOSED_OPTION);
               return false;
            }
    }
    


}
