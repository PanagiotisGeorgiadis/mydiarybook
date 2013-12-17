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
public class CheckFavoritesController {
    public boolean checklinl(String link)
    {
        FavoritesController linkController= new FavoritesController();
        
        return  linkController.checklink(link);
    }
    
    
}
