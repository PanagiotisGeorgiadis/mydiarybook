/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.RegisterFormDao;

/**
 *
 * @author Stef
 */
public class CheckUsernameController {
    
   public  boolean usernameExists(String username)
   {
       RegisterFormDao formDao = new RegisterFormDao();
    return  formDao.checkUsername(username);
   }
}
