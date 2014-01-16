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
public class NewEntryDeleteControllerTest {
    static String fSeparator = File.separator;    
    public NewEntryDeleteControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
                +fSeparator+"Entries"+fSeparator+"Entry1");
        file.mkdirs();
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
                +fSeparator+"Entries"+fSeparator+"Entry2");
        file.mkdirs();
        File imageFile = new File(System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+"java"+fSeparator+"resources"
                +fSeparator+"testImg.jpg");
        try {
            FileUtils.copyFileToDirectory(imageFile, file);
        } catch (IOException ex) {
            Logger.getLogger(NewEntryDeleteControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook");
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException ex) {
            Logger.getLogger(NewEntryDeleteControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Before
    public void setUp() {
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
                +fSeparator+"Entries"+fSeparator+"Entry1");
        file.mkdirs();
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
                +fSeparator+"Entries"+fSeparator+"Entry2"+fSeparator+"Images");
        file.mkdirs();
        File imageFile = new File(System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+"java"+fSeparator+"resources"
                +fSeparator+"testImg.jpg");
        try {
            FileUtils.copyFileToDirectory(imageFile, file);
        } catch (IOException ex) {
            Logger.getLogger(NewEntryDeleteControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        Login.username = "Panagiwtis Georgiadis";
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of deleteDirectory method, of class NewEntryDeleteController.
     */
    @Test
    public void testDeleteDirectory() {
        System.out.println("deleteDirectory With Null entryTitle");
        String entryTitle = null;
        NewEntryDeleteController instance = new NewEntryDeleteController();
        boolean expResult = false;
        boolean result = instance.deleteDirectory(entryTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteDirectory2() {
        System.out.println("deleteDirectory that is an existing entryTitle of an empty Entry");
        String entryTitle = "Entry1";
        NewEntryDeleteController instance = new NewEntryDeleteController();
        boolean expResult = true;
        boolean result = instance.deleteDirectory(entryTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteDirectory3() {
        System.out.println("deleteDirectory that is an existing entryTitle containing an image");
        String entryTitle = "Entry2";
        NewEntryDeleteController instance = new NewEntryDeleteController();
        boolean expResult = true;
        boolean result = instance.deleteDirectory(entryTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteDirectory4() {
        System.out.println("deleteDirectory that is a non existant Entry");
        String entryTitle = "NonExistantEntry";
        NewEntryDeleteController instance = new NewEntryDeleteController();
        boolean expResult = false;
        boolean result = instance.deleteDirectory(entryTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDeleteDirectory5() {
        System.out.println("deleteDirectory non valid Entry Name");
        String entryTitle = "Non-Existant-Entry";
        NewEntryDeleteController instance = new NewEntryDeleteController();
        boolean expResult = false;
        boolean result = instance.deleteDirectory(entryTitle);
        assertEquals(expResult, result);
    }
}
