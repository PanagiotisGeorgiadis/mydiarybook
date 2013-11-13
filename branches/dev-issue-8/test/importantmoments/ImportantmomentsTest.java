/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package importantmoments;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kajou
 */
public class ImportantmomentsTest {
    
    public ImportantmomentsTest() {
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
     * Test of main method, of class momentsframe.
     */
    @Test
    public void testCheckLocation() {
        System.out.println("CheckLocation");
        Importantmoments instance = new Importantmoments();
        assertEquals(true,instance.CheckLocation("Athina"));
        assertEquals(false,instance.CheckLocation("1"));
    }
    
        public void testCheckTitle() {
        System.out.println("CheckTitle");
        Importantmoments instance = new Importantmoments();
        assertEquals(true,instance.CheckTitle("day 1"));
        assertEquals(false,instance.CheckTitle("a"));
    }
    
}
