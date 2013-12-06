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
public class ChangePasswordControllerTest extends TestCase {
    
    public ChangePasswordControllerTest(String testName) {
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
     * Test of checkChangePasswordController method, of class ChangePasswordController.
     */
    public void testCheckChangePasswordController() {
        System.out.println("checkChangePasswordController");
        String pass = "1";
        String repeatpass = "1";
        ChangePasswordController instance = new ChangePasswordController();
        boolean expResult = false;
        boolean result = instance.checkChangePasswordController(pass, repeatpass);
        assertEquals(expResult, result);
      
    }
    
    
       public void testCheckChangePasswordController1() {
        System.out.println("checkChangePasswordController");
        String pass = "12";
        String repeatpass = "13";
        ChangePasswordController instance = new ChangePasswordController();
        boolean expResult = false;
        boolean result = instance.checkChangePasswordController(pass, repeatpass);
        assertEquals(expResult, result);
      
    }
   public void testCheckChangePasswordController3() {
        System.out.println("checkChangePasswordController");
        String pass = "123";
        String repeatpass = "123";
        ChangePasswordController instance = new ChangePasswordController();
        boolean expResult = false;
        boolean result = instance.checkChangePasswordController(pass, repeatpass);
        assertEquals(expResult, result);
      
    }
   
      public void testCheckChangePasswordController4() {
        System.out.println("checkChangePasswordController");
        String pass = "123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123";
        String repeatpass = "123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123";
        ChangePasswordController instance = new ChangePasswordController();
        boolean expResult = false;
        boolean result = instance.checkChangePasswordController(pass, repeatpass);
        assertEquals(expResult, result);
      
    }
         public void testCheckChangePasswordController5() {
        System.out.println("checkChangePasswordController");
        String pass = "the  best";
        String repeatpass = "the  best";
        ChangePasswordController instance = new ChangePasswordController();
        boolean expResult = false;
        boolean result = instance.checkChangePasswordController(pass, repeatpass);
        assertEquals(expResult, result);
      
    }
          public void testCheckChangePasswordController6() {
        System.out.println("checkChangePasswordController");
        String pass = "mayname1";
        String repeatpass = "mynme1";
        ChangePasswordController instance = new ChangePasswordController();
        boolean expResult = false;
        boolean result = instance.checkChangePasswordController(pass, repeatpass);
        assertEquals(expResult, result);
      
    }
        public void testCheckChangePasswordController7() {
        System.out.println("checkChangePasswordController");
        String pass = "myname_1";
        String repeatpass = "myname_1";
        ChangePasswordController instance = new ChangePasswordController();
        boolean expResult = true;
        boolean result = instance.checkChangePasswordController(pass, repeatpass);
        assertEquals(expResult, result);
      
    }
}
