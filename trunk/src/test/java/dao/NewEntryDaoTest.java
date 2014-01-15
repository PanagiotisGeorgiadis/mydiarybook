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
public class NewEntryDaoTest {
    static String fSeparator = File.separator;
    public NewEntryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
        try {
            File testFile = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator);
            FileUtils.deleteDirectory(testFile);
        } catch (IOException ex) {
            Logger.getLogger(NewEntryDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Before
    public void setUp() {
        File newEntry = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator
            +"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"testEntry");
        newEntry.mkdirs();
        Login.username = "Panagiwtis Georgiadis";
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of deleteEntry method, of class NewEntryDao.
     */
    @Test
    public void testDeleteEntry() {
        System.out.println("deleteEntry From existing Entry");
        String entryTitle = "testEntry";
        NewEntryDao instance = new NewEntryDao();
        boolean expResult = true;
        boolean result = instance.deleteEntry(entryTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteEntry2() {
        System.out.println("deleteEntry From non existant Entry");
        String entryTitle = "testEntry2";
        NewEntryDao instance = new NewEntryDao();
        boolean expResult = false;
        boolean result = instance.deleteEntry(entryTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteEntry3() {
        System.out.println("deleteEntry from null Entry Title");
        String entryTitle = null;
        NewEntryDao instance = new NewEntryDao();
        boolean expResult = false;
        boolean result = instance.deleteEntry(entryTitle);
        assertEquals(expResult, result);
    }    
}
