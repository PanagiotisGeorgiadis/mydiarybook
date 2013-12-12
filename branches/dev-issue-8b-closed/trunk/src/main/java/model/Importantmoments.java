/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import ui.*;

/**
 *
 * @author Stef
 */
public class Importantmoments {

    private String location;
    private String title;
    private String day;
    private String month;
    private String years;
    private String mood;

    public String getlocation() {
        return location;
    }

    public String gettitle() {
        return title;
    }

    public String getday() {
        return day;
    }

    public String getmonth() {
        return month;
    }
    public String getyears() {
        return years;
    }
    public String getmood() {
        return mood;
    }

    public void settitle(String title) {
        this.title = title;
    }

    public void setlocation(String location) {
        this.location = location;
    }

    public void setmood(String mood) {
        this.mood = mood;
    }

    public void setday(String day) {
        this.day = day;
    }
    public void setmonth(String month) {
        this.month = month;
    }
    public void setyears(String years) {
        this.years = years;
    }

    Object checkTitle(String day_1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    Object checkLocation(String athina) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
