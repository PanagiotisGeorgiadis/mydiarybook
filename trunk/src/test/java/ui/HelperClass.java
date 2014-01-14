/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

import org.uispec4j.UISpec4J;
import org.uispec4j.UISpecTestCase;

/**
 *
 * @author Zarc
 */
public abstract class HelperClass extends UISpecTestCase {

    static {
        UISpec4J.init();
    }
    
}
