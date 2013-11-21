/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.IOException;
import model.PersonalGoalModel;

/**
 *
 * @author alex
 */
public interface IPersonalGoalDao {

    boolean writeToFilePersonalGoal(PersonalGoalModel pgm) throws IOException;
    
}
