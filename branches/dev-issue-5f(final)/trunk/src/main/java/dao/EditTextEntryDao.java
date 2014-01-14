/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

//import java.io.FileNotFoundException;
//import java.nio.channels.FileChannel;
//import java.util.logging.Level;
//import java.util.logging.Logger;

/**
 *
 * @author PTsilopoulos
 */
public class EditTextEntryDao {
    
    public String EditText(String EntryTitle) {
        NewEntryTextDao editTextDao = new NewEntryTextDao();
        return editTextDao.returnTextFromTextFile(EntryTitle);
    }
    
    
//    java.nio.channels.FileChannel channel;
//
//    public EditTextEntryDao() {
//        try {
//            this.channel = new java.io.RandomAccessFile("/users/MyDiaryBook/Users/Panagiwths Georgiadis/Entries/", "rw").getChannel();
//        } catch (FileNotFoundException ex) {
//            Logger.getLogger(EditTextEntryDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//    
//    java.nio.ByteBuffer inBuffer = java.nio.ByteBuffer.allocate(100);
//int pos = 0;
//int aux = 0;
//StringBuilder sb = new StringBuilder();
//
//while (pos != -1) {
//
//    aux = channel.read(inBuffer, pos);
//    pos = (aux != -1) ? pos + aux : -1;
//
//    b = inBuffer.array();
//    sb.delete(0, sb.length());
//
//    for (int i = 0; i < b.length; ++i) {
//
//         sb.append((char)b[i]);
//
//    }
//
//    //here you can do your stuff on sb
//
//    inBuffer = ByteBuffer.allocate(100);
//
//}
    
}