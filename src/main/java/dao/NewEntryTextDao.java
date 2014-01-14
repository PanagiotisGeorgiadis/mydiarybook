/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import exception.EntryException;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Zarc
 */
public class NewEntryTextDao {
    
    private final String fSeparator = File.separator;
    
    public NewEntryTextDao()
    {
        
    }
    
    public boolean createTextFile(String entryTitle,String userText)
    {
        String textDestPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
                +fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Texts"+fSeparator;
        
        FilesDao textDao = new FilesDao();
        
        return textDao.createTextFile(textDestPath, userText, entryTitle);
        
    }
    
    public String returnTextFromTextFile(String entryTitle)
    {
        String textPath =System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Texts"+fSeparator+entryTitle+".txt";
        FilesDao textDao = new FilesDao();
        try {
            return textDao.returnTextFile(textPath);
        } catch (EntryException ex) {
            Logger.getLogger(NewEntryTextDao.class.getName()).log(Level.SEVERE, null, ex);
            return "";
        }

    }
    
    public String returnTextFilePath(String entryTitle,String userName)
    {
        String textPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+
                userName+fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Texts";
        File file = new File(textPath);
        if(file.exists())
            return textPath;
        else
            return null;
    }
    
    public String getTextFile( String entryTitle){
        INewEntryMockDefaultPath rootPathMock = mock(INewEntryMockDefaultPath.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator);
        INewEntryMockUsername userMock = mock(INewEntryMockUsername.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");

        String textPath = rootPathMock.getDefaultPath() + userMock.getUsername() + fSeparator + "Entries" + fSeparator + entryTitle + fSeparator + "Texts" + fSeparator + entryTitle + ".txt";
        return textPath;
    }

    
     public boolean prepareForDeleteFromList(String textName) {
//        Path textFile = Paths.get(System.getProperty("user.dir") + fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+Username +fSeparator + "Entries" + fSeparator +
//                                textPath + fSeparator + "Texts"+fSeparator+textPath+".txt");
        //TODO Na kanw ti dimiourgia tou path pio dunamiki
        String entryTitle = getTextFile(textName);
//         File textFile = new File(entryTitle);
//        String textFile = textPath +File.separator + textName +".txt";

        File file = new File(entryTitle);
        System.out.println(file);

//        if (file.exists()) {
            FilesDao fileDelete = new FilesDao();
            try {

                return fileDelete.delete(file);

            } catch (Exception ex) {
                //TODO logger
               return false;

            } 

        }
        

    public boolean prepareForDeleteAlbum(String textPath) {

       
        File textFile = new File(textPath);

        FilesDao fileDelete = new FilesDao();
        try {

            return fileDelete.delete(textFile);

        } catch (Exception ex) {
            return false;
            //TODO logger
        }


    }
    
}
