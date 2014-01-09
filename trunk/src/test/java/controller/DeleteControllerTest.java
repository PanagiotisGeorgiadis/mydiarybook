/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import dao.MockFileExist;
import dao.MockFileNoExist;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    public static void setUpClass() throws IOException {
        
     Path path = Paths.get(System.getProperty("user.dir") +File.separator +"Text" +File.separator);
        Path path1;
        File file = new File(path.toString());
        file.mkdirs();
        path1 = Paths.get(path + File.separator+"text.txt");
        file = new File(path1.toString());
       
        path = Paths.get(path + File.separator+"text1.txt");
        file = new File(path1.toString());
    }

    @AfterClass
    public static void tearDownClass() {
        
    }

    @Before
    public void setUp()  {        
        File file = new File("."+File.separator+"Text"+File.separator);
        file.mkdir();
    }

    @After
    public void tearDown() {
        Path path = Paths.get(System.getProperty("user.dir")+File.separator+"Text"+File.separator);
        try {
            Files.deleteIfExists(path);
        } catch (IOException ex) {
            Logger.getLogger(DeleteControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of checkFileExistance method, of class DeleteController.
     */
    @Test
    public void testSuccessfulCheckFileExistance() {
        System.out.
                println("Success CheckFileExistance");
        //File fileText = new File(System.getProperty("user.dir")+"\\Text");
        File fileText = new File("."+ File.separator + "Text"+File.separator);
        DeleteController instance = new DeleteController(new MockFileExist());
        boolean expResult = true;
        boolean result = instance.checkFileExistance(fileText);
        assertEquals(expResult, result);
    }
    
      @Test
    public void testFailCheckFileExistance() {
        System.out.println("Fail CheckFileExistance");
        File fileText = new File(System.getProperty("user.dir")+File.separator+"babis");
        DeleteController instance = new DeleteController(new MockFileNoExist());
        boolean expResult = false;
        boolean result = instance.checkFileExistance(fileText);
        assertEquals(expResult, result);
    }

    /**
     * Test of delete method, of class DeleteController.
     */
    @Test
    public void testSuccessDelete() {
        System.out.println("Successful delete");
        File fileText = new File(System.getProperty("user.dir")+File.separator+"Text");
        DeleteController instance = new DeleteController(new MockFileExist());
        boolean expResult = true;
        boolean result = instance.delete(fileText);
        assertEquals(expResult, result);
    }

        @Test
    public void testFailDelete() {
        System.out.println("Fail delete");
        File fileText = new File("babis");
        DeleteController instance = new DeleteController(new MockFileNoExist());
        boolean expResult = false;
        boolean result = instance.delete(fileText);
        assertEquals(expResult, result);
    }
    /**
     * Test of showNoFileFound method, of class DeleteController.
     */
    @Test
    public void testShowNoFileFound() {
        System.out.println("showNoFileFound");
        DeleteController instance = new DeleteController(new MockFileExist());
        String expResult = "There is not such a file";
        String result = instance.showNoFileFound();
        assertEquals(expResult, result);
    }

    /**
     * Test of showError method, of class DeleteController.
     */
    @Test
    public void testShowError() {
        System.out.println("showError");
        DeleteController instance = new DeleteController(new MockFileExist());
        String expResult = "There was  a undefinied error";
        String result = instance.showError();
        assertEquals(expResult, result);
    }

    /**
     * Test of showSuccess method, of class DeleteController.
     */
    @Test
    public void testShowSuccess() {
        System.out.println("showSuccess");
        DeleteController instance = new DeleteController(new MockFileExist());
        String expResult = "Successful Erase";
        String result = instance.showSuccess();
        assertEquals(expResult, result);
    }

}
