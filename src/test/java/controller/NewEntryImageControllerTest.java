/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.File;
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
 * @author Zarc
 */
public class NewEntryImageControllerTest {
    static String fSeparator = File.separator;
    String imageSourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+"java"+fSeparator+"resources"
                +fSeparator+"testImg.jpg";
    public NewEntryImageControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
                +fSeparator+"Entries"+fSeparator+"Entry1");
        file.mkdirs();
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
                +fSeparator+"Entries"+fSeparator+"Entry2");
        file.mkdirs();        
    }
    
    @AfterClass
    public static void tearDownClass() {
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook");
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException ex) {
            Logger.getLogger(NewEntryImageControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Before
    public void setUp() {
        File file = new File("."+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"PAOK"+fSeparator);
        file.mkdirs();
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Mitsos");
        file.mkdirs();
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Makis");
        file.mkdirs();     
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of copyImage method, of class NewEntryImageController.
     */
@Test
    public void testCopyImage() {
        System.out.println("copyImage From Existing Source To Existing Entry");
        String userTitle = "Entry1";
        String sourcePath = imageSourcePath;
        
        NewEntryImageController instance = new NewEntryImageController();
        boolean expResult = true;
        boolean result = instance.copyImage(userTitle, sourcePath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage2() {
        System.out.println("copyImage From Non Existing Source To Existing Entry");
        String userTitle = "Entry1";
        String sourcePath = imageSourcePath+fSeparator+"asdasdd"; 
        
        NewEntryImageController instance = new NewEntryImageController();
        boolean expResult = false;
        boolean result = instance.copyImage(userTitle, sourcePath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage3() {
        System.out.println("copyImage From Existing Source To Non Existing Entry Which will be created");
        String userTitle = "NonExistingEntry";
        String sourcePath = imageSourcePath;
        
        NewEntryImageController instance = new NewEntryImageController();
        boolean expResult = true;
        boolean result = instance.copyImage(userTitle, sourcePath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage4() {
        System.out.println("copyImage From null sourcePath with a null userTitle");
        String userTitle = "";
        String sourcePath = "";
        
        NewEntryImageController instance = new NewEntryImageController();
        boolean expResult = false;
        boolean result = instance.copyImage(userTitle, sourcePath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage5() {
        System.out.println("copyImage From Existing Path to existing Entry But replacing an image");
        String userTitle = "Entry1";
        String sourcePath = imageSourcePath;
        
        NewEntryImageController instance = new NewEntryImageController();
        boolean expResult = true;
        boolean result = instance.copyImage(userTitle, sourcePath);
        assertEquals(expResult, result);
    }

    /**
     * Test of getImageFiles method, of class NewEntryImageController.
     */
    //TODO tests
//    @Test
//    public void testGetImageFiles() {
//        System.out.println("getImageFiles");
//        String entryTitle = "";
//        NewEntryImageController instance = new NewEntryImageController();
//        File[] expResult = null;
//        File[] result = instance.getImageFiles(entryTitle);
//        assertArrayEquals(expResult, result);
//    }
    
}
