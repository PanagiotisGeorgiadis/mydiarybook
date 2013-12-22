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
public class NewEntryVideoControllerTest {
    private String fSeparator = File.separator;
    public NewEntryVideoControllerTest() {
    }
    
@BeforeClass
    public static void setUpClass() {
    }
    
   @AfterClass
    public static void tearDownClass() {  
        String fSeparator = File.separator;
        File file = new File("."+fSeparator+"MyDiaryBook"+fSeparator);
        try {
            FileUtils.deleteDirectory(file);
            file = new File(System.getProperty("user.dir")+fSeparator+"qweqwe.txt");
            file.delete();
        } catch (IOException ex) {
            Logger.getLogger(NewEntryVideoControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Before
    public void setUp() {
        String fSeparator = File.separator; //System.getProperty("file.separator");
        File file = new File("."+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"PAOK"+fSeparator);
        file.mkdirs();
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Mitsos");
        file.mkdirs();
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Makis");
        file.mkdirs();        
    }
    
    @After
    public void tearDown() {
        String fSeparator = File.separator;
        File file = new File("."+fSeparator+"MyDiaryBook"+fSeparator);
        try {
            FileUtils.deleteDirectory(file);
            file = new File(System.getProperty("user.dir")+fSeparator+"qweqwe.txt");
            file.delete();
        } catch (IOException ex) {
            Logger.getLogger(NewEntryVideoControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of copyVideo method, of class NewEntryVideoController.
     */
    /**
     * Test of copyVideo method, of class NewEntryController.
     */
    @Test
    public void testCopyVideo() {
        System.out.println("copyVideoFromExistingSourceToExistingDest");
        String sourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+"java"+fSeparator+"resources"+fSeparator+"testVideo.mp4";
        String videoDestPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Mitsos"+fSeparator+"Videos"+fSeparator;
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.copyVideo(sourcePath, videoDestPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyVideo2() {
        System.out.println("copyVideo5FromNullSourceToNullDest");
        String sourcePath = null;
        String videoDestPath = null;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyVideo(sourcePath, videoDestPath);
        assertEquals(expResult, result);
        }
        
    @Test
    public void testCopyVideo3() {
        System.out.println("copyVideoFromExistingSourceButNotVideoFileToExistingDest");
        String sourcePath = "C:"+fSeparator+"Users"+fSeparator+"Zarc"+fSeparator+"Documents"+fSeparator+"First Of the year";
        String videoDestPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Mitsos"+fSeparator;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyVideo(sourcePath, videoDestPath);
        assertEquals(expResult, result);
    }
            
    @Test
    public void testCopyVideo4() {
        System.out.println("copyVideoFromEmptySourceToEmptyDest");
        String sourcePath = "   ";
        String videoDestPath = "    ";
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyVideo(sourcePath, videoDestPath);
        assertEquals(expResult, result);
    }

    /**
     * Test of getVideo method, of class NewEntryVideoController.
     */
    //TODO get Video tests
//    @Test
//    public void testGetVideo() {
//        System.out.println("getVideo");
//        String entryTitle = "";
//        NewEntryVideoController instance = new NewEntryVideoController();
//        File expResult = null;
//        File result = instance.getVideo(entryTitle);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
}
