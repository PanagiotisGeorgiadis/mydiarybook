/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.MockFileExist;
import dao.MockFileNoExist;
import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author JohnN'y
 */
public class DeleteControllerTest {
    
    public DeleteControllerTest() {
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
     * Test of checkMockFileExistance method, of class DeleteController.
     */
    @Test
    public void testCheckFileExistance() {
        System.out.println("checkFileExistance");
        File fileText = new File("C:\\MyJavaApp\\dev-issu-6\\src\\Controller\\text.txt");
        DeleteController instance = new DeleteController(new MockFileExist());
        boolean expResult = true;
        boolean result = instance.checkFileExistance(fileText);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCheckFileNoExistance() {
        System.out.println("checkFileNoExistance");
        File fileText = new File("C:\\MyJavaApp\\dev-issu-6\\src\\Controller\\ktl.txt");
        DeleteController instance = new DeleteController(new MockFileNoExist());
        boolean expResult = false;
        boolean result = instance.checkFileExistance(fileText);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class DeleteController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        File fileText = new File("C:\\MyJavaApp\\dev-issu-6\\src\\Controller\\text.txt");
        DeleteController instance = new DeleteController(new MockFileExist());
        boolean expResult = true;
        boolean result = instance.delete(fileText);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of showNoFileFound method, of class DeleteController.
     */
    @Test
    public void testShowNoFileFound() {
        System.out.println("showNoFileFound");
        DeleteController instance = new DeleteController(new MockFileNoExist());
        String expResult = "There is not such a file";
        String result = instance.showNoFileFound();
        assertEquals(expResult, result);

    }
    
        @Test
    public void testDeleteFail() {
        System.out.println("deleteFail");
        File fileText = new File("");
        DeleteController instance = new DeleteController(new MockFileExist());
        boolean expResult = false;
        boolean result = instance.delete(fileText);
        assertEquals(expResult, result);
    }

    /**
     * Test of showError method, of class DeleteController.
     */
    @Test
    public void testShowError() {
        System.out.println("showError");
        DeleteController instance = new DeleteController();
        String expResult = "There was  a undefinied error";
        String result = instance.showError();
        assertEquals(expResult, result);
    }
    
}
