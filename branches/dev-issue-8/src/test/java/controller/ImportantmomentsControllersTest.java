/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import controller.ImportantmomentsControllers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kajou
 */
public class ImportantmomentsControllersTest {

    @Test
    public void testcheckLocation() {
        System.out.println("CheckLocation");
        ImportantmomentsControllers instance = new ImportantmomentsControllers();
        assertEquals(true,instance.checkLocation("Athina"));
        assertEquals(false,instance.checkLocation("1"));
    }
    
        public void testcheckTitle() {
        System.out.println("CheckTitle");
        ImportantmomentsControllers instance = new ImportantmomentsControllers();
        assertEquals(true,instance.checkTitle("day 1"));
        assertEquals(false,instance.checkTitle("a"));
    }
    
}
