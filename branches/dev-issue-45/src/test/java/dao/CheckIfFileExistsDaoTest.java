/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import controller.NewEntryController;
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
public class CheckIfFileExistsDaoTest {
    private String fSeparator = File.separator;
    public CheckIfFileExistsDaoTest() {
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
            Logger.getLogger(CheckIfFileExistsDaoTest.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CheckIfFileExistsDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of filePathExists method, of class CheckIfFileExistsDao.
     */
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
    
}
