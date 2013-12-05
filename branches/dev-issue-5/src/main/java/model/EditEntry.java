/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

//import java.util.Date;

/**
 *
 * @author PTsilopoulos
 */

public class EditEntry {
    
    //private Date date;
    public String text;
    
    public String getEntry(String text) {
        this.text = text;
        return text;
    }
    
    public String setEntry(String entry)
    {
        this.text = entry;
        return entry;
    }
    
    /**
    *
    * Future Enhancement "Edit Date"
    
    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }*/
}
