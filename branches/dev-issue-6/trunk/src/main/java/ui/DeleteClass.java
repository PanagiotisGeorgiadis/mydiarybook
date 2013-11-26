/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import controller.IDeleteController;
import java.io.File;
import java.nio.file.Path;
import javax.swing.JOptionPane;

/**
 *
 * @author JohnN'y
 */
public class DeleteClass  {

    private Path textPath = null;
    private File textFile = null;
    private String textPathToString = null;
    private IDeleteController delObj;
    
    public DeleteClass(Path textPath){
        this.textPath = textPath;
        textPathToString = textPath.toString();
        textFile = new File(textPathToString);
    }
    
    public void delete(){
            if(delObj.checkTextExist(textPath)){
                try{
                    textFile.delete();
                    delObj.deleteFile(textPath);
                    textPath = null;
                   JOptionPane.showMessageDialog(null, "The Erase was Successfull", "Delete...", JOptionPane.ABORT);
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null,"I can't Delete this File", "Delete Failure", JOptionPane.CLOSED_OPTION);
                    System.exit(0);
                }finally{
                   System.exit(0);
                }
            }
    }
    
}
