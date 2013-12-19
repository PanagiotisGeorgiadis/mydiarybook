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
public class NewEntryTextControllerTest {
    private String fSeparator = File.separator;
    public NewEntryTextControllerTest() {
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
            Logger.getLogger(NewEntryTextControllerTest.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NewEntryTextControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of createTextFile method, of class NewEntryTextController.
     */
@Test
    public void testCreateTextFile() {
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
    public void testCreateTextFile2() {
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
    public void testCreateTextFile3() {
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
    public void testCreateTextFile4() {
        System.out.println("createFileWithNullTitleAndTextToExistingDest");
        String title = "";
        String text = "";
        String destPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Makis"+fSeparator+"Texts"+fSeparator;
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.createFile(title, text, destPath);
        instance.createFile(title, text, destPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateTextFile5() {
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
     * Test of returnTextFile method, of class NewEntryTextController.
     */
    //TODO Tests for return text file
//    @Test
//    public void testReturnTextFile() {
//        System.out.println("returnTextFile");
//        String entryTitle = "";
//        NewEntryTextController instance = new NewEntryTextController();
//        String expResult = "";
//        String result = instance.returnTextFile(entryTitle);
//        assertEquals(expResult, result);
//    }
    
}
