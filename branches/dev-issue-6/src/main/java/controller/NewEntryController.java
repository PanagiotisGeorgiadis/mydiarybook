/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IDefaultPathDaoNewEntry;
import dao.IUserNameDaoNewEntry;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import static org.mockito.Mockito.*;
import ui.INewEntryView;
/**
 *
 * @author Zarc
 */
public class NewEntryController {
    
    public NewEntryController()
    {
        
    }
    public NewEntryController(INewEntryView theView,String sourcePath,String fileType,String userTitle,int fileNumber)
    {
        IUserNameDaoNewEntry userMock = mock(IUserNameDaoNewEntry.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
        
        IDefaultPathDaoNewEntry rootPathMock = mock(IDefaultPathDaoNewEntry.class);
        when(rootPathMock.getDefaultPath()).thenReturn("C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Users\\");
        
        String userName = userMock.getUsername();
        String destPath = rootPathMock.getDefaultPath();
                    
        if(fileType.equalsIgnoreCase("Text"))
        {
            String userText = theView.getTextArea();
            String textDestPath = destPath+userName+"\\"+userTitle+"\\Texts\\";
           
            if(!theView.getTextArea().trim().isEmpty())
            {
                if(!createFile(userTitle,userText,textDestPath))
                    theView.displayErrorMessage("Path Couldn't Be Created!");
            }
        }
        else if(fileType.equalsIgnoreCase("Image"))
        {
            String imageDestPath = destPath+userName+"\\"+userTitle+"\\Images\\";   
            if(!copyImage(sourcePath,imageDestPath,fileNumber))
                theView.displayErrorMessage("Please Try With Another Image!");
        }
        else if(fileType.equalsIgnoreCase("Video"))
        {
            String videoDestPath = destPath+userName+"\\"+userTitle+"\\Videos\\";
            if(!copyVideo(sourcePath,videoDestPath))
                theView.displayErrorMessage("Please Try With Another Video!");
        }
        else
        {
           // theView.displayErrorMessage("The Entry Already Exists! Please Try A Different Entry Title");
        }
    }            
    
    public boolean filePathExists(String title)
    {
        IDefaultPathDaoNewEntry rootPathMock = mock(IDefaultPathDaoNewEntry.class);
        when(rootPathMock.getDefaultPath()).thenReturn("C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\Users\\");
        
        IUserNameDaoNewEntry userMock = mock(IUserNameDaoNewEntry.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
        
        File file = new File(rootPathMock.getDefaultPath()+userMock.getUsername()+"\\"+title);
        if(file.exists())
            return true;
        else
            return false;
    }
    
    private boolean createFilePath(String path)
    {
        try
        {
            File file = new File(path);
            if(file.exists())
                return true;
            else
            {
                file.mkdirs();
                createFilePath(path);
            }
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }

    public boolean copyImage(String sourcePath,String destPath,int imageNumber)
    {
        File destFile;
        boolean exists = createFilePath(destPath);
        if(exists)
        {
            try
            {
                File source = new File(sourcePath);
                if(imageNumber == 0)
                    destFile = new File(destPath+"Image.jpg");
                else
                    destFile = new File(destPath+"Image"+imageNumber+".jpg");

                    Files.copy(source.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } 
            catch (Exception ex)
            {
                return false;
            }
        }
        else
        {
            createFilePath(destPath);
            copyImage(sourcePath,destPath,imageNumber);
        }
        return true;
    }
    

    public boolean copyVideo(String sourcePath,String videoDestPath)
    {
        try
        {
            File destFile;
            if(sourcePath.endsWith(".mpeg"))
                destFile = new File(videoDestPath+"Video.mpeg");
            else if(sourcePath.endsWith(".flv"))
                destFile = new File(videoDestPath+"Video.flv");
            else if(sourcePath.endsWith(".mp4"))
                destFile = new File(videoDestPath+"Video.mp4");
            else if(sourcePath.endsWith(".wmv"))
                destFile = new File(videoDestPath+"Video.wmv");
            else if(sourcePath.endsWith(".avi"))
                destFile = new File(videoDestPath+"Video.avi");
            else if(sourcePath.endsWith(".mkv"))
                destFile = new File(videoDestPath+"Video.mkv");
            else
                return false;
            File source = new File(sourcePath);
            
            boolean exists = createFilePath(videoDestPath);
            if(exists)
            {
                try {
                    Files.copy(source.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                } catch (Exception ex) {
                    return false;
                }
            }
            else
            {
                createFilePath(videoDestPath);
                copyVideo(sourcePath,videoDestPath);
            }
        }
        catch(Exception ex)
        {
            return false;
        }
                
        return true;
    }
    
 
    public boolean createFile(String title,String text,String destPath)
    {
        try
        {
            File file = new File(destPath+title+".txt");
            boolean exists = createFilePath(destPath);
            if(exists)
            {
                FileWriter fw = new FileWriter(file,true);
                BufferedWriter bw = new BufferedWriter(fw);
                if(file.exists())
                    bw.append(text);
                else    
                {
                    file.createNewFile();
                    bw.write(text);
                }
                bw.close();
                return true;
            }
            else
            {
                createFilePath(destPath);
                createFile(title,text,destPath);
            }
        }
        catch(Exception ex)
        {
            return false;
        }
        return false;
    }
}
