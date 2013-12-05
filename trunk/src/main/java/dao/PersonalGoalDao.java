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
public class PersonalGoalDao implements  IPersonalGoalDao {
    /**
     * boolean συνάρτηση που κάνει εγγραφή μέσα σε ενα αρχέιο.
     * @param pgm
     * @return
     * @throws IOException 
     */
    
    @Override
    public boolean writeToFilePersonalGoal(PersonalGoalModel pgm) throws IOException{
        
        try{
            try(BufferedWriter personaGoalWriter = new BufferedWriter(new FileWriter("writeToFilePersonalGoal.txt",true)))
            {
               personaGoalWriter.write(pgm.getPersonalGoalTitle()+"\t"+pgm.getPersonalGoalLocation()+"\t"+
                       pgm.getPersonalGoalWithPerson()+"\t"+pgm.getPersonalGoalWhenDate()+"\t"+pgm.getPersonalGoalAnnouncement()+"\n");
            }
            return true;
            
        }catch(IOException e){
            return false;
        }
           
        
    }
    
    private ArrayList<PersonalGoalModel> database;
    private final String delimeter = ";";
    
    /**
     * 
     * @param fileName 
     */
    public void loadDatabase(String fileName)
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
    public void saveToFile(String fileName)
    {
        int listLen = database.size();
        
        if(listLen > 0)
        {
            FileWriter fw = null;
            try {
                File file = new File(fileName);
                PersonalGoalModel temp;
                fw = new FileWriter(file ,true);
                for(int i = 0; i < listLen;i++)
                {
                    temp = database.get(i);
                    fw.write( temp.getPersonalGoalTitle()      +delimeter+
                              temp.getPersonalGoalLocation()   +delimeter+
                              temp.getPersonalGoalWithPerson() +delimeter+
                              temp.getPersonalGoalWhenDate().toString()   +delimeter+
                              temp.getPersonalGoalAnnouncement()
                    );
                    fw.write(System.getProperty("line.separator"));
                }
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(PersonalGoalDao.class.getName()).log(Level.SEVERE, null, ex);
            } 
        }
    }
    
}
