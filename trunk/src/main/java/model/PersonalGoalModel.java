/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.Date;
import javax.swing.JSpinner;

/**
 *
 * @author alex
 */
public class PersonalGoalModel {
    
    private String personalGoalTitle;
    private String personalGoalLocation;
    private String personalGoalWithPerson;
    private String personalGoalWhenDate;
    private String personalGoalAnnouncement;
    private String[] personalGoalList;
    private String personalGoalImage;

    
    public String getPersonalGoalImage() {
        return personalGoalImage;
    }

    public void setPersonalGoalImage(String personalGoalImage) {
        this.personalGoalImage = personalGoalImage;
    }

    public String[] getPersonalGoalList() {
        return personalGoalList;
    }

    public void setPersonalGoalList(String[] personalGoalList) {
        this.personalGoalList = personalGoalList;
    }

    public String getPersonalGoalTitle() {
        return personalGoalTitle;
    }

    public void setPersonalGoalTitle(String personalGoalTitle) {
        this.personalGoalTitle = personalGoalTitle;
    }

    public String getPersonalGoalLocation() {
        return personalGoalLocation;
    }

    public void setPersonalGoalLocation(String personalGoalLocation) {
        this.personalGoalLocation = personalGoalLocation;
    }

    public String getPersonalGoalWithPerson() {
        return personalGoalWithPerson;
    }

    public void setPersonalGoalWithPerson(String personalGoalWithPerson) {
        this.personalGoalWithPerson = personalGoalWithPerson;
    }

    public String getPersonalGoalWhenDate() {
        return personalGoalWhenDate;
    }

    public void setPersonalGoalWhenDate(String personalGoalWhenDate) {
        this.personalGoalWhenDate = personalGoalWhenDate;
    }

    public String getPersonalGoalAnnouncement() {
        return personalGoalAnnouncement;
    }

    public void setPersonalGoalAnnouncement(String personalGoalAnnouncement) {
        this.personalGoalAnnouncement = personalGoalAnnouncement;
    }

   
    
    
    
}
