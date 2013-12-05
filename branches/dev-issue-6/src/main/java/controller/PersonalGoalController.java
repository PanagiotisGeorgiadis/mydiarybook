/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IPersonalGoalDao;
import dao.PersonalGoalPathDao;
import java.io.BufferedWriter;
import java.io.File;
import model.PersonalGoalModel;
import static org.mockito.Mockito.*;
import ui.PersonalGoalForm;
import java.io.FileWriter;
import java.io.IOException;


/*
 **Ένας απλός controller που μέσω checkPersonalGoalTitle,checkPersonalGoalLocation,checkPersonalGoalWithPerson
 *checkPersonalGoalWhenDate checkPersonalGoalAnnouncement.
 *Ελένχει αν τα πεδία που δίνουμε είναι σωστά αλλίως επιστρέφει μήνυμα λάθους.
 * @param personalGoalTitle        : Ο τίτλος του προσωπικόυ στόχου (Personal Goal)
 * @param personalGoalLocation     : Το όνομα της τοποθεσίας.
 * @param personalGoalWithPerson   : Το όνομα του προσώπου που υλοποιούμε μαζι τον προσωπικό στόχο.
 * @param personalGoalWhenDate     : Η ημερομηνία του προσωπικόυ στόχου.
 * @param personalGoalAnnouncement : Το Announcement .
 * @return επιστρέφει ενα true εάν όλα τα πεδία είναι σωστά αλλίως false.
 * @throws 
 *@author alex
 */
public class PersonalGoalController implements IPersonalGoalController {

    public IPersonalGoalDao newPersonalGoalDao;

    public PersonalGoalController(IPersonalGoalDao personalGoalDao) {

        this.newPersonalGoalDao = personalGoalDao;

    }

    public PersonalGoalController(PersonalGoalForm theForm) {
        theForm.getTitleTextField();
        theForm.getLocationTextField();
        theForm.getWithPersonTextField();
        theForm.getAnnouncementEditorPanel();
        theForm.getWhenDateSpinner();
    }

    @Override
    public boolean createPersonalGoal(PersonalGoalForm theForm) throws Exception, IllegalArgumentException {

        PersonalGoalModel newPersonalGoalModel = new PersonalGoalModel();

        PersonalGoalEvaluator eval = new PersonalGoalEvaluator();
        PersonalGoalForm newPersonalGoalForm = new PersonalGoalForm();

        int i, proceed = 0;

        boolean[] Check = new boolean[5];
        Check[0] = eval.checkPersonalGoalTitle(theForm.getTitleTextField());
        Check[1] = eval.checkPersonalGoalLocation(theForm.getLocationTextField());
        Check[2] = eval.checkPersonalGoalWithPerson(theForm.getWithPersonTextField());
        Check[3] = eval.checkPersonalGoalWhenDate(theForm.getWhenDateSpinner());
        Check[4] = eval.checkPersonalGoalAnnouncement(theForm.getAnnouncementEditorPanel());

        for (i = 0; i < 5; i++) {
            if (!Check[i]) {
                newPersonalGoalForm.displayErrorMessage("Please Fill All The Nessessary Fields!");
                break;
            } else {
                proceed++;
            }
        }

        if (proceed == 5) {
            Check[0] = eval.checkPersonalGoalTitle(theForm.getTitleTextField());
            Check[1] = eval.checkPersonalGoalLocation(theForm.getLocationTextField());
            Check[2] = eval.checkPersonalGoalWithPerson(theForm.getWithPersonTextField());
            Check[3] = eval.checkPersonalGoalWhenDate(theForm.getWhenDateSpinner());
            Check[4] = eval.checkPersonalGoalAnnouncement(theForm.getAnnouncementEditorPanel());

        }

        while (proceed == 5) {
            for (i = 0; i < 5; i++) {
                if (!Check[i]) {
                    switch (i) {
                        case 0:
                            newPersonalGoalForm.displayErrorMessage("Title is incorrect.");
                            newPersonalGoalForm.setTitleTextField(null);
                            break;
                        case 1:
                            newPersonalGoalForm.displayErrorMessage("Location is incorrect");
                            newPersonalGoalForm.setLocationTextField(null);
                            break;
                        case 2:
                            newPersonalGoalForm.displayErrorMessage("WithPerson is incorrect");
                            newPersonalGoalForm.setWithPersonTextField(null);
                            break;
                        case 3:
                            newPersonalGoalForm.displayErrorMessage("WhenDate is incorrect");
                            newPersonalGoalForm.setWhenDateSpinner(null);
                            break;
                        case 4:
                            newPersonalGoalForm.displayErrorMessage("Announcement is incorrect");
                            newPersonalGoalForm.setAnnouncementEditorPanel(null);
                            break;

                        default:
                    }

                } else {
                    proceed++;
                    System.out.println(proceed);

                }

            }

            if (proceed == 10) {

                PersonalGoalPathDao destPath = mock(PersonalGoalPathDao.class);
                when(destPath.DefaultPath()).thenReturn("C:\\Users\\alex\\Desktop\\MyDiaryBook\\");

                PersonalGoalPathDao userName = mock(PersonalGoalPathDao.class);
                when(userName.UserName()).thenReturn("alexis");
                try {

                    //FIXME: να φτιάξω ξεχωριστή συνάρτηση για το save μέσα στο txt.
                    
                    File file = new File(destPath.DefaultPath() + userName.UserName() + ".txt");
                    FileWriter fileWriter = new FileWriter(file, true);
                    try (BufferedWriter writer1 = new BufferedWriter(fileWriter)) {
                        writer1.append("\n");
                        writer1.append("\n" + "Title:" + theForm.getTitleTextField() + "\t Location:" + theForm.getLocationTextField() + "\t With:"
                                + theForm.getWithPersonTextField() + "\t when:" + theForm.getWhenDateSpinner()
                                + "\t Annoucement:" + theForm.getAnnouncementEditorPanel());
                        fileWriter.write(System.getProperty("line.separator"));
                    }
                } catch (IOException ex) {
                    newPersonalGoalForm.displayErrorMessage("Something went wrong");
                }
                newPersonalGoalForm.displayErrorMessage("Success!");

            }

            try {
                newPersonalGoalDao.writeToFilePersonalGoal(newPersonalGoalModel);
                return true;
            } catch (IOException ex) {
                System.out.println("File Not Found!");
                return false;
            }
        }
        return true;
    }
}
