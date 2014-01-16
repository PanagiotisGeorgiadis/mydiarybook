/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Enlightened
 */
public class EditTextEntryControllerTest {
    
    public EditTextEntryControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Tests of writeStringToFile method, of class EditTextEntryController.
     */
    @Test
    public void testWriteStringToFile1() {
        System.out.println("writeStringToFile");
        String EntryTitle = "";
        String Data = "";
        EditTextEntryController instance = new EditTextEntryController();
        instance.writeStringToFile(EntryTitle, Data);
    }

    @Test
    public void testWriteStringToFile2() {
        System.out.println("nullEntryTitle");
        String EntryTitle = null;
        String Data = "";
        EditTextEntryController instance = new EditTextEntryController();
        instance.writeStringToFile(EntryTitle, Data);
    }
    
    @Test
    public void testWriteStringToFile3() {
        System.out.println("nullDataEntry");
        String EntryTitle = "";
        String Data = null;
        EditTextEntryController instance = new EditTextEntryController();
        instance.writeStringToFile(EntryTitle, Data);  
    }
    
    /**
     * Tests of checkEdit method, of class EditTextEntryController.
     */
    @Test
    public void testCheckEdit1() {
        System.out.println("checkEdit");
        String textToEdit = "";
        EditTextEntryController instance = new EditTextEntryController();
        boolean expResult = false;
        boolean result = instance.checkEdit(textToEdit);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckEdit2() {
        System.out.println("TextIsProper");
        String textToEdit = "Brotachos";
        EditTextEntryController instance = new EditTextEntryController();
        boolean expResult = true;
        boolean result = instance.checkEdit(textToEdit);
        assertEquals(expResult, result);
    }
}
