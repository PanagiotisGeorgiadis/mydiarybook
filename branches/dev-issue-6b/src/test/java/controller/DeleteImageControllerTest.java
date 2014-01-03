/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

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
public class DeleteImageControllerTest {
    
    public DeleteImageControllerTest() {
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
                                        "allo_ena_test" + File.separator + "Images" + File.separator );
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
        Path path = Paths.get(System.getProperty("user.dir") + File.separator + "MyDiaryBook" + File.separator + "Users"+ File.separator + "John" + File.separator + "Entries" + File.separator + 
                                         "allo_ena_test" + File.separator  + "Images");
        try {
            Files.deleteIfExists(path);
        } catch (IOException ex) {
//            Logger.getLogger(DeleteControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of deleteAElementFromImageList method, of class DeleteImageController.
     */
    @Test
    public void testDeleteAElementFromList() {
        System.out.println("deleteAElementFromList");
        String username = "John";
        String entrytitle = "allo_ena_test";
        String imageName = "image.txt";
        DeleteImageController instance = new DeleteImageController();
        boolean expResult = true;
        boolean result = instance.deleteAElementFromImageList(username, entrytitle, imageName);
        assertEquals(expResult, result);
      
    }

    
       @Test
    public void testUnfoundDeleteAElementFromList() {
        System.out.println("Den bre8ike tpt");
        String username = "John";
        String entrytitle = "fail";
        String imageName = "fail";
        DeleteImageController instance = new DeleteImageController();
        boolean expResult = false;
        boolean result = instance.deleteAElementFromImageList(username, entrytitle, imageName);
        assertEquals(expResult, result);
      
    }
    /**
     * Test of deleteImageAlbum method, of class DeleteImageController.
     */
    @Test
    public void testDeleteImageAlbum() {
        System.out.println("deleteImageAlbum");
        String username = "John";
        String entrytitle = "allo_ena_test";
        DeleteImageController instance = new DeleteImageController();
        boolean expResult = true;
        boolean result = instance.deleteImageAlbum(username, entrytitle);
        assertEquals(expResult, result);
       
    }
    
      @Test
    public void testFailDeleteImageAlbum() {
        System.out.println("FaildeleteImageAlbum");
        String username = "John";
        String entrytitle = "fail";
        DeleteImageController instance = new DeleteImageController();
        boolean expResult = false;
        boolean result = instance.deleteImageAlbum(username, entrytitle);
        assertEquals(expResult, result);
       
    }
    
}
