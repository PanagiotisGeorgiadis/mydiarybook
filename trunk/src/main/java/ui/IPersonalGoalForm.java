/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ui;

/**
 *
 * @author alex
 */
public interface IPersonalGoalForm {

    //FIXME: refactor  σε μια νέα κλάση και να βάλω interface
    // displayErrorMessage εαν υπάρχει κάποιο λάθος.
   public void displayErrorMessage(String errorMessage);

   public  void displaySuccessMessage(String successMessage);
    
}
