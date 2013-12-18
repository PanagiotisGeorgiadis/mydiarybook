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
public class FavoritesControllerTest {
    
    public FavoritesControllerTest() {
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
     * Test of checklink method, of class FavoritesController.
     */
    @Test
    public void testChecklink() {
        System.out.println("checklink");
        String link = " ";
        FavoritesController instance = new FavoritesController();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
    
    @Test
    public void testChecklink1() {
        System.out.println("checklink");
        String link = "wwwgooglecom";
        FavoritesController instance = new FavoritesController();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
    @Test
    public void testChecklink2() {
        System.out.println("checklink");
        String link = "google.com";
        FavoritesController instance = new FavoritesController();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
@Test
    public void testChecklink3() {
        System.out.println("checklink");
        String link = "http://www.google.com";
        FavoritesController instance = new FavoritesController();
        boolean expResult = true;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
    
    @Test
    public void testChecklink4() {
        System.out.println("checklink");
        String link = ".google.com";
        FavoritesController instance = new FavoritesController();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
      @Test
    public void testChecklink5() {
        System.out.println("checklink");
        String link = "!!!!!!!!!!!";
        FavoritesController instance = new FavoritesController();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
      @Test
    public void testChecklink6() {
        System.out.println("checklink");
        String link = "http://www google.com";
        FavoritesController instance = new FavoritesController();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
          @Test
    public void testChecklink7() {
        System.out.println("checklink");
        String link = "http://www.goo.gle.co.m";
        FavoritesController instance = new FavoritesController();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
     @Test
      public void testChecklink8() {
        System.out.println("checklink");
        String link = "http://www.goo.gle.com";
        FavoritesController instance = new FavoritesController();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
       public void testChecklink9() {
        System.out.println("checklink");
        String link = "http://stackoverflow.com/";
        FavoritesController instance = new FavoritesController();
        boolean expResult = true;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
            public void testChecklink10() {
        System.out.println("checklink");
        String link = "ftp://ftp.teiser.gr/";
        FavoritesController instance = new FavoritesController();
        boolean expResult = true;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
    /**
     * Test of checkValues method, of class FavoritesController.
     */
    @Test
    public void testCheckValues() {
        System.out.println("checkValues");
        String link = "http://www.paok.gr";
        boolean expResult = true;
        boolean result = FavoritesController.checkValues(link);
        assertEquals(expResult, result);
       
    }
    
    
    
}
