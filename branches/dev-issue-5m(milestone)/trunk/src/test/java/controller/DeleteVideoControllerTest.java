/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.File;
import java.io.IOException;
import model.Login;
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
public class DeleteVideoControllerTest {
    String rightTextPath = System.getProperty("user.dir") + File.separator + "MyDiaryBook" + File.separator + "Users" + File.separator + "John" + File.separator + "Entries" + File.separator
            + "Allo_ena_test" + File.separator + "Videos" + File.separator + "text.txt";
    String failTextPath =System.getProperty("user.dir") + File.separator + "MyDiaryBook" + File.separator + "Users" + File.separator + "John" + File.separator + "Entries" + File.separator
            + "Fail_Test" + File.separator + "Videos";
    
    File rightFile = new File(rightTextPath);
    File failFile = new File(failTextPath);
    
    public DeleteVideoControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        
    }
    
    @Before
    public void setUp() throws IOException {
         String home = System.getProperty("user.dir") + File.separator + "MyDiaryBook" + File.separator + "Users" + File.separator + "John" + File.separator + "Entries" + File.separator
                + "Allo_ena_test" + File.separator + "Videos";

        File homeFile = new File(home);
        homeFile.mkdirs();

        String pathChoice = home + File.separator + "text.txt";
        File fileChoice = new File(pathChoice);
         fileChoice.createNewFile();
         Login.username = "John";
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
     * Test of deleteVideoAlbum method, of class DeleteVideoController.
     */
    @Test
    public void testDeleteVideoAlbum() {
        System.out.println("deleteVideoAlbum");
        File videoFile = rightFile;
        DeleteVideoController instance = new DeleteVideoController();
        boolean expResult = true;
        boolean result = instance.deleteVideoAlbum(videoFile);
        assertEquals(expResult, result);

    }
    
        @Test
    public void testFailDeleteVideoAlbum() {
        System.out.println("FailureDeleteVideoAlbum");
        File videoFile = failFile;
        DeleteVideoController instance = new DeleteVideoController();
        boolean expResult = false;
        boolean result = instance.deleteVideoAlbum(videoFile);
        assertEquals(expResult, result);

    }

    /**
     * Test of showNoFileFound method, of class DeleteVideoController.
     */
    @Test
    public void testShowNoFileFound() {
        System.out.println("showNoFileFound");
        DeleteVideoController instance = new DeleteVideoController();
        String expResult = "There is not such a file";
        String result = instance.showNoFileFound();
        assertEquals(expResult, result);
 
    }

    /**
     * Test of showError method, of class DeleteVideoController.
     */
    @Test
    public void testShowError() {
        System.out.println("showError");
        DeleteVideoController instance = new DeleteVideoController();
        String expResult = "There was  a undefinied error";
        String result = instance.showError();
        assertEquals(expResult, result);
 
    }

    /**
     * Test of showSuccess method, of class DeleteVideoController.
     */
    @Test
    public void testShowSuccess() {
        System.out.println("showSuccess");
        DeleteVideoController instance = new DeleteVideoController();
        String expResult = "Successful Erase";
        String result = instance.showSuccess();
        assertEquals(expResult, result);

    }
    
}
