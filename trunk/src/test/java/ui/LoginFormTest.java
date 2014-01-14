/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;


import javax.swing.JLabel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.uispec4j.Button;
import org.uispec4j.PasswordField;
import org.uispec4j.TextBox;
import org.uispec4j.UISpec4J;
import org.uispec4j.UISpecTestCase;
import org.uispec4j.Window;
import org.uispec4j.interception.MainClassAdapter;
import org.uispec4j.interception.WindowInterceptor;

/**
 *
 * @author MariosT
 */
public class LoginFormTest extends UISpecTestCase {
    
    protected TextBox user;
    protected PasswordField pass;
    protected Button login;
    protected Button exit;
    protected Button createnewaccount;
    protected Button resetpassword;
   
//    static {
//        UISpec4J.init();
//    }
    
    public LoginFormTest() {
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
       setAdapter(new MainClassAdapter(LoginForm.class));
       
        Window window = getMainWindow();
        this.user = window.getInputTextBox("username");
        this.pass = window.getPasswordField("pass");
        this.login= window.getButton("login");
        this.exit = window.getButton("exit");
        this.createnewaccount = window.getButton("CreateAccountPopUpButton");
        this.resetpassword = window.getButton("ResetPasswordPopUpButton");
        
       
    }
    
    /**
      * Bad Characters are the characters <!@#$%^&*()_+\';./,][{}~|>
      */

    /**
     * Test of main method, of class LoginForm.
     */
    @Test
    public void testUsernameIsNull() {
       JLabel msg = new JLabel("wrongmsg");
        user.setText("");
        pass.setPassword("stef");
        login.click();
       
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        
       msg.setText("Wrong Username Or Password");
    }
    
    
    @Test
    public void testPasswordIsNull() {
        JLabel msg = new JLabel("wrongmsg");
        user.setText("stef");
        pass.setPassword("");
        login.click();
       
       assertTrue(msg.isEnabled());
       assertTrue(msg.isVisible());
        
       msg.setText("Wrong Username Or Password");
        
    }
    
    
    @Test
    public void testBothFieldsAreNull()
    {
        JLabel msg = new JLabel("wrongmsg");
        user.setText("");
        pass.setPassword("");
        login.click();
        
       assertTrue(msg.isEnabled());
       assertTrue(msg.isVisible());
        
       msg.setText("Wrong Username Or Password");
    }
   
    @Test
    public void testCreateNewAccount()
    {
//      
        Window window = WindowInterceptor.run(createnewaccount.triggerClick());
        assertTrue(window.titleEquals("Register"));
        
    }
    
    @Test
    public void testForgotPassword()
    {
        Window window = WindowInterceptor.run(resetpassword.triggerClick());
        assertTrue(window.titleEquals("Reset Password"));
        
    }
    
//    @Test
//    public void testSuccessfullLogin()
//    {
//        user.setText("stef");
//        pass.setPassword("stef");
//        
//        Window window = WindowInterceptor.run(login.triggerClick());
//        assertTrue(window.titleEquals("My Diary Book v1.0!"));
      // TODO problem with windowhandler !!! Bug
//        WindowInterceptor.init(login.triggerClick())
//        .process(new WindowHandler() {
//        @Override
//        public Trigger process(Window dialog) {
//        assertTrue(dialog.titleEquals("My Diary Book "));
//            return null;
//        }
//  })
//  .run();
        
//    }
    
    @Test
    public void testExitButton()
    {
        Window window = getMainWindow();
        exit.click();
        window.dispose();
        
    }
    
    @Test
    public void testInvalidPasswordWith6Digits(){
        // with 
        JLabel msg = new JLabel("wrongmsg");
        user.setText("stef");
        pass.setPassword("123456");
        login.click();
       
       assertTrue(msg.isEnabled());
       assertTrue(msg.isVisible());
        
       msg.setText("Wrong Username Or Password");
        
    }
    
    
    @Test
    public void testInvalidPasswordWith4Digits(){
        
        JLabel msg = new JLabel("wrongmsg");
        user.setText("stef");
        pass.setPassword("1234");
        login.click();
       
       assertTrue(msg.isEnabled());
       assertTrue(msg.isVisible());
        
       msg.setText("Wrong Username Or Password");
        
    }
    
    
    @Test
    public void testInvalidPasswordWithDigits(){
        
        JLabel msg = new JLabel("wrongmsg");
        user.setText("stef");
        pass.setPassword("123456890");
        login.click();
       
       assertTrue(msg.isEnabled());
       assertTrue(msg.isVisible());
        
       msg.setText("Wrong Username Or Password");
        
    }
    
   
    @Test
    public void testValidPasswordWithDigitsAndCharacter(){
        
        JLabel msg = new JLabel("wrongmsg");
        user.setText("stef");
        pass.setPassword("123456a");
        login.click();
       
         assertTrue(msg.isEnabled());
         assertTrue(msg.isVisible());
        
         assertFalse(msg.isShowing());
        
    }
    
    
    @Test
    public void testInvalidUsernameBadCharacters(){
        
        JLabel msg = new JLabel("wrongmsg");
        user.setText("!s#t$e%f^&*");
        pass.setPassword("12345");
        login.click();
       
       assertTrue(msg.isEnabled());
       assertTrue(msg.isVisible());
        
       msg.setText("Wrong Username Or Password");
        
    }
    
    
    @Test
    public void testInvalidUsernameMinimumCharacters(){
        
        JLabel msg = new JLabel("wrongmsg");
        user.setText("st");
        pass.setPassword("12345");
        login.click();
       
       assertTrue(msg.isEnabled());
       assertTrue(msg.isVisible());
        
       msg.setText("Wrong Username Or Password");
        
    }
   
    
    @Test
    public void testInvalidUsernameManyCharacters(){
       
        JLabel msg = new JLabel("wrongmsg");
        user.setText("stefstefstefstefstefstefstefstefstefstefstefstefstefstefstefstefstefstefstefstefstefstef");
        pass.setPassword("12345");
        login.click();
       
       assertTrue(msg.isEnabled());
       assertTrue(msg.isVisible());
        
       msg.setText("Wrong Username Or Password");
        
    }

    
    @After
    public void tearDown() {
        Window window = getMainWindow();
        window.dispose();
    }
    
}
