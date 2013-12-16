/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

/**
 *
 * @author Stef
 */
public class FavoritesController {
    public boolean checklink(String link)
    {
        if(!link.contains(".")) 
        {        
            return false;
        }
        if(!link.startsWith("http://www.")) {
            return false;
        }
        if(link.indexOf(".")==link.length()-1)
        {
            return false;
        }
        if (link.matches(".*..*..*..*"))
        {
            return false;
          }
        return true;
    }    
}
