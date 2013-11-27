/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import com.sun.jna.NativeLibrary;
import controller.NewEntryController;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.net.MalformedURLException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;


/**
 *
 * @author Zarc
 */
public class NewEntryView extends javax.swing.JFrame implements INewEntryView {

    static int imagePositionX = 25;
    static int imagePositionY = 30;
    static int imageNumber = 0;
    static File imagePath;
    private String vlcPath = "C:\\Users\\Zarc\\Desktop\\MyDiaryBook\\VLC\\";  //"C:\\Program Files\\VideoLan\\VLC\\";
    private int maxImageNumber = 30;
    private int videoNumber = 0;
    private String videoPath;
    
    /**
     * Creates new form NewEntryView sets the size and location 
     * on the center of the screen. Also initializes the NativeLibraries
     * used for playing Videos.
     */
    public NewEntryView() 
    {        
        initComponents();
        this.setSize(800,570);
        this.setLocationRelativeTo(null);
        //System.setProperty("jna.library.path", vlcPath);
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), vlcPath);
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcCoreName(), vlcPath);      
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(20);
        jScrollPane2.getHorizontalScrollBar().setUnitIncrement(20);
        previewVideoButton.setVisible(false);
    }
    
    @Override
    public void displayNewImage(URI imagePath)
    {
        JLabel jlabel = new JLabel();
        ImageIcon icon = null;
        if(imageNumber<maxImageNumber)
        {
            try 
            {
                icon = new ImageIcon(imagePath.toURL());
                Image img = icon.getImage();
                Image newimg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
                ImageIcon newIcon = new ImageIcon(newimg);
                jPanel4.add(jlabel);
                jlabel.setIcon(newIcon);
                imageNumber++;
                imagesLeftLabel.setText((maxImageNumber - imageNumber)+" Images"+" Left");
            } 
            catch (MalformedURLException ex) 
            {
                displayErrorMessage("Please Select Another Image");
                imageNumber--;
            }
        }
        else
            imageChooseButton.setVisible(false);
        
    }
    
    @Override
    public void displayVideo(String videoPath)
    {
                // ****** VlcJ framework  ******//
            EmbeddedMediaPlayerComponent mediaPlayer = new EmbeddedMediaPlayerComponent();
            JFrame frame = new JFrame();
            frame.setContentPane(mediaPlayer);
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frame.setVisible(true);
            frame.setLocationRelativeTo(this);
            mediaPlayer.setSize(800, 400);
            mediaPlayer.getMediaPlayer().attachVideoSurface();
            mediaPlayer.getMediaPlayer().playMedia(videoPath);
             
        try {
            Runtime rt = Runtime.getRuntime();
            Process p = rt.exec("taskkill /t /im vlc.exe");
            Runtime rt2 = Runtime.getRuntime();
            Process p2 = rt.exec("taskkill /t /im vlc.exe");
        } catch (IOException ex) {
            Logger.getLogger(NewEntryView.class.getName()).log(Level.SEVERE, null, ex);
        }
            
     }
    
    /**
     *
     * @param errorMessage is a string and its used to display the message I
     * want to the user
     */
    @Override
    public void displayErrorMessage(String errorMessage)
    {
        JOptionPane.showMessageDialog(this, errorMessage);
    }
    
    
    /**
     *
     * @return a String which contains the Text the user Wrote
     */
    @Override
    public String getTextArea()
    {
        return textArea.getText();
    }
    
    
    /**
     *
     * @return the total images that the user "Uploaded"
     */
    @Override
    public int getImageNumber()
    {
        return imageNumber;
    }
    
    /**
     *
     * @return the image path for each picture that the user "Uploaded"
     */
    @Override
    public String getImagePath()
    {
        return imagePath.toString();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        titleField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        dateLabel = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jPanel2 = new javax.swing.JPanel();
        imageChooseButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        imagesLeftLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        videoChooseButton = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        previewVideoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("MyDiaryBook Version 0.2");
        setMinimumSize(new java.awt.Dimension(780, 550));

        submitButton.setText("Submit");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setPreferredSize(new java.awt.Dimension(850, 650));

        textArea.setColumns(20);
        textArea.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        textArea.setLineWrap(true);
        textArea.setRows(5);
        jScrollPane1.setViewportView(textArea);

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        titleLabel.setLabelFor(titleField);
        titleLabel.setText("Τίτλος Κείμένου");

        dateLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        dateLabel.setText("Ημερομηνία");

        jSpinner1.setModel(new javax.swing.SpinnerDateModel());
        jSpinner1.setEditor(new javax.swing.JSpinner.DateEditor(jSpinner1, "dd/MM/yyyy"));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(titleLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 439, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dateLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSpinner1))
                        .addGap(67, 67, 67)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(dateLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSpinner1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Κείμενο", jPanel1);

        jPanel2.setAutoscrolls(true);

        imageChooseButton.setText("Choose");
        imageChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageChooseButtonActionPerformed(evt);
            }
        });

        jPanel4.setLayout(new java.awt.GridLayout(3, 10, 10, 10));
        jScrollPane2.setViewportView(jPanel4);

        imagesLeftLabel.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        imagesLeftLabel.setText("30 Images");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(imageChooseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(imagesLeftLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(imageChooseButton)
                .addGap(39, 39, 39)
                .addComponent(imagesLeftLabel)
                .addContainerGap(359, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Φωτογραφίες", jPanel2);

        videoChooseButton.setText("Choose");
        videoChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                videoChooseButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Μπορείτε να διαλέξετε μόνο 1 Βίντεο");

        previewVideoButton.setText("Preview");
        previewVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewVideoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(previewVideoButton)
                .addGap(294, 294, 294))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(218, 218, 218)
                .addComponent(jLabel1)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(97, 97, 97)
                .addComponent(previewVideoButton)
                .addGap(0, 247, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(videoChooseButton)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(videoChooseButton)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Βίντεο", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 764, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(submitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(cancelButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if(imageNumber>0)
        {
            //TODO An fortwnei eikones kai telika pathsei cancel anti gia submit tote na ta diagrafw ola.
            // isws lynetai me to na valw ena this.dispose(); sto submit button
        }
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void imageChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageChooseButtonActionPerformed
        JFileChooser imageChooser = new JFileChooser();
        imageChooser.setAcceptAllFileFilterUsed(false);
        FileFilter imageFilter = new FileNameExtensionFilter("Image Files",ImageIO.getReaderFileSuffixes());
        imageChooser.setFileFilter(imageFilter);
        
        if(!titleField.getText().trim().isEmpty())
        {
            int returnVal = imageChooser.showOpenDialog(jPanel2);       
            if(returnVal == JFileChooser.OPEN_DIALOG)
            {
               // imagePath = imageChooser.getSelectedFile();
                displayNewImage(imageChooser.getSelectedFile().toURI());
                NewEntryController controller = new NewEntryController(this,imageChooser.getSelectedFile().toString(),"Image",titleField.getText(),imageNumber);
            }
        }
        else 
            displayErrorMessage("Please Enter An Entry Tittle!");

    }//GEN-LAST:event_imageChooseButtonActionPerformed

    private void videoChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_videoChooseButtonActionPerformed
        JFileChooser videoChooser = new JFileChooser();
        videoChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                
        if(!titleField.getText().trim().isEmpty())
        {
            int returnVal = videoChooser.showOpenDialog(jPanel3);
            videoPath = videoChooser.getSelectedFile().toString();
            if(returnVal == JFileChooser.OPEN_DIALOG)
                if(videoPath.endsWith(".mpeg") || videoPath.endsWith(".mp4") || videoPath.endsWith(".flv") || videoPath.endsWith(".wmv") 
                    || videoPath.endsWith(".mkv") || videoPath.endsWith(".avi"))
                {
                    NewEntryController controller = new NewEntryController(this,videoPath,"Video",titleField.getText(),videoNumber);
                    previewVideoButton.setVisible(true);
                    videoChooseButton.setVisible(false);
                }
                else
                    displayErrorMessage("You need to select a Video File!");    

        }
        else
            displayErrorMessage("Please Enter An Entry Tittle!");

    }//GEN-LAST:event_videoChooseButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        if(titleField.getText().isEmpty())
            displayErrorMessage("You Must Fill in A Text Title!");
        else
        {
            NewEntryController controller = new NewEntryController(this,null,"Text",titleField.getText(),videoNumber);
        }
        
    }//GEN-LAST:event_submitButtonActionPerformed

    private void previewVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewVideoButtonActionPerformed
         displayVideo(videoPath);
    }//GEN-LAST:event_previewVideoButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
                java.util.logging.Logger.getLogger(NewEntryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewEntryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewEntryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewEntryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewEntryView().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton imageChooseButton;
    private javax.swing.JLabel imagesLeftLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton previewVideoButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextArea textArea;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton videoChooseButton;
    // End of variables declaration//GEN-END:variables
}
