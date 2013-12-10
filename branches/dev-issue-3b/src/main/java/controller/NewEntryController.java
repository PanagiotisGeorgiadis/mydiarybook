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
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import static org.mockito.Mockito.*;
import ui.INewEntryView;
/**
 *
 * @author Zarc
 */
public class NewEntryController {
    private final int maxImageNumber = 30;
    private final String fileSeparator = File.separator;
    
    public NewEntryController()
    {
        
    }
    public NewEntryController(String userTitle)
    {
        IUserNameDaoNewEntry userMock = mock(IUserNameDaoNewEntry.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
        
        IDefaultPathDaoNewEntry rootPathMock = mock(IDefaultPathDaoNewEntry.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir")+fileSeparator+"MyDiaryBook"+fileSeparator+"Users"+fileSeparator);
        
        String userName = userMock.getUsername();
        String destPath = rootPathMock.getDefaultPath();
        
        String pathToDelete = destPath+userName+fileSeparator+userTitle;
        
        File folderToDelete = new File(pathToDelete);
        
        deleteDirectory(folderToDelete);
        
    }
    //Text Constructor Final//
    public NewEntryController(String userTitle,String userText,INewEntryView theView)
    {
        IUserNameDaoNewEntry userMock = mock(IUserNameDaoNewEntry.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
        IDefaultPathDaoNewEntry rootPathMock = mock(IDefaultPathDaoNewEntry.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir")+fileSeparator+"MyDiaryBook"+fileSeparator+"Users"+fileSeparator);
        
        String destPath = rootPathMock.getDefaultPath();
        String userName = userMock.getUsername();
            
        String textDestPath = destPath+userName+fileSeparator+userTitle+fileSeparator+"Texts"+fileSeparator;
        if(!("").equals(userText))
        {
            if(!createFile(userTitle,userText,textDestPath))
                theView.displayErrorMessage("Path Couldn't Be Created!");
        }
    }
    
    //Image Constructor Final//
    public NewEntryController(String userTitle,String sourcePath,int imageNumber,INewEntryView theView )
    {
        IUserNameDaoNewEntry userMock = mock(IUserNameDaoNewEntry.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
        IDefaultPathDaoNewEntry rootPathMock = mock(IDefaultPathDaoNewEntry.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir")+fileSeparator+"MyDiaryBook"+fileSeparator+"Users"+fileSeparator);
        
        String destPath = rootPathMock.getDefaultPath();
        String userName = userMock.getUsername();
        
        String imageDestPath = destPath+userName+fileSeparator+userTitle+fileSeparator+"Images"+fileSeparator;   
            if(!copyImage(sourcePath,imageDestPath,imageNumber))
                theView.displayErrorMessage("Please Try With Another Image!");
    }
    //Video Constructor Final//
    public NewEntryController(String userTitle,File sourceFile,INewEntryView theView)
    {
        IUserNameDaoNewEntry userMock = mock(IUserNameDaoNewEntry.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
        IDefaultPathDaoNewEntry rootPathMock = mock(IDefaultPathDaoNewEntry.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir")+fileSeparator+"MyDiaryBook"+fileSeparator+"Users"+fileSeparator);
        
        String destPath = rootPathMock.getDefaultPath();
        String userName = userMock.getUsername();
        
        String videoDestPath = destPath+userName+fileSeparator+userTitle+fileSeparator+"Videos"+fileSeparator;
            if(!copyVideo(sourceFile.toString(),videoDestPath))
                theView.displayErrorMessage("Please Try With Another Video!");
    }
//    public NewEntryController(INewEntryView theView,String sourcePath,String fileType,String userTitle,int fileNumber)
//    {
//        IUserNameDaoNewEntry userMock = mock(IUserNameDaoNewEntry.class);
//        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
//        
//        IDefaultPathDaoNewEntry rootPathMock = mock(IDefaultPathDaoNewEntry.class);
//        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir")+"\\MyDiaryBook\\Users\\");
//        
//        String userName = userMock.getUsername();
//        String destPath = rootPathMock.getDefaultPath();
//                    
//        if(fileType.equalsIgnoreCase("Text"))
//        {
//            String userText = theView.getTextArea();
//            String textDestPath = destPath+userName+"\\"+userTitle+"\\Texts\\";
//
//            if(!theView.getTextArea().trim().isEmpty())
//            {
//                if(!createFile(userTitle,userText,textDestPath))
//                    theView.displayErrorMessage("Path Couldn't Be Created!");
//            }
//        }
//        else if(fileType.equalsIgnoreCase("Image"))
//        {
//            String imageDestPath = destPath+userName+"\\"+userTitle+"\\Images\\";   
//            if(!copyImage(sourcePath,imageDestPath,fileNumber))
//                theView.displayErrorMessage("Please Try With Another Image!");
//        }
//        else if(fileType.equalsIgnoreCase("Video"))
//        {
//            String videoDestPath = destPath+userName+"\\"+userTitle+"\\Videos\\";
//            if(!copyVideo(sourcePath,videoDestPath))
//                theView.displayErrorMessage("Please Try With Another Video!");
//        }
//        else
//        {
//           // theView.displayErrorMessage("The Entry Already Exists! Please Try A Different Entry Title");
//        }
//    }            
   
    /**
     * Checks if the given string exists as file in the Directory you are looking for.
     * @param title
     * @return true if the filePathExists or false if not found
     */
    public boolean filePathExists(String title)
    {
        IDefaultPathDaoNewEntry rootPathMock = mock(IDefaultPathDaoNewEntry.class);
        when(rootPathMock.getDefaultPath()).thenReturn(System.getProperty("user.dir")+fileSeparator+"MyDiaryBook"+fileSeparator+"Users"+fileSeparator);
        
        IUserNameDaoNewEntry userMock = mock(IUserNameDaoNewEntry.class);
        when(userMock.getUsername()).thenReturn("Panagiwtis Georgiadis");
        
        File file = new File(rootPathMock.getDefaultPath()+userMock.getUsername()+fileSeparator+title);
        if(file.exists())
            return true;
        else
            return false;
    }
    
    /**
     * 
     * @param path
     * @return true if the FilePath exists or is Created, false if some error occurs 
     */
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

    /**
     * 
     * @param sourcePath String the path from which the User selected the Image
     * @param destPath String the Default Destination Path 
     * @param imageNumber integer the Number of Image 
     * @return true if everything went okay, false if an exception is caught.
     */
    public boolean copyImage(String sourcePath,String destPath,int imageNumber)
    {
        File destFile;
        boolean exists = createFilePath(destPath);
        if(exists && imageNumber<=maxImageNumber && imageNumber>=0)
        {
            try
            {
                File sourceFile = new File(sourcePath);
                if(imageNumber == 0)
                    destFile = new File(destPath+"Image.jpg");
                else
                    destFile = new File(destPath+"Image"+imageNumber+".jpg");
                FileUtils.copyFile(sourceFile, destFile);
             } 
             catch (IOException ex)
             {
                return false;
             }            
        }
        else if(imageNumber>maxImageNumber || imageNumber<0)
        {
            return false;
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
                    FileUtils.copyFile(source, destFile);
                } catch (IOException ex) {
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
    
    /**
     * 
     * @param title String entry title for the File.
     * @param text String the text that must be in the File.
     * @param destPath String the Default Destination Path.
     * @return 
     */
    public boolean createFile(String title,String text,String destPath)
    {
        if(destPath!=null)
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
            catch(Exception e)
            {
                return false;
            }
        else
        {
            createFile(title,text,".");
        }
        return false;
    }
    
    public boolean deleteDirectory(File folder)
    {
        if(folder!=null && folder.exists())
        {
            if (folder.isDirectory()) 
            {
                String[] children = folder.list();
                for (int i=0; i<children.length; i++) 
                {
                    deleteDirectory(new File(folder, children[i]));
                    folder.delete();
                }
                folder.delete();
            }
            else
                folder.delete();
            return true;
        }
        else
        {
            return false;
        }
        
        
    }
}
