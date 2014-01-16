/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exception.EntryException;
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
    public boolean prepareForCreatingTextFile(String title, String location, String withPerson, String whenDate, String announcement,String userName) {
        String textDestPath = System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator + userName  + fSeparator + "PersonalGoal" + fSeparator+ title + fSeparator + "Texts" + fSeparator;
        PersonalGoalDao newTextDao = new PersonalGoalDao();
        return newTextDao.saveTextFile(textDestPath, title, location, withPerson, whenDate, announcement);

    }
    /**
     * function of title text.
     * @param Title
     * @param userName
     * @return  return  the content of title text 
     */
    
    public String returnTextTitleFile(String Title,String userName)
    {
        
    
        String textTitlePath = System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator + userName  + fSeparator + "PersonalGoal" +fSeparator + Title + fSeparator+"Texts"+ fSeparator+"title.txt";
        FilesDao textDao = new FilesDao();
        try{
            return textDao.returnTextFile(textTitlePath);
        }catch(EntryException ex){
            return "";
        }
        
    }
    /**
     * function of location text.
     * @param Title String
     * @param userName String
     * @return  return  the content of location text
     */
    public String returnTextLocationFile(String Title,String userName)
    {
        
    
        String textLocationPath = System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator + userName  + fSeparator + "PersonalGoal" +fSeparator + Title + fSeparator+"Texts"+ fSeparator+"location.txt";
        FilesDao textDao = new FilesDao();
        try{
            return textDao.returnTextFile(textLocationPath);
        }catch(EntryException ex){
            return "";
        }

    }
     /**
      * function of withPerson text.
      * @param Title String
      * @param userName String
      * @return return  the content of with person text
      */
    public String returnTextWithPersonFile(String Title,String userName)
    {
        
    
        String textWithPersonPath = System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator + userName  + fSeparator + "PersonalGoal" +fSeparator + Title + fSeparator+"Texts"+ fSeparator+"withPerson.txt";
        FilesDao textDao = new FilesDao();
        try{
            return textDao.returnTextFile(textWithPersonPath);
        }catch(EntryException ex){
            return "";
        }

    }
        /**
         * function of whenDate text.
         * @param Title String
         * @param userName String
         * @return  the content of when date text
         */ 
    public String returnTextWhenDateFile(String Title,String userName)
    {
        
    
        String textWhenDatePath = System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator + userName  + fSeparator + "PersonalGoal" +fSeparator + Title + fSeparator+"Texts"+ fSeparator+"whenDate.txt";
        FilesDao textDao = new FilesDao();
        try{
            return textDao.returnTextFile(textWhenDatePath);
        }catch(EntryException ex){
            return "";
        }

    }
    
      
        /**
         * function of announcement text.
         * @param Title String
         * @param userName String
         * @return the content of announcement text.
         */   
      public String returnTextAnnouncementFile(String Title,String userName)
    {
        
    
        String textAnnouncementPath = System.getProperty("user.dir") + fSeparator + "MyDiaryBook" + fSeparator + "Users" + fSeparator + userName  + fSeparator + "PersonalGoal" +fSeparator + Title + fSeparator+"Texts"+ fSeparator+"announcement.txt";
        FilesDao textDao = new FilesDao();
        try{
            return textDao.returnTextFile(textAnnouncementPath);
        }catch(EntryException ex){
            return "";
        }

    }
      /**
       * function of image text.
       * @param Title
       * @param userName
       * @return the content of image text.
       */
        public String returnTextImageDestPath(String Title,String userName)
    {
        
    
        
       String textImageDestPath = System.getProperty("user.dir")+ fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+userName+fSeparator+"PersonalGoal"+ fSeparator + Title + fSeparator + "Images" + fSeparator+"imageString.txt";
        FilesDao textDao = new FilesDao();
        try{
            return textDao.returnTextFile(textImageDestPath);
        }catch(EntryException ex){
            return "";
        }

    }
}
