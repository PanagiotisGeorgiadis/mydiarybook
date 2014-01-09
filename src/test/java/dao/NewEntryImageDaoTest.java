/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import static dao.NewEntryDaoTest.fSeparator;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
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
public class NewEntryImageDaoTest {
    static String fSeparator = File.separator;
    public NewEntryImageDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        File newEntry = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator
            +"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"testEntry");
        newEntry.mkdirs();
        File newEntryImageFolder = new File(newEntry.toString()+fSeparator+"Images");
        newEntryImageFolder.mkdirs();
        File newEntryWithImages = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator
            +"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"testEntryWithImages"
            +fSeparator+"Images"+fSeparator);
        newEntryWithImages.mkdirs();
        File srcFile = new File(System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+
                    "java"+fSeparator+"resources"+fSeparator+"testImg.jpg");
        try {
            FileUtils.copyFileToDirectory(srcFile, newEntryWithImages);
        } catch (IOException ex) {
            Logger.getLogger(NewEntryImageDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        File newEntryWithoutImagesFolder = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator
            +"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"emptyEntryFolder");
        newEntryWithoutImagesFolder.mkdirs();
    }
    
    @After
    public void tearDown() {
        File testFile = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook");
        try {
            FileUtils.deleteDirectory(testFile);
        } catch (IOException ex) {
            Logger.getLogger(NewEntryImageDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of prepareImageForCopy method, of class NewEntryImageDao.
     */
    @Test
    public void testPrepareImageForCopy() {
        System.out.println("prepareImageForCopy from existing source to existing dest");
        String entryTitle = "testEntry";
        String sourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+
                    "java"+fSeparator+"resources"+fSeparator+"testImg.jpg";
        NewEntryImageDao instance = new NewEntryImageDao();
        boolean expResult = true;
        boolean result = instance.prepareImageForCopy(entryTitle, sourcePath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPrepareImageForCopy2() {
        System.out.println("prepareImageForCopy with Null source Path");
        String entryTitle = "testEntry";
        String sourcePath = "";
        NewEntryImageDao instance = new NewEntryImageDao();
        boolean expResult = false;
        boolean result = instance.prepareImageForCopy(entryTitle, sourcePath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPrepareImageForCopy3() {
        System.out.println("prepareImageForCopy to non existant entryTitle");
        String entryTitle = "testEntry2";
        String sourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+
                    "java"+fSeparator+"resources"+fSeparator+"testImg.jpg";
        NewEntryImageDao instance = new NewEntryImageDao();
        boolean expResult = true;
        boolean result = instance.prepareImageForCopy(entryTitle, sourcePath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testPrepareImageForCopy4() {
        System.out.println("prepareImageForCopy with Invalid EntryTitle");
        String entryTitle = "?????????";
        String sourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+
                    "java"+fSeparator+"resources"+fSeparator+"testImg.jpg";
        NewEntryImageDao instance = new NewEntryImageDao();
        boolean expResult = false;
        boolean result = instance.prepareImageForCopy(entryTitle, sourcePath);
        assertEquals(expResult, result);
    }

    /**
     * Test of getImageList method, of class NewEntryImageDao.
     */
    @Test
    public void testGetImageList() {
        System.out.println("getImageList from existing Entry with Images");
        String entryTitle = "testEntryWithImages";
        NewEntryImageDao instance = new NewEntryImageDao();
        String[] expResult = new String[1];
        expResult[0] = "testImg.jpg";
        String[] result = instance.getImageList(entryTitle);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetImageList2() {
        System.out.println("getImageList from existing Entry with empty Images Folder");
        String entryTitle = "testEntry";
        NewEntryImageDao instance = new NewEntryImageDao();
        String[] expResult = new String[0];
        String[] result = instance.getImageList(entryTitle);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetImageList3() {
        System.out.println("getImageList from non-existant Entry");
        String entryTitle = "nonExistantEntry";
        NewEntryImageDao instance = new NewEntryImageDao();
        String[] expResult = null;
        String[] result = instance.getImageList(entryTitle);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetImageList4() {
        System.out.println("getImageList from null EntryTitle");
        String entryTitle = "";
        NewEntryImageDao instance = new NewEntryImageDao();
        String[] expResult = null;
        String[] result = instance.getImageList(entryTitle);
        assertArrayEquals(expResult, result);
    }    

    @Test
    public void testGetImageList5() {
        System.out.println("getImageList from existing Entry without Images Folder");
        String entryTitle = "emptyEntryFolder";
        NewEntryImageDao instance = new NewEntryImageDao();
        String[] expResult = null;
        String[] result = instance.getImageList(entryTitle);
        assertArrayEquals(expResult, result);
    }
    
    /**
     * Test of getImageFiles method, of class NewEntryImageDao.
     */
    @Test
    public void testGetImageFiles() {
        System.out.println("getImageFiles From null Entry Title");
        String entryTitle = "";
        NewEntryImageDao instance = new NewEntryImageDao();
        List<URI> expResult = null;
        List<URI> result = instance.getImageFiles(entryTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetImageFiles2() {
        System.out.println("getImageFiles From Existing Entry With Images");
        String entryTitle = "testEntryWithImages";
        NewEntryImageDao instance = new NewEntryImageDao();
        File imageFile = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator
            +"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"testEntryWithImages"
            +fSeparator+"Images"+fSeparator+"testImg.jpg");
        List<URI> expResult = new ArrayList<>();
        expResult.add(imageFile.toURI());
        List<URI> result = instance.getImageFiles(entryTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetImageFiles3() {
        System.out.println("getImageFiles From Existing Entry Without Images");
        String entryTitle = "testEntry";
        NewEntryImageDao instance = new NewEntryImageDao();
        List<URI> expResult = new ArrayList<>();
        List<URI> result = instance.getImageFiles(entryTitle);
        assertEquals(expResult, result);
    }
}
