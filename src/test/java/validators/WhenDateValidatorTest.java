/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package validators;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alex
 */
public class WhenDateValidatorTest {
    
    public WhenDateValidatorTest() {
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
     * Test of whenDateIsValid method, of class WhenDateValidator.
     */
    @Test
    public void testWhenDateIsValidSuccess() {
        System.out.println("testWhenDateIsValidSuccess");
        String whenDate = "27/08/1991";
        WhenDateValidator instance = new WhenDateValidator();
        boolean expResult = true;
        boolean result = instance.whenDateIsValid(whenDate);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of whenDateIsValid method, of class WhenDateValidator.
     */
    @Test
    public void testWhenDateIsValidNull() {
        System.out.println("testWhenDateIsValidNull");
        String whenDate = "";
        WhenDateValidator instance = new WhenDateValidator();
        boolean expResult = false;
        boolean result = instance.whenDateIsValid(whenDate);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of whenDateIsValid method, of class WhenDateValidator.
     */
    @Test
    public void testWhenDateIsValidNullSpaces() {
        System.out.println("testWhenDateIsValidNullSpaces");
        String whenDate = "   ";
        WhenDateValidator instance = new WhenDateValidator();
        boolean expResult = false;
        boolean result = instance.whenDateIsValid(whenDate);
        Assert.assertEquals(expResult, result);

    }

}
