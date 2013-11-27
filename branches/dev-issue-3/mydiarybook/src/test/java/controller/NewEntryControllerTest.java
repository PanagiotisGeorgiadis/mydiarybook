/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import controller.NewEntryController;
import dao.IDefaultPathDaoNewEntry;
import dao.IUserNameDaoNewEntry;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import ui.INewEntryView;
import ui.NewEntryView;

/**
 *
 * @author Zarc
 */
public class NewEntryControllerTest {
    
    public NewEntryControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        IUserNameDaoNewEntry username = mock(IUserNameDaoNewEntry.class);
        when(username.getUsername()).thenReturn("ZARCHON");
        
        IDefaultPathDaoNewEntry defaultPath = mock(IDefaultPathDaoNewEntry.class);
        when(defaultPath.getDefaultPath()).thenReturn("C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\");
        
        INewEntryView theView = mock(INewEntryView.class);
        when(theView.getTextArea()).thenReturn("blablablablabla");
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of copyImage method, of class NewEntryController.
     */
    @Test
    public void testCopyImage() {
        System.out.println("copyImage");
        String sourcePath = "C:\\Users\\Zarc\\Desktop\\9gag\\3126031_700b_v1.jpg";
        String destPath = "C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Makis\\Images\\";
        int imageNumber = 0;
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
        assertEquals(expResult, result);
    }

    @Test
    public void testCopyImage2() {
        System.out.println("copyImage2");
        String sourcePath = null;
        String destPath = "C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Makis\\Images\\";
        int imageNumber = 1;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage3() {
        System.out.println("copyImage3");
        String sourcePath = "C:jpg";
        String destPath = "C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Makis\\Images\\";
        int imageNumber = 2;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage4() {
        System.out.println("copyImage4");
        String sourcePath = "F:\\Bla\\Blabla\\Blablabla";
        String destPath = "C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Makis\\Images\\";
        int imageNumber = 3;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage5() {
        System.out.println("copyImage5");
        String sourcePath = "C:\\Program Files\\World of Warcraft\\Screenshots\\WoWScrnShot_120810_010623.jpg";
        String destPath = "C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Makis\\Images\\";
        int imageNumber = 3;
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyImage6() {
        System.out.println("copyImage5");
        String sourcePath = "C:\\Program Files\\World of Warcraft\\Screenshots\\WoWScrnShot_120810_010623";
        String destPath = "C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Makis\\Images\\";
        int imageNumber = 3;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyImage(sourcePath, destPath, imageNumber);
        assertEquals(expResult, result);
    }
    /**
     * Test of copyVideo method, of class NewEntryController.
     */
    @Test
    public void testCopyVideo() {
        System.out.println("copyVideo");
        String sourcePath = "C:\\Users\\Zarc\\Documents\\First Of The Year (Equinox) - Skrillex [OFFICIAL].mp4";
        String videoDestPath = "C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Makis\\Videos\\";
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.copyVideo(sourcePath, videoDestPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyVideo2() {
        System.out.println("copyVideo2");
        String sourcePath = "C:\\Users\\Zarc\\Documents\\First Of The Year (Equinox) - Skrillex [OFFICIAL]";
        String videoDestPath = null;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyVideo(sourcePath, videoDestPath);
        assertEquals(expResult, result);
    }
        
    @Test
    public void testCopyVideo3() {
        System.out.println("copyVideo3");
        String sourcePath = "C:\\Users\\Zarc\\Documents\\First Of the year";
        String videoDestPath = "C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Mitsos\\";
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyVideo(sourcePath, videoDestPath);
        assertEquals(expResult, result);
    }
            
    @Test
    public void testCopyVideo4() {
        System.out.println("copyVideo4");
        String sourcePath = "   ";
        String videoDestPath = "    ";
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyVideo(sourcePath, videoDestPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCopyVideo5() {
        System.out.println("copyVideo5");
        String sourcePath = null;
        String videoDestPath = null;
        NewEntryController instance = new NewEntryController();
        boolean expResult = false;
        boolean result = instance.copyVideo(sourcePath, videoDestPath);
        assertEquals(expResult, result);
        }
        
    @Test
    public void testCopyVideo6() {
        System.out.println("copyVideo6");
        String sourcePath = "C:\\Users\\Zarc\\Documents\\First Of The Year (Equinox) - Skrillex [OFFICIAL].mp4";
        String videoDestPath = "C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Mitsos\\Videos";
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.copyVideo(sourcePath, videoDestPath);
        assertEquals(expResult, result);
        }
    
    
    /**
     * Test of createFile method, of class NewEntryController.
     */
    @Test
    public void testCreateFile() {
        System.out.println("createFile");
        String title = "Paparounas";
        String text = "wqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwe";
        String destPath = "C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Makis\\Texts\\";
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.createFile(title, text, destPath);
        instance.createFile(title, text, destPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateFile2() {
        System.out.println("createFile2");
        String title = "";
        String text = "wqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwe";
        String destPath = "C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Makis\\Texts\\";
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.createFile(title, text, destPath);
        instance.createFile(title, text, destPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateFile3() {
        System.out.println("createFile3");
        String title = null;
        String text = "wqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwewqeqwe";
        String destPath = "C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Makis\\Texts\\";
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.createFile(title, text, destPath);
        instance.createFile(title, text, destPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateFile4() {
        System.out.println("createFile4");
        String title = null;
        String text = null;
        String destPath = "C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Makis\\Texts\\";
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.createFile(title, text, destPath);
        instance.createFile(title, text, destPath);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testCreateFile5() {
        System.out.println("createFile5");
        String title = "";
        String text = "";
        String destPath = "C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Makis\\Texts\\";
        NewEntryController instance = new NewEntryController();
        boolean expResult = true;
        boolean result = instance.createFile(title, text, destPath);
        instance.createFile(title, text, destPath);
        assertEquals(expResult, result);
    }

}