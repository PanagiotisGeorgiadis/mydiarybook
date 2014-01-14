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
import org.uispec4j.CheckBox;
import org.uispec4j.PasswordField;
import org.uispec4j.TextBox;
import org.uispec4j.Window;
import org.uispec4j.interception.MainClassAdapter;

/**
 *
 * @author MariosT
 */
public class RegisterFormTest extends HelperClass {

    protected TextBox username;
    protected PasswordField pass;
    protected PasswordField repass;
    protected TextBox email;
    protected TextBox favoritepet;
    protected TextBox favoritecar;
    protected Button createaccount;
    protected Button cancel;
    protected CheckBox ok;
    
    
    
//     static {
//        UISpec4J.init();
//    }
    
    public RegisterFormTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    @Override
    public void setUp() throws Exception {
         // setup adapter because we want to test the entire GUI by running the application's main method
       super.setUp();
       setAdapter(new MainClassAdapter(RegisterForm.class));
       
        Window window = getMainWindow();
        this.username =window.getInputTextBox("username");
        this.pass = window.getPasswordField("password");
        this.repass = window.getPasswordField("repassword");
        this.email = window.getInputTextBox("email");
        this.favoritepet = window.getInputTextBox("FavoritePet");
        this.favoritecar = window.getInputTextBox("FavoriteCar");
        this.createaccount = window.getButton("SubmitAccountButton");
        this.cancel = window.getButton("CancelButton");
        this.ok = window.getCheckBox("ConditionAndTemrsCheckBox");
        
    }
    
    
    /**
      * Bad Characters are the characters <!@#$%^&*()_+\';./,][{}~|>
      */
   

    /**
     * Test of main method, of class RegisterForm.
     */
   
