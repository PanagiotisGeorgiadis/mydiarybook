/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author user
 */
public class LoginControllerTest {
    
    public LoginControllerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkUsername method, of class LoginController.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String username = "aqwersdfggfhcxvbsdfgercvfdtgdcfvbaerbvadfrg";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    
    }
    @Test
     public void testCheckUsername1() {
        System.out.println("checkUsername");
        String username = "a";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    
    }
        @Test
       public void testCheckUsername3() {
        System.out.println("checkUsername");
        String username = " ";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    
    }
       @Test
          public void testCheckUsername4() {
        System.out.println("checkUsername");
        String username = "a1s2f3";
        LoginController instance = new LoginController();
        boolean expResult = true;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    
    }
          @Test
            public void testCheckUsername5() {
        System.out.println("checkUsername");
        String username = "pr1nc3";
        LoginController instance = new LoginController();
        boolean expResult = true;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    
    }
          @Test  
          public void testCheckUsername6() {
        System.out.println("checkUsername");
        String username = "6";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    
    }
          @Test
               public void testCheckUsername7() {
        System.out.println("checkUsername");
        String username = "6a";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    
    }
          @Test     
           public void testCheckUsername8() {
        System.out.println("checkUsername");
        String username = "pr1gk1p4 s";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    
    }
           @Test
          public void testCheckUsername9() {
        System.out.println("checkUsername");
        String username = " pr1gk1p4s";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    
    }
          @Test
         public void testCheckUsername10() {
        System.out.println("checkUsername");
        String username = "@pr1nc3";
        LoginController instance = new LoginController();
        boolean expResult = true;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    
    }
         @Test
         public void testCheckUsername11() {
        System.out.println("checkUsername");
        String username = "pr1gk1p4@s";
        LoginController instance = new LoginController();
        boolean expResult = true;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    
    }
         @Test
             public void testCheckUsername12() {
        System.out.println("checkUsername");
        String username = "@ ";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    
    }
       @Test      
       public void testCheckUsername13() {
        System.out.println("checkUsername");
        String username = " @ p r";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    
    }
       @Test
            public void testCheckUsername14() {
        System.out.println("checkUsername");
        String username = "!@#$$%#%";
        LoginController instance = new LoginController();
        boolean expResult = true;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
    
    }
    /**
     * Test of checkPass method, of class LoginController.
     */
    @Test
    public void testCheckPass() {
        System.out.println("checkPass");
        String pass = " ";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkPass(pass);
        assertEquals(expResult, result);
   
    }
    @Test
      public void testCheckPass1() {
        System.out.println("checkPass");
        String pass = " 1";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkPass(pass);
        assertEquals(expResult, result);
   
    }
      @Test
        public void testCheckPass2() {
        System.out.println("checkPass");
        String pass = "12 ";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkPass(pass);
        assertEquals(expResult, result);
   
    }
    @Test
          public void testCheckPass3() {
        System.out.println("checkPass");
        String pass = " 123";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkPass(pass);
        assertEquals(expResult, result);
   
    }
          @Test
         public void testCheckPass4() {
        System.out.println("checkPass");
        String pass = "123";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkPass(pass);
        assertEquals(expResult, result);
   
    }
        
            @Test
         public void testCheckPass5() {
        System.out.println("checkPass");
        String pass = "!@#%$%";
        LoginController instance = new LoginController();
        boolean expResult = true;
        boolean result = instance.checkPass(pass);
        assertEquals(expResult, result);
   
    }
         
            @Test
         public void testCheckPass6() {
        System.out.println("checkPass");
        String pass = "123456";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkPass(pass);
        assertEquals(expResult, result);
   
    }
         
            @Test
         public void testCheckPass7() {
        System.out.println("checkPass");
        String pass = "qwertyt@$";
        LoginController instance = new LoginController();
        boolean expResult = true;
        boolean result = instance.checkPass(pass);
        assertEquals(expResult, result);
   
    }
                 @Test
         public void testCheckPass8() {
        System.out.println("checkPass");
        String pass = "@$";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkPass(pass);
        assertEquals(expResult, result);
   
    }
                 @Test
         public void testCheckPass9() {
        System.out.println("checkPass");
        String pass = "!@$";
        LoginController instance = new LoginController();
        boolean expResult = true;
        boolean result = instance.checkPass(pass);
        assertEquals(expResult, result);
   
    }
                 @Test
         public void testCheckPass10() {
        System.out.println("checkPass");
        String pass = "qwertyt@$dfsjgafdsgnadnfgiaudfngpiuadnfhstfhs";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkPass(pass);
        assertEquals(expResult, result);
   
    }

    /**
     * Test of checkValues method, of class LoginController.
     */
    @Test
    public void testCheckValues() {
        System.out.println("checkValues");
        String username = "stef";
        String pass = "stef";
        LoginController instance = new LoginController();
        boolean expResult = true;
        boolean result = instance.checkValues(username, pass);
        assertEquals(expResult, result);
   
    }
        @Test
    public void testCheckValues1() {
        System.out.println("checkValues");
        String username = "asdf";
        String pass = "asdfasdasdasd";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkValues(username, pass);
        assertEquals(expResult, result);
   
    }
        @Test
    public void testCheckValues2() {
        System.out.println("checkValues");
        String username = "victoras";
        String pass = "1234567789";
        LoginController instance = new LoginController();
        boolean expResult = false;
        boolean result = instance.checkValues(username, pass);
        assertEquals(expResult, result);
   
    }
    
}
