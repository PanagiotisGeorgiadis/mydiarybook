/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.File;
import java.io.IOException;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author alex
 */
public class PersonalGoalTxtDao {

    public String fSeparator = File.separator;

    /**
     * Function to prepareForCreatingTextFile
     *
     * @param title
     * @param location
     * @param withPerson
     * @param whenDate
     * @param announcement
     * @return true or false.
     */
    public boolean prepareForCreatingTextFile(String title, String location, String withPerson, String whenDate, String announcement) {
        String textDestPath = System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator + "Alex Patsanis"  + fSeparator + "PersonalGoal" + fSeparator+ title + fSeparator + "Texts" + fSeparator;
        PersonalGoalDao newTextDao = new PersonalGoalDao();
        //FilesDao newFile = new FilesDao();
        return newTextDao.saveTextFile(textDestPath, title, location, withPerson, whenDate, announcement);

    }
    
    public String returnTextTitleFile(String Title)
    {
        
    
        String textTitlePath = System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator + "Alex Patsanis"  + fSeparator + "PersonalGoal" +fSeparator + Title + fSeparator+"Texts"+ fSeparator+"title.txt";
        FilesDao textDao = new FilesDao();
        try{
            return textDao.returnTextFile(textTitlePath);
        }catch(IOException ex){
            return "";
        }
        
    }
    
       public String returnTextLocationFile(String Title)
    {
        
    
        String textLocationPath = System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator + "Alex Patsanis"  + fSeparator + "PersonalGoal" +fSeparator + Title + fSeparator+"Texts"+ fSeparator+"location.txt";
        FilesDao textDao = new FilesDao();
        try{
            return textDao.returnTextFile(textLocationPath);
        }catch(IOException ex){
            return "";
        }

    }
       
         public String returnTextWithPersonFile(String Title)
    {
        
    
        String textWithPersonPath = System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator + "Alex Patsanis"  + fSeparator + "PersonalGoal" +fSeparator + Title + fSeparator+"Texts"+ fSeparator+"withPerson.txt";
        FilesDao textDao = new FilesDao();
        try{
            return textDao.returnTextFile(textWithPersonPath);
        }catch(IOException ex){
            return "";
        }

    }
         
      public String returnTextWhenDateFile(String Title)
    {
        
    
        String textWhenDatePath = System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator + "Alex Patsanis"  + fSeparator + "PersonalGoal" +fSeparator + Title + fSeparator+"Texts"+ fSeparator+"whenDate.txt";
        FilesDao textDao = new FilesDao();
        try{
            return textDao.returnTextFile(textWhenDatePath);
        }catch(IOException ex){
            return "";
        }

    }
    
      
           
      public String returnTextAnnouncementFile(String Title)
    {
        
    
        String textAnnouncementPath = System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator + "Alex Patsanis"  + fSeparator + "PersonalGoal" +fSeparator + Title + fSeparator+"Texts"+ fSeparator+"announcement.txt";
        FilesDao textDao = new FilesDao();
        try{
            return textDao.returnTextFile(textAnnouncementPath);
        }catch(IOException ex){
            return "";
        }

    }
        public String returnTextImageDestPath(String Title)
    {
        
    
        
       String textImageDestPath = System.getProperty("user.dir")+ fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Alex Patsanis"+fSeparator+"PersonalGoal"+ fSeparator + Title + fSeparator + "Images" + fSeparator+"imageString.txt";
        FilesDao textDao = new FilesDao();
        try{
            return textDao.returnTextFile(textImageDestPath);
        }catch(IOException ex){
            return "";
        }

    }
}
