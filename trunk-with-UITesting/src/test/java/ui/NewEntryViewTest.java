/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import java.awt.TextArea;
import java.net.URI;
import javax.swing.JLabel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.uispec4j.Button;
import org.uispec4j.Panel;
import org.uispec4j.TextBox;
import org.uispec4j.Trigger;
import org.uispec4j.UISpec4J;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.Window;
import org.uispec4j.interception.FileChooserHandler;
import org.uispec4j.interception.MainClassAdapter;
import org.uispec4j.interception.WindowHandler;
import org.uispec4j.interception.WindowInterceptor;

/**
 *
 * @author MariosT
 */
public class NewEntryViewTest extends UISpecTestCase{
    
    protected Panel text;
    protected TextBox title;
    protected TextBox textarea;
    protected Panel image;
    protected Button chooseimage;
    protected Panel video;
    protected Button choosevideo;
    protected Button previewvideo;
    protected Button pausevideo;
    protected Button stopvideo;
    protected Button submit;
    protected Button cancel;

    
    static {
        UISpec4J.init();
    }
    
    public NewEntryViewTest() {
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
       setAdapter(new MainClassAdapter(NewEntryView.class));
       
       Window window = getMainWindow();
       
       this.text = window.getPanel("textPanel");
       this.title = window.getInputTextBox("titleField");
       this.textarea = window.getInputTextBox("textarea");
       this.image = window.getPanel("imagePanel");
       this.chooseimage = window.getButton("imageChooseButton");
       this.video = window.getPanel("videoPanel");
       this.choosevideo = window.getButton("videoChooseButton");
       this.previewvideo = window.getButton("previewVideoButton");
       this.pausevideo = window.getButton("pauseButton");
       this.stopvideo = window.getButton("stopButton");
       this.submit = window.getButton("submitButton");
       this.cancel = window.getButton("cancelButton");
       
    }
    
   


    /**
     * Test for three panels , text , image , video.
     */
    @Test
    public void testTextPanelSuccessfull(){
        
        assertTrue(text.isEnabled());
        assertTrue(text.isVisible());
        
        text.getTextBox("Entry Title");
       
    }
    
    @Test
    public void testImagePanelSuccessfull(){
        
        assertTrue(image.isEnabled());
        assertTrue(image.isVisible());
        
        chooseimage.textEquals("Choose");
       
    }
    
     @Test
    public void testVideoPanelSuccessfull(){
        
        assertTrue(video.isEnabled());
        assertFalse(video.isVisible());
        
        previewvideo.textEquals("preview");
       
    }
    
     /**
     * Tests for first tab the text tab.
     */
    
    
    @Test 
    public void testTitleSuccessfull(){
        
        assertTrue(title.isEditable());
        assertTrue(title.isVisible());
        
        title.setText("Uispec4j");
        assertFalse(title.textIsEmpty());
        
        assertTrue(title.backgroundEquals("FFFFFF"));
        
    }
    
    @Test 
    public void testTitleUnsuccessfullIsEmpty(){
        
        JLabel msg = new JLabel("entryAlreadyExistsLabel");
        
        assertTrue(title.isEditable());
        assertTrue(title.isVisible());
        
        title.setText("");
        assertTrue(title.textIsEmpty());
        msg.setText("Warning! You Must Feel In An Entry Title!");
        assertTrue(title.backgroundEquals("FFFFFF"));
        
    }
    
    
    @Test 
    public void testTitleUnsuccessfull2Character(){
        
        JLabel msg = new JLabel("entryAlreadyExistsLabel");
        
        assertTrue(title.isEditable());
        assertTrue(title.isVisible());
        
        title.setText("Ui");
        assertFalse(title.textIsEmpty());
        msg.setText("Your Title Must Be Aplhanumeric And Maximum Three Words!");
        assertTrue(title.backgroundEquals("FFFFFF"));
        
    }
    
    
    @Test 
    public void testTitleUnsuccessfullManyCharacter(){
        
        JLabel msg = new JLabel("entryAlreadyExistsLabel");
        
        assertTrue(title.isEditable());
        assertTrue(title.isVisible());
        
        title.setText("UISpec4J is an open source functional "
                + "and/or unit-testing Java library for "
                + "Swing-based Java applications that is focused on simplicity. "
                + "UISpec4J's APIs are designed to hide, as much as possible, "
                + "the complexity of Swing");
        assertFalse(title.textIsEmpty());
        
        msg.setText("Your Title Must Be Aplhanumeric And Maximum Three Words!");
        assertTrue(title.backgroundEquals("FFFFFF"));
        
    }
    
