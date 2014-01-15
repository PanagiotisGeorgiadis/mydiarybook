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
public class WithPersonValidatorTest {

    public WithPersonValidatorTest() {
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
     * Test of withPersonIsValid method, of class WithPersonValidator.
     */
    @Test
    public void testWithPersonIsValidSuccess() {
        System.out.println("testWithPersonIsValidSuccess");
        String WithPerson = "Alex";
        WithPersonValidator instance = new WithPersonValidator();
        boolean expResult = true;
        boolean result = instance.withPersonIsValid(WithPerson);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of withPersonIsValid method, of class WithPersonValidator.
     */
    @Test
    public void testWithPersonIsValidWithPersonSuccessNull() {
        System.out.println("testWithPersonIsValidWithPersonSuccessNull");
        String WithPerson = "";
        WithPersonValidator instance = new WithPersonValidator();
        boolean expResult = true;
        boolean result = instance.withPersonIsValid(WithPerson);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of withPersonIsValid method, of class WithPersonValidator.
     */
    @Test
    public void testWithPersonIsValidWithPersonSuccessWithSpaces() {
        System.out.println("testWithPersonIsValidWithPersonSuccessWithSpaces");
        String WithPerson = "    ";
        WithPersonValidator instance = new WithPersonValidator();
        boolean expResult = true;
        boolean result = instance.withPersonIsValid(WithPerson);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of withPersonIsValid method, of class WithPersonValidator.
     */
    @Test
    public void testWithPersonIsValidWithPersonLesserTheThreecharacter() {
        System.out.println("testWithPersonIsValidWithPersonLesserTheThreecharacter");
        String WithPerson = "aa";
        WithPersonValidator instance = new WithPersonValidator();
        boolean expResult = false;
        boolean result = instance.withPersonIsValid(WithPerson);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of withPersonIsValid method, of class WithPersonValidator.
     */
    @Test
    public void testWithPersonIsValidCharactersGreaterThanTheTwentyFiveCharacters() {
        System.out.println("testWithPersonIsValidCharactersGreaterThanTheTwentyFiveCharacters");
        String WithPerson = "testTitleIsValidGreaterThanTheTwentyFiveCharacters";
        WithPersonValidator instance = new WithPersonValidator();
        boolean expResult = false;
        boolean result = instance.withPersonIsValid(WithPerson);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of withPersonIsValid method, of class WithPersonValidator.
     */
    @Test
    public void testWithPersonIsValidLettersAndNumbersBetweenTheThreeAndTwent() {
        System.out.println("testWithPersonIsValidLettersAndNumbersBetweenTheThreeAndTwent");
        String WithPerson = "giannitsa 5";
        WithPersonValidator instance = new WithPersonValidator();
        boolean expResult = false;
        boolean result = instance.withPersonIsValid(WithPerson);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of withPersonIsValid method, of class WithPersonValidator.
     */
    @Test
    public void testWithPersonIsValidOnlyNumbersBetweenTheThreeAndTwentyFiveCharacters() {
        System.out.println("testWithPersonIsValidOnlyNumbersBetweenTheThreeAndTwentyFiveCharacters");
        String WithPerson = "11111";
        WithPersonValidator instance = new WithPersonValidator();
        boolean expResult = false;
        boolean result = instance.withPersonIsValid(WithPerson);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of withPersonIsValid method, of class WithPersonValidator.
     */
    @Test
    public void testWithPersonIsValidOnlynumbersAboveTheTwentyFiveCharacters() {
        System.out.println("testWithPersonIsValidOnlynumbersAboveTheTwentyFiveCharacters");
        String WithPerson = "11111111111111111111111111";
        WithPersonValidator instance = new WithPersonValidator();
        boolean expResult = false;
        boolean result = instance.withPersonIsValid(WithPerson);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of withPersonIsValid method, of class WithPersonValidator.
     */
    @Test
    public void testWithPersonIsValidOnlynumbersBeloveTheTwentyFiveCharacters() {
        System.out.println("testWithPersonIsValidOnlynumbersBeloveTheTwentyFiveCharacters");
        String WithPerson = "11";
        WithPersonValidator instance = new WithPersonValidator();
        boolean expResult = false;
        boolean result = instance.withPersonIsValid(WithPerson);
        Assert.assertEquals(expResult, result);

    }

}
