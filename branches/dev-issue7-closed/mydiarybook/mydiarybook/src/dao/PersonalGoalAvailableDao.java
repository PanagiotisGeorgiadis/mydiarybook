/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Μια απλή κλάση που βλέπει αν υπάρχει στο Dao αυτός ο τίτλος για τον 
 * προσωπικό στόχο.
 * @author alex
 */

/*
* FIXME: να ελένχει αν υπάρχει μέσα στο Dao ο ίδιος τίτλος.
*/
public class PersonalGoalAvailableDao {
    
    /*check if title we given exist*/
    public static boolean chechIfTitleIsAvailable(String sTitle) throws FileNotFoundException{
        
        File newFile = new File("personalGoalTile.txt");
        Scanner sc = new Scanner(newFile);
         boolean result=false;
         ArrayList<String> personalGoalTitle = new ArrayList<String>();
        
         //backup of personalGoalTitles 
          while(sc.hasNextLine()){
            String line = sc.nextLine();
            String[] details = line.split("\t");
            String name = details[0];
            personalGoalTitle.add(name);
        }

         
         // Check if there is already the title that you want to put
         for(int i=0;i<personalGoalTitle.size();i++){
             if(personalGoalTitle.contains(sTitle)){
                 result=true;
             }
             else {
                 result=false;
             }
             return result;
         }
       
         return result;
         
//TODO: add more methoths for fields
        
        
    }
    
}
