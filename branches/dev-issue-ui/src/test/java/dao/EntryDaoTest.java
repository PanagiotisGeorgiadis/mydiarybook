/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Entry;
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
public class EntryDaoTest {
    
    public EntryDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        String fSeparator = File.separator;
        try {
            File folder = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator
                +"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"Texnologia2");
            folder.mkdirs();
            
            File textFolder = new File(folder.toString()+fSeparator+"Texts");
            textFolder.mkdirs();
            File textFile = new File(textFolder.toString()+fSeparator+"test.txt");
            BufferedWriter bw;
            FileWriter fw;
            fw = new FileWriter(textFile,true);
            bw = new BufferedWriter(fw);
            bw.write("test0123456789");
            if(bw!=null)
                bw.close();
            fw.close();
            File imageFolder = new File(folder.toString()+fSeparator+"Images");
            imageFolder.mkdirs();
            String imageSourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+
                    "java"+fSeparator+"resources"+fSeparator+"testImg.jpg";
            File imageSourceFile = new File(imageSourcePath);
            FileUtils.copyFileToDirectory(imageSourceFile, imageFolder);
            
            String videoSourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+
                    "java"+fSeparator+"resources"+fSeparator+"testVideo.mp4";
            File videoSourceFile = new File(videoSourcePath);
            File videoFolder = new File(folder.toString()+fSeparator+"Videos");
            videoFolder.mkdirs();
            FileUtils.copyFileToDirectory(videoSourceFile, videoFolder);
        } catch (IOException ex) {
            Logger.getLogger(EntryDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        String fSeparator = File.separator;
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook");
        try {
            FileUtils.deleteDirectory(file);
        } catch (IOException ex) {
            Logger.getLogger(CheckIfFileExistsDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Before
    public void setUp(){
        String fSeparator = File.separator;
        try {
            File folder = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator
                +"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"PAOK");
            folder.mkdirs();
            
            File textFolder = new File(folder.toString()+fSeparator+"Texts");
            textFolder.mkdirs();
            File textFile = new File(textFolder.toString()+fSeparator+"test.txt");
            
            FileWriter fw = null;
            BufferedWriter bw = null;
            fw = new FileWriter(textFile,true);
            bw = new BufferedWriter(fw);
            bw.write("test0123456789");
            if(bw!=null)
                bw.close();
            fw.close();
            File imageFolder = new File(folder.toString()+fSeparator+"Images");
            imageFolder.mkdirs();
            String imageSourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+
                    "java"+fSeparator+"resources"+fSeparator+"testImg.jpg";
            File imageSourceFile = new File(imageSourcePath);
            FileUtils.copyFileToDirectory(imageSourceFile, imageFolder);
            
            String videoSourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+
                    "java"+fSeparator+"resources"+fSeparator+"testVideo.mp4";
            File videoSourceFile = new File(videoSourcePath);
            File videoFolder = new File(folder.toString()+fSeparator+"Videos");
            videoFolder.mkdirs();
            FileUtils.copyFileToDirectory(videoSourceFile, videoFolder);
        } catch (IOException ex) {
            Logger.getLogger(EntryDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of getEntryByTitle method, of class EntryDao.
     */
    @Test
    public void testGetEntryByTitle() {
        System.out.println("getEntryByTitle with same entries");
        String title = "PAOK";
        Entry expResult = EntryDao.getEntryByTitle("PAOK");
        Entry result = EntryDao.getEntryByTitle(title);
        
        boolean finalExpResult = true;
        boolean finalActualResult;
        
        boolean imageResult = expResult.getEntryImages().equals(result.getEntryImages());
        boolean textResult = expResult.getEntryText().equals(result.getEntryText());
        boolean videoResult = expResult.getEntryVideo().toString().equals(result.getEntryVideo().toString());
        boolean entriesListResult = Arrays.deepEquals(expResult.getEntriesList(), result.getEntriesList());
        boolean imageListResult = Arrays.deepEquals(expResult.getImageList(), result.getImageList());
        if(imageResult && textResult && videoResult && entriesListResult && imageListResult)
            finalActualResult = true;
        else
            finalActualResult = false;
        assertEquals(finalExpResult, finalActualResult);
    }
    
    @Test
    public void testGetEntryByTitle2() {
        System.out.println("getEntryByTitle with different entries");
        String title = "PAOK";
        Entry expResult = EntryDao.getEntryByTitle("Texnologia2");
        Entry result = EntryDao.getEntryByTitle(title);
        
        boolean finalExpResult = false;
        boolean finalActualResult;
        
        boolean imageResult = expResult.getEntryImages().equals(result.getEntryImages());
        boolean textResult = expResult.getEntryText().equals(result.getEntryText());
        boolean videoResult = expResult.getEntryVideo().toString().equals(result.getEntryVideo().toString());
        boolean entriesListResult = Arrays.deepEquals(expResult.getEntriesList(), result.getEntriesList());
        boolean imageListResult = Arrays.deepEquals(expResult.getImageList(), result.getImageList());
        if(imageResult && textResult && videoResult && entriesListResult && imageListResult)
            finalActualResult = true;
        else
            finalActualResult = false;
        assertEquals(finalExpResult, finalActualResult);
    }    
}
