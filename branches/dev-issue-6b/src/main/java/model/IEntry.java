/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.io.File;
import java.net.URI;
import java.util.List;

/**
 *
 * @author JohnN'y
 */
public interface IEntry {

    String[] getEntriesList();

    String getEntryImage();

    List<URI> getEntryImages();

    String getEntryText();

    String getEntryTitle();

    File getEntryVideo();

    String[] getImageList();

    void setEntriesList(String[] entriesList);

    void setEntryImage(String entryImage);

    void setEntryImages(List<URI> entryImages);

    void setEntryText(String entryText);

    void setEntryTitle(String entryTitle);

    void setEntryVideo(File entryVideo);

    void setImageList(String[] imageList);
    
}
