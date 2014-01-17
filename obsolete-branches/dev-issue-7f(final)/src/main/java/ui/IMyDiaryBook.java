/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.net.URI;

/**
 *
 * @author alex
 */
public interface IMyDiaryBook {

    /** Displays the new Image Specified in 2 different modes:
     * Album mode which can contain up to 30 images and
     * Single mode which can contain 1 image but scaled properly.
     * @param imagePath The path of the image.
     * @param mode String "Album" for Album mode or a random string for
     * Single mode
     */
    void displayNewImage(URI imagePath, String mode);

    void displayVideo(String videoPath, String whatToDo);

    void loadEntriesList();

    void loadEntryDateLabel();

    void loadEntryImage();

    void loadEntryImages();

    void loadEntryVideo();

    void loadImageList();
    
    void loadEntryText();

    /**
     * load list of personal goals
     */
    void loadListOfPersonalGoal();

    void loadPersonalGoalAnnouncement();

    void loadPersonalGoalLocation();

    void loadPersonalGoalTitle();

    void loadPersonalGoalWithPerson();

    void loadPersonalGoalwhenDate();

    void pauseOrPlayVideo();

    void refreshEntries();
    
}
