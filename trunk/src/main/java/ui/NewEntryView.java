/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import controller.NewEntryDeleteController;
import controller.NewEntryImageController;
import controller.NewEntryTextController;
import controller.NewEntryVideoController;
import dao.CheckIfFileExistsDao;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.net.MalformedURLException;
import java.net.URI;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.YES_NO_OPTION;
import javax.swing.UIManager;
import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;


/**
 *
 * @author Zarc
 */
public class NewEntryView extends javax.swing.JFrame implements INewEntryView {

    static int imageNumber;
    private final String fSeparator = File.separator;
    private String vlcPath = System.getProperty("user.dir")+fSeparator+"VLC"+fSeparator;
    private int maxImageNumber;
    private String videoPath = null;
    private EmbeddedMediaPlayerComponent mediaPlayer2 =null;
    private static File[] imageFiles;
    private IMyDiaryBook callerFrame;
    /**
     * Creates new form NewEntryView sets the size and location 
     * on the center of the screen. Also initializes the NativeLibraries
     * used for playing Videos.
     */
    public NewEntryView()  
    {        
        initComponents();
        this.setSize(870,570);
        this.setLocationRelativeTo(null);
        System.setProperty("jna.library.path", vlcPath);
        //NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), vlcPath);
        //NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcCoreName(), vlcPath);
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(20);
        jScrollPane2.getHorizontalScrollBar().setUnitIncrement(20);
        previewVideoButton.setVisible(false);
        pauseButton.setVisible(false);
        stopButton.setVisible(false);  
        imageNumber = 0;
        imageFiles = new File[30];
        maxImageNumber = 30;
        entryAlreadyExistsLabel.setVisible(false);
        entryAlreadyExistsLabel.setText("Warning! An Entry With This Title Already Exists!");
        submitButton.setEnabled(false);
        imageExceedLabel.setVisible(false);
    }
    
    @Override
    public void setCallerForm(IMyDiaryBook callerFrame)
    {
        this.callerFrame = callerFrame;
    }
    
    @Override
    public void displayNewImage(URI imagePath)
    {
        JLabel jlabel = new JLabel();
        ImageIcon icon = null;
        try 
        {
            icon = new ImageIcon(imagePath.toURL());
            Image img = icon.getImage();
            Image newimg = img.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
            ImageIcon newIcon = new ImageIcon(newimg);
            imagePanel.add(jlabel);
            jlabel.setIcon(newIcon);
            if(imagePanel.getComponents().length<=maxImageNumber)
            imageNumber++;
            imagesLeftLabel.setText((maxImageNumber - imageNumber)+" Images Left");
            if((maxImageNumber - imageNumber)== 1)
                imagesLeftLabel.setText((maxImageNumber - imageNumber)+" Image Left");
        } 
        catch (MalformedURLException ex) 
        {
            imagePanel.remove(jlabel);
            imageNumber--;
        }
        if(imageNumber>=maxImageNumber)
            imageChooseButton.setVisible(false);
        
    }
    
