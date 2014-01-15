/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validators;

import junit.framework.TestCase;

/**
 *
 * @author Stef
 */
public class ChangePasswordValidatorTest extends TestCase {

    public ChangePasswordValidatorTest(String testName) {
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
     * Test of checkChangePasswordController method, of class
     * ChangePasswordController.
     */
    public void testCheckChangePasswordValidator() {
        System.out.println("checkChangePasswordController");
        String pass = "1";
        String repeatpass = "1";
        ChangePasswordValidator instance = new ChangePasswordValidator();
        boolean expResult = false;
        boolean result = instance.checkChangePasswordController(pass, repeatpass);
        assertEquals(expResult, result);

    }

    public void testCheckChangePasswordValidator1() {
        System.out.println("checkChangePasswordController");
        String pass = "12";
        String repeatpass = "13";
        ChangePasswordValidator instance = new ChangePasswordValidator();
        boolean expResult = false;
        boolean result = instance.checkChangePasswordController(pass, repeatpass);
        assertEquals(expResult, result);

    }

    public void testCheckChangePasswordValidator2() {
        System.out.println("checkChangePasswordController");
        String pass = "123";
        String repeatpass = "123";
        ChangePasswordValidator instance = new ChangePasswordValidator();
        boolean expResult = false;
        boolean result = instance.checkChangePasswordController(pass, repeatpass);
        assertEquals(expResult, result);

    }

    public void testCheckChangePasswordValidator3() {
        System.out.println("checkChangePasswordController");
        String pass = "123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123";
        String repeatpass = "123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123123";
        ChangePasswordValidator instance = new ChangePasswordValidator();
        boolean expResult = false;
        boolean result = instance.checkChangePasswordController(pass, repeatpass);
        assertEquals(expResult, result);

    }

    public void testCheckChangePasswordValidator4() {
        System.out.println("checkChangePasswordController");
        String pass = "the  best";
        String repeatpass = "the  best";
        ChangePasswordValidator instance = new ChangePasswordValidator();
        boolean expResult = false;
        boolean result = instance.checkChangePasswordController(pass, repeatpass);
        assertEquals(expResult, result);

    }

    public void testCheckChangePasswordValidator5() {
        System.out.println("checkChangePasswordController");
        String pass = "mayname1";
        String repeatpass = "mynme1";
        ChangePasswordValidator instance = new ChangePasswordValidator();
        boolean expResult = false;
        boolean result = instance.checkChangePasswordController(pass, repeatpass);
        assertEquals(expResult, result);

    }

    public void testCheckChangePasswordValidator6() {
        System.out.println("checkChangePasswordController");
        String pass = "myname_1";
        String repeatpass = "myname_1";
        ChangePasswordValidator instance = new ChangePasswordValidator();
        boolean expResult = true;
        boolean result = instance.checkChangePasswordController(pass, repeatpass);
        assertEquals(expResult, result);

    }

    public void testCheckChangePasswordValidator7() {
        System.out.println("checkChangePasswordController");
        String pass = "13p14";
        String repeatpass = "13p14";
        ChangePasswordValidator instance = new ChangePasswordValidator();
        boolean expResult = true;
        boolean result = instance.checkChangePasswordController(pass, repeatpass);
        assertEquals(expResult, result);

    }
}
