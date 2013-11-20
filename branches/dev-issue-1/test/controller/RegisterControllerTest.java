/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import controller.RegisterController;
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
public class  RegisterControllerTest {
    
    public  RegisterControllerTest() {
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
     * Test of checkMail method, of class RegisterController.
     */
    @Test
    public void testCheckMail() {
        System.out.println("checkMail");
         RegisterController instance = new  RegisterController();
        assertEquals(true,instance.checkMail("1234@gmail.com"));
        assertEquals(false,instance.checkMail("@"));
        assertEquals(false,instance.checkMail("pr1nc3@"));
        assertEquals(false,instance.checkMail("pr1nc3"));
        assertEquals(false,instance.checkMail("@yahoo.gr"));
    }


    /**
     * Test of checkUsername method, of class  RegisterController.
     */
    @Test
       public void testCheckUsername() {
        System.out.println("checkUsername");
         RegisterController instance = new  RegisterController();
        assertEquals(true,instance.checkUsername("pr1nc3"));
        assertEquals(false,instance.checkUsername("pr1nc3pr1nc3pr1nc3pr1nc3"));
        assertEquals(false,instance.checkUsername(""));
    }


    /**
     * Test of checkPassword method, of class  RegisterController.
     */
    @Test
       public void testCheckPassword() {
        System.out.println("checkPassword");
        RegisterController instance = new  RegisterController();
        assertEquals(true,instance.checkPassword("1234", "1234"));
        assertEquals(false,instance.checkPassword("1234", "12345"));
        assertEquals(false,instance.checkPassword("222222222222", "222222222222"));
        assertEquals(false,instance.checkPassword("1", "1"));
    }

    
}

