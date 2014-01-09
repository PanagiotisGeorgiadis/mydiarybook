/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

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
 * @author Zarc
 */
public class CheckIfFileExistsDaoTest {
    
    public CheckIfFileExistsDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        String fSeparator = File.separator;
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator
                +"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"PAOK");
        file.mkdirs();
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator
                +"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"TexnologiaLogismikou2"); 
        file.mkdirs();
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        String fSeparator = File.separator;
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator
                +"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"PAOK");
        file.mkdirs();
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator
                +"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"TexnologiaLogismikou2"); 
        file.mkdirs();
    }
    
    @After
    public void tearDown() {
        String fSeparator = File.separator;
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook");
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException ex) {
            Logger.getLogger(CheckIfFileExistsDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of filePathExists method, of class CheckIfFileExistsDao.
     */
    @Test
    public void testFilePathExists() {
        System.out.println("filePathExists");
        String title = "PAOK";
        CheckIfFileExistsDao instance = new CheckIfFileExistsDao();
        boolean expResult = true;
        boolean result = instance.filePathExists(title);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFilePathExists2() {
        System.out.println("filePathExists");
        String title = "PAOK2";
        CheckIfFileExistsDao instance = new CheckIfFileExistsDao();
        boolean expResult = false;
        boolean result = instance.filePathExists(title);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFilePathExists3() {
        System.out.println("filePathExists");
        String title = "C:\\qweqweq\\qweqwee\\qweqweqwe";
        CheckIfFileExistsDao instance = new CheckIfFileExistsDao();
        boolean expResult = false;
        boolean result = instance.filePathExists(title);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFilePathExist4() {
        System.out.println("filePathExists");
        String title = null;
        CheckIfFileExistsDao instance = new CheckIfFileExistsDao();
        boolean expResult = false;
        boolean result = instance.filePathExists(title);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFilePathExists5() {
        System.out.println("filePathExists");
        String title = "";
        CheckIfFileExistsDao instance = new CheckIfFileExistsDao();
        boolean expResult = false;
        boolean result = instance.filePathExists(title);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFilePathExists6() {
        System.out.println("filePathExists");
        String title = "     ";
        CheckIfFileExistsDao instance = new CheckIfFileExistsDao();
        boolean expResult = false;
        boolean result = instance.filePathExists(title);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFilePathExists7() {
        System.out.println("filePathExists");
        String title = "TexnologiaLogismikou2";
        CheckIfFileExistsDao instance = new CheckIfFileExistsDao();
        boolean expResult = true;
        boolean result = instance.filePathExists(title);
        assertEquals(expResult, result);
    }
}
