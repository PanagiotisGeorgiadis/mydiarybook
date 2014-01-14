/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class DeletePersonalGoalControllerTest {

    String home = System.getProperty("user.dir") + File.separator + "MyDiaryBook" + File.separator + "Users" + File.separator + "John" + File.separator + "PersonalGoal" + File.separator
            + "Allo_ena_test" + File.separator + "Texts" + File.separator + "Allo_ena_test";
    String path = home + File.separator + "TitleName.txt";
    File homeFile = new File(home);
    File testFile = new File(path);
    File rootFile = new File(System.getProperty("user.dir") + File.separator + "MyDiaryBook");

    public DeletePersonalGoalControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
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
        homeFile.mkdirs();
        testFile.createNewFile();

    }

    @After
    public void tearDown() {
        try {
            FileUtils.deleteDirectory(homeFile);
        } catch (IOException ex) {
            Logger.getLogger(DeletePersonalGoalControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of deleteElementFromList method, of class
     * DeletePersonalGoalController.
     */
    @Test
    public void testSuccessDeleteElementFromList() throws Exception {
        System.out.println("Successfull Erase");
        String userName = "John";
        String entryTitle = "Allo_ena_test";
        DeletePersonalGoalController instance = new DeletePersonalGoalController();
        boolean expResult = true;
        boolean result = instance.deleteElementFromList(userName, entryTitle);
        assertEquals(expResult, result);

    }
    
     @Test
    public void testFailureDeleteElementFromList() throws Exception {
        System.out.println("Failure Erase");
        String userName = "John";
        String entryTitle = "Fail";
        DeletePersonalGoalController instance = new DeletePersonalGoalController();
        boolean expResult = false;
        boolean result = instance.deleteElementFromList(userName, entryTitle);
        assertEquals(expResult, result);

    }

    /**
     * Test of showNoFileFound method, of class DeletePersonalGoalController.
     */
    @Test
    public void testShowNoFileFound() {
        System.out.println("showNoFileFound");
        DeletePersonalGoalController instance = new DeletePersonalGoalController();
        String expResult = "There is not such a file";
        String result = instance.showNoFileFound();
        assertEquals(expResult, result);
    }

    /**
     * Test of showError method, of class DeletePersonalGoalController.
     */
    @Test
    public void testShowError() {
        System.out.println("showError");
        DeletePersonalGoalController instance = new DeletePersonalGoalController();
        String expResult = "There was  a undefinied error";
        String result = instance.showError();
        assertEquals(expResult, result);
    }

    /**
     * Test of showSuccess method, of class DeletePersonalGoalController.
     */
    @Test
    public void testShowSuccess() {
        System.out.println("showSuccess");
        DeletePersonalGoalController instance = new DeletePersonalGoalController();
        String expResult = "Successful Erase";
        String result = instance.showSuccess();
        assertEquals(expResult, result);

    }

}
