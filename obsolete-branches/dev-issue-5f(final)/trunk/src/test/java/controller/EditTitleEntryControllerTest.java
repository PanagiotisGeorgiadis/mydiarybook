/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author PTsilopoulos
 */
public class EditTitleEntryControllerTest {
    
    public EditTitleEntryControllerTest() {
    }
    
    private final String fSeparator = File.separator;    
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
     * Test of editFileTitle method, of class EditTitleEntryController.
     */
    @Test
    public void testEditFileTitleFailure() {
        System.out.println("editFileTitleFailure");
        String FileTitle = "";
        EditTitleEntryController instance = new EditTitleEntryController();
        boolean expResult = false;
        boolean result = instance.editFileTitle(FileTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testEditFileTitleFailurePart2() {
        System.out.println("editFileTitleFailurePart2");
        String Brotacho = "MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
             +fSeparator+"Entries"+fSeparator+"Brotacho"+fSeparator+"Texts"+fSeparator;
        EditTitleEntryController instance = new EditTitleEntryController();
        boolean expResult = false;
        boolean result = instance.editFileTitle(Brotacho);
        assertEquals(expResult, result);
    }
}
