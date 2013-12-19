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
public class NewEntryDeleteControllerTest {
    private final String fSeparator = File.separator;    
    public NewEntryDeleteControllerTest() {
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
            Logger.getLogger(NewEntryDeleteControllerTest.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(NewEntryDeleteControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of deleteDirectory method, of class NewEntryDeleteController.
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
}
