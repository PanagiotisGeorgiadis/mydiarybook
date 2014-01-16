///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package ui;
//
//import javax.swing.JLabel;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//import org.uispec4j.Button;
//import org.uispec4j.TextBox;
//import org.uispec4j.UISpec4J;
//import org.uispec4j.UISpecTestCase;
//import org.uispec4j.Window;
//import org.uispec4j.interception.MainClassAdapter;
//
///**
// *
// * @author MariosT
// */
//public class FavoritesFormTest extends UISpecTestCase{
//      
//    
//      protected TextBox link;
//      protected TextBox comment;
//      protected Button save;
//      protected Button clear;
//      protected Button close;
//
//    
//     static {
//        UISpec4J.init();
//    }
//     
//     
//    public FavoritesFormTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() throws Exception {
//        
//        //super.setUp();
//        setAdapter(new MainClassAdapter(FavoritesForm.class));
//       
//        Window window = getMainWindow();
//        this.link = window.getInputTextBox("link");
//        this.comment = window.getInputTextBox("comment");
//        this.save = window.getButton("save");
//        this.clear = window.getButton("clear");
//        this.close = window.getButton("back");
//        
//    }
//    
//   
//
//    /**
//     * Test of main method, of class FavoritesForm.
//     */
//    @Test
//    public void testIfLinkIsEmpty() {
//        
//          JLabel msg = new JLabel("emptymsg");
//          link.setText("");
//          
//          assertTrue(msg.isEnabled());
//          assertTrue(msg.isVisible());
//          
//          msg.setText("invalid link");
//    }
//    
//
//    @Test
//    public void testIfLinkIsInvalid() {
//        
//          JLabel msg = new JLabel("emptymsg");
//          link.setText("google");
//          
//          assertTrue(msg.isEnabled());
//          assertTrue(msg.isVisible());
//          
//          msg.setText("invalid link");
//    }
//
//   @Test
//    public void testIfLinkIsValid() {
//        
//          JLabel msg = new JLabel("emptymsg");
//          link.setText("https://www.google.gr");
//          
//          assertTrue(msg.isEnabled());
//          assertTrue(msg.isVisible());
//          
//          msg.disable();
//    }
//    
//    @Test
//    public void testIfCommentIsEmpty() {
//        
//          JLabel msg = new JLabel("emptymsg");
//          comment.setText("");
//          
//          assertTrue(msg.isEnabled());
//          assertTrue(msg.isVisible());
//          
//          msg.setText("invalid comment");
//    }
//    
//
//    
//   @Test
//    public void testIfCommentIsValid() {
//        
//          JLabel msg = new JLabel("emptymsg");
//          comment.setText("This site is very interesting");
//          
//          assertTrue(msg.isEnabled());
//          assertTrue(msg.isVisible());
//          
//          msg.disable();
//    }
// 
////    @Test 
////    public void testSuccessfullClose(){
////        
////        Window window = getMainWindow();
////        
////        close.click();
////        assertTrue(close.isVisible());
////        window.dispose();
////         
////    }
//           
//    
////    @Test 
////    public void testUnsuccessfullClose(){
////        
////        Window window = getMainWindow();
////        assertTrue(close.isEnabled());
////        assertTrue(close.isVisible());
////        
////        close.click();
////        
////        window.dispose();
////         
////    }
//    
//    @Test 
//    public void testSuccessfullClear(){
//        
//        link.setText("https://www.google.gr");
//        comment.setText("Is very fast");
//        
//        clear.click();
//        
//        assertTrue(link.textIsEmpty());
//        assertTrue(comment.textIsEmpty());
//        
//    }
//    
//    @Test 
//    public void testUnsuccessfullClear(){
//        
//        link.setText("https://www.google.gr");
//        comment.setText("Is very fast");
//        
//        clear.click();
//        
//        assertFalse(link.textContains("www.google.gr"));
//        assertFalse(comment.textContains("Is very fast"));
//        
//    }
//    
////    @Test
////    public void testSuccessfullSave(){
////        
////        JLabel msg = new JLabel("msg");
////        assertTrue(save.isEnabled());
////        assertTrue(save.isVisible());
////        
////        //TODO: problem with button->save "Uncompilable source code
////        //- incompatible types: try-with-resources not applicable to variable type
////        save.click();
////        
////        
////        assertTrue(msg.isEnabled());
////        assertTrue(msg.isVisible());
////        
////        msg.setText("Link Successfully Saved!");
////    }
//
//    
////    @Test
////    public void testUnuccessfullSave(){
////        
////        JLabel msg = new JLabel("msg");
////        assertTrue(save.isEnabled());
////        assertTrue(save.isVisible());
////        
////        //TODO: problem with button->save "Uncompilable source code
////        //- incompatible types: try-with-resources not applicable to variable type
////        
////        save.click();
////        
////        assertTrue(msg.isEnabled());
////        assertTrue(msg.isVisible());
////        
////        
////        msg.setText("Error Saving Your Link!");
////    }
//     @After
//    public void tearDown() {
//        Window window = getMainWindow();
//        window.dispose();
//        
//    }
//    
//}
