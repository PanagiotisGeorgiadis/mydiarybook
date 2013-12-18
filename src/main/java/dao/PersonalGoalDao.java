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
    

    /**
     * function save text file
     * @param path
     * @param title
     * @param location
     * @param withPerson
     * @param announcement
     * @param whenDate
     * @return true if file is saved or false if is not.
     */
    @Override
   public boolean saveTextFile(String path ,String title, String location, String withPerson, String whenDate, String announcement)
    {
        
       try
        {
           
           // File file = new File(path+"Alex.txt");
            File file = new File(path+"TitleName.txt");
            boolean exists = createFilePath(path);
            if(exists)
            {
            
                FileWriter fw = new FileWriter(file,true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write("\n" + "Title:" + title + "\t Location:" + location + "\t With:"
                                + withPerson + "\t when:" + whenDate
                                + "\t Annoucement:" + announcement);
                bw.close();
                fw.close();
                return true;
            }
        } 
        catch(Exception e)
        {
            return false;
        }
         return false;
    }    
   /**
    * Boolean function greateFilePath
    * @param path
    * @return true or false
    */
   public boolean createFilePath(String path)
    {
        try
        {
            File file = new File(path);
            if(file.exists())
                return true;
            else
            {
                file.mkdirs();
                createFilePath(path);
            }
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
                
    
           
    
   

}
