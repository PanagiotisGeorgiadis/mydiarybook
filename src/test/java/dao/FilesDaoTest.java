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
public class FilesDaoTest {
    private static final String fSeparator = File.separator;
    private static File folder = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook"
            +fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries"
            +fSeparator+"Texnologia2");
    public FilesDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        folder.mkdirs();
        File textFolder = new File(folder.toString()+fSeparator+"Texts");
        textFolder.mkdirs();
        File imageFolder = new File(folder.toString()+fSeparator+"Images");
        imageFolder.mkdirs();
        File videoFolder = new File(folder.toString()+fSeparator+"Videos");
        videoFolder.mkdirs();
        File emptyFolder = new File(folder.toString()+fSeparator+"EmptyFolder");
        emptyFolder.mkdirs();
    }
    
    @AfterClass
    public static void tearDownClass() {
        try {
            File testFolder = new File(System.getProperty("user.dir")+fSeparator+"MyDiaryBook");
            FileUtils.deleteDirectory(testFolder);
        } catch (IOException ex) {
            Logger.getLogger(FilesDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Before
    public void setUp() {
        folder.mkdirs();
        File textFolder = new File(folder.toString()+fSeparator+"Texts");
        textFolder.mkdirs();
        File imageFolder = new File(folder.toString()+fSeparator+"Images"+fSeparator);
        imageFolder.mkdirs();
        String imageSourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+
                    "java"+fSeparator+"resources"+fSeparator+"testImg.jpg";
        String imageSourcePath2 = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+
                    "java"+fSeparator+"resources"+fSeparator+"testImg2.jpg";
        File sourceImageFolder = new File(imageSourcePath);
        File sourceImageFolder2 = new File(imageSourcePath2);
        try {
            FileUtils.copyFileToDirectory(sourceImageFolder, imageFolder);
            FileUtils.copyFileToDirectory(sourceImageFolder2, imageFolder);
        } catch (IOException ex) {
            Logger.getLogger(FilesDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        File textFile = new File(folder.toString()+fSeparator+"Texts"+fSeparator+"textFile.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        try{
            fw = new FileWriter(textFile);
            bw = new BufferedWriter(fw);
            fw.write("textOfTextFile");
            if(fw!=null)
                try {
                    fw.close();
            } catch (IOException ex) {
                Logger.getLogger(FilesDaoTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(bw!=null)
                try {
                    bw.close();
            } catch (IOException ex) {
                Logger.getLogger(FilesDaoTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(IOException ex){
            Logger.getLogger(EntryDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        File emptyTextFile = new File(folder.toString()+fSeparator+"Texts"+fSeparator+"emptyTextFile.txt");
        try{
            fw = new FileWriter(emptyTextFile);
            if(fw!=null)
                try {
                    fw.close();
            } catch (IOException ex) {
                Logger.getLogger(FilesDaoTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            if(bw!=null)
                try {
                    bw.close();
            } catch (IOException ex) {
                Logger.getLogger(FilesDaoTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }catch(IOException ex){
            Logger.getLogger(EntryDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @After
    public void tearDown() {
        File textFolder = new File(folder.toString()+fSeparator+"Texts");
        File imageFolder = new File(folder.toString()+fSeparator+"Images");
        try {
            FileUtils.deleteDirectory(textFolder);
            FileUtils.deleteDirectory(imageFolder);
        } catch (IOException ex) {
            Logger.getLogger(FilesDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of copyFile method, of class FilesDao.
     */
    @Test
    public void testCopyFile() throws Exception {
        System.out.println("copyFile with existing source image file");
        String sourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+
                    "java"+fSeparator+"resources"+fSeparator+"testImg.jpg";
        File source = new File(sourcePath);
        
        File dest = new File(folder.toString()+fSeparator+"Images");
        FilesDao instance = new FilesDao();
        boolean result;
        try{
            instance.copyFile(source, dest);
            File copiedFile = new File(dest+fSeparator+"testImg.jpg");
            if(copiedFile.exists())
                result = true;
            else
                result = false;
        }catch(Exception ex){
            result = false;
        }
        boolean expResult = true;
        assertEquals("Some message",expResult,result);
    }
    
    @Test
    public void testCopyFile2() throws Exception {
        System.out.println("copyFile with non existant source image file");
        String sourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+
                    "java"+fSeparator+"resources"+fSeparator+"testImg4.jpg";
        File source = new File(sourcePath);
        File dest = new File(folder.toString()+fSeparator+"Images");
        FilesDao instance = new FilesDao();
        boolean result;
        try{
            instance.copyFile(source, dest);
            File copiedFile = new File(dest+fSeparator+"testImg4.jpg");
            if(copiedFile.exists())
                result = true;
            else
                result = false;
        }catch(Exception ex){
            result = false;
        }
        
        boolean expResult = false;
        assertEquals("Some message",expResult,result);
    }
    
    @Test
    public void testCopyFile3() throws Exception {
        System.out.println("copyFile with existing source video file and non existant destination folder");
        String sourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+
                    "java"+fSeparator+"resources"+fSeparator+"testVideo.mp4";
        File source = new File(sourcePath);
        
        File dest = new File(folder.toString()+fSeparator+"Videos");
        FilesDao instance = new FilesDao();
        boolean result;
        try{
        instance.copyFile(source, dest);
        File copiedFile = new File(dest+fSeparator+"testVideo.mp4");
        if(copiedFile.exists())
            result = true;
        else
            result = false;
        }catch(IOException ex){
            result = false;
        }
        boolean expResult = true;
        assertEquals("Some message",expResult,result);
    }
    
    @Test
    public void testCopyFile4() throws Exception {
        System.out.println("copyFile with existing destination video file");
        String sourcePath = System.getProperty("user.dir")+fSeparator+"src"+fSeparator+"test"+fSeparator+
                    "java"+fSeparator+"resources"+fSeparator+"testVideo.mp4";
        File source = new File(sourcePath);
        
        File dest = new File(folder.toString()+fSeparator+"Videos");
        FilesDao instance = new FilesDao();
        boolean result;
        try{
        instance.copyFile(source, dest);
        File copiedFile = new File(dest+fSeparator+"testVideo.mp4");
        if(copiedFile.exists())
            result = true;
        else
            result = false;
        }catch(IOException ex){
            result = false;
        }
        boolean expResult = true;
        assertEquals("Some message",expResult,result);
    }

    /**
     * Test of createTextFile method, of class FilesDao.
     */
    @Test
    public void testCreateTextFile() {
        System.out.println("createTextFile to existing dest Path");
        String destPath = folder.toString()+fSeparator+"Texts"+fSeparator;
        String text = "qweqweqwewqeqw";
        String fileName = "test";
        FilesDao instance = new FilesDao();
        boolean expResult = true;
        boolean result = instance.createTextFile(destPath, text, fileName);
        assertEquals("Some message",expResult, result);
    }
    
    @Test
    public void testCreateTextFile2() {
        System.out.println("createTextFile to non existant dest Path");
        String destPath = folder.toString()+fSeparator+"Texts"+fSeparator+"TestTexts"+fSeparator;
        String text = "testTexts";
        String fileName = "test";
        FilesDao instance = new FilesDao();
        boolean expResult = true;
        boolean result = instance.createTextFile(destPath, text, fileName);
        assertEquals("Some message",expResult, result);
    }
    
    @Test
    public void testCreateTextFile3() {
        System.out.println("createTextFile to not possible dest Path");
        String destPath = "//////asdasd...asd..ads.asqwe";
        String text = "qweqweqwewqeqw";
        String fileName = "test";
        FilesDao instance = new FilesDao();
        boolean expResult = false;
        boolean result;
        try{
            result = instance.createTextFile(destPath, text, fileName);
        }catch(StackOverflowError error){
            result = false;
        }
         assertEquals("Expected False",expResult, result);
    }
    
    @Test
    public void testCreateTextFile4() {
        System.out.println("createTextFile with null destination path");
        String destPath = null;
        String text = "qweqweqwewqeqw";
        String fileName = "test";
        FilesDao instance = new FilesDao();
        boolean expResult = false;
        boolean result;
        try{
            result = instance.createTextFile(destPath, text, fileName);
        }catch(StackOverflowError error){
            result = false;
        }
        assertEquals("Expected False",expResult, result);
    }

    /**
     * Test of createFilePath method, of class FilesDao.
     */
    @Test
    public void testCreateFilePath() {
        System.out.println("createFilePath with realistic path");
        String path = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"
            +fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+fSeparator+"Entries"
            +fSeparator+"Test1";
        FilesDao instance = new FilesDao();
        boolean expResult = true;
        boolean result = instance.createFilePath(path);
        assertEquals("Some message",expResult, result);
    }
        
    @Test
    public void testCreateFilePath3() {
        System.out.println("createFilePath with null path");
        String path = "";
        FilesDao instance = new FilesDao();
        boolean expResult = false;
        boolean result;
        try{
            result = instance.createFilePath(path);
        }catch(StackOverflowError error){
            result = false;
        }
        assertEquals("Some message",expResult, result);
    }

    /**
     * Test of deleteDirectory method, of class FilesDao.
     */
    @Test
    public void testDeleteDirectory() {
        System.out.println("deleteDirectory with existing folder as input");
        File testFolder = new File(folder.toString()+fSeparator+"Texts");
        FilesDao instance = new FilesDao();
        boolean expResult = true;
        boolean result = instance.deleteDirectory(testFolder);
        assertEquals("Some message",expResult, result);
    }
    
    @Test
    public void testDeleteDirectory2() {
        System.out.println("deleteDirectory with null folder as input");
        File testFolder = new File("");
        FilesDao instance = new FilesDao();
        boolean expResult = false;
        boolean result = instance.deleteDirectory(testFolder);
        assertEquals("Some message",expResult, result);
    }
    
    @Test
    public void testDeleteDirectory3() {
        System.out.println("deleteDirectory with non existant folder as input");
        File testFolder = new File(System.getProperty("user.dir")+fSeparator+"asdqwert");
        FilesDao instance = new FilesDao();
        boolean expResult = false;
        boolean result = instance.deleteDirectory(testFolder);
        assertEquals("Some message",expResult, result);
    }
    

    /**
     * Test of getDirectoryList method, of class FilesDao.
     */
    @Test
    public void testGetDirectoryList() {
        System.out.println("getDirectoryList for existing folder with subfolders");
        String entriesPath = folder.toString();
        FilesDao instance = new FilesDao();
        String[] expResult = new String[4];
        expResult[0]="EmptyFolder";
        expResult[1]="Images";
        expResult[2]="Texts";
        expResult[3]="Videos";
        String[] result = instance.getDirectoryList(entriesPath);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetDirectoryList2() {
        System.out.println("getDirectoryList for existing folder with no subfolders");
        String entriesPath = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"+
                fSeparator+"Entries"+fSeparator+"Test1";
        FilesDao instance = new FilesDao();
        String[] expResult = new String[0];
        String[] result = instance.getDirectoryList(entriesPath);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetDirectoryList3() {
        System.out.println("getDirectoryList for existing file");
        String entriesPath = System.getProperty("user.dir")+"pom.xml";
        FilesDao instance = new FilesDao();
        String[] expResult = null;
        String[] result;
        try{
            result = instance.getDirectoryList(entriesPath);
        }catch(NullPointerException ex){
            result = null;
        }
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetDirectoryList4() {
        System.out.println("getDirectoryList for entry path set to null");
        String entriesPath = null;
        FilesDao instance = new FilesDao();
        String[] expResult = null;
        String[] result;
        try{
            result = instance.getDirectoryList(entriesPath);
        }catch(NullPointerException ex){
            result = null;
        }
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getFilesList method, of class FilesDao.
     */
    @Test
    public void testGetFilesList() {
        System.out.println("getFilesList from existing folder with existing subfiles");
        String entryPath = folder.toString()+fSeparator+"Images";
        FilesDao instance = new FilesDao();
        String[] expResult = new String[2];
        expResult[0] = "testImg.jpg";
        expResult[1] = "testImg2.jpg";
        String[] result = instance.getFilesList(entryPath);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetFilesList2() {
        System.out.println("getFilesList from existing folder with non existant subfiles");
        String entryPath = folder.toString()+fSeparator+"EmptyFolder";
        FilesDao instance = new FilesDao();
        String[] expResult = new String[0];
        String[] result = instance.getFilesList(entryPath);
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetFilesList3() {
        System.out.println("getFilesList from non existant folder");
        String entryPath = folder.toString()+fSeparator+"NonExistantFolder";
        FilesDao instance = new FilesDao();
        String[] expResult = null;
        String[] result;
        try{
            result = instance.getFilesList(entryPath);
        }catch(NullPointerException ex){
            result = null;
        }
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetFilesList4() {
        System.out.println("getFilesList with null");
        String entryPath = null;
        FilesDao instance = new FilesDao();
        String[] expResult = null;
        String[] result = null;
        try{
            result = instance.getFilesList(entryPath);
        }catch(NullPointerException ex){
            result = null;
        }
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getSubFiles method, of class FilesDao.
     */
    @Test
    public void testGetSubFiles() {
        System.out.println("getSubFiles from ");
        String path = folder.toString()+fSeparator+"Images";
        FilesDao instance = new FilesDao();
        
        File firstImageFile = new File(path+fSeparator+"testImg.jpg");
        File secondImageFile = new File(path+fSeparator+"testImg2.jpg");
        List<URI> expResult = new ArrayList<>();
        expResult.add(firstImageFile.toURI());
        expResult.add(secondImageFile.toURI());
        List<URI> result = instance.getSubFiles(path);
        assertEquals("Some message",expResult, result);
    }
    
    @Test
    public void testGetSubFiles2() {
        System.out.println("getSubFiles from empty Folder");
        String path = folder.toString()+fSeparator+"EmptyFolder";
        FilesDao instance = new FilesDao();

        List<URI> expResult = new ArrayList<URI>();
        expResult.removeAll(expResult);
        List<URI> result = instance.getSubFiles(path);
        assertEquals("Some message",expResult, result);
    }

    /**
     * Test of getSubDirectories method, of class FilesDao.
     */
    @Test
    public void testGetSubDirectories() {
        System.out.println("getSubDirectories from a folder containing 2 subdirectories");
        String path = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+"Panagiwtis Georgiadis"
                +fSeparator+"Entries";
        
        FilesDao instance = new FilesDao();
        File entriesFile = new File(path);
        File subFolder;
        String[] children = entriesFile.list();
        File[] expResult = new File[entriesFile.list().length];
        
        for(int i=0;i<entriesFile.list().length;i++)
        {
            subFolder = new File(path+fSeparator+children[i]);
            if(subFolder.isDirectory())
                expResult[i] = subFolder; 
        }
        
        File[] result = instance.getSubDirectories(path);
        
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetSubDirectories2() {
        System.out.println("getSubDirectories from empty folder");
        String path = folder.toString()+fSeparator+"EmptyFolder";
        
        FilesDao instance = new FilesDao();
        File entriesFile = new File(path);
        File subFolder;
        String[] children = entriesFile.list();
        File[] expResult = new File[entriesFile.list().length];
        
        for(int i=0;i<entriesFile.list().length;i++)
        {
            subFolder = new File(path+fSeparator+children[i]);
            if(subFolder.isDirectory())
                expResult[i] = subFolder; 
        }
        
        File[] result = instance.getSubDirectories(path);
        
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetSubDirectories3() {
        System.out.println("getSubDirectories from a folder containing 2 subfiles and no subfolders");
        String path = folder.toString()+fSeparator+"Images";
        
        FilesDao instance = new FilesDao();
        File entriesFile = new File(path);
        File subFolder;
        String[] children = entriesFile.list();
        File[] expResult = new File[entriesFile.list().length];
        
        for(int i=0;i<entriesFile.list().length;i++)
        {
            subFolder = new File(path+fSeparator+children[i]);
            if(subFolder.isDirectory())
                expResult[i] = subFolder; 
        }
        
        File[] result = instance.getSubDirectories(path);
        
        assertArrayEquals(expResult, result);
    }
    
    @Test
    public void testGetSubDirectories4() {
        System.out.println("getSubDirectories from a null path");
        String path = null;
        
        FilesDao instance = new FilesDao();
        File[] expResult = null;
        File[] result;
        
        try{
            result = instance.getSubDirectories(path);
        }catch(NullPointerException ex){
            result = null;
        }        
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getFile method, of class FilesDao.
     */
    @Test
    public void testGetFile() {
        System.out.println("getFile with valid path of existing folder with 2 subfiles");
        String path = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+
                "Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"Texnologia2"+fSeparator+"Images";
        FilesDao instance = new FilesDao();
        File expResult = new File(path+fSeparator+"testImg.jpg");
        File result = instance.getFile(path);
        assertEquals("Some message",expResult, result);
    }
    
    @Test
    public void testGetFile2() {
        System.out.println("getFile with null path");
        String path = null;
        FilesDao instance = new FilesDao();
        File expResult = null;
        File result;
        try{
            result = instance.getFile(path);
        }catch(NullPointerException ex){
            result=null;
        }
        assertEquals("Some message",expResult, result);
    }
    
    @Test
    public void testGetFile3() {
        System.out.println("getFile with valid path of existing empty folder");
        String path = System.getProperty("user.dir")+fSeparator+"MyDiaryBook"+fSeparator+"Users"+fSeparator+
                "Panagiwtis Georgiadis"+fSeparator+"Entries"+fSeparator+"Texnologia2"+fSeparator+"EmptyFolder";
        FilesDao instance = new FilesDao();
        File expResult = null;
        File result = instance.getFile(path);
        assertEquals("Some message",expResult, result);
    }

    /**
     * Test of returnTextFile method, of class FilesDao.
     */
    @Test
    public void testReturnTextFile() throws Exception {
        System.out.println("returnTextFile which contains text");
        String path = folder.toString()+fSeparator+"Texts"+fSeparator+"textFile.txt";
        FilesDao instance = new FilesDao();
        String expResult = "textOfTextFile";
        String result = instance.returnTextFile(path);
        assertEquals("Some message",expResult, result);
    }
    
    @Test
    public void testReturnTextFile2() throws Exception {
        System.out.println("returnTextFile without text");
        String path = folder.toString()+fSeparator+"Texts"+fSeparator+"emptyTextFile.txt";
        FilesDao instance = new FilesDao();
        String expResult = "";
        String result = instance.returnTextFile(path);
        assertEquals("Some message",expResult, result);
    }
    
    @Test
    public void testReturnTextFile3() throws Exception {
        System.out.println("returnTextFile from Empty path");
        String path = "";
        FilesDao instance = new FilesDao();
        String expResult = "";
        String result;
        try{
            result = instance.returnTextFile(path);
        }catch(IOException ex){
            result = "";
        }
        assertEquals("Some message",expResult, result);
    }
    
}
