/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package deleteentries;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author JohnN'y
 */
public class TextAreaFrame extends JFrame{
    private JTextArea textArea1;
    private JTextArea textArea2;
    private JButton copyJButton;
    
    public TextAreaFrame()
    {
        super("TextArea Demo");
        Box box = Box.createHorizontalBox();
        String demo = "bla bla";
        
        textArea1 = new JTextArea(demo, 10,15);
        box.add(new JScrollPane(textArea1));
        
        copyJButton = new JButton("Copy >>>");
        box.add(copyJButton);
        copyJButton.addActionListener(
        new ActionListener(){
            public void actionPerfomed(ActionEvent event){
                textArea2.setText(textArea1.getSelectedText());
//            }
//
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
                    
        }
        );
        textArea2 = new JTextArea(10, 15);
        textArea2.setEditable(false);
        box.add(new JScrollPane(textArea2));
        
        add(box);
    }    
}

