/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import static dao.NewEntryTextDaoTest.fSeparator;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alex
 */
public class PersonalGoalTxtDaoTest {
    private Object ex;
    
    public PersonalGoalTxtDaoTest() {
        
        
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
       
    }
    
     @AfterClass
    public static void tearDownClass() {
        
         File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook");
        try {      
            FileUtils.deleteDirectory(file);
        } catch (IOException ex) {
            Logger.getLogger(PersonalGoalTxtDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
         
    }
    
    @Before
    public void setUp() throws IOException  {
       
            String path =System.getProperty("user.dir")+fSeparator+"MyDiaryBook"
            +fSeparator+"Users"+fSeparator+"Alex Patsanis"+fSeparator+"PersonalGoal"+fSeparator+"Texts"
            +fSeparator+"testProject"+fSeparator;
               
               
                File titleFile = new File(path +"title.txt");
              
               File locationFile = new File(path + "location.txt");
              
               File withPersonFile= new File(path + "withPerson.txt");
             
               File whenDateFile = new File(path + "whenDate.txt");
               
               File  announcementFile =  new File(path + "announcement.txt");
              
            
              
               String title = "New job";
               String location = "Giannitsa";
               String withPerson ="Alex Patsanis";
               String whenDate = "Tue Jan 14 21:31:39 EET 2014";
               String announcement = "A new job";
               
                boolean exists = createFilePath( path);
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
                try {
                    announcementWritter.close();
                } catch (IOException ex) {
                    Logger.getLogger(PersonalGoalTxtDaoTest.class.getName()).log(Level.SEVERE, null, ex);
                }
               
                       
                }
                 titleFile.mkdirs();
               locationFile.mkdirs();
               withPersonFile.mkdirs();
                whenDateFile.mkdirs();
                 announcementFile.mkdirs(); 
      
                 
                  File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook");
        try {      
            FileUtils.deleteDirectory(file);
        } catch (IOException ex) {
            Logger.getLogger(PersonalGoalTxtDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
       
        
    }
    
    @After
    public void tearDown() {
       
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook");
        try {      
            FileUtils.deleteDirectory(file);
        } catch (IOException ex) {
            Logger.getLogger(PersonalGoalTxtDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
           
      
    }

    /**
     * Test of prepareForCreatingTextFile method, of class PersonalGoalTxtDao.
     */
    @Test
    public void testPrepareForCreatingTextFileSuccess() {
        System.out.println("testPrepareForCreatingTextFileSuccess");
        String title = "testProject";
        String location = "Giannitsa";
        String withPerson = "alex";
        String whenDate = "27/11/2014";
        String announcement = "i want a new job";
        String userName = "Alex Patsanis";
        PersonalGoalTxtDao instance = new PersonalGoalTxtDao();
        boolean expResult = true;
        boolean result = instance.prepareForCreatingTextFile(title, location, withPerson, whenDate, announcement, userName);
        assertEquals(expResult, result);
        
        
        
        
        
       
    }
    
   
     
    /**
     * Test of prepareForCreatingTextFile method, of class PersonalGoalTxtDao.
     */
    @Test
    public void testPrepareForCreatingTextFileFaild() {
        System.out.println("testPrepareForCreatingTextFileFaild");
        String title = null;
        String location = "";
        String withPerson = "";
        String whenDate = "";
        String announcement = "";
        String userName = "Alex Patsanis";
        PersonalGoalTxtDao instance = new PersonalGoalTxtDao();
        boolean expResult = false;
        boolean result = instance.prepareForCreatingTextFile(title, location, withPerson, whenDate, announcement, userName);
     
        assertEquals(expResult, result);
        
        
      
    }
  
   
     /**
     * Test of prepareForCreatingTextFile method, of class PersonalGoalTxtDao.
     */
    @Test
    public void testPrepareForCreatingTextFileFaildTitle() {
         System.out.println("testPrepareForCreatingTextFileFaildTitle");
        String title = null;
        String location = "Giannitsa";
        String withPerson = "alex";
        String whenDate = "27/11/2014";
        String announcement = "i want a new job";
       String userName = "Alex Patsanis";
        PersonalGoalTxtDao instance = new PersonalGoalTxtDao();
        boolean expResult = false;
        boolean result = instance.prepareForCreatingTextFile(title, location, withPerson, whenDate, announcement, userName);
        assertEquals(expResult, result);
        
      
       
        
       
    }
    
     
    
    @Test
    public void testPrepareForCreatingTextFileFaildLocation() {
         System.out.println("testPrepareForCreatingTextFileFaildLocation");
        String title = "testProject";
        String location = null;
        String withPerson = "alex";
        String whenDate = "27/11/2014";
        String announcement = "i want a new job";
      String userName = "Alex Patsanis";
        PersonalGoalTxtDao instance = new PersonalGoalTxtDao();
        boolean expResult = false;
        boolean result = instance.prepareForCreatingTextFile(title, location, withPerson, whenDate, announcement, userName);
        assertEquals(expResult, result);
        
       
        
       
    }
    
    
    
     @Test
    public void testPrepareForCreatingTextFileFaildWithPerson() {
         System.out.println("testPrepareForCreatingTextFileFaildWithPerson");
        String title = "testProject";
        String location = "Giannitsa";
        String withPerson = null;
        String whenDate = "27/11/2014";
        String announcement = "i want a new job";
        String userName = "Alex Patsanis";
        PersonalGoalTxtDao instance = new PersonalGoalTxtDao();
        boolean expResult = false;
        boolean result = instance.prepareForCreatingTextFile(title, location, withPerson, whenDate, announcement, userName);
        assertEquals(expResult, result);
        
       
       
    }
     
    
     @Test
    public void testPrepareForCreatingTextFileFaildWhenDate() {
         System.out.println("testPrepareForCreatingTextFileFaildWhenDate");
        String title = "testProject";
        String location = "Giannitsa";
        String withPerson = "alex";
        String whenDate = null;
        String announcement = "i want a new job";
        String userName = "Alex Patsanis";
        PersonalGoalTxtDao instance = new PersonalGoalTxtDao();
        boolean expResult = false;
        boolean result = instance.prepareForCreatingTextFile(title, location, withPerson, whenDate, announcement, userName);
        
        
        assertEquals(expResult, result);
        
        
        
       
    }
     
    
     @Test
    public void testPrepareForCreatingTextFileFaildAnnouncement() {
         System.out.println("testPrepareForCreatingTextFileFaildAnnouncement");
        String title = "testProject";
        String location = "Giannitsa";
        String withPerson = "alex";
        String whenDate = "27/11/2014";
        String announcement = null;
        String userName = "Alex Patsanis";
        PersonalGoalTxtDao instance = new PersonalGoalTxtDao();
        boolean expResult = false;
        boolean result = instance.prepareForCreatingTextFile(title, location, withPerson, whenDate, announcement, userName);
       
         
        
        assertEquals(expResult, result);
        
       
        
       
    }
 
    
    
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
     
}
