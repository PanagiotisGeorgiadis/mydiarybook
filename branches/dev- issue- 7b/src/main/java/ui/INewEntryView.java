/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.net.URI;

/**
 *
 * @author Zarc
 */
public interface INewEntryView {

    /**
     *
     * @param errorMessage is a string and its used to display the message I
     * want to the user
     */
    void displayErrorMessage(String errorMessage);
    

    void displayNewImage(URI imagePath);

    void displayVideo(String videoPath,String whatToDo);

    
}
