/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import exception.EntryException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
     * @throws EntryException if the file doesn't exist. 
     */
    public void copyFile(File source,File dest) throws EntryException
    {
        boolean exists = createFilePath(dest.toString());
        if(exists)
            try{
                FileUtils.copyFileToDirectory(source, dest);
            }catch(IOException ex){
                throw new EntryException();
            }
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
        int loops = 0;
        if(destPath==null || fileName==null)
        {
            return false;
        }
        else if(!fileName.trim().equals("") && !destPath.trim().equals(""))
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
                    createTextFile(destPath,text,fileName,loops);
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
                    //TODO: Add logger
                }
                try{
                    if(fw!=null)
                        fw.close();
                }catch(IOException ex){
                    //TODO: Add logger
                }
            }
        }
        else
            return false;
        return false;
    }
    /**
     * Private version of createTextFile with one extra parameter named loops and used 
     * for Recursive Function calls with max loop count of 10 calls.
     * @param destPath destination path of the file to be created
     * @param text the text that the file created will contain.
     * @param fileName the name of the created text file.
     * @param loops the loop counter which has been initialized in the original
     * version of createTextFile function.
     * @return true only if the file(and the path if needed) was created 
     * else returns false. 
     */
    private boolean createTextFile(String destPath,String text,String fileName,int loops)
    {
        loops++;
        if(!fileName.trim().equals("") && !destPath.trim().equals("") && loops<6)
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
                    createTextFile(destPath,text,fileName,loops);
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
                    //TODO: Add logger
                }
                try{
                    if(fw!=null)
                        fw.close();
                }catch(IOException ex){
                    //TODO: Add logger
                }
            }
        }
        else
        {
            if(loops==6)
            {
                //TODO: Add logger
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
        int loops=0;
        if(path==null || path.trim().equals(""))
        {
            return false;
        }
        File file = new File(path);
        if(file.exists())
            return true;
        else
        {
            file.mkdirs();
            createFilePath(path,loops);
        }
        if(file.exists())
            return true;
        else
            return false;
    }
    
    /**
     * Private version of createFilePath with one extra parameter named loops and used
     * for Recursive call of this function with max loop count of 5 calls.
     * @param path the path do be created.
     * @param loops the loop counter which has been initialized in the original
     * version of createFilePath function. 
     * @return true if the FilePath exists or is Created, false if some error
     * occurs. 
     */
    private boolean createFilePath(String path,int loops)
    {        
        if(path==null || path.trim().equals("") || loops==5)
        {
            //if(loops==5)
                //TODO: Add logger
            return false;
        }
        loops++;
        File file = new File(path);
        if(file.exists())
            return true;
        else
        {
            file.mkdirs();
            createFilePath(path,loops);
        }
        return file.exists();
    }
    
    /**
    * Deletes a directory and all of its components.
    * @param folder File type parameter used to point at the directory you want to delete
    * @return true if and only if the directory pointed exists and is deleted with its
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
     * @throws EntryException
     */
    public String[] getDirectoryList(String entriesPath) throws EntryException
    {
        if(entriesPath==null)
        {
            return null;
        }
        else if(!entriesPath.trim().isEmpty() && !entriesPath.trim().equals(""))
        {
            File file = new File(entriesPath);
            if(file.list()==null)
                return null;
            String[] children = file.list();
            File subFile;
            String[] subFoldersList = new String[children.length];
            int j=0;
    //        File[] subFolders = new File[children.length];
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
        else
        {
            return null;
        }
   }
    
    /**
     * Gets a path and if it is a folder returns the names of the Files that 
     * the folder contains. If the path is empty, null or does not exist throws 
     * NullPointerException. NOTE: returns only File names and NOT Directories.
     * @param entryPath the path of the Folder that you want to check. 
     * @return String[] of the file names of the files that the folder contains. 
     * @throws EntryException
     */
    public String[] getFilesList(String entryPath) throws EntryException
    {
        if(entryPath == null)
            return null;
        else if(!entryPath.trim().equals("") && !entryPath.trim().isEmpty())
        {
            File file = new File(entryPath);
            if(file.list()==null)
                return null;
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
        return null;
    }    
    
    /**
     * Gets a path and returns a list of the Files that are in the folder 
     * specified by the path. If the path is empty, null or does not exist throws 
     * NullPointerException. NOTE: returns only Files and NOT Directories.
     * @param path The path of the target Directory.
     * @return File[] that contains only Files and not Directories.
     * @throws EntryException
     */
    public List<URI> getSubFiles(String path) throws EntryException
    {
        if(path == null)
            return null;
        else if(!path.trim().isEmpty() && !path.trim().equals(""))
        {
            File file = new File(path);
            if(file.list()==null)
                return null;
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
        return null;
        
    }
    
    /**
     * Gets a path and returns a list of the folders that are in the folder 
     * specified by the path. NOTE: returns only Directories and NOT Files.
     * @param path The path of the target Directory.
     * @return File[] that contains only Directories and not Files.
     */
    public File[] getSubDirectories(String path)
    {
        if(path == null)
            return null;
        else if(!path.trim().isEmpty() && !path.trim().equals(""))
        {
            File file = new File(path);
            String[] children = file.list();
            if(file.list()==null)
                return null;
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
        return null;
    }
    
    /**
     * Gets a path and returns a single File that is in the folder 
     * specified by the path. Used to return a single file that is placed in a 
     * Folder. If the path is empty, null or does not exist throws 
     * NullPointerException. If the Folder Specified is null returns null. If the 
     * path specified points to a File and not a Folder returns null.
     * NOTE: returns only Files and NOT Directories.
     * @param path
     * @return File which is the last file of the Folder. 
     * @throws EntryException
     */
    public File getFile(String path) throws EntryException
    {   
        if(path == null)
            return null;
        else if(!path.trim().equals("") && !path.trim().isEmpty())
        {    
            File file = new File(path);
            if(file.list() == null)
                return null;
            String[] children = file.list();
            File subFile;
            for(int i=0;i<children.length;i++)
            {
                subFile = new File(path+File.separator+children[i]);
                if(!subFile.isDirectory())
                    return subFile;
            }
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
     * @throws exception.EntryException
     */
    public String returnTextFile(String path) throws EntryException
    {
        if(path==null || path.isEmpty() || path.trim().equals(""))
            return null;
        File textFile = new File(path);
        String text;
        try {
            text = FileUtils.readFileToString(textFile);
        } catch (IOException ex) {
            text = "";
            //TODO: Add Logger
        }
        return text;
    }
    
    public boolean delete(File fileText) {
        File fileParent = fileText.getParentFile();

        if (fileText.exists()) {
            if (fileText.isDirectory()) {
                String[] subFile = fileText.list();
                for (String childFile : subFile) {
                    delete(new File(fileText, childFile));
                }
                fileText.delete();
            } else {
                fileText.delete();
                String[] subFile = fileParent.list();
                if (subFile.length == 0) {
                    fileParent.delete();
                }
            }
        } else {
            return false;
        }
        if (fileText.exists()) {
            return false;
        } else {
            return true;
        }
    }
    
}
