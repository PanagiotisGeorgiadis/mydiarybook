/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mydiarybook;


import javax.swing.UIManager;
import ui.LoginForm;

/**
 *
 * @author Zarc
 */
public class MyDiaryBook {
    
 public static void showDefaultFrame() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch(Exception e) {
            e.printStackTrace();
        }
        LoginForm theView = new LoginForm();

        LoginForm.setDefaultLookAndFeelDecorated(true);
        theView.setVisible(true);
    }    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO refer to https://code.google.com/p/mydiarybook/issues/list
        
        showDefaultFrame();
    }
    
}
