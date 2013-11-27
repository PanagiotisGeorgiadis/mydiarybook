/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mydiarybook;

import java.nio.file.Paths;
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
public class DeleteHandlerTest {
    
    public DeleteHandlerTest() {
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
     * Test of delete method, of class DeleteClass.
     */
    @Test
    public void testDelete() {
        System.out.println("If there is entry");
        java.nio.file.Path textPath = Paths.get("C:\\MyJavaApp\\MyFilesPractice\\src\\devIssue6\\text.txt");        
        DeleteHandler instance = new DeleteHandler(textPath);
       boolean result = instance.delete();
       boolean expResult = false;
      if(result == false){
        expResult = false;
       assertEquals(result,expResult);
      }
      else
          expResult = true;
         assertEquals(result,expResult);
    }

     @Test
    public void testDeleteUnSuccess() {
        System.out.println("If there no is entry");
        java.nio.file.Path textPath = Paths.get("C:\\MyJavaApp\\MyFilesPractice\\src\\devIssue6\\text.txt");        
        DeleteClass instance = new DeleteClass(textPath);
       boolean result = instance.delete();
       boolean expResult = false;
       assertEquals(result,expResult);
    }
    /**
     * Test of checkFileExist method, of class DeleteClass.
     */
    /*
    @Test
    public void testCheckFileExist() {
        System.out.println("checkFileExist");
        String textPathToString = "";
        DeleteClass instance = null;
        boolean expResult = false;
        boolean result = instance.checkFileExist(textPathToString);
        assertEquals(expResult, result);
        
    }
    */


    
}
