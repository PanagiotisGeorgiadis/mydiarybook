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
    @Test
    public void testCheckPersonalGoalTitleSuccess() {
        System.out.println("checkPersonalGoalTitleSuccess");
        String personalGoalTitle = "alex";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = true;
        boolean result = instance.checkPersonalGoalTitle(personalGoalTitle);
        Assert.assertEquals(expResult, result);
        
    }
    @Test
    public void testCheckPersonalGoalTitleNull() {
        System.out.println("checkPersonalGoalTitleFailure");
        String personalGoalTitle = "";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalTitle(personalGoalTitle);
        Assert.assertEquals(expResult, result);
        
    }
    
    @Test
    public void testCheckPersonalGoalTitleWrong() {
        System.out.println("checkPersonalGoalTitleWrong");
        String personalGoalTitle = "-";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalTitle(personalGoalTitle);
        Assert.assertEquals(expResult, result);
        
    }
    
    
    /**
     * Test of checkPersonalGoalLocation method, of class PersonalGoalEvaluator.
     */
    @Test
    public void testCheckPersonalGoalLocationSuccess() {
        System.out.println("checkPersonalGoalLocationSuccess");
        String personalGoalLocation = "Giannitsa";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = true;
        boolean result = instance.checkPersonalGoalLocation(personalGoalLocation);
       Assert.assertEquals(expResult, result);

    /**
     * Test of checkPersonalGoalWithPerson method, of class PersonalGoalEvaluator.
     */
    }
     @Test
    public void testCheckPersonalGoalLocationNull() {
        System.out.println("checkPersonalGoalLocationNull");
        String personalGoalLocation = " ";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalLocation(personalGoalLocation);
       Assert.assertEquals(expResult, result);

    /**
     * Test of checkPersonalGoalWithPerson method, of class PersonalGoalEvaluator.
     */
    }
    @Test
    public void testCheckPersonalGoalLocationWrong() {
        System.out.println("checkPersonalGoalLocationWrong");
        String personalGoalLocation = "-";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalLocation(personalGoalLocation);
       Assert.assertEquals(expResult, result);

    /**
     * Test of checkPersonalGoalWithPerson method, of class PersonalGoalEvaluator.
     */
    }
    
    @Test
    public void testCheckPersonalGoalWithPersonSuccess() {
        System.out.println("checkPersonalGoalWithPersonSuccess");
        String personalGoalWithPerson = "Alex";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = true;
        boolean result = instance.checkPersonalGoalWithPerson(personalGoalWithPerson);
       Assert.assertEquals(expResult, result);
        
    }
    
    @Test
    public void testCheckPersonalGoalWithPersonWrong() {
        System.out.println("checkPersonalGoalWithPersonWrong");
        String personalGoalWithPerson = "-";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalWithPerson(personalGoalWithPerson);
       Assert.assertEquals(expResult, result);
        
    }

    /**
     * Test of checkPersonalGoalWhenDate method, of class PersonalGoalEvaluator.
     */
    @Test
    public void testCheckPersonalGoalWhenDateSuccess() {
        System.out.println("checkPersonalGoalWhenDate");
        String personalGoalWhenDate = "27/08/1991";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = true;
        boolean result = instance.checkPersonalGoalWhenDate(personalGoalWhenDate);
        
         Assert.assertEquals(expResult, result);
        
    }
  
    
    

    /**
     * Test of checkPersonalGoalAnnouncement method, of class PersonalGoalEvaluator.
     */
    @Test
    public void testCheckPersonalGoalAnnouncementWordLimit() {
        System.out.println("checkPersonalGoalAnnouncementWordLimit");
        String personalGoalAnnouncement = "1234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890";
        PersonalGoalEvaluator instance = new PersonalGoalEvaluator();
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalAnnouncement(personalGoalAnnouncement);
         Assert.assertEquals(expResult, result);
        
    }
    


    
}
