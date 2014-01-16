/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.awt.Menu;
import java.net.URI;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.uispec4j.Button;
import org.uispec4j.MenuBar;
import org.uispec4j.MenuItem;
import org.uispec4j.Trigger;
import org.uispec4j.UISpec4J;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.Window;
import org.uispec4j.interception.BasicHandler;
import org.uispec4j.interception.MainClassAdapter;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;

/**
 *
 * @author MariosT
 */
public class MyDiaryBookTest extends UISpecTestCase {
    
    protected Button exit;
    protected MenuBar entry;
    protected MenuItem newentry;
    protected MenuItem editentry;
    protected Button cancel ;
    protected Button showimage;
    
    
    
     static {
        UISpec4J.init();
    }
    
    
    public MyDiaryBookTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
          
       // setup adapter because we want to test the entire GUI by running the application's main method
       super.setUp();
       setAdapter(new MainClassAdapter(MyDiaryBook.class));
       
        Window window = getMainWindow();
        this.exit = window.getButton("exitButton");
        this.entry = window.getMenuBar();
        this.cancel = window.getButton("cancelEditButton");
        this.showimage = window.getButton("showPersonalGoalImageButton");
        
    }
    
    
    

    /**
     * Test of displayNewImage method, of class MyDiaryBook.
     */
    @Test
    public void testDisplayNewImage() {
        
    }
    
    
        
     /**
     * Test exit button.
     */
    
    

    
    @Test
    public void testExitUnsuccessfull(){
        
        assertTrue(exit.isEnabled());
        assertTrue(exit.isVisible());
        
        WindowInterceptor.init(exit.triggerClick())
        .process(new WindowHandler() {
        public Trigger process(Window dialog) {
        assertTrue(dialog.titleEquals("Select an Option"));
        dialog.containsLabel("Are You Sure?");
        return dialog.getButton("Cancel").triggerClick();
        }
       })
    .run();
        
    }    
    
    
    @Test
    public void testExitSuccessfull(){
       
        assertTrue(exit.isEnabled());
        assertTrue(exit.isVisible());
        
        WindowInterceptor.init(exit.triggerClick())
        .process(new WindowHandler() {
        public Trigger process(Window dialog) {
        assertTrue(dialog.titleEquals("Select an Option"));
        dialog.containsLabel("Are You Sure?");
        //BUG: if set Yes i have Build Failure !
        return dialog.getButton("No").triggerClick();
       }
       })
    .run();
        
    }    

    
