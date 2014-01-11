/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Zarc
 */
public class NewEntryTextDao {

    private final String fSeparator = File.separator;

    public NewEntryTextDao() {

    }

    public boolean createTextFile(String entryTitle, String userText) {
        INewEntryMockDefaultPath rootPathMock = mock(INewEntryMockDefaultPath.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator);
        INewEntryMockUsername userMock = mock(INewEntryMockUsername.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");

        String textDestPath = rootPathMock.getDefaultPath() + userMock.getUsername() + fSeparator + "Entries" + fSeparator + entryTitle + fSeparator + "Texts" + fSeparator;

        FilesDao textDao = new FilesDao();

        return textDao.createTextFile(textDestPath, userText, entryTitle);

    }

    public String returnTextFile(String entryTitle) {
        INewEntryMockDefaultPath rootPathMock = mock(INewEntryMockDefaultPath.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator);
        INewEntryMockUsername userMock = mock(INewEntryMockUsername.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");

        String textPath = rootPathMock.getDefaultPath() + userMock.getUsername() + fSeparator + "Entries" + fSeparator + entryTitle + fSeparator + "Texts" + fSeparator + entryTitle + ".txt";
        FilesDao textDao = new FilesDao();
        try {
            return textDao.returnTextFile(textPath);
        } catch (IOException ex) {
            return "";
        }
    }

    public String getEntryTitle(String entryTitle) {

        INewEntryMockDefaultPath rootPathMock = mock(INewEntryMockDefaultPath.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator);
        INewEntryMockUsername userMock = mock(INewEntryMockUsername.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");

        return rootPathMock.getDefaultPath() + userMock.getUsername() + fSeparator + "Entries" + fSeparator + entryTitle + fSeparator + "Texts" + fSeparator;

    }
    
    public String getTextFie( String entryTitle){
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
        String entryTitle = getTextFie(textName);
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
//    Path path = Paths.get(System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users"+ fSeparator + Username + fSeparator + "Entries" + fSeparator + textPath + fSeparator
//                                         + "Texts");
       
        File textFile = new File(textPath);
//    if(textFile.exists()){
        FilesDao fileDelete = new FilesDao();
        try {

            return fileDelete.delete(textFile);

        } catch (Exception ex) {
            return false;
            //TODO logger
        }

//          if(textFile.exists())
//           return false;
//       else
//           return true;
//    }
//    else
//        return false;
    }
}
