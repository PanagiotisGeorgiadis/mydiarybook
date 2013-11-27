/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controllers;

/**
 *
 * @author Kajou
 */
public class ImportantmomentsControllers 

{
    public boolean checkLocation(String location)
    {
        
                if(location.length() > 20 || location.length() <=2) return false;
                return true;
    }
    public boolean checkTitle(String title)
    {
                if(title.length() > 20 || title.length() <=2) return false;
                return true;
    }

    
}
    

