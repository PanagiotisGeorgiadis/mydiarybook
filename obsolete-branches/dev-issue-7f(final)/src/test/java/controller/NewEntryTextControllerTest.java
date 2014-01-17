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
    static String fSeparator = File.separator;
    public NewEntryTextControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
   @AfterClass
    public static void tearDownClass() {  
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator);
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException ex) {
            Logger.getLogger(NewEntryTextControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @Before
    public void setUp() {
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator
                +"Entries"+fSeparator+"ExistingEntry"+fSeparator+"Texts");
        file.mkdirs();       
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createTextFile method, of class NewEntryTextController.
     */
@Test
    public void testCreateTextFile() {
        System.out.println("createFile to existing empty entry");
        String entryTitle = "ExistingEntry";
        String userText = "wqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqqeqwewqeqwe";
        
        NewEntryTextController instance = new NewEntryTextController();
        boolean expResult = true;
        boolean result = instance.createTextFile(entryTitle, userText);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateTextFile2() {
        System.out.println("createFile to null titled Entry but with text");
        String entryTitle = "";
        String userText = "wqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqqeqwewqeqwe";
        
        NewEntryTextController instance = new NewEntryTextController();
        boolean expResult = false;
        boolean result = instance.createTextFile(entryTitle, userText);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateTextFile3() {
        System.out.println("createFile with null text");
        String entryTitle = "Entry2";
        String userText = "";
        
        NewEntryTextController instance = new NewEntryTextController();
        boolean expResult = true;
        boolean result = instance.createTextFile(entryTitle, userText);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateTextFile4() {
        System.out.println("createFile with null title and text");
        String entryTitle = "";
        String userText = "";
        
        NewEntryTextController instance = new NewEntryTextController();
        boolean expResult = false;
        boolean result = instance.createTextFile(entryTitle, userText);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateTextFile5() {
        System.out.println("createFile with already existing entry title");
        String entryTitle = "ExistingEntry";
        String userText = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
        
        NewEntryTextController instance = new NewEntryTextController();
        boolean expResult = true;
        boolean result = instance.createTextFile(entryTitle, userText);
        assertEquals(expResult, result);
    }
    
}
