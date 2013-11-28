/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import dao.IPersonalGoalDao;
import java.util.ArrayList;
import java.util.List;
import model.PersonalGoalModel;

/**
 * Ένα απλό mock για Failure στο Dao.
 * @author alex
 */
public class MockPersonalGoalDaoFailure implements IPersonalGoalDao {
    
        @Override
        public boolean writeToFilePersonalGoal(PersonalGoalModel pgm){
        return false;
    
   }

   
}

/*



implements IPersonalGoalDao{
    List<PersonalGoalModel> PersonalGoalModel = new ArrayList<PersonalGoalModel>();
    
    @Override
 public boolean writeToFilePersonalGoal(PersonalGoalModel cr){
     PersonalGoalModel.add(cr);
     return false;
 }
*/
