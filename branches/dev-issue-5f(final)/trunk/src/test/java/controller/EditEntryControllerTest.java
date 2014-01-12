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
public class EditEntryControllerTest {
    
    public EditEntryControllerTest() {
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
     * Test of checkEdit method, of class EditEntryController.
     */
    @Test
    public void testCheckEdit() {
        System.out.println("checkEdit");
        String textToEdit = "This is the test text!";
        EditEntryController instance = new EditEntryController();
        boolean expResult = true;
        boolean result = instance.checkEdit(textToEdit);
        assertEquals(expResult, result);
    }
    
    public void testCheckEditIsEmpty() {
        System.out.println("checkEditIsEmpty");
        String textToEdit = "";
        EditEntryController instance = new EditEntryController();
        boolean expResult = true;
        boolean result = instance.checkEdit(textToEdit);
        assertEquals(expResult, result);
    }
    
}
