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

/**
 *
 * @author alex
 */
public class AnnouncementValidatorTest {
    
    public AnnouncementValidatorTest() {
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
     * Test of checkPersonalGoalAnnouncement method, of class
     * AnnouncementValidator.
     */
    @Test
    public void testCheckPersonalGoalAnnouncementSuccess() {
        System.out.println("testCheckPersonalGoalAnnouncementSuccess");
        String announcement = "";
        AnnouncementValidator instance = new AnnouncementValidator();
        boolean expResult = true;
        boolean result = instance.announcementIsValid(announcement);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of checkPersonalGoalAnnouncement method, of class
     * AnnouncementValidator.
     */
    @Test
    public void testCheckPersonalGoalAnnouncementLimit() {
        System.out.println("testCheckPersonalGoalAnnouncementLimit");
        String announcement = "12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345612345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678907890";
        AnnouncementValidator instance = new AnnouncementValidator();
        boolean expResult = false;
        boolean result = instance.announcementIsValid(announcement);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of checkPersonalGoalAnnouncement method, of class
     * AnnouncementValidator.
     */
    @Test
    public void testCheckPersonalGoalAnnouncementSuccessNull() {
        System.out.println("testCheckPersonalGoalAnnouncementSuccessNull");
        String announcement = "";
        AnnouncementValidator instance = new AnnouncementValidator();
        boolean expResult = true;
        boolean result = instance.announcementIsValid(announcement);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of checkPersonalGoalAnnouncement method, of class
     * AnnouncementValidator.
     */
    @Test
    public void testCheckPersonalGoalAnnouncementNullSpaces() {
        System.out.println("testCheckPersonalGoalAnnouncementNullSpaces");
        String announcement = "  ";
        AnnouncementValidator instance = new AnnouncementValidator();
        boolean expResult = true;
        boolean result = instance.announcementIsValid(announcement);
        Assert.assertEquals(expResult, result);

    }
    
}
