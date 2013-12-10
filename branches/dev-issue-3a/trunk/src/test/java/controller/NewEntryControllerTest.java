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
 * @author Zarc
 */
public class NewEntryControllerTest {
    
    public NewEntryControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        String fSeparator = System.getProperty("file.separator");
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Makis");
        file.mkdir();
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Mitsos"+fSeparator);
        file.mkdir();
        file = new File("."+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"PAOK"+fSeparator);
        File file2 = new File(file+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"PAOK"+fSeparator);
        file.mkdir();
    }
    
    @AfterClass
    public static void tearDownClass() {
        String fSeparator = System.getProperty("file.separator");
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Makis");
        file.delete();
        file = new File("."+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"PAOK"+fSeparator);
        file.delete();
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
        String title = "F:\\BLABLA\\BLABLA\\BLABLA";
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.filePathExists(title);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFilePathExists2() {
        System.out.println("filePathExistsWithExistantEntry");
        String title = "PAOK";
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.filePathExists(title);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFilePathExists3() {
        System.out.println("filePathExistsWithNonExistantEntry");
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
        System.out.println("copyImage");
        String sourcePath = System.getProperty("user.dir")+"\\src\\test\\java\\resources\\testImg.jpg";
        String destPath = System.getProperty("user.dir")+"\\MyDiaryBook\\Mitsos\\Images\\";
        int imageNumber = 0;
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage3() {
        System.out.println("copyImage3");
        String sourcePath = "C:jpg";
        String destPath = System.getProperty("user.dir")+"\\MyDiaryBook\\Makis\\Images\\";
        int imageNumber = 2;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage4() {
        System.out.println("copyImage4");
        String sourcePath = "F:\\Bla\\Blabla\\Blablabla";
        String destPath = System.getProperty("user.dir")+"\\MyDiaryBook\\Makis\\Images\\";
        int imageNumber = 3;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage5() {
        System.out.println("copyImage5");
        String sourcePath = System.getProperty("user.dir")+"\\src\\test\\java\\resources\\testImg.jpg";
        String destPath = System.getProperty("user.dir")+"\\MyDiaryBook\\Makis\\Images\\";
        int imageNumber = 3;
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage6() {
        System.out.println("copyImage5");
        String sourcePath = System.getProperty("user.dir")+"\\src\\test\\java\\resources\\testImg.jpg";
        String destPath = System.getProperty("user.dir")+"\\MyDiaryBook\\Makis\\Images\\";
        int imageNumber = 3;
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
        assertEquals(expResult, result);
    }
    /**
     * Test of copyVideo method, of class NewEntryController.
     */
    @Test
    public void testCopyVideo() {
        System.out.println("copyVideo");
        String sourcePath = System.getProperty("user.dir")+"\\src\\test\\java\\resources\\testVideo.mp4";
        String videoDestPath = System.getProperty("user.dir")+"\\MyDiaryBook\\Makis\\Videos\\";
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.copyVideo(sourcePath, videoDestPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyVideo2() {
        System.out.println("copyVideo5");
        String sourcePath = null;
        String videoDestPath = null;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyVideo(sourcePath, videoDestPath);
        assertEquals(expResult, result);
        }
        
    @Test
    public void testCopyVideo3() {
        System.out.println("copyVideo3");
        String sourcePath = "C:\\Users\\Zarc\\Documents\\First Of the year";
        String videoDestPath = System.getProperty("user.dir")+"\\MyDiaryBook\\Mitsos\\";
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyVideo(sourcePath, videoDestPath);
        assertEquals(expResult, result);
    }
            
    @Test
    public void testCopyVideo4() {
        System.out.println("copyVideo4");
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
        System.out.println("createFile");
        String title = "Paparounas";
        String text = "wqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwe";
        String destPath = System.getProperty("user.dir")+"\\MyDiaryBook\\Makis\\Texts\\";
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.createFile(title, text, destPath);
        instance.createFile(title, text, destPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateFile2() {
        System.out.println("createFile2");
        String title = "";
        String text = "wqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwe";
        String destPath = System.getProperty("user.dir")+"\\MyDiaryBook\\Makis\\Texts\\";
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.createFile(title, text, destPath);
        instance.createFile(title, text, destPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateFile3() {
        System.out.println("createFile3");
        String title = null;
        String text = "wqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwe";
        String destPath = System.getProperty("user.dir")+"\\MyDiaryBook\\Makis\\Texts\\";
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.createFile(title, text, destPath);
        instance.createFile(title, text, destPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateFile4() {
        System.out.println("createFile4");
        String title = null;
        String text = null;
        String destPath = System.getProperty("user.dir")+"\\MyDiaryBook\\Makis\\Texts\\";
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.createFile(title, text, destPath);
        instance.createFile(title, text, destPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateFile5() {
        System.out.println("createFile5");
        String title = "";
        String text = "";
        String destPath = System.getProperty("user.dir")+"\\MyDiaryBook\\Makis\\Texts\\";
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
        File folder = new File(System.getProperty("user.dir")+"\\MyDiaryBook\\Makis");
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
        File folder = new File("F:\\adasdas\\BLABLA\\qweqweqw");
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.deleteDirectory(folder);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteDirectory5() {
        System.out.println("deleteDirectoryWithExistantPathCreatedFromTests");
        File folder = new File(System.getProperty("user.dir")+"\\MyDiaryBook\\Mitsos");
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.deleteDirectory(folder);
        assertEquals(expResult, result);
    }
    @Test
    public void testDeleteDirectory6() {
        System.out.println("deleteDirectoryWithNonExistantPathCreatedFromTests");
        File folder = new File(System.getProperty("user.dir")+"\\MyDiaryBook\\Mitsos\\");
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.deleteDirectory(folder);
        assertEquals(expResult, result);
    }
}
