/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import java.nio.file.Path;

/**
 *
 * @author JohnN'y
 */
public interface IDeleteController {
    
    public boolean checkTextExist( Path textPath);
    public void deleteFile(Path textPath);
    
}
