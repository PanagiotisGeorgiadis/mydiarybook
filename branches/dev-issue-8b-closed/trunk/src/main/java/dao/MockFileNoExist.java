/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.File;

/**
 *
 * @author JohnN'y
 */
public class MockFileNoExist implements IEntriesDao {

        private String textFile = new String("C:\\MyJavaApp\\dev-issu-6\\src\\Controller\\text.txt");

    @Override
    public String getFile() {
        return null;
    }

   

    @Override
    public void setFile(String textFile) {
        this.textFile = textFile;
    }
    
}
