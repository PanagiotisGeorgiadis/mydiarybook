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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author JohnN'y
 */
public class DeleteAlbumHandler implements ActionListener {

    private DeleteController delObj = new DeleteController(new MockFileExist());
    private File folder = null;
    private JFrame form = new JFrame();

    public DeleteAlbumHandler(Delete form, File folder) {
        this.form = form;
        this.folder = folder;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int dialog = JOptionPane.showConfirmDialog(form, "Are you sure that you want to delete it?");

        if (dialog == JOptionPane.YES_OPTION) {
            if (delObj.checkFileExistance(folder)) {
                delObj.delete(folder);
                JOptionPane.showMessageDialog(form, delObj.showSuccess(), "Success ", JOptionPane.DEFAULT_OPTION);
            } else {
                JOptionPane.showMessageDialog(form, delObj.showNoFileFound(), "No File.. ", JOptionPane.DEFAULT_OPTION);
            }

        } else {
            System.exit(-1);
        }

    }
    
}
