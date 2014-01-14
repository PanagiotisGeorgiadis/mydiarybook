/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.PersonalGoalModel;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import ui.IPersonalGoalForm;
import ui.PersonalGoalForm;

/*
 **Μια κλάση που υλοποιή την εγγραφή σε και την κάνει load.
 * @param PersonalGoalModel: pgm που το μοντέλο.
 * @param String fileName  : το όνομα του αρχείου
 * @return το writeToFilePersonalGoal επιστρέφει ενα true εάν όλα τα πεδία είναι σωστά αλλίως false.
 * TODO: να φτίαξω τα return σε saveToFile 
 * @throws IOException
 *@author alex
 */
public class PersonalGoalDao implements IPersonalGoalDao {

    private ArrayList<PersonalGoalModel> database;
    private final String delimeter = ";";

    /**
     *
     * @param fileName
     */
    @Override
    public void txtLoadPersonalGoal(String fileName) {

        FileReader fr = null;
        String line = null;
        try {
            fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            line = br.readLine();
            String[] lineSplit;
            PersonalGoalModel tempPGM = null;
            while (line != null) {
                line = br.readLine();
                lineSplit = line.split(delimeter);
                tempPGM.setPersonalGoalTitle(lineSplit[0]);
                tempPGM.setPersonalGoalLocation(lineSplit[1]);
                tempPGM.setPersonalGoalWithPerson(lineSplit[2]);
                tempPGM.setPersonalGoalWhenDate(new Date(lineSplit[3]));
                tempPGM.setPersonalGoalAnnouncement(lineSplit[4]);
                database.add(tempPGM);
            }
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(PersonalGoalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
    @Override
    public boolean saveTextFile(String path, String title, String location, String withPerson, String whenDate, String announcement) {

        try {

           
               File titleFile = new File(path +"title.txt");
               File locationFile = new File(path + "location.txt");
               File withPersonFile= new File(path + "withPerson.txt");
               File whenDateFile = new File(path + "whenDate.txt");
               File  announcementFile =  new File(path + "announcement.txt");
            boolean exists = createFilePath(path);
            if (exists) {
                /*
                FileWriter fw = new FileWriter(file, true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("\n" + "Title:" + title + "\t Location:" + location + "\t With:"
                        + withPerson + "\t when:" + whenDate
                        + "\t Annoucement:" + announcement);
                bw.close();
                fw.close();
                */
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
    
     public static PersonalGoalModel getPersonalGoalByTitle(String title)
    {
        //NewEntryImageDao imageFilesDao = new NewEntryImageDao();
        PersonalGoalTxtDao textFile = new PersonalGoalTxtDao();
        PersonalGoalListDao personalGoalListDao = new PersonalGoalListDao();
        
       // String imageList[] = imageFilesDao.getImageList(title);
       
        String  personalGoalTitle = textFile.returnTextTitleFile(title);
        String  personalGoalLocation = textFile.returnTextLocationFile(title);
        String  personalGoalWithPerson = textFile.returnTextWithPersonFile(title);
        String  personalGoalWhenDate = textFile.returnTextWhenDateFile(title);
        String  personalGoalAnnouncement = textFile.returnTextAnnouncementFile(title);
        String  personalGoalImage = textFile.returnTextImageDestPath(title);
        
        String[] entriesList = personalGoalListDao.getListOfPersonalGoal();
        
        PersonalGoalModel personalGoal = new PersonalGoalModel();
        personalGoal.setPersonalGoalTitle(personalGoalTitle);
        personalGoal.setPersonalGoalLocation(personalGoalLocation);
        personalGoal.setPersonalGoalWithPerson(personalGoalWithPerson);
        //FIX DATE
        //personalGoal.setPersonalGoalWhenDate(personalGoalWhenDate);
        personalGoal.setPersonalGoalAnnouncement(personalGoalAnnouncement);
        personalGoal.setPersonalGoalImage(personalGoalImage);
        personalGoal.setPersonalGoalList(entriesList);
        
         
        return personalGoal;
     
            
    }
       public boolean prepareForDelete(String userName, String personalGoalTitle) throws IOException{
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
