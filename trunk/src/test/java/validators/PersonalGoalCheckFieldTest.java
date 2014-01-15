/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

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
public class PersonalGoalCheckFieldTest {

    public PersonalGoalCheckFieldTest() {
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
    public void testCheckFieldSuccess() {
        System.out.println("testCheckFieldSuccess");
        String title = "Title";
        String location = "asdasd";
        String withPerson = "asdasd";
        String whenDate = "12/12/1991";
        String announcement = "adsasdas";
        PersonalGoalCheckField instance = new PersonalGoalCheckField();
        String expResult = "success";
        String result = instance.CheckField(title, location, withPerson, whenDate, announcement);
        assertEquals(expResult, result);

    }

    /**
     * Test of CheckField method, of class PersonalGoalEvaluator.
     */
    @Test
    public void testCheckFieldTitle() {
        System.out.println("testCheckFieldTitle");
        String title = "";
        String location = "Location";
        String withPerson = "WithPerson";
        String whenDate = "WhenPerson";
        String announcement = "Announcement";
        PersonalGoalCheckField instance = new PersonalGoalCheckField();
        String expResult = "Title";
        String result = instance.CheckField(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);

    }

    @Test
    public void testCheckFieldLocation() {
        System.out.println("testCheckFieldLocation");
        String title = "Title";
        String location = "";
        String withPerson = "WithPerson";
        String whenDate = "WhenPerson";
        String announcement = "Announcement";
        PersonalGoalCheckField instance = new PersonalGoalCheckField();
        String expResult = "Location";
        String result = instance.CheckField(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);

    }

    @Test
    public void testCheckFieldWithPerson() {
        System.out.println("testCheckFieldWithPerson");
        String title = "Title";
        String location = "Location";
        String withPerson = "123456789012345678901234567890";
        String whenDate = "WhenDate";
        String announcement = "Announcement";
        PersonalGoalCheckField instance = new PersonalGoalCheckField();
        String expResult = "WithPerson";
        String result = instance.CheckField(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);

    }

    @Test
    public void testCheckFieldWhenDate() {
        System.out.println("testCheckFieldWhenDate");
        String title = "Title";
        String location = "Location";
        String withPerson = "WithPerson";
        String whenDate = "";
        String announcement = "Announcement";
        PersonalGoalCheckField instance = new PersonalGoalCheckField();
        String expResult = "WhenDate";
        String result = instance.CheckField(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);

    }

    @Test
    public void testCheckFieldAnnouncement() {
        System.out.println("testCheckFieldAnnouncement");
        String title = "Title";
        String location = "Location";
        String withPerson = "WithPerson";
        String whenDate = "27/12/1991";
        String announcement = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901";
        PersonalGoalCheckField instance = new PersonalGoalCheckField();
        String expResult = "Announcement";
        String result = instance.CheckField(title, location, withPerson, whenDate, announcement);
        Assert.assertEquals(expResult, result);

    }

}
