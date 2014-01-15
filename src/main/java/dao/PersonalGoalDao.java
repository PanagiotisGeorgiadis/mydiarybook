/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import model.PersonalGoalModel;

/*
 **Μια κλάση που υλοποιή την εγγραφή σε και την κάνει load.
 * @param PersonalGoalModel: pgm που το μοντέλο.
 * @param String fileName  : το όνομα του αρχείου
 * @return το writeToFilePersonalGoal επιστρέφει ενα true εάν όλα τα πεδία είναι σωστά αλλίως false.
 * TODO: να φτίαξω τα return σε saveToFile 
 * @throws IOException
 *@author alex
 */
public class PersonalGoalDao {

    private ArrayList<PersonalGoalModel> database;
    private final String delimeter = ";";

   

    /**
     * function save text file
     *
     * @param path
     * @param title
     * @param location
     * @param withPerson
     * @param announcement
     * @param whenDate
     * @return true if file is saved or false if is not.
     */
    public boolean saveTextFile(String path, String title, String location, String withPerson, String whenDate, String announcement) {

        try {

           
               File titleFile = new File(path +"title.txt");
               File locationFile = new File(path + "location.txt");
               File withPersonFile= new File(path + "withPerson.txt");
               File whenDateFile = new File(path + "whenDate.txt");
               File  announcementFile =  new File(path + "announcement.txt");
            boolean exists = createFilePath(path);
            if (exists) {
               
                FileWriter titleWritter = new FileWriter(titleFile, true);
                BufferedWriter titleBufferedWriter = new BufferedWriter(titleWritter);
                titleBufferedWriter.write(title);
                titleBufferedWriter.close();
                titleWritter.close();
                
                 FileWriter locationWritter = new FileWriter(locationFile, true);
                BufferedWriter locationBufferedWriter = new BufferedWriter(locationWritter);
                locationBufferedWriter.write(location);
                locationBufferedWriter.close();
                locationWritter.close();
                
                FileWriter withPersonWritter = new FileWriter(withPersonFile, true);
                BufferedWriter withPersonBufferedWriter = new BufferedWriter(withPersonWritter);
                withPersonBufferedWriter.write(withPerson);
                withPersonBufferedWriter.close();
                withPersonWritter.close();
                
                FileWriter whenDateWritter = new FileWriter(whenDateFile, true);
                BufferedWriter whenDateBufferedWriter = new BufferedWriter(whenDateWritter);
                whenDateBufferedWriter.write(whenDate);
               whenDateBufferedWriter.close();
                whenDateWritter.close();
                
                FileWriter announcementWritter = new FileWriter(announcementFile, true);
                BufferedWriter announcementBufferedWriter = new BufferedWriter(announcementWritter);
               announcementBufferedWriter.write(announcement);
               announcementBufferedWriter.close();
                announcementWritter.close();
                
                
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    /**
     * Boolean function greateFilePath
     *
     * @param path
     * @return true or false
     */
    public boolean createFilePath(String path) {
        try {
            File file = new File(path);
            if (file.exists()) {
                return true;
            } else {
                file.mkdirs();
                createFilePath(path);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * Function for taking a model of personalGoal
     * @param title
     * @param userName
     * @return a personalGoal model
     */
     public static PersonalGoalModel getPersonalGoalByTitle(String title,String userName)
    {
        
        PersonalGoalTxtDao textFile = new PersonalGoalTxtDao();
        PersonalGoalListDao personalGoalListDao = new PersonalGoalListDao();
        PersonalGoalModel personalGoal = new PersonalGoalModel();
      
       
        String  personalGoalTitle = textFile.returnTextTitleFile(title,userName);
        String  personalGoalLocation = textFile.returnTextLocationFile(title,userName);
        String  personalGoalWithPerson = textFile.returnTextWithPersonFile(title,userName);
        String  personalGoalWhenDate = textFile.returnTextWhenDateFile(title,userName);
        String  personalGoalAnnouncement = textFile.returnTextAnnouncementFile(title,userName);
        String  personalGoalImage = textFile.returnTextImageDestPath(title,userName);
        
        String[] personalGoalList = personalGoalListDao.getListOfPersonalGoal(userName);
        
        
        personalGoal.setPersonalGoalTitle(personalGoalTitle);
        personalGoal.setPersonalGoalLocation(personalGoalLocation);
        personalGoal.setPersonalGoalWithPerson(personalGoalWithPerson);
        personalGoal.setPersonalGoalWhenDate(personalGoalWhenDate);
        personalGoal.setPersonalGoalAnnouncement(personalGoalAnnouncement);
        personalGoal.setPersonalGoalImage(personalGoalImage);
        personalGoal.setPersonalGoalList(personalGoalList);
        
         
        return personalGoal;
     
            
    }
    
    public boolean prepareForDelete(String userName, String personalGoalTitle){
        String filePath = System.getProperty("user.dir") + File.separator + "MyDiaryBook"+ File.separator + "Users" + File.separator + userName + File.separator + "PersonalGoal" + File.separator + personalGoalTitle + File.separator +
                                    "Texts" ;
        String imagePath = System.getProperty("user.dir") + File.separator + "MyDiaryBook"+ File.separator + "Users" + File.separator + userName + File.separator + "PersonalGoal" + File.separator + personalGoalTitle + File.separator +
                                    "Images" ;
        File filePersonalGoal = new File(filePath);
        File fileImage = new File(imagePath);
        File fileParent = fileImage.getParentFile();
        FilesDao deleteFile = new FilesDao();
        deleteFile.delete(fileImage);
        deleteFile.delete(filePersonalGoal);
        return deleteFile.delete(fileParent);
        
    }

}
