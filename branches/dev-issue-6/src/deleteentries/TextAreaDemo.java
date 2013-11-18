/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package deleteentries;

import javax.swing.JFrame;

/**
 *
 * @author JohnN'y
 */
public class TextAreaDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       TextAreaFrame textAreaFrame = new TextAreaFrame();
        textAreaFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        textAreaFrame.setSize(425,200);
        textAreaFrame.setVisible(true);
    }
    
}
