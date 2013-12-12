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
public class PersonalGoalDao implements IPersonalGoalDao  {
  
   
   
        
    
    
    private ArrayList<PersonalGoalModel> database;
    private final String delimeter = ";";
    
    /**
     * 
     * @param fileName 
     */
    
    @Override
    public void txtLoadPersonalGoal(String fileName)
    {
        
                
                
        FileReader fr = null;
        String line = null;
        try {
            fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            
            line = br.readLine();
            String[] lineSplit;
            PersonalGoalModel tempPGM = null;
            while( line != null)
            {
                line = br.readLine();
                lineSplit = line.split(delimeter);
                tempPGM.setPersonalGoalTitle       (lineSplit[0]);
                tempPGM.setPersonalGoalLocation    (lineSplit[1]);
                tempPGM.setPersonalGoalWithPerson  (lineSplit[2]);
                tempPGM.setPersonalGoalWhenDate    (new Date (lineSplit[3]));
                tempPGM.setPersonalGoalAnnouncement(lineSplit[4]);
                database.add(tempPGM);
            }
            fr.close();
        } catch (IOException ex) {
            Logger.getLogger(PersonalGoalDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //TODO: να ενώσω saveToFile και writeToFilePersonalGoal.
    /**
     * 
     * @param fileName 
     */
    @Override
    public void saveToFile(String fileName,String title, String location, String withPerson, String whenDate, String announcement)
    {
          //String database = fileName;
          IPersonalGoalForm newForm = new PersonalGoalForm();
          PersonalGoalPathDao destPath = mock(PersonalGoalPathDao.class);
          when(destPath.getDefaultPath()).thenReturn("C:\\Users\\alex\\Desktop\\MyDiaryBook\\");

          PersonalGoalPathDao userName = mock(PersonalGoalPathDao.class);
          when(userName.getUserName()).thenReturn(fileName);
        try{  
                       // File file = new File(destPath.DefaultPath() + userName.UserName() + ".txt");
                         File file = new File(destPath.getDefaultPath() + userName.getUserName() + ".txt");
                         FileWriter fileWriter = new FileWriter(file, true);
                   
                   
                       BufferedWriter writer1 = new BufferedWriter(fileWriter);
                        //writer1.append("\n");
                        writer1.append("\n" + "Title:" + title + "\t Location:" + location + "\t With:"
                                + withPerson + "\t when:" + whenDate
                                + "\t Annoucement:" + announcement);
                       
                        fileWriter.write(System.getProperty("line.separator")); 
            
                        writer1.close();
                        fileWriter.close();
                }catch (IOException ex) {
                    newForm.displayErrorMessage("Something went wrong");
                }
                 
                
                
            
           
       }
    
    public boolean filePathExists(String title)
    {
       
        
        IPersonalGoalPathDao destPath;
        destPath = mock(IPersonalGoalPathDao.class);
        when(destPath.getDefaultPath()).thenReturn(System.getProperty("user.dir")+"\\MyDiaryBook\\Users\\");

        IPersonalGoalPathDao userName;
        userName = mock(IPersonalGoalPathDao.class);
        when(userName.getUserName()).thenReturn(title);
       
        File file = new File(userName.getDefaultPath()+userName.getUserName()+"\\"+title);
        if(file.exists())
            return true;
        else
            return false;
    }

}
