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
public class TitleValidatorTest {

    public TitleValidatorTest() {
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
     * Test of titleIsValid method, of class TitleValidator.
     */
    @Test
    public void testTitleIsValidSuccess() {
        System.out.println("testTitleIsValidSuccess");
        String Title = "alex";
        TitleValidator instance = new TitleValidator();
        boolean expResult = true;
        boolean result = instance.titleIsValid(Title);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of titleIsValid method, of class TitleValidator.
     */
    @Test
    public void testTitleIsValidNull() {
        System.out.println("testTitleIsValidNull");
        String Title = "";
        TitleValidator instance = new TitleValidator();
        boolean expResult = false;
        boolean result = instance.titleIsValid(Title);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of titleIsValid method, of class TitleValidator.
     */
    @Test
    public void testTitleIsValidNullSpace() {
        System.out.println("testTitleIsValidNullSpace");
        String Title = "      ";
        TitleValidator instance = new TitleValidator();
        boolean expResult = false;
        boolean result = instance.titleIsValid(Title);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of titleIsValid method, of class TitleValidator.
     */
    @Test
    public void testTitleIsValidLesserTheThreeCharacter() {
        System.out.println("testTitleIsValidLesserTheThreeCharacter");
        String Title = "--";
        TitleValidator instance = new TitleValidator();
        boolean expResult = false;
        boolean result = instance.titleIsValid(Title);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of titleIsValid method, of class TitleValidator.
     */
    @Test
    public void testTitleIsValidCharactersGreaterThanTheTwentyFiveCharacters() {
        System.out.println("testTitleIsValidCharactersGreaterThanTheTwentyFiveCharacters");
        String Title = "asdfghjkloasdfghjkloasdfghjklo";
        TitleValidator instance = new TitleValidator();
        boolean expResult = false;
        boolean result = instance.titleIsValid(Title);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of titleIsValid method, of class TitleValidator.
     */
    @Test
    public void testTitleIsValidLettersAndNumbersBetweenTheThreeAndTwentyFiveCharacters() {
        System.out.println("testTitleIsValidLettersAndNumbersBetweenTheThreeAndTwentyFiveCharacters");
        String Title = "basko vol 5";
        TitleValidator instance = new TitleValidator();
        boolean expResult = true;
        boolean result = instance.titleIsValid(Title);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of titleIsValid method, of class TitleValidator.
     */
    @Test
    public void testTitleIsValidOnlyNumbersBetweenTheThreeAndTwentyFiveCharacters() {
        System.out.println("testTitleIsValidOnlyNumbersBetweenTheThreeAndTwentyFiveCharacters");
        String Title = "12111111111";
        TitleValidator instance = new TitleValidator();
        boolean expResult = false;
        boolean result = instance.titleIsValid(Title);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of titleIsValid method, of class TitleValidator.
     */
    @Test
    public void testTitleIsValidOnlynumbersAboveTheTwentyFiveCharacters() {
        System.out.println("testTitleIsValidOnlynumbersAboveTheTwentyFiveCharacters");
        String Title = "11111111111111111111111111";
        TitleValidator instance = new TitleValidator();
        boolean expResult = false;
        boolean result = instance.titleIsValid(Title);
        Assert.assertEquals(expResult, result);

    }

    /**
     * Test of titleIsValid method, of class TitleValidator.
     */
    @Test
    public void testTitleIsValidOnlynumbersBeloveTheTwentyFiveCharacters() {
        System.out.println("testTitleIsValidOnlynumbersBeloveTheTwentyFiveCharacters");
        String Title = "11";
        TitleValidator instance = new TitleValidator();
        boolean expResult = false;
        boolean result = instance.titleIsValid(Title);
        Assert.assertEquals(expResult, result);

    }

}
