/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.NewEntryVideoDao;
import java.io.File;

/**
 *
 * @author JohnN'y
 */
public class DeleteVideoController {

    private NewEntryVideoDao videoDao = new NewEntryVideoDao();

    public DeleteVideoController() {
    }

    public boolean deleteVideoAlbum(File videoFile) {

        try {

            return videoDao.prepareForDeleteAlbum(videoFile);

        } catch (Exception ex) {
            return false;
            //TODO logger
        }
    }

    public String showNoFileFound() {
        String message = "There is not such a file";
        return message;

    }

    /**
     * Display a error message
     *
     * @return There was a undefined error
     */

    public String showError() {
        String message = "There was  a undefinied error";
        return message;
    }

    /**
     * Display a successful message
     *
     * @return Successful Erase
     */

    public String showSuccess() {
        String message = "Successful Erase";
        return message;
    }
}
