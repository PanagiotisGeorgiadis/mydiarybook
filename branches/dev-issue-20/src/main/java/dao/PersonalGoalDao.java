/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import model.PersonalGoalModel;

/**
 * Μια απλή κλάση η οποία κάνει μια καταχώρηση μέσα στo DAO.
 * @author alex
 */
public class PersonalGoalDao implements IPersonalGoalDao {
    
   // @Override
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
    
}
