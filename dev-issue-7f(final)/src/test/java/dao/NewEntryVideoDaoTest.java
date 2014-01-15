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
public class NewEntryVideoDaoTest {
    static String fSeparator = File.separator;
    File videoFile = new File(System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+
                    "java"+fSeparator+"resources"+fSeparator+"testVideo.mp4");
    public NewEntryVideoDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"
            +fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries"
            +fSeparator+"Texnologia2"+fSeparator+"Videos");
        file.mkdirs();
        File videoEntry = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"
            +fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries"
            +fSeparator+"videoEntry"+fSeparator+"Videos");
        videoEntry.mkdirs();
        try {
            FileUtils.copyFileToDirectory(videoFile, videoEntry);
        } catch (IOException ex) {
            Logger.getLogger(NewEntryVideoDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook");
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException ex) {
            Logger.getLogger(NewEntryVideoDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of copyVideo method, of class NewEntryVideoDao.
     */
    @Test
    public void testCopyVideo() {
        System.out.println("copyVideo to an existing Entry without videos");
        String entryTitle = "Texnologia2";
        String sourcePath = videoFile.toString();
        NewEntryVideoDao instance = new NewEntryVideoDao();
        boolean expResult = true;
        boolean result = instance.copyVideo(entryTitle, sourcePath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyVideo2() {
        System.out.println("copyVideo to an existing Entry with video to replace");
        String entryTitle = "testVideo";
        String sourcePath = videoFile.toString();
        NewEntryVideoDao instance = new NewEntryVideoDao();
        boolean expResult = true;
        boolean result = instance.copyVideo(entryTitle, sourcePath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyVideo3() {
        System.out.println("copyVideo to a non Existing entry");
        String entryTitle = "NonExistantEntry";
        String sourcePath = videoFile.toString();
        NewEntryVideoDao instance = new NewEntryVideoDao();
        boolean expResult = true;
        boolean result = instance.copyVideo(entryTitle, sourcePath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyVideo4() {
        System.out.println("copyVideo to existing entry but with not existant source file");
        String entryTitle = "Texnologia2";
        String sourcePath = System.getProperty("user.dir")+fSeparator+"NonExistantResource.mp4";
        NewEntryVideoDao instance = new NewEntryVideoDao();
        boolean expResult = false;
        boolean result = instance.copyVideo(entryTitle, sourcePath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyVideo5() {
        System.out.println("copyVideo with null entryTitle and null sourcePath");
        String entryTitle = null;
        String sourcePath = null;
        NewEntryVideoDao instance = new NewEntryVideoDao();
        boolean expResult = false;
        boolean result = instance.copyVideo(entryTitle, sourcePath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyVideo6() {
        System.out.println("copyVideo with empty entryTitle and empty sourcePath");
        String entryTitle = "";
        String sourcePath = "";
        NewEntryVideoDao instance = new NewEntryVideoDao();
        boolean expResult = false;
        boolean result = instance.copyVideo(entryTitle, sourcePath);
        assertEquals(expResult, result);
    }

    /**
     * Test of getVideo method, of class NewEntryVideoDao.
     */
    @Test
    public void testGetVideo() {
        System.out.println("getVideo from empty entryTitle");
        String entryTitle = "";
        NewEntryVideoDao instance = new NewEntryVideoDao();
        File expResult = null;
        File result = instance.getVideoFile(entryTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetVideo2() {
        System.out.println("getVideo from existing entry without videos");
        String entryTitle = "Texnologia2";
        NewEntryVideoDao instance = new NewEntryVideoDao();
        File expResult = null;
        File result = instance.getVideoFile(entryTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetVideo3() {
        System.out.println("getVideo from existing entry with video");
        String entryTitle = "videoEntry";
        NewEntryVideoDao instance = new NewEntryVideoDao();
        File expResult = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"
                +fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"videoEntry"
                +fSeparator+"Videos"+fSeparator+"testVideo.mp4");
        File result = instance.getVideoFile(entryTitle);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testGetVideo4() {
        System.out.println("getVideo from non existant entry");
        String entryTitle = "NonExistantEntry";
        NewEntryVideoDao instance = new NewEntryVideoDao();
        File expResult = null;
        File result = instance.getVideoFile(entryTitle);
        assertEquals(expResult, result);
    }
}
