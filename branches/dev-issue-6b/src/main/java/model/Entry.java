/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import dao.EntriesListDao;
import dao.NewEntryImageDao;
import java.io.File;
import java.net.URI;
import java.util.List;

/**
 *
 * @author Zarc
 */
public class Entry implements IEntry {
    private List<URI> entryImages;
    private String entryText;
    private File entryVideo;
    private String[] entriesList;
    private String[] imageList;
    private String entryImage;
    private String entryTitle;

    @Override
    public String getEntryTitle() {
        return entryTitle;
    }

    @Override
    public void setEntryTitle(String entryTitle) {
        this.entryTitle = entryTitle;
    }

    @Override
    public String[] getImageList() {
        return imageList;
    }

    @Override
    public void setImageList(String[] imageList) {
        this.imageList = imageList;
    }
    
    @Override
    public String[] getEntriesList() {
        return entriesList;
    }

    @Override
    public void setEntriesList(String[] entriesList) {
        this.entriesList = entriesList;
    }
    
    public Entry()
    {
    }

    @Override
    public List<URI> getEntryImages() {
        return entryImages;
    }

    @Override
    public void setEntryImages(List<URI> entryImages) {
        this.entryImages = entryImages;
    }

    @Override
    public String getEntryText() {
        return entryText;
    }

    @Override
    public void setEntryText(String entryText) {
        this.entryText = entryText;
    }

    @Override
    public File getEntryVideo() {
        return entryVideo;
    }

    @Override
    public void setEntryVideo(File entryVideo) {
        this.entryVideo = entryVideo;
    }
    
    @Override
    public void setEntryImage(String entryImage){
        this.entryImage = entryImage;
    }
    
    @Override
    public String getEntryImage(){
        return entryImage;
    }
}