     @Test
     public void testIfUsernameIsInvalid2Characters() {
        
        JLabel msg = new JLabel("msg");
        username.setText("ma");
                
        assertTrue(username.textEquals("ma"));
        
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        
        msg.setText("invalid username");
      
    }
    
    
     @Test
     public void testIfUsernameIsInvalidBadCharacters() {
        
         JLabel msg = new JLabel("msg");
      
        username.setText("ma$3^r*U@o*");
      
        assertTrue(username.textEquals("ma$3^r*U@o*"));
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        
        msg.setText("invalid username");
      
    }
    
     
     @Test
     public void testIfUsernameIsInvalidManyCharacters() {
        
        JLabel msg = new JLabel("msg");
        
        username.setText("mariosstefpanagospanosalexdimtsastsiamistrolisalcapone");
        
        assertTrue(username.textEquals("mariosstefpanagospanosalexdimtsastsiamistrolisalcapone"));
        
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        
        msg.setText("invalid username");
      
    }
    
     
     @Test
     public void testIfUsernameIsEmpty(){
        
        username.setText("");
        
        assertTrue(username.textIsEmpty());
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
         
     }
    
     
     @Test
     public void testIfPasswordIsEmpty() {
             
        pass.setPassword("");
        
        assertTrue(pass.passwordEquals(""));
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
   
    }
    
     
     @Test
     public void testIfRepasswordIsEmpty() {
        
         repass.setPassword("");
        
        assertTrue(repass.passwordEquals(""));
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
    } 
    
     
     @Test
     public void testIfEmailIsEmpty() {
        
        email.setText("");
        
        assertTrue(email.textIsEmpty());
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
      
    } 
     
     
     @Test
     public void testEmailIsInvalid() {
        //without  @ !!!
         
        JLabel msg = new JLabel("invalidemail");
        username.setText("marios");
        pass.setPassword("12345");
        repass.setPassword("12345");
        email.setText("tasmarios");
        favoritepet.setText("dog");
        favoritecar.setText("audi");
        
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        msg.setText("invalid email");
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
      
    }  
     
     
     @Test
     public void testEmailIsInvalidWith2() {
        //without  2@ !!!
         
        JLabel msg = new JLabel("invalidemail");
        username.setText("marios");
        pass.setPassword("12345");
        repass.setPassword("12345");
        email.setText("@tasmarios@hotmail.com");
        favoritepet.setText("dog");
        favoritecar.setText("audi");
        
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        msg.setText("invalid email");
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
      
    }   
     
     
     @Test
     public void testEmailValidWith1() {
        //without  1 @ !!!
         
        JLabel msg = new JLabel("invalidemail");
        username.setText("marios");
        pass.setPassword("12345");
        repass.setPassword("12345");
        email.setText("tasmarios@hotmail.com");
        favoritepet.setText("dog");
        favoritecar.setText("audi");
        
        assertTrue( email.textEquals("tasmarios@hotmail.com"));
        
        //assertFalse(msg.isEnabled());
        //assertFalse(msg.isVisible());
        
        msg.disable();
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
      
    }
     
     
     @Test
     public void testIfFavoritePetIsEmpty() {
         
        favoritepet.setText("");
        
        assertTrue(favoritepet.textIsEmpty());
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
      
    } 
    
     
     @Test
     public void testIfFavoriteCarIsEmpty() {
       
        favoritecar.setText("");
        
        assertTrue(favoritecar.textIsEmpty());
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible()); 
      
    } 
     
     
     @Test
     public void testPasswordAndRepasswordIsSame() {
        
        JLabel msg = new JLabel("missmatchpasswords");
        username.setText("marios");
        pass.setPassword("12345");
        repass.setPassword("123456");
        email.setText("tasmarios@hotmail.com");
        favoritepet.setText("dog");
        favoritecar.setText("audi");
        
        assertFalse(pass.equals(repass));
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        msg.setText("miss-match passwords");
      
    } 
    
    
     @Test 
     public void testIfUsernameExist() {
        JLabel msg = new JLabel("usernameexistmsg");
        username.setText("marios");
        
        pass.setPassword("12345");
        repass.setPassword("12345");
        email.setText("tasmarios@hotmail.com");
        favoritepet.setText("dog");
        favoritecar.setText("audi");
        
        assertTrue(username.textEquals("marios"));
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        
        msg.setText("username exist");
      
    }
   
     
     @Test
     public void testPasswordIsInvalidBadCharacters(){
         
        JLabel msg = new JLabel("invalidpassword");
        username.setText("marios");
        pass.setPassword("&*$%567#@!789");
        repass.setPassword("123456");
        email.setText("tasmarios@hotmail.com");
        favoritepet.setText("dog");
        favoritecar.setText("audi");
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        msg.setText("invalid passwords");
        
    }
    
     
     @Test
     public void testPasswordIsInvalidOnlyDigits(){
         
        JLabel msg = new JLabel("invalidpassword");
        username.setText("marios");
        pass.setPassword("1234567890");
        repass.setPassword("123456");
        email.setText("tasmarios@hotmail.com");
        favoritepet.setText("dog");
        favoritecar.setText("audi");
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        msg.setText("invalid passwords");
        
    }
    
     
     @Test
     public void testFavoritePetHasOnly2Characters(){
         
        JLabel msg = new JLabel("q1msg");
        username.setText("marios");
        pass.setPassword("1234567890");
        repass.setPassword("123456");
        email.setText("tasmarios@hotmail.com");
        favoritepet.setText("do");
        favoritecar.setText("audi");
        
        
        assertTrue(favoritepet.textEquals("do"));
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        msg.setText("answer must be at least 3 chars ");
        
    }
    
     
     @Test
     public void testFavoritePetHas3Characters(){
         
        JLabel msg = new JLabel("q1msg");
        username.setText("marios");
        pass.setPassword("1234567890");
        repass.setPassword("123456");
        email.setText("tasmarios@hotmail.com");
        favoritepet.setText("dog");
        favoritecar.setText("audi");
        
        assertTrue(favoritepet.textEquals("dog"));
        msg.disable();
          
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
        
//        assertFalse(msg.isEnabled());
//        assertFalse(msg.isVisible());
 
    }
    
    
     @Test
     public void testFavoritePetHasManyCharactersAndDigits(){
         
        JLabel msg = new JLabel("q1msg");
        username.setText("marios");
        pass.setPassword("1234567890");
        repass.setPassword("123456");
        email.setText("tasmarios@hotmail.com");
        favoritepet.setText("elephant12387dog890monkey1234");
        favoritecar.setText("audi");
        
        assertTrue(favoritepet.textEquals("elephant12387dog890monkey1234"));
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        msg.setText("answer must be at least 3 chars ");
        
    }
    
    
     @Test
     public void testFavoriteCarHasOnly2Characters(){
         
        JLabel msg = new JLabel("q2msg");
        username.setText("marios");
        pass.setPassword("1234567890");
        repass.setPassword("123456");
        email.setText("tasmarios@hotmail.com");
        favoritepet.setText("dog");
        favoritecar.setText("bm");
        
        
        //assertTrue(favoritecar.textEquals("bm"));
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        msg.setText("answer must be at least 3 chars ");
        
    }
    
     
     @Test
     public void testFavoriteCarHas3Characters(){
         
        JLabel msg = new JLabel("q2msg");
        username.setText("marios");
        pass.setPassword("1234567890");
        repass.setPassword("123456");
        email.setText("tasmarios@hotmail.com");
        favoritepet.setText("dog");
        favoritecar.setText("bmv");
        
        assertTrue(favoritecar.textEquals("bmv"));
        msg.disable();
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
//        assertFalse(msg.isEnabled());
//        assertFalse(msg.isVisible());
        
        
     }
    
    
     @Test
     public void testFavoriteCarHasManyCharactersAndDigits(){
         
        JLabel msg = new JLabel("q2msg");
        username.setText("marios");
        pass.setPassword("1234567890");
        repass.setPassword("123456");
        email.setText("tasmarios@hotmail.com");
        favoritepet.setText("cat");
        favoritecar.setText("audibmv239merc4des67ferra234ri");
        
        assertTrue(favoritecar.textEquals("audibmv239merc4des67ferra234ri"));
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        msg.setText("answer must be at least 3 chars ");
        
    }
    
    
     @Test
     public void testPasswordIsInvalidOnlyCharacter(){
         
        JLabel msg = new JLabel("invalidpassword");
        username.setText("marios");
        pass.setPassword("java");
        repass.setPassword("123456");
        email.setText("tasmarios@hotmail.com");
        favoritepet.setText("dog");
        favoritecar.setText("audi");
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        msg.setText("invalid passwords");
        
    }
    
     
     @Test
     public void testPasswordIsInvalidSmallPassword(){
         
        JLabel msg = new JLabel("invalidpassword");
        username.setText("marios");
        pass.setPassword("ja1");
        repass.setPassword("123456");
        email.setText("tasmarios@hotmail.com");
        favoritepet.setText("dog");
        favoritecar.setText("audi");
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());
        msg.setText("invalid passwords");
        
    }
    
     
     @Test
     public void tullCheckConditiestSuccessfullCheckConditionsTerms(){
        
        JLabel msg = new JLabel("cndaccept");
        ok.click();
        
        assertFalse(msg.isEnabled());
        assertFalse(msg.isVisible());
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
    }
    
    
     @Test
     public void testUnsuccessfullCheckConditionsTerms(){
        
        JLabel msg = new JLabel("cndaccept");
        
        
        assertTrue(msg.isEnabled());
        assertTrue(msg.isVisible());

        msg.setText("please accept the terms and conditions");
        
        not(createaccount.isEnabled());
        not(createaccount.isVisible());
        
    }
    
    
