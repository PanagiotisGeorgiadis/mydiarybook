/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Zarc
 */
public class FilesDao {
    
    public FilesDao()
    {
        
    }
    /**
     * Gets the source path of the file and copies it to the destination path.
     * If the destination path doesn't exist it creates it automatically.
     * @param source source path of the file.
     * @param dest destination path of the file.
     * @throws IOException if the file doesn't exist. 
     */
    public void copyFile(File source,File dest) throws IOException
    {
        boolean exists = createFilePath(dest.toString());
        if(exists)
            FileUtils.copyFileToDirectory(source, dest);
        else
        {
            createFilePath(dest.toString());
            copyFile(source,dest);
        }
    }
    /**
     * Creates a simple text file on the destination path specified with text
     * from the text parameter.If the destination path doesn't exist it 
     * automatically creates it.
     * @param destPath destination path of the file to be created
     * @param text the text that the file created will contain.
     * @param fileName the name of the created text file.
     * @return true only if the file(and the path if needed) was created 
     * else returns false.
     */
    public boolean createTextFile(String destPath,String text,String fileName)
    {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try
        {
            File file = new File(destPath+fileName+".txt");
            boolean exists = createFilePath(destPath);
            if(exists)
            {
                fw = new FileWriter(file,true);
                bw = new BufferedWriter(fw);
                bw.write(text);
                
                return true;
            }
            else
            {
                createFilePath(destPath);
                createTextFile(destPath,text,fileName);
            }
        }
        catch(IOException ex)
        {
            //TODO: Add logger.
            return false;
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(IOException ex){
                //logger
            }
            try{
                if(fw!=null)
                    fw.close();
            }catch(IOException ex){
                //logger
            }
        }
        return false;
    }
       
    /**
     * Creates a full path if it doesn't exist.
     * @param path the path do be created.
     * @return true if the FilePath exists or is Created, false if some error
     * occurs 
     */
    public boolean createFilePath(String path)
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
    * Deletes a directory and all of its components.
    * @param folder File type parameter used to point at the directory you want to delete
    * @returns true if and only if the directory pointed exists and is deleted with its
    * components else returns false.
    */
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
    
    /**
     * Loads a list of the children of the Folder denoted by the entriesPath 
     * @param entriesPath String denotes the folder that contains all the entries.
     * @return the names of the entries.
     */
    public String[] getDirectoryList(String entriesPath)
    {
        File file = new File(entriesPath);
        String[] children = file.list();
        File subFile;
        String[] subFoldersList = new String[children.length];
//        File[] subFolders = new File[children.length];
        int j=0;
//        for(int i=0;i<children.length;i++)
//        {
//            subFile = new File(entriesPath+File.separator+children[i]);
//            if(subFile.isDirectory())
//                subFolders[j] = subFile;
//        }
//        subFoldersList[0]= getMostRecentFile(subFolders);
//        j=0;
        for(int i=0;i<children.length;i++)
        {
            subFile = new File(entriesPath+File.separator+children[i]);
            if(subFile.isDirectory())
            {
                subFoldersList[j] = children[i];
                j++;
            }
        }
        return subFoldersList;
    }
    
    public String[] getFilesList(String entryPath) throws NullPointerException
    {
        File file = new File(entryPath);
        String[] children = file.list();
        File subFile;
        String[] subFolders = new String[children.length];
        int j=0;
        for(int i=0;i<children.length;i++)
        {
            subFile = new File(entryPath+File.separator+children[i]);
            if(!subFile.isDirectory())
            {
                subFolders[j] = children[i];
                j++;
            }
        }
        return subFolders;
    }    
    
    /**
     * Gets a path and returns a list of the Files that are in the folder 
     * specified by the path. NOTE: returns only Files and NOT Directories.
     * @param path The path of the target Directory.
     * @return File[] that contains only Files and not Directories.
     */
    public List<URI> getSubFiles(String path) throws NullPointerException
    {
        File file = new File(path);
        String[] children = file.list();
        File subFile;
        List<URI> subFolders = new ArrayList<URI>();
        int j=0;
         for(int i=0;i<children.length;i++)
        {
            subFile = new File(path+File.separator+children[i]);
            if(!subFile.isDirectory())
            {
                subFolders.add(subFile.toURI());
                j++;
            }
        }
        return subFolders;
    }
    
    /**
     * Gets a path and returns a list of the folders that are in the folder 
     * specified by the path. NOTE: returns only Directories and NOT Files.
     * @param path The path of the target Directory.
     * @return File[] that contains only Directories and not Files.
     */
    public File[] getSubDirectories(String path)
    {
        File file = new File(path);
        String[] children = file.list();
        File subFile;
        File[] subFolders = new File[children.length];
        int j=0;
        for(int i=0;i<children.length;i++)
        {
            subFile = new File(path+File.separator+children[i]);
            if(subFile.isDirectory())
            {
                subFolders[j] = subFile;
                j++;
            }
        }
        return subFolders;
    }
    
    public File getFile(String path) throws NullPointerException
    {
        File file = new File(path);
        String[] children = file.list();
        File subFile;
        for(int i=0;i<children.length;i++)
        {
            subFile = new File(path+File.separator+children[i]);
            if(!subFile.isDirectory())
                return subFile;
        }
        return null;
    }
    
//    public String getMostRecentFile(File[] input)
//    {
//        Date d = new Date(input[0].lastModified());
//        Date d2;
//        int indexOfMostRecent = 0;
//        for(int i=0;i<input.length;i++)
//        {
//            d2 = new Date(input[i].lastModified());
//            if(d.compareTo(d2) < 0)
//            {
//                d=d2;
//                indexOfMostRecent = i;
//            }
//        }
//        
//        return input[indexOfMostRecent].getName();
//    }
    
    /**
     * Returns the text of the specified text file if it exists.
     * @param path The path of the text file you want to read.
     * @return The text of the specified File if it exists else returns null.
     */
    public String returnTextFile(String path) throws IOException
    {
        File textFile = new File(path);
        String text;
        text = FileUtils.readFileToString(textFile);
        return text;
    }
    
}
