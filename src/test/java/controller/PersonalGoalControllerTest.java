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
     * Test of CheckField method, of class PersonalGoalCheckField.
     */
    @Test
    public void testCreatePersonalGoalSuccess() {
        System.out.println("testCreatePersonalGoalSuccess");
        String title = "Title";
        String location = "asdasd";
        String withPerson = "asdasd";
        String whenDate = "12/12/1991";
        String announcement = "adsasdas";
        PersonalGoalController instance = new PersonalGoalController();
        String expResult = "success";
        String result = instance.createPersonalGoal(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);;

    }

    /**
     * Test of CheckField method, of class PersonalGoalEvaluator.
     */
    @Test
    public void testCreatePersonalGoalFieldTitle() {
        System.out.println("testCreatePersonalGoalFieldTitle");
        String title = "";
        String location = "Location";
        String withPerson = "WithPerson";
        String whenDate = "WhenPerson";
        String announcement = "Announcement";
        PersonalGoalController instance = new PersonalGoalController();
        String expResult = "Title";
        String result = instance.createPersonalGoal(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);

    }

    @Test
    public void testCreatePersonalGoalFieldLocation() {
        System.out.println("testCreatePersonalGoalFieldLocation");
        String title = "Title";
        String location = "";
        String withPerson = "WithPerson";
        String whenDate = "WhenPerson";
        String announcement = "Announcement";
        PersonalGoalController instance = new PersonalGoalController();
        String expResult = "Location";
        String result = instance.createPersonalGoal(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);

    }

    @Test
    public void testCreatePersonalGoalFieldWithPerson() {
        System.out.println("testCreatePersonalGoalFieldWithPerson");
        String title = "Title";
        String location = "Location";
        String withPerson = "123456789012345678901234567890";
        String whenDate = "WhenDate";
        String announcement = "Announcement";
        PersonalGoalController instance = new PersonalGoalController();
        String expResult = "WithPerson";
        String result = instance.createPersonalGoal(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);

    }

    @Test
    public void testCreatePersonalGoalWhenDate() {
        System.out.println("testCreatePersonalGoalWhenDate");
        String title = "Title";
        String location = "Location";
        String withPerson = "WithPerson";
        String whenDate = "";
        String announcement = "Announcement";
        PersonalGoalController instance = new PersonalGoalController();
        String expResult = "WhenDate";
        String result = instance.createPersonalGoal(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);

    }

    @Test
    public void testCreatePersonalGoalAnnouncement() {
        System.out.println("testCreatePersonalGoalAnnouncement");
        String title = "Title";
        String location = "Location";
        String withPerson = "WithPerson";
        String whenDate = "27/12/1991";
        String announcement = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901";
        PersonalGoalController instance = new PersonalGoalController();
        String expResult = "Announcement";
        String result = instance.createPersonalGoal(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);

    }

}
