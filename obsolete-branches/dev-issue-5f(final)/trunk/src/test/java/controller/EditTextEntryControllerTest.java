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
 * @author user
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
     * Test of checkEdit method, of class EditTextEntryController.
     */
    @Test
    public void testCheckEditWorks() {
        System.out.println("checkEditWorksAsIntended");
        String textToEdit = "This is the test text!";
        EditTextEntryController instance = new EditTextEntryController();
        boolean expResult = true;
        boolean result = instance.checkEdit(textToEdit);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckEditIsEmpty() {
        System.out.println("checkEditIsEmpty");
        String textToEdit = "";
        EditTextEntryController instance = new EditTextEntryController();
        boolean expResult = false;
        boolean result = instance.checkEdit(textToEdit);
        assertEquals(expResult, result);
    }
    
     /**
     * Test of editTestEntry method, of class EditTextEntryController.
     */
    
     @Test
    public void editTestEntry() {
        System.out.println("EditTestEntry");
        String textToEdit = "This is the test text!";
        EditTextEntryController instance = new EditTextEntryController();
        String expResult = "";
        String result;
        result = instance.editTextEntry(textToEdit);
        assertEquals(expResult, result);
    }
}