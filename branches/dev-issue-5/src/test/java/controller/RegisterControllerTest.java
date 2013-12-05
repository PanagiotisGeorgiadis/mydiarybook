/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import junit.framework.TestCase;

/**
 *
 * @author Stef
 */
public class RegisterControllerTest extends TestCase {
    
    public RegisterControllerTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of checkMail method, of class RegisterController.
     */
    public void testCheckMail() {
        System.out.println("checkMail");
        String email = "@yahoo";
        RegisterController instance = new RegisterController();
        boolean expResult = false;
        boolean result = instance.checkMail(email);
        assertEquals(expResult, result);
     
    }
   public void testCheckMail1() {
        System.out.println("checkMail");
        String email = "teiser@";
        RegisterController instance = new RegisterController();
        boolean expResult = false;
        boolean result = instance.checkMail(email);
        assertEquals(expResult, result);
     
    }
      public void testCheckMail2() {
        System.out.println("checkMail");
        String email = "w@y";
        RegisterController instance = new RegisterController();
        boolean expResult = false;
        boolean result = instance.checkMail(email);
        assertEquals(expResult, result);
     
    }
         public void testCheckMail3() {
        System.out.println("checkMail");
        String email = "SVD@yahoo";
        RegisterController instance = new RegisterController();
        boolean expResult = true;
        boolean result = instance.checkMail(email);
        assertEquals(expResult, result);
     
    }
         public void testCheckMail4() {
        System.out.println("checkMail");
        String email = "yahoo";
        RegisterController instance = new RegisterController();
        boolean expResult = false;
        boolean result = instance.checkMail(email);
        assertEquals(expResult, result);
     
    }
          public void testCheckMail5() {
        System.out.println("checkMail");
        String email = "dsdd@@yahoo";
        RegisterController instance = new RegisterController();
        boolean expResult = false;
        boolean result = instance.checkMail(email);
        assertEquals(expResult, result);
     
    }
    /**
     * Test of checkUsername method, of class RegisterController.
     */
    public void testCheckUsername() {
        System.out.println("checkUsername");
        String username = "     ";
        RegisterController instance = new RegisterController();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
  
    }
     public void testCheckUsername1() {
        System.out.println("checkUsername");
        String username = "st";
        RegisterController instance = new RegisterController();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
  
    }
       public void testCheckUsername2() {
        System.out.println("checkUsername");
        String username = "thesuperthedouperthetrooperme";
        RegisterController instance = new RegisterController();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
  
    }
     public void testCheckUsername3() {
        System.out.println("checkUsername");
        String username = "";
        RegisterController instance = new RegisterController();
        boolean expResult = false;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
  
    }
          public void testCheckUsername4() {
        System.out.println("checkUsername");
        String username = "test";
        RegisterController instance = new RegisterController();
        boolean expResult = true;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
  
    }
             public void testCheckUsername5() {
        System.out.println("checkUsername");
        String username = "!succes!";
        RegisterController instance = new RegisterController();
        boolean expResult = true;
        boolean result = instance.checkUsername(username);
        assertEquals(expResult, result);
  
    }
    
    /**
     * Test of checkPassword method, of class RegisterController.
     */
    public void testCheckPassword() {
        System.out.println("checkPassword");
        String password = "1234";
        String repeatedpassword = "1234";
        RegisterController instance = new RegisterController();
        boolean expResult = false;
        boolean result = instance.checkPassword(password, repeatedpassword);
        assertEquals(expResult, result);
  
    }
       public void testCheckPassword1() {
        System.out.println("checkPassword");
        String password = "12";
        String repeatedpassword = "12";
        RegisterController instance = new RegisterController();
        boolean expResult = false;
        boolean result = instance.checkPassword(password, repeatedpassword);
        assertEquals(expResult, result);
  
    }
   public void testCheckPassword3(){
        System.out.println("checkPassword");
        String password = "12341234123412341234123412341234123412341234123412341234";
        String repeatedpassword = "12341234123412341234123412341234123412341234123412341234";
        RegisterController instance = new RegisterController();
        boolean expResult = false;
        boolean result = instance.checkPassword(password, repeatedpassword);
        assertEquals(expResult, result);
  
    }
     public void testCheckPassword4(){
        System.out.println("checkPassword");
        String password = "the best";
        String repeatedpassword = "the best";
        RegisterController instance = new RegisterController();
        boolean expResult = false;
        boolean result = instance.checkPassword(password, repeatedpassword);
        assertEquals(expResult, result);
  
    }
     public void testCheckPassword5(){
        System.out.println("checkPassword");
        String password = "1a2b";
        String repeatedpassword = "1a2c";
        RegisterController instance = new RegisterController();
        boolean expResult = false;
        boolean result = instance.checkPassword(password, repeatedpassword);
        assertEquals(expResult, result);
  
    }
        public void testCheckPassword6(){
        System.out.println("checkPassword");
        String password = "a1234";
        String repeatedpassword = "a1234";
        RegisterController instance = new RegisterController();
        boolean expResult = true;
        boolean result = instance.checkPassword(password, repeatedpassword);
        assertEquals(expResult, result);
  
    }
        public void testCheckPassword7(){
        System.out.println("checkPassword");
        String password = "12a34";
        String repeatedpassword = "12a34";
        RegisterController instance = new RegisterController();
        boolean expResult = true;
        boolean result = instance.checkPassword(password, repeatedpassword);
        assertEquals(expResult, result);
  
    }
        public void testCheckPassword8(){
        System.out.println("checkPassword");
        String password = "1234a";
        String repeatedpassword = "1234a";
        RegisterController instance = new RegisterController();
        boolean expResult = true;
        boolean result = instance.checkPassword(password, repeatedpassword);
        assertEquals(expResult, result);
  
    }
  
}
