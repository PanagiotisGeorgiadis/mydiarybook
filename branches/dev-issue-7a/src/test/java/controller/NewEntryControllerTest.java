/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class NewEntryControllerTest {
    private final String fSeparator = File.separator;
    public NewEntryControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        String fSeparator = File.separator; //System.getProperty("file.separator");
        File file = new File("."+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"PAOK"+fSeparator);
        file.mkdirs();
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
            Logger.getLogger(NewEntryControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of filePathExists method, of class NewEntryController.
     */
    @Test
    public void testFilePathExists() {
        System.out.println("filePathExistsWithNonExistantPath");
        String title = "F:"+fSeparator+"BLABLA"+fSeparator+"BLABLA"+fSeparator+"BLABLA";
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.filePathExists(title);
        assertEquals(expResult, result);
    }
    

    
    @Test
    public void testFilePathExists3() {
        System.out.println("filePathExistsWithNonPathTypeEntry");
        String title = "1541546565665545897";
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.filePathExists(title);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFilePathExists4() {
        System.out.println("filePathExistsWithNullTitle");
        String title = null;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.filePathExists(title);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of copyImage method, of class NewEntryController.
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
     * Test of createFile method, of class NewEntryController.
     */
    @Test
    public void testCreateFile() {
        System.out.println("createFileWithTitleWithTextToExistingDest");
        String title = "Paparounas";
        String text = "wqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwe";
        String destPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Makis"+fSeparator+"Texts"+fSeparator;
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.createFile(title, text, destPath);
        instance.createFile(title, text, destPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateFile2() {
        System.out.println("createFileWithoutTitleWithTextToExistingDest");
        String title = "";
        String text = "wqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwe";
        String destPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Makis"+fSeparator+"Texts"+fSeparator;
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.createFile(title, text, destPath);
        instance.createFile(title, text, destPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateFile3() {
        System.out.println("createFileWithNullTitleWithTextToExistingDest");
        String title = null;
        String text = "wqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwe";
        String destPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Makis"+fSeparator+"Texts"+fSeparator;
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.createFile(title, text, destPath);
        instance.createFile(title, text, destPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateFile4() {
        System.out.println("createFileWithNullTitleAndTextToExistingDest");
        String title = null;
        String text = null;
        String destPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Makis"+fSeparator+"Texts"+fSeparator;
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.createFile(title, text, destPath);
        instance.createFile(title, text, destPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateFile5() {
        System.out.println("createFileWithCurrentPathAsPath");
        String title = "qweqwe";
        String text = "qweqweqe";
        String destPath = System.getProperty("user.dir")+fSeparator;
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.createFile(title, text, destPath);
        instance.createFile(title, text, destPath);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteDirectory method, of class NewEntryController.
     */
    @Test
    public void testDeleteDirectory() {
        System.out.println("deleteDirectoryWithNullPath");
        File folder = null;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.deleteDirectory(folder);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteDirectory2() {
        System.out.println("deleteDirectoryWithExistandPath");
        File folder = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Makis");
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.deleteDirectory(folder);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteDirectory3() {
        System.out.println("deleteDirectoryWithNonPathVariable");
        File folder = new File("asdas");
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.deleteDirectory(folder);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteDirectory4() {
        System.out.println("deleteDirectoryWithNonExistantPath");
        File folder = new File("F:"+fSeparator+"adasdas"+fSeparator+"BLABLA"+fSeparator+"qweqweqw");
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.deleteDirectory(folder);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteDirectory5() {
        System.out.println("deleteDirectoryWithExistantPathCreatedFromTests");
        File folder = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Mitsos");
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.deleteDirectory(folder);
        assertEquals(expResult, result);
    }
    @Test
    public void testDeleteDirectory6() {
        System.out.println("deleteDirectoryWithNonExistantPathCreatedFromTests");
        File folder = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Mitsos"+fSeparator);
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.deleteDirectory(folder);
        assertEquals(expResult, result);
    }
}
