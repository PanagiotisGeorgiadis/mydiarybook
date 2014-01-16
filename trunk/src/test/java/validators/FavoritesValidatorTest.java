/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validators;

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
public class FavoritesValidatorTest {
    
    public FavoritesValidatorTest() {
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
        FavoritesValidator instance = new FavoritesValidator();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
    
    @Test
    public void testChecklink1() {
        System.out.println("checklink");
        String link = "wwwgooglecom";
        FavoritesValidator instance = new FavoritesValidator();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
    @Test
    public void testChecklink2() {
        System.out.println("checklink");
        String link = "google.com";
        FavoritesValidator instance = new FavoritesValidator();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
@Test
    public void testChecklink3() {
        System.out.println("checklink");
        String link = "http://www.google.com";
        FavoritesValidator instance = new FavoritesValidator();
        boolean expResult = true;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
    
    @Test
    public void testChecklink4() {
        System.out.println("checklink");
        String link = ".google.com";
        FavoritesValidator instance = new FavoritesValidator();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
      @Test
    public void testChecklink5() {
        System.out.println("checklink");
        String link = "!!!!!!!!!!!";
        FavoritesValidator instance = new FavoritesValidator();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
      @Test
    public void testChecklink6() {
        System.out.println("checklink");
        String link = "http://www google.com";
        FavoritesValidator instance = new FavoritesValidator();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
          @Test
    public void testChecklink7() {
        System.out.println("checklink");
        String link = "http://www.goo.gle.co.m";
        FavoritesValidator instance = new FavoritesValidator();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
     @Test
      public void testChecklink8() {
        System.out.println("checklink");
        String link = "http://www.goo.gle.com";
        FavoritesValidator instance = new FavoritesValidator();
        boolean expResult = false;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
       public void testChecklink9() {
        System.out.println("checklink");
        String link = "http://stackoverflow.com/";
        FavoritesValidator instance = new FavoritesValidator();
        boolean expResult = true;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }
            public void testChecklink10() {
        System.out.println("checklink");
        String link = "ftp://ftp.teiser.gr/";
        FavoritesValidator instance = new FavoritesValidator();
        boolean expResult = true;
        boolean result = instance.checklink(link);
        assertEquals(expResult, result);
      
    }

    
    
    
}