    @Override
    public void displayVideo(String videoPath,String whatToDo)
    {
        EmbeddedMediaPlayerComponent mediaPlayer = mediaPlayer2;
                // ****** VlcJ framework  ******//
        if(whatToDo.equalsIgnoreCase("Display"))
        {
            Dimension d = videoPanel.getSize();
            mediaPlayer.setSize(d);
            videoPanel.add(mediaPlayer);
            mediaPlayer.getMediaPlayer().attachVideoSurface();
            mediaPlayer.getMediaPlayer().playMedia(videoPath); 
        }
        else if(whatToDo.equalsIgnoreCase("Pause"))
        {
            mediaPlayer.getMediaPlayer().pause();
        }
        else if(whatToDo.equalsIgnoreCase("Play"))
        {
            mediaPlayer.getMediaPlayer().play();
        }
        else
        {
            mediaPlayer.release(true);
            videoPanel.remove(mediaPlayer);
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
        textPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea = new javax.swing.JTextArea();
        titleField = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        introLabel = new javax.swing.JLabel();
        entryAlreadyExistsLabel = new javax.swing.JLabel();
        imageContainerPanel = new javax.swing.JPanel();
        imageChooseButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        imagePanel = new javax.swing.JPanel();
        imagesLeftLabel = new javax.swing.JLabel();
        imageExceedLabel = new javax.swing.JLabel();
        videoPanel = new javax.swing.JPanel();
        videoChooseButton = new javax.swing.JButton();
        previewVideoButton = new javax.swing.JButton();
        stopButton = new javax.swing.JButton();
        pauseButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New Entry");
        setMinimumSize(new java.awt.Dimension(780, 550));
        setPreferredSize(new java.awt.Dimension(890, 580));

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

        titleField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                titleFieldFocusLost(evt);
            }
        });
        titleField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                titleFieldKeyTyped(evt);
            }
        });

        titleLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        titleLabel.setLabelFor(titleField);
        titleLabel.setText("Entry Title");

        introLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        introLabel.setText("Write Something");

        entryAlreadyExistsLabel.setText("Warning! An Entry With This Title Already Exists!");

        javax.swing.GroupLayout textPanelLayout = new javax.swing.GroupLayout(textPanel);
        textPanel.setLayout(textPanelLayout);
        textPanelLayout.setHorizontalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 834, Short.MAX_VALUE)
                    .addGroup(textPanelLayout.createSequentialGroup()
                        .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(textPanelLayout.createSequentialGroup()
                                .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(entryAlreadyExistsLabel))
                            .addGroup(textPanelLayout.createSequentialGroup()
                                .addComponent(titleLabel)
                                .addGap(256, 256, 256)
                                .addComponent(introLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        textPanelLayout.setVerticalGroup(
            textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleLabel)
                    .addComponent(introLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(textPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(entryAlreadyExistsLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Text", textPanel);

        imageContainerPanel.setAutoscrolls(true);

        imageChooseButton.setText("Choose");
        imageChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imageChooseButtonActionPerformed(evt);
            }
        });

        imagePanel.setLayout(new java.awt.GridLayout(3, 10, 10, 10));
        jScrollPane2.setViewportView(imagePanel);

        imagesLeftLabel.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        imagesLeftLabel.setText("30 Images");

        imageExceedLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        imageExceedLabel.setText("Too Many Selected!");

        javax.swing.GroupLayout imageContainerPanelLayout = new javax.swing.GroupLayout(imageContainerPanel);
        imageContainerPanel.setLayout(imageContainerPanelLayout);
        imageContainerPanelLayout.setHorizontalGroup(
            imageContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imageContainerPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 691, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(imageContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(imageContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(imageChooseButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(imagesLeftLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(imageExceedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        imageContainerPanelLayout.setVerticalGroup(
            imageContainerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(imageContainerPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(imageChooseButton)
                .addGap(35, 35, 35)
                .addComponent(imagesLeftLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imageExceedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(367, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Photos", imageContainerPanel);

        videoChooseButton.setText("Choose");
        videoChooseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                videoChooseButtonActionPerformed(evt);
            }
        });

        previewVideoButton.setText("Preview");
        previewVideoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previewVideoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout videoPanelLayout = new javax.swing.GroupLayout(videoPanel);
        videoPanel.setLayout(videoPanelLayout);
        videoPanelLayout.setHorizontalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(videoPanelLayout.createSequentialGroup()
                .addContainerGap(783, Short.MAX_VALUE)
                .addGroup(videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(previewVideoButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(videoChooseButton, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        videoPanelLayout.setVerticalGroup(
            videoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(videoPanelLayout.createSequentialGroup()
                .addComponent(videoChooseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(previewVideoButton)
                .addContainerGap(452, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Video", videoPanel);

        stopButton.setText("Stop");
        stopButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopButtonActionPerformed(evt);
            }
        });

        pauseButton.setText("Pause");
        pauseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(345, Short.MAX_VALUE)
                .addComponent(pauseButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopButton)
                .addGap(252, 252, 252)
                .addComponent(submitButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(submitButton)
                    .addComponent(cancelButton)
                    .addComponent(stopButton)
                    .addComponent(pauseButton))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        if(mediaPlayer2!=null)
            displayVideo(videoPath,"hhg");
        
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void imageChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imageChooseButtonActionPerformed
        JFileChooser imageChooser = new JFileChooser();
        imageChooser.setAcceptAllFileFilterUsed(false);
        FileFilter imageFilter = new FileNameExtensionFilter("Image Files",ImageIO.getReaderFileSuffixes());
        imageChooser.setFileFilter(imageFilter);
        imageChooser.setMultiSelectionEnabled(true);
        File[] tempFile = new File[100];
        
        imageExceedLabel.setVisible(false);        
        int returnVal = imageChooser.showOpenDialog(imageContainerPanel);       
        if(returnVal == JFileChooser.OPEN_DIALOG)
        {    
            tempFile = imageChooser.getSelectedFiles();
            int i=0;
            if(imageNumber + tempFile.length<=maxImageNumber)
                while(i<tempFile.length && tempFile.length<=maxImageNumber && imageNumber<=maxImageNumber && imagePanel.getComponents().length<maxImageNumber)
                {
                    imageFiles[imageNumber] = tempFile[i];
                    displayNewImage(tempFile[i].toURI());
                    i++;
                }
            else
                imageExceedLabel.setVisible(true);
        }

    }//GEN-LAST:event_imageChooseButtonActionPerformed

    private void videoChooseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_videoChooseButtonActionPerformed
        JFileChooser videoChooser = new JFileChooser();
        videoChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                
        int returnVal = videoChooser.showOpenDialog(videoPanel);
        if(returnVal == JFileChooser.APPROVE_OPTION)
        {
            videoPath = videoChooser.getSelectedFile().toString();
            if(videoPath.endsWith(".mpeg") || videoPath.endsWith(".mp4") || videoPath.endsWith(".flv") || videoPath.endsWith(".wmv") 
                || videoPath.endsWith(".mkv") || videoPath.endsWith(".avi"))
            {
                previewVideoButton.setVisible(true);
                videoChooseButton.setVisible(false);
            }
            else
                videoPath = null;
        }

    }//GEN-LAST:event_videoChooseButtonActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        NewEntryVideoController videoController = new NewEntryVideoController();
        NewEntryImageController imageController = new NewEntryImageController();
        NewEntryTextController textController = new NewEntryTextController();
        NewEntryDeleteController deleteController = new NewEntryDeleteController(); 
        if(!textArea.getText().equals("") || imageNumber!=0 || videoPath!=null)
            if(titleField.getBackground() == Color.orange)
            {
                int ret = JOptionPane.showConfirmDialog(this, "Do You Want To Overwrite It?\n", "Duplicate Entry Found!",YES_NO_OPTION , WARNING_MESSAGE);
                if(ret == JOptionPane.YES_OPTION)
                {
                    deleteController.deleteDirectory(titleField.getText());
                    titleField.setBackground(Color.green);
                    this.submitButtonActionPerformed(evt);
                }
                else
                {
                    titleField.setText("");
                    titleField.requestFocusInWindow();
                    titleField.setBackground(Color.white);
                    entryAlreadyExistsLabel.setVisible(false);                
                }
            }
            else
            {
                textController.createTextFile(titleField.getText(), textArea.getText());
                if(imageNumber>0)
                    for(int i=0;i<imageNumber;i++)  
                        imageController.copyImage(titleField.getText(), imageFiles[i].toString());
                if(videoPath!=null)
                    videoController.copyVideo(titleField.getText(), videoPath);
                if(mediaPlayer2!=null)
                    displayVideo(videoPath,"hhg");
                callerFrame.refreshEntries();
                this.dispose();
            }
        else
        {
            entryAlreadyExistsLabel.setText("Sorry, you can't submit a null Entry!");
            entryAlreadyExistsLabel.setVisible(true);
        }
        
        
    }//GEN-LAST:event_submitButtonActionPerformed

    private void previewVideoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previewVideoButtonActionPerformed
        mediaPlayer2 = new EmbeddedMediaPlayerComponent(); 
        displayVideo(videoPath,"Display");
        stopButton.setVisible(true);
        pauseButton.setVisible(true);
        previewVideoButton.setVisible(false);
    }//GEN-LAST:event_previewVideoButtonActionPerformed

    private void pauseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseButtonActionPerformed
        
        if(pauseButton.getText().equals("Pause"))
        {
            pauseButton.setText("Play");
            displayVideo(videoPath,"Pause");
        }
        else
        {
            pauseButton.setText("Pause");
            displayVideo(videoPath,"Play");
        }
    }//GEN-LAST:event_pauseButtonActionPerformed

    private void stopButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopButtonActionPerformed
        displayVideo(videoPath,"Nothing");
        pauseButton.setVisible(false);
        stopButton.setVisible(false);
    }//GEN-LAST:event_stopButtonActionPerformed

    private void titleFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_titleFieldFocusLost
        if(!titleField.getText().trim().isEmpty())
        {
            submitButton.setEnabled(true);
            CheckIfFileExistsDao entryExistance = new CheckIfFileExistsDao();
            if(entryExistance.filePathExists(titleField.getText())) 
            {
                entryAlreadyExistsLabel.setVisible(true);
                titleField.setBackground(Color.orange);            
            }
            else
            {
                entryAlreadyExistsLabel.setVisible(false);
                titleField.setBackground(Color.green);
            }
            
            if(!titleField.getText().matches("\\w*") && !titleField.getText().matches("\\w*\\s\\w*") && !titleField.getText().matches("\\w*\\s\\w*\\s\\w*"))
            {
                entryAlreadyExistsLabel.setText("Your Title Must Be Aplhanumeric And Maximum Three Words!");
                entryAlreadyExistsLabel.setVisible(true);
                titleField.setText("");
                titleField.requestFocusInWindow();
                titleField.setBackground(Color.WHITE);
            }         
        }
        else
        {
            submitButton.setEnabled(false);
            entryAlreadyExistsLabel.setVisible(true);
            entryAlreadyExistsLabel.setText("Warning! You Must Feel In An Entry Title!");
            titleField.requestFocusInWindow();
            titleField.setBackground(Color.red);
        }
    }//GEN-LAST:event_titleFieldFocusLost

    private void titleFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_titleFieldKeyTyped
        titleField.setBackground(Color.white);
    }//GEN-LAST:event_titleFieldKeyTyped

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
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
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
    private javax.swing.JLabel entryAlreadyExistsLabel;
    private javax.swing.JButton imageChooseButton;
    private javax.swing.JPanel imageContainerPanel;
    private javax.swing.JLabel imageExceedLabel;
    private javax.swing.JPanel imagePanel;
    private javax.swing.JLabel imagesLeftLabel;
    private javax.swing.JLabel introLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton pauseButton;
    private javax.swing.JButton previewVideoButton;
    private javax.swing.JButton stopButton;
    private javax.swing.JButton submitButton;
    private javax.swing.JTextArea textArea;
    private javax.swing.JPanel textPanel;
    private javax.swing.JTextField titleField;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JButton videoChooseButton;
    private javax.swing.JPanel videoPanel;
    // End of variables declaration//GEN-END:variables
}
