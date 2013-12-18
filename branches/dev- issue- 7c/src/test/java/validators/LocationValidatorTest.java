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

/**
 *
 * @author alex
 */
public class LocationValidatorTest {

    public LocationValidatorTest() {
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
     * Test of locationIsValid method, of class LocationValidator.
     */

    @Test
    public void testlocationIsValidSuccess() {
        System.out.println("testlocationIsValidSuccess");
        String Location = "Giannitsa";
        LocationValidator instance = new LocationValidator();
        boolean expResult = true;
        boolean result = instance.locationIsValid(Location);
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of locationIsValid method, of class LocationValidator.
     */
    @Test
    public void testlocationIsValidNull() {
        System.out.println("testlocationIsValidNull");
        String Location = "";
        LocationValidator instance = new LocationValidator();
        boolean expResult = false;
        boolean result = instance.locationIsValid(Location);
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of locationIsValid method, of class LocationValidator.
     */
    @Test
    public void testlocationIsValidNullSpace() {
        System.out.println("testlocationIsValidNullSpace");
        String Location = "   ";
        LocationValidator instance = new LocationValidator();
        boolean expResult = false;
        boolean result = instance.locationIsValid(Location);
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of locationIsValid method, of class LocationValidator.
     */
    @Test
    public void testlocationIsValidLesserTheThreecharacter() {
        System.out.println("testlocationIsValidLesserTheThreecharacter");
        String Location = "--";
        LocationValidator instance = new LocationValidator();
        boolean expResult = false;
        boolean result = instance.locationIsValid(Location);
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of locationIsValid method, of class LocationValidator.
     */
    @Test
    public void testlocationIsValidoneGreaterThanTheTwentyFiveCharacters() {
        System.out.println("testlocationIsValidoneGreaterThanTheTwentyFiveCharacters");
        String Location = "aaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        LocationValidator instance = new LocationValidator();
        boolean expResult = false;
        boolean result = instance.locationIsValid(Location);
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of locationIsValid method, of class LocationValidator.
     */
    @Test
    public void testlocationIsValidLettersAndNumbersBetweenTheThreeAndTwentyFiveCharacters() {
        System.out.println("testlocationIsValidLettersAndNumbersBetweenTheThreeAndTwentyFiveCharacters");
        String Location = "12345678901234567890a2345";
        LocationValidator instance = new LocationValidator();
        boolean expResult = true;
        boolean result = instance.locationIsValid(Location);
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of locationIsValid method, of class LocationValidator.
     */
    @Test
    public void testlocationIsValidOnlyNumbersBetweenTheThreeAndTwentyFiveCharacters() {
        System.out.println("testlocationIsValidOnlyNumbersBetweenTheThreeAndTwentyFiveCharacters");
        String Location = "12345678901234567890a2345";
        LocationValidator instance = new LocationValidator();
        boolean expResult = true;
        boolean result = instance.locationIsValid(Location);
        Assert.assertEquals(expResult, result);
    }

}
