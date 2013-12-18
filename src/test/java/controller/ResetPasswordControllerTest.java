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
public class ResetPasswordControllerTest extends TestCase {
    
    public ResetPasswordControllerTest(String testName) {
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
     * Test of ResetPasswordController method, of class ResetPasswordController.
     */
    public void testResetPasswordController() {
        System.out.println("ResetPasswordController");
        String q1 = "g";
        String q2 = "g";
        ResetPasswordController instance = new ResetPasswordController();
        boolean expResult = false;
        boolean result = instance.ResetPasswordController(q1, q2);
        assertEquals(expResult, result);
  
    }
     public void testResetPasswordController1() {
        System.out.println("ResetPasswordController");
        String q1 = "gata";
        String q2 = "g";
        ResetPasswordController instance = new ResetPasswordController();
        boolean expResult = false;
        boolean result = instance.ResetPasswordController(q1, q2);
        assertEquals(expResult, result);
  
    }
       public void testResetPasswordController2() {
        System.out.println("ResetPasswordController");
        String q1 = "g";
        String q2 = "fiat";
        ResetPasswordController instance = new ResetPasswordController();
        boolean expResult = false;
        boolean result = instance.ResetPasswordController(q1, q2);
        assertEquals(expResult, result);
  
    }
         public void testResetPasswordController3() {
        System.out.println("ResetPasswordController");
        String q1 = "gata";
        String q2 = "fiat";
        ResetPasswordController instance = new ResetPasswordController();
        boolean expResult = true;
        boolean result = instance.ResetPasswordController(q1, q2);
        assertEquals(expResult, result);
  
    }
        
       public void testResetPasswordController4() {
        System.out.println("ResetPasswordController");
        String q1 = "miapoluomorfhgatapouthhnagapopolu";
        String q2 = "fiat";
        ResetPasswordController instance = new ResetPasswordController();
        boolean expResult = false;
        boolean result = instance.ResetPasswordController(q1, q2);
        assertEquals(expResult, result);
  
    }
        public void testResetPasswordController5() {
        System.out.println("ResetPasswordController");
        String q1 = "gata";
        String q2 = "enaparapolygrhgorofiat";
        ResetPasswordController instance = new ResetPasswordController();
        boolean expResult = false;
        boolean result = instance.ResetPasswordController(q1, q2);
        assertEquals(expResult, result);
  
    }
         public void testResetPasswordController6() {
        System.out.println("ResetPasswordController");
        String q1 = "!h gata mou!";
        String q2 = "!to toyota moy!";
        ResetPasswordController instance = new ResetPasswordController();
        boolean expResult = true;
        boolean result = instance.ResetPasswordController(q1, q2);
        assertEquals(expResult, result);
  
    }    
         public void testResetPasswordController7() {
        System.out.println("ResetPasswordController");
        String q1 = "gata3";
        String q2 = "ferrari4";
        ResetPasswordController instance = new ResetPasswordController();
        boolean expResult = true;
        boolean result = instance.ResetPasswordController(q1, q2);
        assertEquals(expResult, result);
  
    }




    
}
