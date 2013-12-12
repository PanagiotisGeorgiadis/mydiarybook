/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import controller.DeleteController;
import dao.MockFileExist;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

/**
 *
 * @author JohnN'y
 */
public class DeleteListHandler implements ActionListener {

    private JFrame form = new JFrame();
    private JList jList1 = new JList();
    private DefaultListModel listModel;
    private DeleteController delObj = new DeleteController(new MockFileExist());
    
    public DeleteListHandler(DeleteList form, JList jList1, DefaultListModel listModel) {
        this.form = form;
        this.jList1 = jList1;
        this.listModel = listModel;
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        int dialog = JOptionPane.showConfirmDialog(form, "Are you sure that you want to delete it?");

       if (dialog == JOptionPane.YES_OPTION) {
        try{
        int index = jList1.getSelectedIndex();
       // String indexString = Integer.toString(index);
        File file = new File(listModel.getElementAt(index).toString());       
        /*
        i malakia checkFileExistance dn mou douleuei!!!!
        */
  //    if(delObj.checkFileExistance(file)){
        listModel.removeElementAt(index);
        delObj.delete(file);
        /**
         * Gia na epilegei to katalilo pedio mesa sto JList
         */
        if (index == 0) 
            index = index;
        else 
            index--;
       /**
        * Na mporei na diagrapsei ton fakelo otan einai adeios
        */ 
         if(listModel.isEmpty())
            delObj.delete(new File(file.getParent()));
      

        jList1.ensureIndexIsVisible(index);
        jList1.setSelectedIndex(index);
           
      JOptionPane.showMessageDialog(form, delObj.showSuccess(), "Success ", JOptionPane.DEFAULT_OPTION);
      }catch(ArrayIndexOutOfBoundsException exp){
          JOptionPane.showMessageDialog(form, delObj.showNoFileFound(), "No File.. ", JOptionPane.DEFAULT_OPTION);
      }
//       else
       }
       
    
    }
}

    
    