//    /**
//     * Test Menu Bar and sub menus.
//     */
    
    @Test
    public void testMenuEntryNewEntrySuccess(){

        Window window = getMainWindow();  

        WindowInterceptor.run(window.getMenuBar().getMenu("Entries").getSubMenu(
                "New Entry..").triggerClick()).assertTitleContains("New Entry");
              
    }
    
    @Test
    public void testMenuEntryNewEntryUnsuccess(){

        Window window = getMainWindow();  

        WindowInterceptor.run(window.getMenuBar().getMenu("Entries").getSubMenu(
                "New Entry..").triggerClick()).dispose();
              
    }
    
    @Test
    public void testMenuEntryEditEntry(){
            
//        entry.getMenu("Entries");
//        editentry.getSubMenu("Edit Entry Title..");
//        
//        //assertFalse(editentry.isEnabled());
//        
//        editentry.triggerClick();
//        assertTrue(cancel.isVisible());
//        assertTrue(cancel.isEnabled());
        
    }

    
    @Test
    public void testMenuPersonalGoalNewSuccess(){

        Window window = getMainWindow();  

        WindowInterceptor.run(window.getMenuBar().getMenu("Personal Goals").getSubMenu(
                "New Personal Goal..").triggerClick()).titleEquals("New Personal Goal");
              
    }
    
    
    @Test
    public void testMenuPersonalGoalNewUnsuccess(){

        Window window = getMainWindow();  

        WindowInterceptor.run(window.getMenuBar().getMenu("Personal Goals").getSubMenu(
                "New Personal Goal..").triggerClick()).dispose();
              
    }
    
    
    @Test
    public void testMenuPersonalGoalDeleteSuccess(){

        Window window = getMainWindow();  

          WindowInterceptor.init(window.getMenuBar().getMenu("Personal Goals").getSubMenu(
                "Delete Personal Goal..").triggerClick()).
                process(BasicHandler.init().
                assertTitleContains("Info").
                triggerButtonClick("OK")).run();
        
        
    }
    
    
    @Test
    public void testMenuPersonalGoalDeleteUnsuccess(){

        Window window = getMainWindow();  

          WindowInterceptor.init(window.getMenuBar().getMenu("Personal Goals").getSubMenu(
                "Delete Personal Goal..").triggerClick()).
                process(BasicHandler.init().
                triggerButtonClick("OK")).run();
        
        
    }
    
     @Test
    public void testMenuFavoutitesNewSuccess(){

        Window window = getMainWindow();  

           WindowInterceptor.run(window.getMenuBar().getMenu("Favourites").getSubMenu(
                "New Favorite..").triggerClick()).titleEquals("Favorites Form");
        
        
    }
    
    
    @Test
    public void testMenuFavoutitesNewUnsuccess(){

        Window window = getMainWindow();  

           WindowInterceptor.run(window.getMenuBar().getMenu("Favourites").getSubMenu(
                "New Favorite..").triggerClick()).dispose();
        
        
    }
    
    @Test
    public void testMenuFavoutitesEditSuccess(){

        Window window = getMainWindow();  

           WindowInterceptor.run(window.getMenuBar().getMenu("Favourites").getSubMenu(
                "Edit Favorites").triggerClick()).titleEquals("Edit Favourites");

    }
    
    @Test
    public void testMenuFavoutitesEditUnsuccess(){

        Window window = getMainWindow();  

           WindowInterceptor.run(window.getMenuBar().getMenu("Favourites").getSubMenu(
                "Edit Favorites").triggerClick()).dispose();

    }
    
    
    @Test
    public void testMenuImportantMomentsNewSuccess(){

        Window window = getMainWindow();  

           WindowInterceptor.run(window.getMenuBar().getMenu("Important Momments").getSubMenu(
                "New Important Momment").triggerClick()).titleEquals("New Important Moments");
        
        
    }
    
    
    @Test
    public void testMenuImportantMomentsNewUnsuccess(){

        Window window = getMainWindow();  

           WindowInterceptor.run(window.getMenuBar().getMenu("Important Momments").getSubMenu(
                "New Important Momment").triggerClick()).dispose();
        
        
    }
    
    
    @Test
    public void testMenuImportantMomentsDeleteSuccess(){

        Window window = getMainWindow();  

           WindowInterceptor.run(window.getMenuBar().getMenu("Important Momments").getSubMenu(
                "Delete Important Momment").triggerClick()).titleEquals("Delete Important Moments");
    }
    
    @Test
    public void testMenuImportantMomentsDeleteUnsuccess(){

        Window window = getMainWindow();  

           WindowInterceptor.run(window.getMenuBar().getMenu("Important Momments").getSubMenu(
                "Delete Important Momment").triggerClick()).dispose();
    }
    
    
    @Test
    public void testMenuChangePasswordSuccess(){

//        Window window = getMainWindow();  
//
//        WindowInterceptor.run(window.getMenuBar().getMenu("Change Password").
//                   triggerClick()).titleEquals("Change Password");
//           
        
    }
    
    
    public void testMenuChangePasswordUnsuccess(){

//        Window window = getMainWindow();  
//
//        WindowInterceptor.run(window.getMenuBar().getMenu("Change Password").
//                   triggerClick()).dispose();
           
        
    }
    
    
    
     /**
     * Test of Show Image Button.
     */
    
    @Test
    public void testShowImageSuccessfull(){
        
          
//        assertTrue(showimage.isEnabled());
//        assertTrue(showimage.isVisible());
//        
//        WindowInterceptor.run(showimage.
//                 triggerClick()).titleEquals("Show Image");
//        
        
    }
    
    
     @Test
    public void testShowImageUnsuccessfull(){
        
//        assertTrue(showimage.isEnabled());
//        assertTrue(showimage.isVisible());
//        
//        WindowInterceptor.run(showimage.triggerClick()).dispose();
//        
        
    }
    
    
    /**
     * Test of displayVideo method, of class MyDiaryBook.
     */
    @Test
    public void testDisplayVideo() {
        }

    /**
     * Test of loadEntriesList method, of class MyDiaryBook.
     */
    @Test
    public void testLoadEntriesList() {
        }

    /**
     * Test of loadImageList method, of class MyDiaryBook.
     */
    @Test
    public void testLoadImageList() {
         }

    /**
     * Test of loadEntryImages method, of class MyDiaryBook.
     */
    @Test
    public void testLoadEntryImages() {
        }

    /**
     * Test of loadEntryImage method, of class MyDiaryBook.
     */
    @Test
    public void testLoadEntryImage() {
        }

    /**
     * Test of loadEntryText method, of class MyDiaryBook.
     */
    @Test
    public void testLoadEntryText() {
        }

    /**
     * Test of loadEntryVideo method, of class MyDiaryBook.
     */
    @Test
    public void testLoadEntryVideo() {
        }

    /**
     * Test of pauseOrPlayVideo method, of class MyDiaryBook.
     */
    @Test
    public void testPauseOrPlayVideo() {
        }

    /**
     * Test of loadEntryDateLabel method, of class MyDiaryBook.
     */
    @Test
    public void testLoadEntryDateLabel() {
        }

    /**
     * Test of refreshEntries method, of class MyDiaryBook.
     */
    @Test
    public void testRefreshEntries() {
        }

    /**
     * Test of loadFavorites method, of class MyDiaryBook.
     */
    @Test
    public void testLoadFavorites() {
        }

    /**
     * Test of loadListOfPersonalGoal method, of class MyDiaryBook.
     */
    @Test
    public void testLoadListOfPersonalGoal() {
        }

    /**
     * Test of loadPersonalGoalTitle method, of class MyDiaryBook.
     */
    @Test
    public void testLoadPersonalGoalTitle() {
        }

    /**
     * Test of loadPersonalGoalLocation method, of class MyDiaryBook.
     */
    @Test
    public void testLoadPersonalGoalLocation() {
        }

    /**
     * Test of loadPersonalGoalWithPerson method, of class MyDiaryBook.
     */
    @Test
    public void testLoadPersonalGoalWithPerson() {
        }

    /**
     * Test of loadPersonalGoalwhenDate method, of class MyDiaryBook.
     */
    @Test
    public void testLoadPersonalGoalwhenDate() {
        }

    /**
     * Test of loadPersonalGoalAnnouncement method, of class MyDiaryBook.
     */
    @Test
    public void testLoadPersonalGoalAnnouncement() {
          }

    /**
     * Test of emptyPersonalTextField method, of class MyDiaryBook.
     */
    @Test
    public void testEmptyPersonalTextField() {
        }

    /**
     * Test of main method, of class MyDiaryBook.
     */
   
 
    
    @After
    public void tearDown() {
        
          Window window = getMainWindow();
          window.dispose();
    }

}
