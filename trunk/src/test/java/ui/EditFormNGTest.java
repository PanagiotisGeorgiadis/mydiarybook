/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import static org.junit.Assert.assertEquals;

/**
 *
 * @author PTsilopoulos
 */
public class EditFormNGTest {
    
    public EditFormNGTest() {
    }

    @org.testng.annotations.BeforeClass
    public static void setUpClass() throws Exception {
    }

    @org.testng.annotations.AfterClass
    public static void tearDownClass() throws Exception {
    }

    @org.testng.annotations.BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @org.testng.annotations.AfterMethod
    public void tearDownMethod() throws Exception {
    }

    /**
     * Test of displayEntry method, of class EditForm.
     */
    @org.testng.annotations.Test
    public void testDisplayEntry() {
        System.out.println("displayEntry");
        String entry = "This is a test string.";
        EditForm instance = new EditForm();
        String expResult = "This is a test string.";
        String result = instance.displayEntry(entry);
        assertEquals(result, expResult); 
    }

    /**
     * Test of main method, of class EditForm.
     */
    @org.testng.annotations.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        EditForm.main(args);     
    }
}