    @Test 
    public void testTitleUnsuccessfullBadCharacter(){
        
        JLabel msg = new JLabel("entryAlreadyExistsLabel");
        assertTrue(title.isEditable());
        assertTrue(title.isVisible());
        
        title.setText("!@#$%^&*(^%$#_|_");
        
        assertFalse(title.textIsEmpty());
        msg.setText("Your Title Must Be Aplhanumeric And Maximum Three Words!");
        assertTrue(title.backgroundEquals("FFFFFF"));
        
    }
    
    
    @Test 
    public void testTitleUnsuccessfullTitleExist(){
        
        JLabel msg = new JLabel("entryAlreadyExistsLabel");
        
        assertTrue(title.isEditable());
        assertTrue(title.isVisible());
        
        title.setText("Uispec4j");
        textarea.setText("UISpec4J is an open source functional "
                + "and/or unit-testing Java library for "
                + "Swing-based Java applications that is focused on simplicity. "
                + "UISpec4J's APIs are designed to hide, as much as possible, "
                + "the complexity of Swing");
        
        assertFalse(title.textIsEmpty());
        assertFalse(textarea.textIsEmpty());
        assertTrue(title.textEquals("Uispec4j"));
        
        assertTrue(submit.isEnabled());
        assertTrue(submit.isVisible());
        
        
        submit.triggerClick();
        assertTrue(msg.isVisible());
        assertFalse(msg.isShowing());
        
        msg.setText("Warning! An Entry With This Title Already Exists!");

        assertTrue(title.backgroundEquals("FFFFFF"));


//        WindowInterceptor.init(submit.triggerClick())
//        .process(new WindowHandler() {
//        public Trigger process(Window dialog) {
//        assertTrue(dialog.titleEquals("Duplicate Entry Found!"));
//        dialog.containsLabel("Do You Want To Overwrite it?");
//        return dialog.getButton("Yes").triggerClick();
//        }
//        })
//        .run();
        

        
    }
    
    @Test 
    public void testTextAreaSuccessfull(){
        
        assertTrue(textarea.isEditable());
        assertTrue(textarea.isVisible());
        
        textarea.setText("UISpec4J is an open source functional "
                + "and/or unit-testing Java library for "
                + "Swing-based Java applications that is focused on simplicity. "
                + "UISpec4J's APIs are designed to hide, as much as possible, "
                + "the complexity of Swing");
        
       assertFalse(textarea.textIsEmpty()); 
        
    }
    

    @Test 
    public void testTextAreaUnsuccessfullIsEmpty(){
        
        assertTrue(textarea.isEditable());
        assertTrue(textarea.isVisible());
        
        textarea.setText("");
        
       assertTrue(textarea.textIsEmpty()); 
        
    }
    
    
    /**
     * Tests for second tab the image tab.
     */
    
    
    @Test
    public void testChooseImageSuccssfull(){
        
        JLabel msg = new JLabel("imagesLeftLabel");
        
        assertTrue(chooseimage.isEnabled());
        assertTrue(chooseimage.isVisible());
        
        WindowInterceptor.init(chooseimage.triggerClick())
            .process( 
            FileChooserHandler.init()
             .titleEquals("Open")
            .assertAcceptsFilesOnly()
            .cancelSelection())
            .run(); 
        
         assertTrue(image.isEnabled());
         assertTrue(image.isVisible());
         
         image.getLabel();
         
         msg.isShowing();
         msg.isValid();
    }
            
    
    @Test
    public void testChooseImageUnsuccessful(){
        
        JLabel msg = new JLabel("imagesLeftLabel");
        
        assertTrue(chooseimage.isEnabled());
        assertTrue(chooseimage.isVisible());
        
         WindowInterceptor.init(chooseimage.triggerClick())
            .process( 
            FileChooserHandler.init()
            .cancelSelection())
            .run(); 
         
         assertTrue(image.isEnabled());
         assertTrue(image.isVisible());
         
          msg.isShowing();
          msg.isValid();
         
    }
    
    
    
    
    