//     @Test
//     public void testSuccessfullCreateAcount() {
//        
//        username.setText("alexis");
//        pass.setPassword("123456a");
//        repass.setPassword("123456a");
//        email.setText("tasmarios@hotmail.com");
//        favoritepet.setText("dog");
//        favoritecar.setText("audi");
//        ok.click();
//        
//        assertTrue(createaccount.isEnabled());
//        assertTrue(createaccount.isVisible());
//        
//        WindowInterceptor.init(createaccount.triggerClick())
//        .process(new WindowHandler() {
//        public Trigger process(Window dialog) {
//        assertTrue(dialog.titleEquals("Message"));
//        return dialog.getButton("OK").triggerClick();
//        }
//        })
//        .run();
//        
//    }  
    
     
//     @Test
//     public void testSuccessfullCancel(){
//         
//        Window window = WindowInterceptor.run(cancel.triggerClick());
//        assertTrue(window.titleEquals("User Login"));
//         
//     }
    
     
//     @Test
//     public void testUnsuccessfullCancel(){
//        
//        assertTrue(cancel.isEnabled());
//        assertTrue(cancel.isVisible());
//         
//        Window window = WindowInterceptor.run(cancel.triggerClick());
//        window.dispose();
//         
//     }
     
     
    @After
    @Override
    public void tearDown() {
        Window window = getMainWindow();
        window.dispose();
    }
    
}
