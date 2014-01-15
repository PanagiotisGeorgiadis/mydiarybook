/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Login;
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
public class NewEntryTextDaoTest {
    static String fSeparator = File.separator;
    public NewEntryTextDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook");
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException ex) {
            Logger.getLogger(NewEntryTextDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Before
    public void setUp() {
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"
            +fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries"
            +fSeparator+"Texnologia2");
        file.mkdirs();
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"
            +fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries"
            +fSeparator+"testEntry");
        file.mkdirs();
        File emptyfile = new File(file+fSeparator+"testEntry.txt");
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"
            +fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries"
            +fSeparator+"testEntry2");
        file.mkdirs();
        File textFile = new File(file+fSeparator+"Texts"+fSeparator+"testEntry2.txt");
        try {
            FileUtils.write(textFile, "2014", false);
        } catch (IOException ex) {
            Logger.getLogger(NewEntryTextDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+
                "Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"testEntry"+fSeparator+"Texts");
        file.mkdirs();
        Login.username = "Panagiwtis Georgiadis";
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createTextFile method, of class NewEntryTextDao.
     */
    @Test
    public void testCreateTextFile() {
        System.out.println("createTextFile with valid entryTitle and userText");
        String entryTitle = "Texnologia2";
        String userText = "qweqweqweqeqeqewqewqeqweqeeee";
        NewEntryTextDao instance = new NewEntryTextDao();
        boolean expResult = true;
        boolean result = instance.createTextFile(entryTitle, userText);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateTextFile2() {
        System.out.println("createTextFile with null entryTitle and valid userText");
        String entryTitle = null;
        String userText = "qweqweqweqeqeqewqewqeqweqeeee";
        NewEntryTextDao instance = new NewEntryTextDao();
        boolean expResult = false;
        boolean result = instance.createTextFile(entryTitle, userText);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateTextFile3() {
        System.out.println("createTextFile with null entryTitle and null userText");
        String entryTitle = null;
        String userText = null;
        NewEntryTextDao instance = new NewEntryTextDao();
        boolean expResult = false;
        boolean result = instance.createTextFile(entryTitle, userText);
        assertEquals(expResult, result);
    }

    @Test
    public void testCreateTextFile4() {
        System.out.println("createTextFile with valid entryTitle and null userText");
        String entryTitle = "Texnologia2";
        String userText = "";
        NewEntryTextDao instance = new NewEntryTextDao();
        boolean expResult = true;
        boolean result = instance.createTextFile(entryTitle, userText);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateTextFile5() {
        System.out.println("createTextFile with valid entryTitle but non existant entry and valid userText");
        String entryTitle = "Texnologia2014";
        String userText = "2014";
        NewEntryTextDao instance = new NewEntryTextDao();
        boolean expResult = true;
        boolean result = instance.createTextFile(entryTitle, userText);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of returnTextFromTextFile method, of class NewEntryTextDao.
     */
    @Test
    public void testReturnTextFromTextFile() {
        System.out.println("returnTextFromTextFile from existant text file with text");
        String entryTitle = "testEntry2";
        NewEntryTextDao instance = new NewEntryTextDao();
        String expResult = "2014";
        String result = instance.returnTextFromTextFile(entryTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReturnTextFromTextFile2() {
        System.out.println("returnTextFromTextFile from existant text file with null text");
        String entryTitle = "testEntry";
        NewEntryTextDao instance = new NewEntryTextDao();
        String expResult = "";
        String result = instance.returnTextFromTextFile(entryTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReturnTextFromTextFile3() {
        System.out.println("returnTextFromTextFile from non existant entry");
        String entryTitle = "Non-Existant-Entry";
        NewEntryTextDao instance = new NewEntryTextDao();
        String expResult = "";
        String result = instance.returnTextFromTextFile(entryTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReturnTextFromTextFile4() {
        System.out.println("returnTextFromTextFile from non valid entry title");
        String entryTitle = ":::::qweqw::::";
        NewEntryTextDao instance = new NewEntryTextDao();
        String expResult = "";
        String result = instance.returnTextFromTextFile(entryTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReturnTextFromTextFile5() {
        System.out.println("returnTextFromTextFile from null entryTitle");
        String entryTitle = null;
        NewEntryTextDao instance = new NewEntryTextDao();
        String expResult = "";
        String result = instance.returnTextFromTextFile(entryTitle);
        assertEquals(expResult, result);
    }

    /**
     * Test of returnTextFilePath method, of class NewEntryTextDao.
     */
    @Test
    public void testReturnTextFilePath() {
        System.out.println("returnTextFilePath from existant Entry");
        String entryTitle = "testEntry";
        String userName = "Panagiwtis Georgiadis";
        NewEntryTextDao instance = new NewEntryTextDao();
        String expResult = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+
                userName+fSeparator+"Entries"+fSeparator+entryTitle+fSeparator+"Texts";
        String result = instance.returnTextFilePath(entryTitle, userName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReturnTextFilePath2() {
        System.out.println("returnTextFilePath with valid username and non existant entry");
        String entryTitle = "NonExistantEntry";
        String userName = "Panagiwtis Georgiadis";
        NewEntryTextDao instance = new NewEntryTextDao();
        String expResult = null;
        String result = instance.returnTextFilePath(entryTitle, userName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReturnTextFilePath3() {
        System.out.println("returnTextFilePath with non existant username but existant entry with different username");
        String entryTitle = "testEntry";
        String userName = "NonExistantUser";
        NewEntryTextDao instance = new NewEntryTextDao();
        String expResult = null;
        String result = instance.returnTextFilePath(entryTitle, userName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testReturnTextFilePath4() {
        System.out.println("returnTextFilePath with null username and null entry");
        String entryTitle = null;
        String userName = null;
        NewEntryTextDao instance = new NewEntryTextDao();
        String expResult = null;
        String result = instance.returnTextFilePath(entryTitle, userName);
        assertEquals(expResult, result);
    }
}