      /**
     * Tests for third tab the video tab.
     */
    
    
    @Test
    public void testChooseVideoSuccessfull(){
        
         assertTrue(choosevideo.isEnabled());
        assertTrue(choosevideo.isVisible());
        
        WindowInterceptor.init(choosevideo.triggerClick())
            .process( 
            FileChooserHandler.init()
             .titleEquals("Open")
            .assertAcceptsFilesOnly()
            .cancelSelection())
            .run(); 

        assertTrue(previewvideo.isEnabled());
        assertTrue(previewvideo.isVisible());
        assertTrue(previewvideo.textEquals("Preview"));
        
        
    }
    
    
    @Test
    public void testChooseVideoUnsuccessfull(){
        
         assertTrue(choosevideo.isEnabled());
        assertTrue(choosevideo.isVisible());
        
        WindowInterceptor.init(choosevideo.triggerClick())
             .process( 
            FileChooserHandler.init()
            .cancelSelection())
            .run();

        assertTrue(previewvideo.isEnabled());
        assertTrue(previewvideo.isVisible());
     
        
    }
    
    
    @Test
    public void testPreviewVideoSuccessfull(){
       
        assertTrue(previewvideo.isEnabled());
        assertTrue(previewvideo.isVisible());
        
        previewvideo.triggerClick();
        
        assertTrue(pausevideo.isEnabled());
        assertTrue(stopvideo.isEnabled());
        
    }
    
    
     @Test
    public void testPreviewVideoUnsuccessfull(){
       
        assertTrue(previewvideo.isEnabled());
        assertTrue(previewvideo.isVisible());
        
        previewvideo.triggerClick();
        
        assertTrue(pausevideo.isEnabled());
        assertTrue(stopvideo.isEnabled());
        
    }
    
     /**
     * Tests button in form .
     */
    
    @Test
    public void testSubmitSuccessfull(){
        
        assertTrue(title.isEditable());
        title.setText("Uispec4j");
        assertTrue(textarea.isEditable());
        textarea.setText("UISpec4J is an open source functional "
                + "and/or unit-testing Java library for "
                + "Swing-based Java applications that is focused on simplicity. "
                + "UISpec4J's APIs are designed to hide, as much as possible, "
                + "the complexity of Swing, resulting in easy-to-write and "
                + "easy-to-read test scripts.");
        
        assertTrue(submit.isEnabled());
        assertTrue(submit.isVisible());
        
        submit.triggerClick();
        
    }

    
    @Test
    public void testSubmitUnsuccessfullTextAreaIsEmpty(){
        
        JLabel msg = new JLabel("entryAlreadyExistsLabel");
        
        assertTrue(title.isEditable());
        title.setText("Uispec4j");
        assertTrue(textarea.isEditable());
        textarea.setText("");
        
        assertTrue(textarea.textIsEmpty());
        assertTrue(submit.isEnabled());
        assertTrue(submit.isVisible());
        
        msg.setText("Sorry, you can't submit a null Entry!");
        
    }
    
    
    @Test
    public void testSubmitUnsuccessfullTitleIsEmpty(){
        
        JLabel msg = new JLabel("entryAlreadyExistsLabel");
        
        assertTrue(title.isEditable());
        title.setText("");
        assertTrue(textarea.isEditable());
        textarea.setText("UISpec4J is an open source functional "
                + "and/or unit-testing Java library for "
                + "Swing-based Java applications that is focused on simplicity. "
                + "UISpec4J's APIs are designed to hide, as much as possible, "
                + "the complexity of Swing, resulting in easy-to-write and "
                + "easy-to-read test scripts.");
        
        assertTrue(title.textIsEmpty());
        assertTrue(submit.isEnabled());
        assertTrue(submit.isVisible());
        
        msg.setText("Warning! You Must Feel In An Entry Title!");
        
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
