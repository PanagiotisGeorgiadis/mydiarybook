/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
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
public class DeleteTextControllerTest {
    
    String rightTextPath = System.getProperty("user.dir") + File.separator + "MyDiaryBook" + File.separator + "Users" + File.separator + "John" + File.separator + "Entries" + File.separator
            + "Allo_ena_test" + File.separator + "Texts";
    String failTextPath =System.getProperty("user.dir") + File.separator + "MyDiaryBook" + File.separator + "Users" + File.separator + "John" + File.separator + "Entries" + File.separator
            + "Fail_Test" + File.separator + "Texts";
    String rightTextName = "text";
    String failTextName = "fail";
    
    public DeleteTextControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        String home = System.getProperty("user.dir") + File.separator + "MyDiaryBook" + File.separator + "Users" + File.separator + "John" + File.separator + "Entries" + File.separator
                + "Allo_ena_test" + File.separator + "Texts";

        File homeFile = new File(home);
        homeFile.mkdirs();

        String pathChoice = home + File.separator + "text.txt";
        File fileChoice = new File(pathChoice);
    }
    
    @AfterClass
    public static void tearDownClass() {
        
        String home = System.getProperty("user.dir") + File.separator + "MyDiaryBook";
        File path = new File(home);
        try {
            FileUtils.deleteDirectory(path);
        } catch (IOException ex) {
   //         Logger.getLogger(DeleteControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Before
    public void setUp() throws IOException {
        String home = System.getProperty("user.dir") + File.separator + "MyDiaryBook" + File.separator + "Users" + File.separator + "John" + File.separator + "Entries" + File.separator
                + "Allo_ena_test" + File.separator + "Texts";

        File homeFile = new File(home);
        homeFile.mkdirs();

        String pathChoice = home + File.separator + "text.txt";
        File fileChoice = new File(pathChoice);
        fileChoice.createNewFile();

    }
    
    @After
    public void tearDown() {
        
        String home = System.getProperty("user.dir") + File.separator + "MyDiaryBook";
        File path = new File(home);
        try {
            FileUtils.deleteDirectory(path);
        } catch (IOException ex) {
   //         Logger.getLogger(DeleteControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of deleteAElementFromTextList method, of class DeleteTextController.
     */
    @Test
    public void testDeleteAElementFromTextList() {
        System.out.println("deleteAElementFromTextList");
        String textPath = rightTextPath;
        String textName = rightTextName;
        DeleteTextController instance = new DeleteTextController();
        boolean expResult = true;
        boolean result = instance.deleteAElementFromTextList(textPath, textName);
        assertEquals(expResult, result);
       
    }
    @Test
    public void testFailDeleteAElementFromTextList() {
        System.out.println("FailureDeleteAElementFromTextList");
        String textPath = rightTextPath;
        String textName = failTextName;
        DeleteTextController instance = new DeleteTextController();
        boolean expResult = false;
        boolean result = instance.deleteAElementFromTextList(textPath, textName);
        assertEquals(expResult, result);
       
    }

    /**
     * Test of deleteTextAlbum method, of class DeleteTextController.
     */
    @Test
    public void testDeleteTextAlbum() {
        System.out.println("deleteTextAlbum");
        String textPath = rightTextPath;
        DeleteTextController instance = new DeleteTextController();
        boolean expResult = true;
        boolean result = instance.deleteTextAlbum(textPath);
        assertEquals(expResult, result);
        
    }
    
     @Test
    public void testFailDeleteTextAlbum() {
        System.out.println("FailureDeleteTextAlbum");
        String textPath = failTextPath;
        DeleteTextController instance = new DeleteTextController();
        boolean expResult = false;
        boolean result = instance.deleteTextAlbum(textPath);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of showNoFileFound method, of class DeleteTextController.
     */
    @Test
    public void testShowNoFileFound() {
        System.out.println("showNoFileFound");
        DeleteTextController instance = new DeleteTextController();
        String expResult = "There is not such a file";
        String result = instance.showNoFileFound();
        assertEquals(expResult, result);
   
    }

    /**
     * Test of showError method, of class DeleteTextController.
     */
    @Test
    public void testShowError() {
        System.out.println("showError");
        DeleteTextController instance = new DeleteTextController();
        String expResult = "There was  a undefinied error";
        String result = instance.showError();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of showSuccess method, of class DeleteTextController.
     */
    @Test
    public void testShowSuccess() {
        System.out.println("showSuccess");
        DeleteTextController instance = new DeleteTextController();
        String expResult = "Successful Erase";
        String result = instance.showSuccess();
        assertEquals(expResult, result);
       
    }
    
}
