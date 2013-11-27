/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;
import ui.IRegisterForm;
/**
 *
 * @author Stef
 */
public interface IRegister {

    public void  successRegister(IRegisterForm form,String Mail, String Password, String RePassword, String UserName);
    
}
