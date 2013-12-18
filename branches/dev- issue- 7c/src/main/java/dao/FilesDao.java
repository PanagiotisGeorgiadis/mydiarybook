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
import org.apache.commons.io.FileUtils;

/**
 *
 * @author Zarc
 */
public class FilesDao {
    
    public FilesDao()
    {
        
    }
    
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
    
    public boolean createTextFile(String destPath,String text)
    {
        try
        {
            File file = new File(destPath+"diarybook.txt");
            boolean exists = createFilePath(destPath);
            if(exists)
            {
                FileWriter fw = new FileWriter(file,true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(text);
                bw.close();
                fw.close();
                return true;
            }
            else
            {
                createFilePath(destPath);
                createTextFile(destPath,text);
            }
        }
        catch(Exception e)
        {
            return false;
        }
        return false;
    }
       
    /**
     * 
     * @param path
     * @return true if the FilePath exists or is Created, false if some error occurs 
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
    * 
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
}
