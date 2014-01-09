/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.File;
import model.Entry;

/**
 *
 * @author Zarc
 */
public class EntryDao {
    public static Entry getEntryByTitle(String title)
    {
        NewEntryImageDao imageFilesDao = new NewEntryImageDao();
        NewEntryVideoDao videoDao = new NewEntryVideoDao();
        NewEntryTextDao textFile = new NewEntryTextDao();
        EntriesListDao entriesListDao = new EntriesListDao();
        

        String[] imageList = imageFilesDao.getImageList(title);
        String[] entriesList = entriesListDao.getListOfEntries();
        String  entryText = textFile.returnTextFromTextFile(title);
        File entryVideo = videoDao.getVideo(title);
        
        Entry entry = new Entry();
        
        entry.setEntryText(entryText);
        entry.setEntryImages(imageFilesDao.getImageFiles(title));
        entry.setEntryVideo(entryVideo);
        entry.setEntriesList(entriesList);
        entry.setImageList(imageList);
        return entry;
    }
}