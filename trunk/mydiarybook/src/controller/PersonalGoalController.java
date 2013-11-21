/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.IPersonalGoalDao;
import dao.PersonalGoalAvailableDao;
import dao.PersonalGoalDao;
import exceptions.ExceptionDao;
import java.io.IOException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import model.PersonalGoalModel;

/*
    **Ένας απλός controller που μέσω checkPersonalGoalTitle,checkPersonalGoalLocation,checkPersonalGoalWithPerson
     *checkPersonalGoalWhenDate checkPersonalGoalAnnouncement.
     *Ελένχει αν τα πεδία που δίνουμε είναι σωστά αλλίως επιστρέφει μήνυμα λάθους.
     * @param personalGoalTitle        : Ο τίτλος του προσωπικόυ στόχου (Personal Goal)
     * @param personalGoalLocation     : Το όνομα της τοποθεσίας.
     * @param personalGoalWithPerson   : Το όνομα του προσώπου που υλοποιούμε μαζι τον προσωπικό στόχο.
     * @param personalGoalWhenDate     : Η ημερομηνία του προσωπικόυ στόχου.
     * @param personalGoalAnnouncement : Το Announcement .
     * @return επιστρέφει ενα true εάν όλα τα πεδία είναι σωστά αλλίως false.
     * @throws 
     *@author alex
 */
public class PersonalGoalController implements  IPersonalGoalController {
    public  IPersonalGoalDao newPersonalGoalDao ;
    
    public PersonalGoalController(IPersonalGoalDao personalGoalDao){
        
        this.newPersonalGoalDao = personalGoalDao;
        
        
    }
    
 
 /*FIXME: Να ελένχει μέσα στην φόρμα μονο απο την createPersonalGoal όλα τα πεδία.
  * ui.PersonalGoalForm 
  * line : 242-286
  */
   
    @Override
   public boolean createPersonalGoal(String personalGoalTitle,String personalGoalLocation ,String personalGoalWithPerson,
   Date personalGoalWhenDate, String personalGoalAnnouncement)throws Exception,IllegalArgumentException{
      PersonalGoalModel newPersonalGoalModel = new PersonalGoalModel();

       try{
           newPersonalGoalDao.writeToFilePersonalGoal(newPersonalGoalModel);
            return true;
        }catch (Exception ex){
            System.out.println("File Not Found!");
            return false;
        }

  
    /*  
     boolean result=false;
     boolean finalResult=false;
    
     while(result=false){
     result = checkPersonalGoalTitle(personalGoalTitle); 
     
     }
     
     while(result=false){
     result = checkPersonalGoalLocation(personalGoalLocation); 
     
     }
     while(result=false){
     result = checkPersonalGoalWithPerson(personalGoalWithPerson); 
     
     }
     while(result=false){
     result = checkPersonalGoalAnnouncement(personalGoalAnnouncement); 
     
     }
     boolean result1 =  personalGoalDao.writeToFilePersonalGoal(newPersonalGoalModel);
       
        if(result=result1) {
            finalResult=true;
            
        }
        return finalResult;
    
        
       */
        
      
        
   }
   
  
   //FIXME: να τσεκάρει αν υπάρχει ίδιος τίτλος .και αν ναι να εμφανίζει μνμ λάθος        
       
      /* check if the given personalGoalTitle exist in the file */
      /*  
        try{
            boolean resultIfPersonalGoalTitle=false;
            resultIfPersonalGoalTitle=
           PersonalGoalAvailableDao.chechIfTitleIsAvailable(newPersonalGoal.getPersonalGoalTitle());
            if(resultIfPersonalGoalTitle=false){
                System.out.println("The Title exist..\n");
                return false;
            }
            else{
                System.out.println("Title is acceptable\n!");
                
                }       
           }catch (Exception e){
            System.out.println(e);
            
            }
      // check if can write to file..  
        try{
           personalGoalDao.writeToFilePersonalGoal(newPersonalGoal);
           return true;
        }catch (Exception ex){
            System.out.println("File Not Found!");
            return false;
        }
       */
        
   

  
   // check if  title is correctly..   
    @Override
   public boolean checkPersonalGoalTitle(String personalGoalTitle)throws IllegalArgumentException{
     boolean result=false;
     String checkNull="";
            

            if(personalGoalTitle.length()>0&&personalGoalTitle.length()<3 ){
                
                JOptionPane.showMessageDialog(null,"Title must have atleast 3 characters");
            }
            else if(personalGoalTitle.length()>25){
                
                JOptionPane.showMessageDialog(null,"Title must be less than 25 characters");
            }
            else if(personalGoalTitle.equals(checkNull)){
                
                JOptionPane.showMessageDialog(null,"Title can't be null");
            }
            else{
                result=true;
            }
        return result;
             
        
        }
   //---------------------------------------------------------------------------------------------
   // check if  title is correctly.. 
    @Override
    public boolean checkPersonalGoalLocation(String personalGoalLocation) throws IllegalArgumentException {
     boolean result=false;
     String checkNull="";       

            if(personalGoalLocation.length()>0&&personalGoalLocation.length()<3){
                
                
                JOptionPane.showMessageDialog(null,"Location must have atleast 3 characters");
            }
            else if(personalGoalLocation.length()>25){
                
                JOptionPane.showMessageDialog(null,"Location must be less than 25 characters");
                
            }
            else if(personalGoalLocation.equals(checkNull)){
                
                JOptionPane.showMessageDialog(null,"Location can't be null");
                
            }
            else{
                result=true;
            }
        return result;
             
        
        }
    //---------------------------------------------------------------------------------------------
    // check if WithPerson is correctly.. 
    @Override
    public boolean checkPersonalGoalWithPerson(String personalGoalWithPerson)throws IllegalArgumentException{
     boolean result=false;
            

            if(personalGoalWithPerson.length()>0&&personalGoalWithPerson.length()<3){
                
                
                JOptionPane.showMessageDialog(null,"WithPerson must have atleast 3 characters");
            }
            else if(personalGoalWithPerson.length()>25){
                
                JOptionPane.showMessageDialog(null,"WithPerson must be less than 25 characters");
                
            }
            else{
                result=true;
            }
        return result;
             
        
        }
   //---------------------------------------------------------------------------------------------
     @Override
    public boolean checkPersonalGoalWhenDate(String personalGoalWhenDate)throws IllegalArgumentException{
     boolean result=false;
     String checkNull="";
            

            if(personalGoalWhenDate.equals(checkNull)){
                
                
                JOptionPane.showMessageDialog(null,"Date can't Date");
            }
            
            else{
                result=true;
            }
        return result;
             
        
        }
     //---------------------------------------------------------------------------------------------
   //check if personalGoalAnnouncement is correctly..
    @Override
   public boolean checkPersonalGoalAnnouncement(String personalGoalAnnouncement)throws IllegalArgumentException{
     boolean result=false;;
            

            
            if(personalGoalAnnouncement.length()>150){
                 
                JOptionPane.showMessageDialog(null,"Announcement must be less than 150 characters");
                
            }
            else{
                result=true;
            }
        return result;
             
        
        }

    
      

     
        
        
      
    
 }

    
    

