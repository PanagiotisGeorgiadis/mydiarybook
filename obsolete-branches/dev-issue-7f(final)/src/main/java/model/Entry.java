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
 * @author Zarc
 */
public class Entry {
    private List<URI> entryImages;
    private String entryText;
    private File entryVideo;
    private String[] entriesList;
    private String[] imageList;

    public String[] getImageList() {
        return imageList;
    }

    public void setImageList(String[] imageList) {
        this.imageList = imageList;
    }
    
    public String[] getEntriesList() {
        return entriesList;
    }

    public void setEntriesList(String[] entriesList) {
        this.entriesList = entriesList;
    }
    
    public Entry()
    {
    }

    public List<URI> getEntryImages() {
        return entryImages;
    }

    public void setEntryImages(List<URI> entryImages) {
        this.entryImages = entryImages;
    }

    public String getEntryText() {
        return entryText;
    }

    public void setEntryText(String entryText) {
        this.entryText = entryText;
    }

    public File getEntryVideo() {
        return entryVideo;
    }

    public void setEntryVideo(File entryVideo) {
        this.entryVideo = entryVideo;
    }
    
}
