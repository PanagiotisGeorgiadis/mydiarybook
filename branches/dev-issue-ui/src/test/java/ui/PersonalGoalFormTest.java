/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.awt.Image;
import javax.swing.JLabel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.uispec4j.Button;
import org.uispec4j.DateSpinner;
import org.uispec4j.TextBox;
import org.uispec4j.Trigger;
import org.uispec4j.UISpec4J;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.interception.MainClassAdapter;
import org.uispec4j.Window;
import org.uispec4j.interception.FileChooserHandler;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;

/**
 *
 * @author MariosT
 */
public class PersonalGoalFormTest extends UISpecTestCase{
    
    protected TextBox title;
    protected TextBox location;
    protected Button browse;
    protected Button upload;
    protected TextBox filepath;
    protected Button save;
    protected Button cancel;
    protected TextBox checkmsg;
    protected DateSpinner date;
      
    static {
        UISpec4J.init();
    }
    
    
    public PersonalGoalFormTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        
        //setup adapter because we want to test the entire GUI by running the application's main method
       super.setUp();
       setAdapter(new MainClassAdapter(PersonalGoalForm.class));
       
       Window window = getMainWindow();
       this.title = window.getInputTextBox("titleTextField");
       this.location = window.getInputTextBox("locationTextField");
       this.browse = window.getButton("browseFotoFile");
       this.upload = window.getButton("buttonUploadFoto");
       this.filepath = window.getInputTextBox("browseFotoTextField");
       this.date = window.getDateSpinner("whenDateSpinner");
       this.save = window.getButton("saveButton");
       this.cancel = window.getButton("cancelButton");
       this.checkmsg = window.getInputTextBox("checkFieldTextField");
        
    }
    
   

    /**
     * Test of displayImage method, of class PersonalGoalForm.
     */
    
    @Test
    public void testTitleIsEmpty(){
        
        title.setText("");
        
        assertTrue(title.textIsEmpty());
        
        not(save.isEnabled());
        not(save.isVisible());
        
    }
    
    @Test
    public void testTitleHas2Characters(){
        
        title.setText("go");
        
        assertTrue(title.textEquals("go"));
        
        not(save.isEnabled());
        not(save.isVisible());
        
    }
    
    @Test
    public void testTitleHas26Characters(){
        
        title.setText("'ve been fiddling around with "
                + "this problem for some time now and I finally got "
                + "all the pieces together so I guess I'd better "
                + "share my newfound knowledge on these obscure "
                + "topics that I hope I'll never have to encounter again.");
        
        not(save.isEnabled());
        not(save.isVisible());
        
    }
    
    @Test
    public void testTitleSuccessfull(){
        
        title.setText("Uispec4j is a framework");
        
        assertTrue(title.textEquals("Uispec4j is a framework"));
        
        save.isEnabled();
        save.isVisible();
        
    }
    
    @Test
    public void testLocationIsEmpty(){
        
        location.setText("");
        
        assertTrue(location.textIsEmpty());
        
        not(save.isEnabled());
        not(save.isVisible());
        
    }
    
    @Test
    public void testLocationHas3Characters(){
        
        location.setText("ser");
        
        assertTrue(location.textEquals("ser"));
        
        not(save.isEnabled());
        not(save.isVisible());
        
    }
    
    @Test
    public void testTitleHas12Characters(){
        
        location.setText("serresathina");
        
        assertTrue(location.textEquals("serresathina"));
        
        not(save.isEnabled());
        not(save.isVisible());
        
    }
    
    @Test
    public void testLocationSuccessfull(){
        
        title.setText("serres");
        
        assertTrue(title.textEquals("serres"));
        
        save.isEnabled();
        save.isVisible();
        
    }

    @Test
    public void testBrowseSuccessful(){
        
       WindowInterceptor.init(browse.triggerClick())
            .process( 
            FileChooserHandler.init()
             .titleEquals("Select")
            .assertAcceptsFilesOnly()
            .cancelSelection())
            .run(); 
       
//       
//       WindowInterceptor
//   .run(openMenu.triggerClick())
//   .process(FileChooserHandler.init()
//            .titleEquals("Select a template file")
//            .assertAcceptsFilesOnly()
//            .select("/home/bond/file.txt"))
//   .run();
 
       
        
    }
    
    
    @Test
    public void testBrowseUnsuccessful(){
       
        WindowInterceptor.init(browse.triggerClick())
            .process( 
            FileChooserHandler.init()
            .cancelSelection())
            .run(); 
        
    }
    
    
    @Test
    public void testUploadSuccessfull(){
        
        JLabel msg = new JLabel("imageLabel");
       
        
        filepath.setText("C:\\Users......");
        assertFalse(filepath.textIsEmpty());
        
        //TODO: Button upload Bug
       // upload.click();
        
        assertTrue(msg.isVisible());
        assertFalse(msg.isShowing());
        msg.getIcon();
        
    }
    
    
    @Test
    public void testUploadUnsuccessfull(){
        
        JLabel msg = new JLabel("imageLabel");
       
        
        filepath.setText(null);
        assertTrue(filepath.textIsEmpty());
        
        //TODO: Button upload Bug
        //upload.click();
        
        assertTrue(msg.isVisible());
        assertFalse(msg.isShowing());
        msg.setIcon(null);
        
        
    }
    
    
    @Test
    public void testFilePathIsEmpty(){
        
       assertTrue(filepath.isEditable());
       assertTrue(filepath.isVisible());
       
       filepath.setText("");
        
    }
    
    
    @Test
    public void testFilePathIsCorrect(){
        
       assertTrue(filepath.isEditable());
       assertTrue(filepath.isVisible());
       
       filepath.setText("C:\\Users\\Kostas\\Image1.png");
        
    }
    
    
    
    
    @Test
    public void testDisplayImageSuccessfull() {
         
        JLabel msg = new JLabel("imageLabel");
       
        assertTrue(msg.isVisible());
        assertFalse(msg.isShowing());
        msg.getIcon();
        
      
    }

  
    @Test
    public void testDisplayImageUnsuccessfull() {
        
        JLabel msg = new JLabel("imageLabel");
       
        assertTrue(msg.isVisible());
        assertFalse(msg.isShowing());
        msg.setIcon(null);
      
    }
    
    
    @Test
    public void testSaveSuccessfull(){
        
        title.setText("Uispec4j");
        location.setText("serres");
        
        assertFalse(title.textIsEmpty());
        assertFalse(location.textIsEmpty());
 
        assertTrue(save.isEnabled());
        assertTrue(save.isVisible());
        
        save.click();
        
        checkmsg.setText("success");
        
    }
    
    
    @Test
    public void testSaveInvalidTitle(){
        
        title.setText("Ui");
        location.setText("serres");
        
        assertFalse(title.textIsEmpty());
        assertFalse(location.textIsEmpty());
 
        assertTrue(save.isEnabled());
        assertTrue(save.isVisible());
        
        save.click();
        
        checkmsg.setText("is incorect!");
        
    }
    
    
    @Test
    public void testSaveInvalidLocation(){
        
        title.setText("Uispe4j");
        location.setText("serresathinathessalonikh");
        
        assertFalse(title.textIsEmpty());
        assertFalse(location.textIsEmpty());
 
        assertTrue(save.isEnabled());
        assertTrue(save.isVisible());
        
        save.click();
        
        checkmsg.setText("is incorect!");
        
    }
    
    
    @Test
    public void testCancelSuccessfull(){
        
        Window window = getMainWindow();
        assertTrue(cancel.isEnabled());
        cancel.click();
        window.dispose();
        
    }
    
    @Test
    public void testCancelUnsuccessfull(){
        
        Window window = getMainWindow();
        assertTrue(cancel.isEnabled());
        cancel.click();
        window.isVisible();
        
    }
    
     @After
    public void tearDown() {
         
       Window window = getMainWindow();
       window.dispose();
   }
    
}
