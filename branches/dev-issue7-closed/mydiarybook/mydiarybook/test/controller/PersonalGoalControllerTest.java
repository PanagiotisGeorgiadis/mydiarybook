/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * FIXME: fix tests
 * @author alex
 */
public class PersonalGoalControllerTest {
    
    public PersonalGoalControllerTest() {
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
     * Test of createPersonalGoal method, of class PersonalGoalController.
     */
    @Test
    public void testCreatePersonalGoal() throws Exception {
        System.out.println("createPersonalGoal");
        String personalGoalTitle = "";
        String personalGoalLocation = "";
        String personalGoalWithPerson = "";
        Date personalGoalWhenDate = null;
        String personalGoalAnnouncement = "";
        PersonalGoalController instance = null;
        boolean expResult = false;
        boolean result = instance.createPersonalGoal(personalGoalTitle, personalGoalLocation, personalGoalWithPerson, personalGoalWhenDate, personalGoalAnnouncement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPersonalGoalTitle method, of class PersonalGoalController.
     */
    @Test
    public void testCheckPersonalGoalTitle() {
        System.out.println("checkPersonalGoalTitle");
        String personalGoalTitle = "";
        PersonalGoalController instance = null;
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalTitle(personalGoalTitle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPersonalGoalLocation method, of class PersonalGoalController.
     */
    @Test
    public void testCheckPersonalGoalLocation() {
        System.out.println("checkPersonalGoalLocation");
        String personalGoalLocation = "";
        PersonalGoalController instance = null;
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalLocation(personalGoalLocation);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPersonalGoalWithPerson method, of class PersonalGoalController.
     */
    @Test
    public void testCheckPersonalGoalWithPerson() {
        System.out.println("checkPersonalGoalWithPerson");
        String personalGoalWithPerson = "";
        PersonalGoalController instance = null;
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalWithPerson(personalGoalWithPerson);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPersonalGoalWhenDate method, of class PersonalGoalController.
     */
    @Test
    public void testCheckPersonalGoalWhenDate() {
        System.out.println("checkPersonalGoalWhenDate");
        String personalGoalWhenDate = "";
        PersonalGoalController instance = null;
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalWhenDate(personalGoalWhenDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPersonalGoalAnnouncement method, of class PersonalGoalController.
     */
    @Test
    public void testCheckPersonalGoalAnnouncement() {
        System.out.println("checkPersonalGoalAnnouncement");
        String personalGoalAnnouncement = "";
        PersonalGoalController instance = null;
        boolean expResult = false;
        boolean result = instance.checkPersonalGoalAnnouncement(personalGoalAnnouncement);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
