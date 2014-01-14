/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.INewEntryMockDefaultPath;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import model.Entry;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

/**
 *
 * @author JohnN'y
 */
public class DeleteImageControllerTest {

    List<URI> pathListURI = new ArrayList();
    URI pathURI;
    String path = System.getProperty("user.dir") + File.separator + "MyDiaryBook" + File.separator + "Users" + File.separator + "Panagiwtis Georgiadis" + File.separator + "Entries" + File.separator
            + "Allo_ena_test" + File.separator + "Images" + File.separator + "image.txt";
    String image = "image.txt";
    String entryTitle = "Allo_ena_test";
    String imageEntry = path.toString() + image;

      
    public DeleteImageControllerTest() throws URISyntaxException {
       
       

               
    }

    @BeforeClass
    public static void setUpClass() throws IOException {

        String home = System.getProperty("user.dir") + File.separator + "MyDiaryBook" + File.separator + "Users" + File.separator + "Panagiwtis Georgiadis" + File.separator + "Entries" + File.separator
                + "Allo_ena_test" + File.separator + "Images";

        File homeFile = new File(home);
        homeFile.mkdirs();

        String pathChoice = home + File.separator + "image.txt";
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

        String home = System.getProperty("user.dir") + File.separator + "MyDiaryBook" + File.separator + "Users" + File.separator + "Panagiwtis Georgiadis" + File.separator + "Entries" + File.separator
                + "Allo_ena_test" + File.separator + "Images";

        File homeFile = new File(home);
        homeFile.mkdirs();

        String pathChoice = home + File.separator + "image.txt";
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
     * Test of deleteAElementFromImageList method, of class
     * DeleteImageController.
     */
    @Test
    public void testDeleteAElementFromImageList() {
        System.out.println("deleteAElementFromImageList");
 
        String imageName = image;
        DeleteImageController instance = new DeleteImageController();
        boolean expResult = true;
        boolean result = instance.deleteAElementFromImageList(entryTitle, imageName);
        assertEquals(expResult, result);

    }
    
     @Test
    public void testFailDeleteAElementFromImageList() {
        System.out.println("FailureDeleteAElementFromImageList");
        
        String imageName = "fail";
        DeleteImageController instance = new DeleteImageController();//mockEntry);
        boolean expResult = false;
        boolean result = instance.deleteAElementFromImageList(entryTitle,imageName);
        assertEquals(expResult, result);

    }

    /**
     * Test of deleteImageAlbum method, of class DeleteImageController.
     */
    @Test
    public void testFailDeleteImageAlbum() {
        System.out.println("FailureDeleteImageAlbum");
        String imagePath = "fail";
        DeleteImageController instance = new DeleteImageController();//mockEntry);
        boolean expResult =false;
        boolean result = instance.deleteImageAlbum(imagePath);
 
    }

    
    @Test
    public void testDeleteImageAlbum() {
        System.out.println("deleteImageAlbum");
        String imagePath = entryTitle;
        DeleteImageController instance = new DeleteImageController();//mockEntry);
        boolean expResult = true;
        boolean result = instance.deleteImageAlbum(imagePath);
    }

    /**
     * Test of showNoFileFound method, of class DeleteImageController.
     */
    @Test
    public void testShowNoFileFound() {
        System.out.println("showNoFileFound");
        DeleteImageController instance = new DeleteImageController();//mockEntry);
        String expResult = "There is not such a file";
        String result = instance.showNoFileFound();
        assertEquals(expResult, result);

    }

    /**
     * Test of showError method, of class DeleteImageController.
     */
    @Test
    public void testShowError() {
        System.out.println("showError");
        DeleteImageController instance = new DeleteImageController();//mockEntry);
        String expResult = "There was  a undefinied error";
        String result = instance.showError();
        assertEquals(expResult, result);

    }

    /**
     * Test of showSuccess method, of class DeleteImageController.
     */
    @Test
    public void testShowSuccess() {
        System.out.println("showSuccess");
        DeleteImageController instance = new DeleteImageController();//mockEntry);
        String expResult = "Successful Erase";
        String result = instance.showSuccess();
        assertEquals(expResult, result);

    }

}
