/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

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
public class PersonalGoalEvaluatorTest {
    
    public PersonalGoalEvaluatorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkPersonalGoalTitle method, of class PersonalGoalEvaluator.
     */
    /**
     * Test of checkPersonalGoalTitle method, of class PersonalGoalEvaluator.
     */
    @Test
    public void testCheckPersonalGoalTitleSuccess() {
        System.out.println("checkPersonalGoalTitleSuccess");
        String Title = "alex";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = true;
        boolean result = instance.checkPersonalGoalTitle(Title);
        Assert.assertEquals(expResult, result);
        
    }
    @Test
    public void testCheckPersonalGoalTitleNull() {
        System.out.println("checkPersonalGoalTitleNull");
        String Title = "";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalTitle(Title);
        Assert.assertEquals(expResult, result);
        
    }
    
    @Test
    public void testCheckPersonalGoalTitleWrong() {
        System.out.println("checkPersonalGoalTitleWrong");
        String Title = "-";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalTitle(Title);
        Assert.assertEquals(expResult, result);
        
    }
    
    
    /**
     * Test of checkPersonalGoalLocation method, of class PersonalGoalEvaluator.
     */
    @Test
    public void testCheckPersonalGoalLocationSuccess() {
        System.out.println("checkPersonalGoalLocationSuccess");
        String Location = "Giannitsa";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = true;
        boolean result = instance.checkPersonalGoalLocation(Location);
       Assert.assertEquals(expResult, result);

    /**
     * Test of checkPersonalGoalWithPerson method, of class PersonalGoalEvaluator.
     */
    }
     @Test
    public void testCheckPersonalGoalLocationNull() {
        System.out.println("checkPersonalGoalLocationNull");
        String Location = "";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalLocation(Location);
       Assert.assertEquals(expResult, result);

    /**
     * Test of checkPersonalGoalWithPerson method, of class PersonalGoalEvaluator.
     */
    }
    @Test
    public void testCheckPersonalGoalLocationWrong() {
        System.out.println("checkPersonalGoalLocationWrong");
        String Location = "-";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalLocation(Location);
       Assert.assertEquals(expResult, result);

    /**
     * Test of checkPersonalGoalWithPerson method, of class PersonalGoalEvaluator.
     */
    }
    
    @Test
    public void testCheckPersonalGoalWithPersonSuccess() {
        System.out.println("checkPersonalGoalWithPersonSuccess");
        String WithPerson = "Alex";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = true;
        boolean result = instance.checkPersonalGoalWithPerson(WithPerson);
       Assert.assertEquals(expResult, result);
        
    }
    
        @Test
    public void testCheckPersonalGoalWithPersonWrong() {
        System.out.println("checkPersonalGoalWithPersonWrong");
        String WithPerson = "-";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalWithPerson(WithPerson);
       Assert.assertEquals(expResult, result);
        
    }

    /**
     * Test of checkPersonalGoalWhenDate method, of class PersonalGoalEvaluator.
     */
    @Test
    public void testCheckPersonalGoalWhenDateSuccess() {
        System.out.println("checkPersonalGoalWhenDateSuccess");
        String WhenDate = "27/08/1991";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = true;
        boolean result = instance.checkPersonalGoalWhenDate(WhenDate);
        
         Assert.assertEquals(expResult, result);
        
    }
     @Test
    public void testCheckPersonalGoalWhenDateNull() {
        System.out.println("checkPersonalGoalWhenDateNull");
        String WhenDate = "";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalWhenDate(WhenDate);
        
         Assert.assertEquals(expResult, result);
        
    }
  

    /**
     * Test of checkPersonalGoalAnnouncement method, of class PersonalGoalEvaluator.
     */
    @Test
    public void testCheckPersonalGoalAnnouncementWordLimit() {
        System.out.println("checkPersonalGoalAnnouncementWordLimit");
        String Announcement = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345612345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678907890";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalAnnouncement(Announcement);
         Assert.assertEquals(expResult, result);
        
    }
    /**
     * Test of checkPersonalGoalAnnouncement method, of class PersonalGoalEvaluator.
     */
    @Test
    public void testCheckPersonalGoalAnnouncementSuccess() {
        System.out.println("checkPersonalGoalAnnouncementSuccess");
        String Announcement = "I want a now job !!";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = true;
        boolean result = instance.checkPersonalGoalAnnouncement(Announcement);
         Assert.assertEquals(expResult, result);
        
    }
    /**
     * Test of CheckField method, of class PersonalGoalEvaluator.
     */
    @Test
    public void testCheckFieldSuccess() {
        System.out.println("CheckField");
        String title = "Title";
        String location = "asdasd";
        String withPerson = "asdasd";
        String whenDate = "asdasd";
        String announcement = "adsasdas";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        String expResult = "success";
        String result = instance.CheckField(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);
       
    }
      @Test
    public void testCheckFieldTitle() {
        System.out.println("CheckField");
        String title = "";
        String location = "Location";
        String withPerson = "WithPerson";
        String whenDate = "WhenPerson";
        String announcement = "Announcement";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        String expResult = "Title";
        String result = instance.CheckField(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);
       
    }
    
      @Test
    public void testCheckFieldLocation() {
        System.out.println("CheckField");
       String title = "Title";
        String location = "";
        String withPerson = "WithPerson";
        String whenDate = "WhenPerson";
        String announcement = "Announcement";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        String expResult = "Location";
        String result = instance.CheckField(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);
       
    }
      @Test
    public void testCheckFieldWithPerson() {
        System.out.println("CheckField");
        String title = "Title";
        String location = "Location";
        String withPerson = "123456789012345678901234567890";
        String whenDate = "WhenDate";
        String announcement = "Announcement";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        String expResult = "WithPerson";
        String result = instance.CheckField(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);
       
    }
      @Test
    public void testCheckFieldWhenDate() {
        System.out.println("CheckField");
        String title = "Title";
        String location = "Location";
        String withPerson = "WithPerson";
        String whenDate = "";
        String announcement = "Announcement";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        String expResult = "WhenDate";
        String result = instance.CheckField(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);
       
    }
      @Test
    public void testCheckFieldAnnouncement() {
        System.out.println("CheckField");
         String title = "Title";
        String location = "Location";
        String withPerson = "WithPerson";
        String whenDate = "WhenDate";
        String announcement = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        String expResult = "Announcement";
        String result = instance.CheckField(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);
       
    }
    
    
}
