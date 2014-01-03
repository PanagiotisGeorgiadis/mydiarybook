/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
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
public class DeleteTextControllerTest {
    
    public DeleteTextControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws IOException {
        Path home = Paths.get(System.getProperty("user.dir") + File.separator +"MyDiaryBook" + File.separator + "Users" + File.separator + "John" + File.separator + "Entries" +  File.separator +  
                                        "allo_ena_test" + File.separator + "Text" + File.separator );
        File homeFile = new File(home.toString());
        homeFile.mkdir();
        Path path = Paths.get(home + File.separator + "image.txt");
        Path otherpath = Paths.get(home + File.separator + "image2.txt");
        File newFile = new File(path.toString());
        newFile.createNewFile();
        File otherFile = new File(otherpath.toString());
        otherFile.createNewFile();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of deleteAElementFromTextList method, of class DeleteTextController.
     */
    @Test
    public void testDeleteAElementFromTextList() {
        System.out.println("deleteAElementFromTextList");
        String username = "John";
        String entrytitle = "allo_ena_test";
        String textName = "image.txt";
        DeleteTextController instance = new DeleteTextController();
        boolean expResult = true;
        boolean result = instance.deleteAElementFromTextList(username, entrytitle, textName);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFaiDeleteAElementFromTextList() {
        System.out.println("FailureDeleteAElementFromTextList");
        String username = "John";
        String entrytitle = "allo_ena_test";
        String textName = "fail";
        DeleteTextController instance = new DeleteTextController();
        boolean expResult = false;
        boolean result = instance.deleteAElementFromTextList(username, entrytitle, textName);
        assertEquals(expResult, result);
    }

    /**
     * Test of deleteTextAlbum method, of class DeleteTextController.
     */
    @Test
    public void testDeleteTextAlbum() {
        System.out.println("deleteTextAlbum");
        String username = "John";
        String entrytitle = "allo_ena_test";
        DeleteTextController instance = new DeleteTextController();
        boolean expResult = true;
        boolean result = instance.deleteTextAlbum(username, entrytitle);
        assertEquals(expResult, result);
    }
    
     @Test
    public void testFailDeleteTextAlbum() {
        System.out.println("FailureDeleteTextAlbum");
        String username = "John";
        String entrytitle = "fail";
        DeleteTextController instance = new DeleteTextController();
        boolean expResult = false;
        boolean result = instance.deleteTextAlbum(username, entrytitle);
        assertEquals(expResult, result);
    }
    
}
