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
 * @author Zarc
 */
public class EntriesListDaoTest {
    static String fSeparator = File.separator;
    public EntriesListDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
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
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator
                +"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"PAOK");
        file.mkdirs();
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator
                +"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"TexnologiaLogismikou2"); 
        file.mkdirs();
        file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator
                +"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"Trela"); 
        file.mkdirs();
        Login.username = "Panagiwtis Georgiadis";
    }
    
    @After
    public void tearDown() {
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
        Arrays.sort(expResult);
        String[] result = instance.getListOfEntries();
        Arrays.sort(result);
        assertArrayEquals("getListOfEntries With Existant Entries",expResult, result);
    }
    
    @Test
    public void testGetListOfEntries2() {
        System.out.println("getListOfEntries With Non Existant Entries");
        EntriesListDao instance = new EntriesListDao();
        File file = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator
                +"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"TexnologiaLogismikou2");        
        File file2;
        try{
            file2 = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator
                +"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"PAOK");
            FileUtils.deleteDirectory(file2);
            file2 = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator
                +"Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"Trela");
            FileUtils.deleteDirectory(file2);
        }catch(IOException ex){
            
        }
        String[] expResult = new String[1]; 
        expResult[0] = "TexnologiaLogismikou2";
        String[] result = instance.getListOfEntries();
        assertArrayEquals(expResult,result);
    }
    
    @Test
    public void testGetListOfEntries4() {
        System.out.println("getListOfEntries With Non Existant Entries");
        EntriesListDao instance = new EntriesListDao();
        try {
            FileUtils.deleteDirectory(new File(System.getProperty("user.dir")+File.separator+"MyDiaryBook"+File.separator+"Users"+File.separator+"Panagiwtis Georgiadis"+File.separator
                +"Entries"));
        } catch (IOException ex) {
            Logger.getLogger(EntriesListDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        String[] expResult = null; 
        String[] result = instance.getListOfEntries();
        assertArrayEquals(expResult, result);
    }
    
}
