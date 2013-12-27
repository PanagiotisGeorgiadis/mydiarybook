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
    private String fSeparator = File.separator;
    public NewEntryImageControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        String fSeparator = File.separator;
        File file = new File("."+fSeparator+"MyDiaryBook"+fSeparator);
        try {
            FileUtils.deleteDirectory(file);
            file = new File(System.getProperty("user.dir")+fSeparator+"qweqwe.txt");
            file.delete();
        } catch (IOException ex) {
            Logger.getLogger(NewEntryImageControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @AfterClass
    public static void tearDownClass() {
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
            Logger.getLogger(NewEntryImageControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of copyImage method, of class NewEntryImageController.
     */
@Test
    public void testCopyImage() {
        System.out.println("copyImageFromExistingSourceToExistingDest");
        String sourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+"java"+fSeparator+"resources"+fSeparator+"testImg.jpg";
        String destPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Mitsos"+fSeparator+"Images"+fSeparator;
        int imageNumber = 0;
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage2() {
        System.out.println("copyImageFromNonExistingSourceToExistingDest");
        String sourcePath = "C.jpg";
        String destPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Mitsos"+fSeparator+"Images"+fSeparator;
        int imageNumber = 2;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage3() {
        System.out.println("copyImageFromNonExistingSourceToExistingDest");
        String sourcePath = "F:"+fSeparator+"Bla"+fSeparator+"Blabla"+fSeparator+"Blablabla";
        String destPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Mitsos"+fSeparator+"Images"+fSeparator;
        int imageNumber = 3;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage4() {
        System.out.println("copyImageFromExistingSourceToExistingDestWhileCreatingTheDestPath");
        String sourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+"java"+fSeparator+"resources"+fSeparator+"testImg.jpg";
        String destPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Makis"+fSeparator+"Images"+fSeparator;
        int imageNumber = 3;
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage5() {
        System.out.println("copyImageFromExistingPathButBigImageNumber");
        String sourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+"java"+fSeparator+"resources"+fSeparator+"testImg.jpg"+fSeparator;
        String destPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Makis"+fSeparator+"Images"+fSeparator;
        int imageNumber = 100;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
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
