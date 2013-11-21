/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import model.PersonalGoalModel;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author alex
 */
public class PersonalGoalDaoTest {
    
    public PersonalGoalDaoTest() {
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
     * Test of writeToFilePersonalGoal method, of class PersonalGoalDao.
     */
    @Test
    public void testWriteToFilePersonalGoal() throws Exception {
        System.out.println("writeToFilePersonalGoal");
        PersonalGoalModel pgm = null;
        PersonalGoalDao instance = new PersonalGoalDao();
        boolean expResult = false;
        boolean result = instance.writeToFilePersonalGoal(pgm);
        assertEquals(expResult, result);
       
    }
    
}
