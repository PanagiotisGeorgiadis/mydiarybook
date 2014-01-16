/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.File;
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
public class PersonalGoalImageControllerTest {
    static String fSeparator = File.separator;
    String imageSourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+"java"+fSeparator+"resources"
                +fSeparator+"testImg.jpg";
    
    public PersonalGoalImageControllerTest() {
        
        
         File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Alex Patsanis"
                +fSeparator+"PersonalGoal"+fSeparator+"testPersonalGoal");
        file.mkdirs();
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        File file = new File("."+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Alex Patsanis"+fSeparator+"testImage"+fSeparator);
        file.mkdirs();
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"alex");
        file.mkdirs();
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of saveImage method, of class PersonalGoalImageController.
     */
    @Test
    public void testSaveImageSuccess() {
        System.out.println("testSaveImageSuccess");
        String userTitle = "testPersonalGoal";
        String imagePath = imageSourcePath;
        String userName = "Alex Patsanis";
        PersonalGoalImageController instance = new PersonalGoalImageController();
        boolean expResult = true;
        boolean result = instance.saveImage(userTitle, imagePath, userName);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSaveImageWrongUserTitle() {
        System.out.println("testSaveImageWrongUserTitle");
        String userTitle = "wrong";
        String imagePath = imageSourcePath;
        String userName = "Alex Patsanis";
        PersonalGoalImageController instance = new PersonalGoalImageController();
        boolean expResult = true;
        boolean result = instance.saveImage(userTitle, imagePath, userName);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSaveImageWrongUserImagePath() {
        System.out.println("testSaveImageWrongUserImagePath");
        String userTitle = "wrong";
        String imagePath = imageSourcePath+fSeparator+"wrongS";
        String userName = "Alex Patsanis";
        PersonalGoalImageController instance = new PersonalGoalImageController();
        boolean expResult = false;
        boolean result = instance.saveImage(userTitle, imagePath, userName);
        assertEquals(expResult, result);
        
    }
    
    @Test
    public void testSaveImageWrongUserName() {
        System.out.println("testSaveImageWrongUserName");
        String userTitle = "wrong";
        String imagePath = "";
        String userName = "Alex Patsanis aaa";
        PersonalGoalImageController instance = new PersonalGoalImageController();
        boolean expResult = false;
        boolean result = instance.saveImage(userTitle, imagePath, userName);
        assertEquals(expResult, result);
        
    }
    
    
   
    
}
