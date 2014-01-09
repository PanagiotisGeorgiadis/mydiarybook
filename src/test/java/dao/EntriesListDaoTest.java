/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
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
public class EntriesListDaoTest {
    
    public EntriesListDaoTest() {
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
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator
                +"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"Trela"); 
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
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator
                +"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"Trela"); 
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
     * Test of getListOfEntries method, of class EntriesListDao.
     */
    @Test
    public void testGetListOfEntries() {
        System.out.println("getListOfEntries With Existant Entries");
        EntriesListDao instance = new EntriesListDao();
        
        String[] expResult = new String[3]; 
        expResult[0] = "PAOK";
        expResult[1] = "TexnologiaLogismikou2";
        expResult[2] = "Trela";
        String[] result = instance.getListOfEntries();
        assertArrayEquals("getListOfEntries With Existant Entries",expResult, result);
    }
    
    @Test
    public void testGetListOfEntries2() {
        System.out.println("getListOfEntries With Non Existant Entries");
        EntriesListDao instance = new EntriesListDao();
        
        String[] expResult = new String[3]; 
        expResult[0] = "";
        expResult[1] = "Texnologia2";
        expResult[2] = "";
        String[] result = instance.getListOfEntries();
        boolean booleanActualResult = Arrays.deepEquals(expResult, result);
        boolean booleanExpResult = false;
        assertEquals("getListOfEntries With non Existant Entries",booleanExpResult, booleanActualResult);
    }
    
    @Test
    public void testGetListOfEntries3() {
        System.out.println("getListOfEntries With Existant Entries And Boolean Assert");
        EntriesListDao instance = new EntriesListDao();
        
        String[] expResult = new String[3]; 
        expResult[0] = "PAOK";
        expResult[1] = "TexnologiaLogismikou2";
        expResult[2] = "Trela";
        String[] result = instance.getListOfEntries();
        boolean booleanActualResult = Arrays.deepEquals(expResult, result);
        boolean booleanExpResult = true;
        assertEquals("getListOfEntries With Existant Entries And Boolean Assert",booleanExpResult, booleanActualResult);
    }
    
    @Test
    public void testGetListOfEntries4() {
        System.out.println("getListOfEntries With Non Existant Entries And Boolean Assert With Empty String Array");
        EntriesListDao instance = new EntriesListDao();
        
        String[] expResult = new String[3]; 
        String[] result = instance.getListOfEntries();
        boolean booleanActualResult = Arrays.deepEquals(expResult, result);
        boolean booleanExpResult = false;
        assertEquals("Non Existant Entries And Boolean Assert With Empty String Array",booleanExpResult, booleanActualResult);
    }
    
}
