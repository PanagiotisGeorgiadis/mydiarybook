/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import static controller.NewEntryTextControllerTest.fSeparator;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alex
 */
public class PersonalGoalTextControllerTest {

    public PersonalGoalTextControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
        
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator);
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException ex) {
            Logger.getLogger(NewEntryTextControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Before
    public void setUp() {
        
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Alex Patsanis"+fSeparator
                +"PersonalGoal"+fSeparator+"testProject"+fSeparator+"Texts");
        file.mkdirs(); 
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createTextFile method, of class PersonalGoalTextController.
     */
    @Test
    public void testCreateTextFileSuccess() {
        System.out.println("testCreateTextFileSuccess");
        String title = "A new job";
        String location = "Giannitsa";
        String withPerson = "Alex";
        String whenDate = "27/08/1991";
        String announcement = "I want a new job";
        String userName="alex";
        PersonalGoalTextController instance = new PersonalGoalTextController();
        boolean expResult = true;
        boolean result = instance.createTextFile(title, location, withPerson, whenDate, announcement, userName);

    }

    /**
     * Test of createTextFile method, of class PersonalGoalTextController.
     */
    @Test
    public void testCreateTextFileFaild() {
        System.out.println("testCreateTextFileFaild");
        String title = "";
        String location = "";
        String withPerson = "";
        String whenDate = "";
        String announcement = "";
        String userName="";
        PersonalGoalTextController instance = new PersonalGoalTextController();
        boolean expResult = false;
        boolean result = instance.createTextFile(title, location, withPerson, whenDate, announcement,userName);

    }

    /**
     * Test of createTextFile method, of class PersonalGoalTextController.
     */
    @Test
    public void testCreateTextFileFaildTitle() {
        System.out.println("testCreateTextFileFaildTitle");
        String title = "";
        String location = "Giannitsa";
        String withPerson = "Alex";
        String whenDate = "27/08/1991";
        String announcement = "I want a new job";
        String userName="alex";
        PersonalGoalTextController instance = new PersonalGoalTextController();
        boolean expResult = false;
        boolean result = instance.createTextFile(title, location, withPerson, whenDate, announcement,userName);

    }

    /**
     * Test of createTextFile method, of class PersonalGoalTextController.
     */
    @Test
    public void testCreateTextFileFaildLocation() {
        System.out.println("testCreateTextFileFaildLocation");
        String title = "A new job";
        String location = "";
        String withPerson = "Alex";
        String whenDate = "27/08/1991";
        String announcement = "I want a new job";
        String userName="alex";
        PersonalGoalTextController instance = new PersonalGoalTextController();
        boolean expResult = false;
        boolean result = instance.createTextFile(title, location, withPerson, whenDate, announcement,userName);

    }

    /**
     * Test of createTextFile method, of class PersonalGoalTextController.
     */
    @Test
    public void testCreateTextFileFaildwithPersonWrong() {
        System.out.println("testCreateTextFileFaildwithPersonWrong");
        String title = "A new job";
        String location = "123123";
        String withPerson = "Alex";
        String whenDate = "27/08/1991";
        String announcement = "I want a new job";
        String userName="alex";
        PersonalGoalTextController instance = new PersonalGoalTextController();
        boolean expResult = false;
        boolean result = instance.createTextFile(title, location, withPerson, whenDate, announcement,userName);

    }

    /**
     * Test of createTextFile method, of class PersonalGoalTextController.
     */
    @Test
    public void testCreateTextFileFaildWhenDateWrong() {
        System.out.println("testCreateTextFileFaildWhenDateWrong");
        String title = "A new job";
        String location = "123123";
        String withPerson = "Alex";
        String whenDate = "";
        String announcement = "I want a new job";
        String userName="alex";
        PersonalGoalTextController instance = new PersonalGoalTextController();
        boolean expResult = false;
        boolean result = instance.createTextFile(title, location, withPerson, whenDate, announcement,userName);

    }

    /**
     * Test of createTextFile method, of class PersonalGoalTextController.
     */
    @Test
    public void testCreateTextFileFailAnnouncementWrong() {
        System.out.println("testCreateTextFileFailAnnouncementWrong");
        String title = "A new job";
        String location = "123123";
        String withPerson = "Alex";
        String whenDate = "";
        String announcement = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901";
        String userName="alex";
        PersonalGoalTextController instance = new PersonalGoalTextController();
        boolean expResult = false;
        boolean result = instance.createTextFile(title, location, withPerson, whenDate, announcement,userName);

    }

}
